/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.scene;

import com.gmail.mararok.igui.spi.render.RenderDevice;

public interface SceneManager {
	Scene createScene(String sceneName);
	void removeScene(String sceneName);
	
	Scene getCurrentScene();
	void setCurrentScene(String sceneName);
	
	RenderDevice getRenderDevice();
}
