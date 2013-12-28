/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.igui.test.sc;

import com.gmail.mararok.igui.ImpactGUI;
import com.gmail.mararok.igui.control.standard.Panel;
import com.gmail.mararok.igui.control.standard.impl.PanelImpl;
import com.gmail.mararok.igui.jme.input.JMEInputDevice;
import com.gmail.mararok.igui.jme.render.JMERenderDevice;
import com.gmail.mararok.igui.render.RGBAColor;
import com.gmail.mararok.igui.scene.Scene;
import com.gmail.mararok.igui.spi.render.RenderDevice;
import com.jme3.app.SimpleApplication;

public class SCTestApplication extends SimpleApplication {
	private ImpactGUI igui;
	private Scene testScene;
	@Override
	public void simpleInitApp() {
		igui = new ImpactGUI(new JMERenderDevice(guiNode,assetManager,cam),new JMEInputDevice(inputManager));
		testScene = igui.getSceneManager().createScene("TestScene");
		igui.getSceneManager().setCurrentScene("TestScene");
		inputManager.setCursorVisible(true);
		Panel leftPanel = new PanelImpl(getIGUI());
		Panel rightPanel = new PanelImpl(getIGUI());
		leftPanel.setBackgroundColor(RGBAColor.RED);
		leftPanel.setSize(400,600);
		leftPanel.setID("leftPanel");
		
		rightPanel.setBackgroundColor(RGBAColor.BLUE);
		rightPanel.setSize(400,600);
		rightPanel.setLocalX(400);
		rightPanel.setID("rightPanel");
		testScene.attachChild(leftPanel);
		testScene.attachChild(rightPanel);
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
		SCTestApplication app = new SCTestApplication();
		app.start();
	}

}
