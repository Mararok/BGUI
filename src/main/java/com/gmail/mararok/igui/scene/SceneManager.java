/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.scene;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
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
	private SceneScriptEngineContext scriptContext;
	
	private ImpactGUI gui;
	
	public SceneManager(ImpactGUI gui) {
		scenes = new THashMap<String,Scene>();
		scriptContext = new SceneScriptEngineContext(gui.getScriptEngine());
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
		Scene scene = null;
		try {
			Object rawScene = scriptContext.eval(Files.newBufferedReader(path,Charset.defaultCharset()));
			// TODO proccess raw scene data.
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return scene;
	}
	
	
	public Scene getCurrentScene() {
		return currentScene;
	}
	
	public void setCurrentScene(String sceneName) {
		if (sceneName == null) {
			currentScene = null;
			return;
		}
		
		currentScene = scenes.get(sceneName);
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
		System.out.println(event);
		if (currentScene != null) {
			currentScene.onEvent(event);
		}
	}
}
