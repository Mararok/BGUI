/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.test.jme;

import com.gmail.mararok.igui.ImpactGUI;
import com.gmail.mararok.igui.jme.input.JMEInputDevice;
import com.gmail.mararok.igui.jme.render.JMERenderDevice;
import com.gmail.mararok.igui.scene.Scene;
import com.gmail.mararok.igui.spi.render.RenderDevice;
import com.jme3.app.SimpleApplication;

public class JMEImpactGUITestApplication extends SimpleApplication {
	private ImpactGUI igui;
	private Scene testScene;
	@Override
	public void simpleInitApp() {
		igui = new ImpactGUI(new JMERenderDevice(guiNode,assetManager,cam),new JMEInputDevice(inputManager));
		testScene = igui.getSceneManager().createScene("TestScene");
		igui.getSceneManager().setCurrentScene("testScene");
		JMETextVisualNodeTest test = new JMETextVisualNodeTest(this);
		//JMEGeometryVisualNodeTest test = new JMEGeometryVisualNodeTest(this);
		test.init();
	}

	public ImpactGUI getIGUI() {
		return igui;
	}
	
	public RenderDevice getRenderDevice() {
		return getIGUI().getRenderDevice();
	}
	
	public Scene getTestScene() {
		return testScene;
	}
	
	public static void main(String[] args) {
		JMEImpactGUITestApplication app = new JMEImpactGUITestApplication();
		app.start();
	}
}
