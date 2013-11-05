/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.scene;

import com.gmail.mararok.igui.ImpactGUI;
import com.gmail.mararok.igui.spi.input.InputDevice;
import com.gmail.mararok.igui.spi.render.RenderDevice;
import com.gmail.mararok.igui.spi.sound.SoundDevice;
import com.gmail.mararok.igui.spi.time.TimeProvider;

public interface SceneManager {
	Scene createScene(String sceneName);
	void removeScene(String sceneName);
	
	Scene getCurrentScene();
	void setCurrentScene(String sceneName);
	
	ImpactGUI getGUI();
	RenderDevice getRenderDevice();
	InputDevice getInputDevice();
	SoundDevice getSoundDevice();
	TimeProvider getTimeProvider();
}
