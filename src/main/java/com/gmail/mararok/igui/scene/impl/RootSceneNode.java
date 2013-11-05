/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.scene.impl;

import com.gmail.mararok.igui.scene.Scene;

public class RootSceneNode extends ParentSceneNodeImpl {
	private Scene scene;
	
	public RootSceneNode(Scene scene) {
		super(scene.getSceneManager().getGUI());
		this.scene = scene;
		mainVisualNode = getGUI().getRenderDevice().getRootGUINode();
	}
	
	@Override
	public Scene getScene() {
		return scene;
	}
}
