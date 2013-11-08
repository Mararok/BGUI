/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.control;

import com.gmail.mararok.igui.ImpactGUI;
import com.gmail.mararok.igui.scene.impl.ParentSceneNodeImpl;
import com.gmail.mararok.igui.style.Style;
import com.gmail.mararok.igui.style.Styleable;

public abstract class StyleableRegion extends ParentSceneNodeImpl implements Styleable {
	private Style currentStyle;
	
	public StyleableRegion(ImpactGUI gui) {
		super(gui);
	}

	@Override
	public void setStyle(String newStyle) {
		currentStyle.set(newStyle);
	}

	@Override
	public Style getStyle() {
		return currentStyle;
	}
	
}
