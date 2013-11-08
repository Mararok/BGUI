/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.test.jme;

import com.gmail.mararok.igui.ImpactGUI;
import com.gmail.mararok.igui.jme.input.JMEInputDevice;
import com.gmail.mararok.igui.jme.render.JMERenderDevice;
import com.gmail.mararok.igui.sc.Panel;
import com.gmail.mararok.igui.sc.impl.PanelImpl;
import com.jme3.app.SimpleApplication;

public class TestJMEApplication extends SimpleApplication {
	ImpactGUI impactGUI;
	@Override
	public void simpleInitApp() {
		settings.setStencilBits(8);
		impactGUI = new ImpactGUI(new JMERenderDevice(guiNode,assetManager,renderer),new JMEInputDevice());
		impactGUI.getSceneManager().createScene("testScene");
		impactGUI.getSceneManager().setCurrentScene("testScene");
		Panel p = new PanelImpl(impactGUI);
		impactGUI.getSceneManager().getCurrentScene().getRootNode().attachChild(p);
		p.setPosition(50,50);
		p.setSize(100,100);
		Panel p2 = new PanelImpl(impactGUI);
		p.attachChild(p2);
		p2.setSize(200,200);
		p2.setPosition(100,100);
	}
	
	public static void main(String[] args) {
		TestJMEApplication application = new TestJMEApplication();
		application.start();
	}

}
