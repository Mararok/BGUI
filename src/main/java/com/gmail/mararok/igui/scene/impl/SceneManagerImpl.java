/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.scene.impl;

import java.util.HashMap;

import com.gmail.mararok.igui.ImpactGUI;
import com.gmail.mararok.igui.scene.Scene;
import com.gmail.mararok.igui.scene.SceneManager;
import com.gmail.mararok.igui.spi.input.InputDevice;
import com.gmail.mararok.igui.spi.render.RenderDevice;
import com.gmail.mararok.igui.spi.sound.SoundDevice;
import com.gmail.mararok.igui.spi.time.TimeProvider;

public class SceneManagerImpl implements SceneManager {
	private HashMap<String,Scene> scenes;
	private Scene currentScene;
	
	private ImpactGUI gui;
	
	public SceneManagerImpl(ImpactGUI gui) {
		scenes = new HashMap<String,Scene>();
		this.gui = gui;
	}
	
	@Override
	public Scene createScene(String sceneName) {
		Scene scene = (Scene) new SceneImpl(sceneName,this);
		scenes.put(sceneName,scene);
		return scene;
	}
	
	@Override
	public void removeScene(String sceneName) {
		if (currentScene != null && currentScene.getName() == sceneName) {
			currentScene.onDisable();
			currentScene = null;
		}
		
		scenes.remove(sceneName);
	}
	@Override
	public Scene getCurrentScene() {
		return currentScene;
	}
	@Override
	public void setCurrentScene(String sceneName) {
		if (currentScene != null) {
			currentScene.onDisable();
		}
		
		currentScene = scenes.get(sceneName);
	}

	@Override
	public ImpactGUI getGUI() {
		return gui;
	}
	
	@Override
	public RenderDevice getRenderDevice() {
		return gui.getRenderDevice();
	}

	@Override
	public InputDevice getInputDevice() {
		return gui.getInputDevice();
	}

	@Override
	public SoundDevice getSoundDevice() {
		return gui.getSoundDevice();
	}

	@Override
	public TimeProvider getTimeProvider() {
		return gui.getTimeProvider();
	}
}
