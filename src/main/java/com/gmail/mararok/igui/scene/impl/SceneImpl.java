/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.scene.impl;

import com.gmail.mararok.igui.scene.ParentSceneNode;
import com.gmail.mararok.igui.scene.Scene;
import com.gmail.mararok.igui.scene.SceneManager;
import com.gmail.mararok.igui.spi.render.RenderDevice;

public class SceneImpl implements Scene {
	private String name;
	private RootSceneNode rootNode;
	
	private SceneManager sceneManager;
	
	public SceneImpl(String name, SceneManager sceneManager) {
		this.name = name;
		this.sceneManager = sceneManager;
		rootNode = new RootSceneNode(this);
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
