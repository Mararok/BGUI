/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.test.jme;

import com.gmail.mararok.igui.ImpactGUI;
import com.gmail.mararok.igui.jme.render.JMERenderDevice;
import com.jme3.app.SimpleApplication;

public class TestJMEApplication extends SimpleApplication {
	ImpactGUI ImpactGUI;
	@Override
	public void simpleInitApp() {
		ImpactGUI = new ImpactGUI(new JMERenderDevice(this));
		ImpactGUI.getSceneManager().createScene("testScene");
		ImpactGUI.getSceneManager().setCurrentScene("testScene");
	}
	
	public static void main(String[] args) {
		TestJMEApplication application = new TestJMEApplication();
		application.start();
	}

}
