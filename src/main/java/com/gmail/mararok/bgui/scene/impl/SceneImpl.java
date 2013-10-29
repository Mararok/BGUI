/**
 * BGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.bgui.scene.impl;

import com.gmail.mararok.bgui.scene.ParentSceneNode;
import com.gmail.mararok.bgui.scene.Scene;
import com.gmail.mararok.bgui.scene.SceneManager;
import com.gmail.mararok.bgui.spi.render.RenderDevice;

public class SceneImpl implements Scene {
	private String name;
	private RootSceneNode rootNode;
	
	private SceneManager sceneManager;
	
	public SceneImpl(String name, SceneManager sceneManager) {
		this.name = name;
		rootNode = new RootSceneNode(this);
		this.sceneManager = sceneManager;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public ParentSceneNode getRootNode() {
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
	public void onEnable() {
	}

	@Override
	public void onDisable() {
	}


}
