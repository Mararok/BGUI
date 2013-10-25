/**
 * BGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.bgui.scene;

public interface Scene {
	String getName();
	ContainerSceneNode getRootNode();
	SceneManager getSceneManager();
	
	void onEnable();
	void onDisable();
}
