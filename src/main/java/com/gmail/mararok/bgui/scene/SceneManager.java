/**
 * BGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.bgui.scene;

import com.gmail.mararok.bgui.spi.render.RenderDevice;

public interface SceneManager {
	Scene createScene(String sceneName);
	void removeScene(String sceneName);
	
	Scene getCurrentScene();
	void setCurrentScene(String sceneName);
	
	RenderDevice getRenderDevice();
}
