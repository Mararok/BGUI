/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.scene.impl;

import java.nio.file.Path;

import gnu.trove.map.hash.THashMap;

import com.gmail.mararok.igui.ImpactGUI;
import com.gmail.mararok.igui.event.ImpactEvent;
import com.gmail.mararok.igui.scene.Scene;
import com.gmail.mararok.igui.scene.SceneManager;
import com.gmail.mararok.igui.spi.input.InputDevice;
import com.gmail.mararok.igui.spi.render.RenderDevice;
import com.gmail.mararok.igui.spi.sound.SoundDevice;
import com.gmail.mararok.igui.spi.time.TimeProvider;

public class SceneManagerImpl implements SceneManager {
	private THashMap<String,Scene> scenes;
	private SceneImpl currentScene;
	
	private ImpactGUI gui;
	
	public SceneManagerImpl(ImpactGUI gui) {
		scenes = new THashMap<String,Scene>();
		this.gui = gui;
	}
	
	@Override
	public Scene createScene(String sceneName) {
		Scene scene = new SceneImpl(sceneName,this);
		scenes.put(sceneName,scene);
		return scene;
	}
	
	@Override
	public void removeScene(String sceneName) {
		if (currentScene != null && currentScene.getID() == sceneName) {
			currentScene = null;
		}
		
		scenes.remove(sceneName);
	}
	
	@Override
	public Scene loadScene(Path path) {
		return null;
	}
	
	
	@Override
	public Scene getCurrentScene() {
		return currentScene;
	}
	@Override
	public void setCurrentScene(String sceneName) {
		currentScene = (SceneImpl)scenes.get(sceneName);
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

	public void onEvent(ImpactEvent event) {
		if (currentScene != null) {
			currentScene.onEvent(event);
		}
	}
}
