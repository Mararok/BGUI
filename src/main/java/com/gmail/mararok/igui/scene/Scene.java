/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.scene;

import com.gmail.mararok.igui.control.Controller;
import com.gmail.mararok.igui.spi.render.RenderDevice;

public interface Scene {
	String getID();
	SceneNode getFocusedNode();
	void setFocusedNode(SceneNode sceneNode);
	
	SceneManager getSceneManager();
	RenderDevice getRenderDevice();
	
	ParentSceneNode getRoot();
	void attachChild(SceneNode child);
	void detachChild(SceneNode child);
	
	Controller getController(String name);
	void setController(String name, Controller controller);
}
