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
import com.jme3.scene.Node;

public class TestJMEApplication extends SimpleApplication {
	ImpactGUI impactGUI;
	@Override
	public void simpleInitApp() {
		impactGUI = new ImpactGUI(new JMERenderDevice(guiNode,assetManager),new JMEInputDevice());
		impactGUI.getSceneManager().createScene("testScene");
		impactGUI.getSceneManager().setCurrentScene("testScene");
		Panel p = new PanelImpl(impactGUI);
		p.setParent(impactGUI.getSceneManager().getCurrentScene().getRootNode());
		p.setLocalTranslation(200,200);
		System.out.println(((Node)((Node)guiNode.getChild(0)).getChild(0)).getChild(0));
	}
	
	public static void main(String[] args) {
		TestJMEApplication application = new TestJMEApplication();
		application.start();
	}

}
