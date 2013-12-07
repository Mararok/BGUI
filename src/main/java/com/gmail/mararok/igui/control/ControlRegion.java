/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.control;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.gmail.mararok.igui.ImpactGUI;
import com.gmail.mararok.igui.scene.impl.ParentSceneNodeImpl;
import com.gmail.mararok.igui.style.Style;
import com.gmail.mararok.igui.style.StyleClass;
import com.gmail.mararok.igui.style.Styleable;
import com.gmail.mararok.igui.style.attribute.Attribute;
import com.gmail.mararok.igui.util.Rectangle;

public class ControlRegion extends ParentSceneNodeImpl implements Styleable {
	private Style style;
	private List<StyleClass> styleClasses;
	
	private Rectangle localBounds;
	private int z;
	
	public ControlRegion(ImpactGUI gui) {
		super(gui);
	}

	//@Override
	public Style getStyle() {
		if (style == null) {
			style = new Style(this);
		}
		
		return style;
	}

	@Override
	public void setStyle(Style newStyle) {
		style = newStyle;
	}

	@Override
	public StyleClass getStyleClass(String className) {
		for (StyleClass styleClass: styleClasses) {
			if (className == styleClass.getName()) {
				return styleClass;
			}
		}
		return null;
	}

	@Override
	public boolean hasStyleClass(String className) {
		return getStyleClass(className) != null;
	}

	@Override
	public void addStyleClass(StyleClass newClass) {
		if (hasStyleClass(newClass.getName())) {
			return;
		}
		
		if (styleClasses == null) {
			styleClasses = new LinkedList<StyleClass>();
		}
		styleClasses.add(newClass);
	}

	@Override
	public void removeStyleClass(String className) {
		if (styleClasses != null) {
			Iterator<StyleClass> it = styleClasses.iterator();
			while (it.hasNext()) {
				if (it.next().getName() == className) {
					it.remove();
					return;
				}
			}
		}
	}
	
	
	public void updateAttribute(Attribute attribute) {
		
	}
}
