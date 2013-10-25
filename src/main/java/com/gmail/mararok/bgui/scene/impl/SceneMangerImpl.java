/**
 * BGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.bgui.scene.impl;

import java.util.HashMap;

import com.gmail.mararok.bgui.scene.Scene;
import com.gmail.mararok.bgui.scene.SceneManager;

public class SceneMangerImpl implements SceneManager {
	private HashMap<String,Scene> scenes;
	private Scene currentScene;
	
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
}
