/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.test.jme;

import com.gmail.mararok.igui.render.QuadMemoryMesh;
import com.gmail.mararok.igui.spi.render.GeometryVisualNode;

public class JMEGeometryVisualNodeTest extends JMETest {

	public JMEGeometryVisualNodeTest(JMEImpactGUITestApplication app) {
		super(app);
	}

	@Override
	public void init() {
		GeometryVisualNode geo = app.getRenderDevice().createGeometryNode();
		geo.setMesh(new QuadMemoryMesh());
		geo.setTranslation(100,100,1);
		geo.setScale(100);
		app.getRenderDevice().getRootGUINode().attachChild(geo);
	}

}
