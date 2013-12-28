/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.scene.impl;

import gnu.trove.map.hash.THashMap;

import com.gmail.mararok.igui.event.Controller;
import com.gmail.mararok.igui.event.ImpactEvent;
import com.gmail.mararok.igui.event.keyboard.KeyboardEvent;
import com.gmail.mararok.igui.scene.ParentSceneNode;
import com.gmail.mararok.igui.scene.Scene;
import com.gmail.mararok.igui.scene.SceneManager;
import com.gmail.mararok.igui.scene.SceneNode;
import com.gmail.mararok.igui.spi.render.RenderDevice;

public class SceneImpl implements Scene {
	private String id;
	private ParentSceneNodeImpl rootNode;
	private SceneNode focusedNode;
	
	private THashMap<String,Controller> controllers; 
	
	private SceneManager sceneManager;
	
	public SceneImpl(String id, SceneManager sceneManager) {
		this.id = id;
		this.sceneManager = sceneManager;
		
		rootNode = new ParentSceneNodeImpl(sceneManager.getGUI(),sceneManager.getRenderDevice().getRootGUINode());
		focusedNode = rootNode;
	}

	@Override
	public String getID() {
		return id;
	}

	@Override
	public ParentSceneNode getRoot() {
		return rootNode;
	}

	@Override
	public SceneManager getSceneManager() {
		return sceneManager;
	}

	@Override
	public RenderDevice getRenderDevice() {
		return getSceneManager().getRenderDevice();
	}

	@Override
	public void attachChild(SceneNode child) {
		getRoot().attachChild(child);
	}

	@Override
	public void detachChild(SceneNode child) {
		getRoot().detachChild(child);
		
	}

	@Override
	public SceneNode getFocusedNode() {
		return focusedNode;
	}

	@Override
	public void setFocusedNode(SceneNode sceneNode) {
		if (sceneNode == null) {
			focusedNode = rootNode;
		} else if (sceneNode.getScene() == this) {
			focusedNode = sceneNode;
		}
	}
	
	@Override
	public Controller getController(String name) {
		return controllers.get(name);
	}

	@Override
	public void setController(String name, Controller controller) {
		controllers.put(name,controller);
		
	}
	
	public void onEvent(ImpactEvent event) {
		if (event instanceof KeyboardEvent) {
			if (focusedNode != null) {
				focusedNode.onEvent(event);
			}
		} else {
			rootNode.onEvent(event);
		}
	}
}
