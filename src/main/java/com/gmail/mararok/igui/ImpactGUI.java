/**
 * ImpactGUI
 * The MIT License
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.igui;

import com.gmail.mararok.igui.scene.SceneManager;
import com.gmail.mararok.igui.scene.impl.SceneMangerImpl;
import com.gmail.mararok.igui.spi.render.RenderDevice;

public class ImpactGUI {
	private RenderDevice renderDevice;
	private SceneManager sceneManager;
	
	public ImpactGUI(RenderDevice renderDevice) {
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
