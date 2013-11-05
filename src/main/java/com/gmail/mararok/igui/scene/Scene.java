/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.scene;

import com.gmail.mararok.igui.spi.render.RenderDevice;

public interface Scene {
	String getName();
	ParentSceneNode getRootNode();
	SceneManager getSceneManager();
	
	RenderDevice getRenderDevice();
	
	void onEnable();
	void onDisable();
}
