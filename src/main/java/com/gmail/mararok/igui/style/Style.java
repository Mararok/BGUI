/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.style;

import java.util.EnumMap;

import com.gmail.mararok.igui.control.ControlRegion;
import com.gmail.mararok.igui.style.attribute.Attribute;
import com.gmail.mararok.igui.style.attribute.AttributeType;
import com.gmail.mararok.igui.style.attribute.AttributeValue;

public class Style {
	private EnumMap<AttributeType,Attribute> attributes;
	
	private ControlRegion region;
	
	public Style() {
		attributes = new EnumMap<AttributeType,Attribute>(AttributeType.class);
	}
	
	public Style(ControlRegion region) {
		attributes = new EnumMap<AttributeType,Attribute>(AttributeType.class);
		this.region = region;
	}
	
	public Attribute getAttribute(AttributeType type) {
		return attributes.get(type);
	}
	
	public boolean hasAttribute(AttributeType type)  {
		return getAttribute(type) != null;
	}
	
	public void setAttribute(AttributeType type, AttributeValue newValue) {
		Attribute attribute = getAttribute(type);
		if (attribute == null) {
			if (newValue != null) {
				addAttribute(type).setValue(newValue);
			}
		} else {
			if (newValue == null) {
				removeAttribute(type);
			} else {
				attribute.setValue(newValue);
			}
		}
		updateAttribute(type);
	}
	
	public void updateAttribute(AttributeType type) {
		region.updateAttribute(type);
	}
	
	private Attribute addAttribute(AttributeType attributeType) {
		return attributes.put(attributeType,attributeType.createValue());
	}
	
	private void removeAttribute(AttributeType attributeType) {
		attributes.remove(attributeType);
	}


}
