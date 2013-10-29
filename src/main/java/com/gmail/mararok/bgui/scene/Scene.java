/**
 * BGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.bgui.scene;

import com.gmail.mararok.bgui.spi.render.RenderDevice;

public interface Scene {
	String getName();
	ParentSceneNode getRootNode();
	SceneManager getSceneManager();
	
	RenderDevice getRenderDevice();
	
	void onEnable();
	void onDisable();
}
