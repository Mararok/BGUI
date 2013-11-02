/**
 * BGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.bgui.test.jme;

import com.gmail.mararok.bgui.BGUI;
import com.gmail.mararok.bgui.jme.render.JMERenderDevice;
import com.jme3.app.SimpleApplication;

public class TestJMEApplication extends SimpleApplication {
	BGUI bgui;
	@Override
	public void simpleInitApp() {
		bgui = new BGUI(new JMERenderDevice(this));
		bgui.getSceneManager().createScene("testScene");
		bgui.getSceneManager().setCurrentScene("testScene");
	}
	
	public static void main(String[] args) {
		TestJMEApplication application = new TestJMEApplication();
		application.start();
	}

}
