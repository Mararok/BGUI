/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.scene;

import gnu.trove.map.hash.THashMap;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.gmail.mararok.igui.event.EventHandler;
import com.gmail.mararok.igui.event.EventType;
import com.gmail.mararok.igui.event.ImpactEvent;
import com.gmail.mararok.igui.scene.Scene;
import com.gmail.mararok.igui.style.Region;
import com.gmail.mararok.igui.style.Style;
import com.gmail.mararok.igui.style.StyleClass;
import com.gmail.mararok.igui.util.Rectangle;

public abstract class SceneNode implements Region {
	private String id;
	private Rectangle bounds;
	private int z;
	
	private boolean enabled;
	private boolean visible;
	
	private Style style;
	private List<StyleClass> styleClasses;
	
	
	private THashMap<String,EventHandler> eventHandlers;
	
	private ParentSceneNode parent;
	Scene scene;
	
	public SceneNode() {
		bounds = new Rectangle();
	}
	
	public String getID() {
		return id;
	}
	
	public void setID(String newID) {
		id = newID;
	}
	
	
	@Override
	public int getCenterX() {
		return bounds.getCenterX();
	}

	@Override
	public int getCenterY() {
		return bounds.getCenterY();
	}

	@Override
	public int getX() {
		return bounds.getX();
	}

	@Override
	public void setX(int newX) {
		bounds.setX(newX);
		updateBounds();
	}

	@Override
	public int getY() {
		return bounds.getY();
	}

	@Override
	public void setY(int newY) {
		bounds.setY(newY);
		updateBounds();
	}

	@Override
	public void setPosition(int newX, int newY) {
		bounds.setX(newX);
		bounds.setY(newY);
		updateBounds();
	}

	@Override
	public int getZ() {
		return z;
	}

	@Override
	public void setZ(int newZ) {
		z = newZ;
		updateBounds();
		
	}
	
	
	@Override
	public int getLocalCenterX() {
		return (hasParent())?getCenterX()-getParent().getX():getCenterX();
	}

	@Override
	public int getLocalCenterY() {
		return (hasParent())?getCenterY()-getParent().getY():getCenterY();
	}

	@Override
	public int getLocalX() {
		return (hasParent())?getX()-getParent().getX():getX();
	}

	@Override
	public void setLocalX(int newX) {
		setX((hasParent())?getParent().getX()+newX:newX);
	}

	@Override
	public int getLocalY() {
		return (hasParent())?getY()-getParent().getY():getY();
	}

	@Override
	public void setLocalY(int newY) {
		setY((hasParent())?getParent().getY()+newY:newY);
	}

	@Override
	public void setLocalPosition(int newX, int newY) {
		setPosition(
				(hasParent())?getParent().getX()+newX:newX,
				(hasParent())?getParent().getY()+newY:newY
		);
	}

	@Override
	public int getLocalZ() {
		return (hasParent())?getZ()-getParent().getZ():getZ();
	}

	@Override
	public void setLocalZ(int newZ) {
		setZ((hasParent())?getParent().getZ()+newZ:newZ);
	}

	@Override
	public int getWidth() {
		return bounds.getWidth();
	}

	@Override
	public void setWidth(int newWidth) {
		bounds.setWidth(newWidth);
		updateBounds();
	}

	@Override
	public int getHeight() {
		return bounds.getHeight();
	}

	@Override
	public void setHeight(int newHeight) {
		bounds.setHeight(newHeight);
		updateBounds();
	}

	@Override
	public void setSize(int newWidth, int newHeight) {
		bounds.setWidth(newWidth);
		bounds.setHeight(newHeight);
		updateBounds();
	}
	
	protected abstract void updateBounds();
	
	public ParentSceneNode getParent() {
		return parent;
	}
	
	public boolean hasParent() {
		return parent != null;
	}
	
	public void setParent(ParentSceneNode newParent) {
		if (hasParent()) {
			getParent().detachChild(this);
		}
		
		parent = (ParentSceneNode)newParent;
		boolean hasScene = scene != null;
		scene = parent.getScene();
		if (scene == null && hasScene) {
			onDetachFromScene();
		} else if (scene != null && !hasScene) {
			onAttachToScene();
		}
	}
	
	public Scene getScene() {
		return scene;
	}

	public void setFocused(boolean focus) {
		if (getScene() == null) {
			return;
		}
		
		if (focus) {
			scene.setFocusedNode(this);
		} else if (hasFocus()) {
			scene.setFocusedNode(null);
		}
		
	}

	public boolean hasFocus() {
		return (scene != null && scene.getFocusedNode() == this);
	}
	
	public void setEnabled(boolean enable) {
		if (enabled == enable) {
			return;
		}
		
		enabled = enable;
	}

	public void enable() {
		setEnabled(true);
	}

	public void disable() {
		setEnabled(false);
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setVisible(boolean visible) {
		if (this.visible == visible) {
			return;
		}
		
		this.visible = visible;
	}

	public void show() {
		setVisible(true);
	}

	public void hide() {
		setVisible(false);
	}

	public boolean isVisible() {
		return visible;
	}

	@Override
	public Style getStyle() {
		if (style == null) {
			style = new Style(this);
		}
		
		return style;
	}

	@Override
	public StyleClass getStyleClass(String className) {
		for (StyleClass styleClass: styleClasses) {
			if (className == styleClass.getName()) {
				return styleClass;
			}
		}
		return null;
	}

	@Override
	public boolean hasStyleClass(String className) {
		return getStyleClass(className) != null;
	}

	@Override
	public void addStyleClass(StyleClass newClass) {
		if (hasStyleClass(newClass.getName())) {
			return;
		}
		
		if (styleClasses == null) {
			styleClasses = new LinkedList<StyleClass>();
		}
		styleClasses.add(newClass);
	}

	@Override
	public void removeStyleClass(String className) {
		if (styleClasses != null) {
			Iterator<StyleClass> it = styleClasses.iterator();
			while (it.hasNext()) {
				if (it.next().getName() == className) {
					it.remove();
					return;
				}
			}
		}
	}

	public void registerHandler(String eventName, EventHandler handler) {
		if (eventHandlers == null) {
			eventHandlers = new THashMap<String,EventHandler>();
		}
		
		eventHandlers.put(eventName,handler);
	}
	
	public void registerHandler(EventType eventType, EventHandler handler) {
		registerHandler(eventType.toString(),handler);
	}
	
	public abstract void onEvent(ImpactEvent event);
	
	protected abstract void onAttachToScene();
	protected abstract void onDetachFromScene();
	
	@Override
	public String toString() {
		return String.format("SN[%s],scene:%s,v:%s,e:%s",id,scene,visible,enabled);
	}

}
