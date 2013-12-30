/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.scene;

import java.nio.file.Path;

import gnu.trove.map.hash.THashMap;

import com.gmail.mararok.igui.ImpactGUI;
import com.gmail.mararok.igui.event.ImpactEvent;
import com.gmail.mararok.igui.scene.SceneManager;
import com.gmail.mararok.igui.spi.input.InputDevice;
import com.gmail.mararok.igui.spi.render.RenderDevice;
import com.gmail.mararok.igui.spi.sound.SoundDevice;
import com.gmail.mararok.igui.spi.time.TimeProvider;

public class SceneManager {
	private THashMap<String,Scene> scenes;
	private Scene currentScene;
	
	private ImpactGUI gui;
	
	public SceneManager(ImpactGUI gui) {
		scenes = new THashMap<String,Scene>();
		this.gui = gui;
	}
	
	public Scene createScene(String sceneName) {
		Scene scene = new Scene(sceneName,this);
		scenes.put(sceneName,scene);
		return scene;
	}
	
	public void removeScene(String sceneName) {
		if (currentScene != null && currentScene.getID() == sceneName) {
			currentScene = null;
		}
		
		scenes.remove(sceneName);
	}
	
	public Scene loadScene(Path path) {
		return null;
	}
	
	
	public Scene getCurrentScene() {
		return currentScene;
	}
	
	public void setCurrentScene(String sceneName) {
		currentScene = (Scene)scenes.get(sceneName);
	}

	
	public ImpactGUI getGUI() {
		return gui;
	}
	
	
	public RenderDevice getRenderDevice() {
		return gui.getRenderDevice();
	}

	
	public InputDevice getInputDevice() {
		return gui.getInputDevice();
	}

	
	public SoundDevice getSoundDevice() {
		return gui.getSoundDevice();
	}

	
	public TimeProvider getTimeProvider() {
		return gui.getTimeProvider();
	}

	public void onEvent(ImpactEvent event) {
		if (currentScene != null) {
			currentScene.onEvent(event);
		}
	}
}
