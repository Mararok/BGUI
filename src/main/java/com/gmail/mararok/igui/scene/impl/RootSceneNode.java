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
		super("");
		this.scene = scene;
	}
	
	@Override
	public Scene getScene() {
		return scene;
	}
}
