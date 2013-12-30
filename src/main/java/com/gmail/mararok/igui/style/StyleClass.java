/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.style;

import java.util.List;

import com.gmail.mararok.igui.style.attributes.AttributeType;

public class StyleClass extends Style {
	private String name;
	private StyleClass superClass;
	private StyleClass[] subClasses;
	//private EnumMap<PseudoClass,Style> pseudoClasses;
	
	private List<Region> regions;
	
	public StyleClass(String name, StyleClass superClass) {
		this(name,superClass,null);
	}
	
	public StyleClass(String name, StyleClass superClass, StyleClass[] subClasses) {
		super(null);
		this.name = name;
		this.superClass = superClass;
		this.subClasses = subClasses;
	}
	
	public String getName() {
		return name;
	}
	
	public StyleClass getSuperClass() {
		return superClass;
	}
	
	StyleClass[] getSubClasses() {
		return subClasses;
	}
	
	@Override
	public void updateAttribute(AttributeType type) {
		for (Region region : regions) {
			region.updateAttribute(type,getAttribute(type));
		}
	}
}
