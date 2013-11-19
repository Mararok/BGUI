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
	backgroundColor(background),
	backgroundImage(background);
	
	/*minWidth,
	width,
	maxWidth,
	
	minHeight,
	height,
	maxHeight,
	
	border,
	borderColor,
	borderStyle,
	borderRadius,
	
	opacity,
	
	font,
	fontSize,
	fontStyle,
	
	margin,
	marginLeft,
	marginTop,
	marginRgiht,
	marginBottom,
	
	padding,
	paddingLeft,
	paddingTop,
	paddingRgiht,
	paddingBottom;*/

	private Class<? extends Attribute> attributeClass;
	private AttributeType mainType;
	
	private AttributeType(AttributeType mainType) {
		this.mainType = mainType;
	}
	
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

	public AttributeType getMainType() {
		return mainType;
	}
	
	public boolean isMain() {
		return ( mainType == null );
	}
	
}
