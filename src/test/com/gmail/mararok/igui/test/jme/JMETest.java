/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.test.jme;

public abstract class JMETest {
	protected JMEImpactGUITestApplication app;
	public JMETest(JMEImpactGUITestApplication app) {
		this.app = app;
	}
	
	public abstract void init();
}
