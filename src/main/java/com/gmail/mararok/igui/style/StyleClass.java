/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.style;

import java.util.List;

public class StyleClass extends Style {
	private String name;
	private StyleClass superClass;
	private StyleClass[] subClasses;
	//private EnumMap<PseudoClass,Style> pseudoClasses;
	
	private List<RegionImpl> regions;
	
	public StyleClass(String name, StyleClass superClass) {
		this(name,superClass,null);
	}
	
	public StyleClass(String name, StyleClass superClass, StyleClass[] subClasses) {
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
}
