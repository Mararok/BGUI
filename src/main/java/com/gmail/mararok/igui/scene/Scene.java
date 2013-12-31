/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.scene;

import gnu.trove.map.hash.THashMap;

import com.gmail.mararok.igui.event.Controller;
import com.gmail.mararok.igui.event.ImpactEvent;
import com.gmail.mararok.igui.event.keyboard.KeyboardEvent;
import com.gmail.mararok.igui.scene.SceneManager;
import com.gmail.mararok.igui.spi.render.ParentVisualNode;
import com.gmail.mararok.igui.spi.render.RenderDevice;

public class Scene {
	private String id;
	private ParentVisualNode rootVisualNode;
	private ParentSceneNode rootNode;
	private SceneNode focusedNode;
	
	private THashMap<String,Controller> controllers; 
	
	private SceneManager sceneManager;
	
	public Scene(String id, SceneManager sceneManager) {
		this.id = id;
		rootVisualNode = sceneManager.getRenderDevice().getRootGUINode();
		this.sceneManager = sceneManager;
		controllers = new THashMap<String,Controller>();
		
		rootNode = new RootSceneNode(this);
		
	}

	public String getID() {
		return id;
	}

	public SceneNode getFocusedNode() {
		return focusedNode;
	}

	public ParentSceneNode getRoot() {
		return rootNode;
	}
	
	public ParentVisualNode getVisualRoot() {
		return rootVisualNode;
	}
	
	public void attachChild(SceneNode child) {
		getRoot().attachChild(child);
	}
	
	public void detachChild(SceneNode child) {
		getRoot().detachChild(child);
	}
	
	public void setFocusedNode(SceneNode sceneNode) {
		if (sceneNode == null) {
			focusedNode = null;
		} else if (sceneNode.getScene() == this) {
			focusedNode = sceneNode;
		}
	}
	
	public Controller getController(String name) {
		return controllers.get(name);
	}

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
	
	public SceneManager getSceneManager() {
		return sceneManager;
	}

	public RenderDevice getRenderDevice() {
		return getSceneManager().getRenderDevice();
	}
}
