/**
 * BGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.bgui.scene.impl;

import com.gmail.mararok.bgui.scene.Scene;

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
