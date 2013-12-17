/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.scene.impl;

import com.gmail.mararok.igui.scene.ParentSceneNode;
import com.gmail.mararok.igui.scene.Scene;
import com.gmail.mararok.igui.scene.SceneManager;
import com.gmail.mararok.igui.scene.SceneNode;
import com.gmail.mararok.igui.spi.render.RenderDevice;

public class SceneImpl implements Scene {
	private String id;
	private RootSceneNode rootNode;
	private SceneNode focusedNode;
	private SceneManager sceneManager;
	
	public SceneImpl(String id, SceneManager sceneManager) {
		this.id = id;
		this.sceneManager = sceneManager;
		rootNode = new RootSceneNode(this);
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

}
