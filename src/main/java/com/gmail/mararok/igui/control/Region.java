/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.control;


import java.util.List;

import com.gmail.mararok.igui.ImpactGUI;
import com.gmail.mararok.igui.scene.impl.ParentSceneNodeImpl;
import com.gmail.mararok.igui.style.Style;
import com.gmail.mararok.igui.style.StyleClass;
import com.gmail.mararok.igui.style.attribute.AttributeType;

public class Region extends ParentSceneNodeImpl {
	private Style style;
	private List<StyleClass> styleClasses;
	public Region(ImpactGUI gui) {
		super(gui);
	}

	public void updateStyleAttribute(AttributeType attributeType) {
		
	}

	//@Override
	public Style getStyle() {
		return style;
	}
	
}
