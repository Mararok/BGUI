/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.test.jme;

import com.gmail.mararok.igui.render.RGBAColor;
import com.gmail.mararok.igui.spi.render.TextVisualNode;

public class JMETextVisualNodeTest extends JMETest {
	public JMETextVisualNodeTest(JMEImpactGUITestApplication app) {
		super(app);
	}

	@Override
	public void init() {
		
		TextVisualNode text = app.getRenderDevice().createTextNode();
		text.setColor(RGBAColor.WHITE);
		text.setText("TEST JME TextVisualNode class");
		text.setTranslation(300,300,1);
		app.getRenderDevice().getRootGUINode().attachChild(text);

	}

}
