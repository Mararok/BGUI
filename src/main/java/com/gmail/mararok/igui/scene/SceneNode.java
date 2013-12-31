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
import com.gmail.mararok.igui.event.ImpactEvent;
import com.gmail.mararok.igui.event.mouse.MouseEvent;
import com.gmail.mararok.igui.scene.Scene;
import com.gmail.mararok.igui.style.Region;
import com.gmail.mararok.igui.style.Style;
import com.gmail.mararok.igui.style.StyleClass;
import com.gmail.mararok.igui.style.attributes.Attribute;
import com.gmail.mararok.igui.style.attributes.AttributeType;
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
		
		parent = newParent;
		
		onDetachFromScene();
	
		if (parent != null && parent.getScene() != null) {
			onAttachToScene(parent.getScene());
		}
		
	}
	
	public Scene getScene() {
		return scene;
	}

	public boolean hasScene() {
		return scene != null;
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

	@Override
	public void updateAttribute(AttributeType type, Attribute attribute) {}
	
	public void registerHandler(String eventTypeName, EventHandler handler) {
		if (eventHandlers == null) {
			eventHandlers = new THashMap<String,EventHandler>();
		}
		
		eventHandlers.put(eventTypeName,handler);
	}
	
	public void onEvent(ImpactEvent event) {
		if (event instanceof MouseEvent) {
			MouseEvent mevent = (MouseEvent) event;
			if (bounds.contains(mevent.getX(),mevent.getY())) {
				onMouseEvent(mevent);
			}
		}
	}
	
	protected void onMouseEvent(MouseEvent event) {
		if (eventHandlers != null) {
			EventHandler handler = eventHandlers.get(event.getName());
			if (handler != null) {
				handler.onEvent(event);
			}
		}
	}
	
	protected void onAttachToScene(Scene newScene) {
		if (scene != newScene) {
			onDetachFromScene();
			scene = newScene;
		}
	}
	
	protected void onDetachFromScene() {
		scene = null;
	}
	
	@Override
	public String toString() {
		return String.format("SN[%s],scene:%s,v:%s,e:%s",id,scene,visible,enabled);
	}

}
