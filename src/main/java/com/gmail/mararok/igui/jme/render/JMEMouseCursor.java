/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.jme.render;

import com.gmail.mararok.igui.spi.render.MouseCursor;
import com.jme3.cursors.plugins.JmeCursor;

public class JMEMouseCursor implements MouseCursor {
	private JmeCursor nativeCursor;
	
	JMEMouseCursor(JmeCursor nativeCursor) {
		this.nativeCursor = nativeCursor;
	}
	
	@Override
	public void dispose() {
	}

	public JmeCursor getNative() {
		return nativeCursor;
	}
}
