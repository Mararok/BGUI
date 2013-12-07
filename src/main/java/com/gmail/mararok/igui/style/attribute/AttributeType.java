/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.style.attribute;

public enum AttributeType {
	halign(HAlignAttribute.class),
	valign(VAlignAttribute.class),
	
	color(ColorAttribute.class),
	
	background(BackgroundAttribute.class),
	
	size(SizeAttribute.class),
	
	position(PositionAttribute.class),
	
	border(BorderAttribute.class),
	
	opacity(OpactityAttribute.class),
	
	font(FontAttribute.class),
	
	margin(MarginAttribute.class),
	
	padding(PaddingAttribute.class);

	private Class<? extends Attribute> attributeClass;
	
	private AttributeType(Class<? extends Attribute> attributeClass) {
		this.attributeClass = attributeClass;
	}
	
	public Attribute createValue() {
		try {
			return (Attribute) attributeClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
