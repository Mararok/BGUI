/**
 * BGUI
 * The MIT License
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.bgui;

import com.gmail.mararok.bgui.scene.SceneManager;
import com.gmail.mararok.bgui.scene.impl.SceneMangerImpl;
import com.gmail.mararok.bgui.spi.render.RenderDevice;

public class BGUI {
	private RenderDevice renderDevice;
	private SceneManager sceneManager;
	
	public BGUI(RenderDevice renderDevice) {
		this.renderDevice = renderDevice;
		sceneManager = new SceneMangerImpl();
	}
	
	public RenderDevice getRenderDevice() {
		return renderDevice;
	}
	
	public SceneManager getSceneManager() {
		return sceneManager;
	}
}
