/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.scene;

public class RootSceneNode extends ParentSceneNode {
	
	public RootSceneNode(Scene scene) {
		super();
		this.scene = scene;
		setSize(scene.getRenderDevice().getWidth(),scene.getRenderDevice().getHeight());
	}
}
