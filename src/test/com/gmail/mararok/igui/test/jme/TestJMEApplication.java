/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.test.jme;

import com.gmail.mararok.igui.ImpactGUI;
import com.gmail.mararok.igui.jme.input.JMEInputDevice;
import com.gmail.mararok.igui.jme.render.JMERenderDevice;
import com.gmail.mararok.igui.render.RGBAColor;
import com.gmail.mararok.igui.sc.Label;
import com.gmail.mararok.igui.sc.Panel;
import com.gmail.mararok.igui.sc.impl.LabelImpl;
import com.gmail.mararok.igui.sc.impl.PanelImpl;
import com.gmail.mararok.igui.spi.render.Font.Style;
import com.jme3.app.SimpleApplication;

public class TestJMEApplication extends SimpleApplication {
	ImpactGUI impactGUI;
	@Override
	public void simpleInitApp() {
		impactGUI = new ImpactGUI(new JMERenderDevice(guiNode,assetManager,renderer),new JMEInputDevice());
		impactGUI.getSceneManager().createScene("testScene");
		impactGUI.getSceneManager().setCurrentScene("testScene");
		Panel p = new PanelImpl(impactGUI);
		Label lb = new LabelImpl(impactGUI);
		impactGUI.getSceneManager().getCurrentScene().getRootNode().attachChild(p);
		impactGUI.getSceneManager().getCurrentScene().getRootNode().attachChild(lb);
		lb.setFont(impactGUI.getRenderDevice().createFont("Arial",Style.PLAIN,12));
		lb.setText("TEXT");
		lb.setColor(RGBAColor.GREEN);
		p.setLocalLeft(0);
		p.setLocalTop(0);
		p.setSize(799,600);
		p.setBackgroundColor(RGBAColor.BLUE);
	}
	
	public static void main(String[] args) {
		TestJMEApplication application = new TestJMEApplication();
		application.start();
	}

}
