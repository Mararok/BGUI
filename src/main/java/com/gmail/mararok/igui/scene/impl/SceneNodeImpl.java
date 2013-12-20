/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.scene.impl;

import com.gmail.mararok.igui.ImpactGUI;
import com.gmail.mararok.igui.event.ImpactEvent;
import com.gmail.mararok.igui.event.mouse.MouseClickeEvent;
import com.gmail.mararok.igui.event.mouse.MouseMotionEvent;
import com.gmail.mararok.igui.scene.ParentSceneNode;
import com.gmail.mararok.igui.scene.Scene;
import com.gmail.mararok.igui.scene.SceneNode;
import com.gmail.mararok.igui.spi.render.ParentVisualNode;

import de.greenrobot.event.EventBus;

public abstract class SceneNodeImpl implements SceneNode {
	private String id;
	private ParentSceneNodeImpl parent;
	
	protected ParentVisualNode mainVisualNode;
	protected ImpactGUI gui;
	private Scene currentScene;
	
	private boolean enabled;
	private boolean visible;
	
	public SceneNodeImpl(ImpactGUI gui) {
		this.gui = gui;
	}
	
	@Override
	public String getID() {
		return id;
	}
	
	@Override
	public void setID(String newID) {
		id = newID;
	}
	
	@Override
	public ParentSceneNode getParent() {
		return parent;
	}
	
	@Override
	public boolean hasParent() {
		return parent != null;
	}
	
	@Override
	public void setParent(ParentSceneNode newParent) {
		if (hasParent()) {
			getParent().detachChild(this);
			((ParentSceneNodeImpl)getParent()).mainVisualNode.detachChild(mainVisualNode);
		}
		
		parent = (ParentSceneNodeImpl)newParent;
		((ParentSceneNodeImpl)getParent()).mainVisualNode.attachChild(mainVisualNode);
		currentScene = parent.getScene();
	}
	
	@Override
	public Scene getScene() {
		return  currentScene;
	}

	@Override
	public void setFocused(boolean focus) {
		if (getScene() == null) {
			return;
		}
		
		if (focus) {
			currentScene.setFocusedNode(this);
		} else if (hasFocus()) {
			currentScene.setFocusedNode(null);
		}
		
	}

	@Override
	public boolean hasFocus() {
		return (currentScene != null && currentScene.getFocusedNode() == this);
	}
	
	@Override
	public void setEnabled(boolean value) {
		if (enabled == value) {
			return;
		}
		
		enabled = value;
		if (enabled) {
			onEnable();
		} else {
			onDisable();
		}
	}

	@Override
	public void enable() {
		setEnabled(true);
	}

	@Override
	public void disable() {
		setEnabled(false);
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	@Override
	public void setVisible(boolean value) {
		if (visible == value) {
			return;
		}
		
		visible = value;
		if (visible) {
			if (hasParent()) {
				parent.mainVisualNode.attachChild(mainVisualNode);
			}
			
		} else {
			onHide();
		}
		
	}

	@Override
	public void show() {
		setVisible(true);
	}

	@Override
	public void hide() {
		setVisible(false);
	}

	@Override
	public boolean isVisible() {
		return visible;
	}

	abstract public void onEvent(ImpactEvent event);
	
	protected void createVisualNode() {
		mainVisualNode = getGUI().getRenderDevice().createParentNode();
	}
	
	
	protected ImpactGUI getGUI() {
		return gui;
	}
}
