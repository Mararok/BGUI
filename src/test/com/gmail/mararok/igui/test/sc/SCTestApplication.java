/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.igui.test.sc;

import com.gmail.mararok.igui.ImpactGUI;
import com.gmail.mararok.igui.control.standard.Label;
import com.gmail.mararok.igui.control.standard.Panel;
import com.gmail.mararok.igui.jme.input.JMEInputDevice;
import com.gmail.mararok.igui.jme.render.JMERenderDevice;
import com.gmail.mararok.igui.render.RGBAColor;
import com.gmail.mararok.igui.scene.Scene;
import com.gmail.mararok.igui.spi.render.RenderDevice;
import com.gmail.mararok.igui.style.attributes.AttributeType;
import com.gmail.mararok.igui.style.attributes.BackgroundAttribute;
import com.jme3.app.SimpleApplication;

public class SCTestApplication extends SimpleApplication {
	private ImpactGUI igui;
	private Scene testScene;
	@Override
	public void simpleInitApp() {
		flyCam.setDragToRotate(true);
		igui = new ImpactGUI(new JMERenderDevice(guiNode,assetManager,cam),new JMEInputDevice(inputManager));
		testScene = igui.getSceneManager().createScene("TestScene");
		igui.getSceneManager().setCurrentScene("TestScene");
		
		
		Panel leftPanel = new Panel();
		((BackgroundAttribute)leftPanel.getStyle().getAttribute(AttributeType.background)).setColor(RGBAColor.RED);
		leftPanel.setSize(300,300);
		leftPanel.setID("leftPanel");
		
		Label label = new Label();
		label.setText("TEST text");
		//label.setPosition(100,100);
		
		System.out.println(label.getWidth());
		Panel rightPanel = new Panel();
		((BackgroundAttribute)rightPanel.getStyle().getAttribute(AttributeType.background)).setColor(RGBAColor.BLUE);
		rightPanel.setSize(300,300);
		rightPanel.setLocalX(400);
		rightPanel.setID("rightPanel");
		testScene.attachChild(rightPanel);
		testScene.attachChild(label);
		testScene.attachChild(leftPanel);
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
