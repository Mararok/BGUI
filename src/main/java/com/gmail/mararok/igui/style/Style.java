/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.style;

import java.util.EnumMap;

import com.gmail.mararok.igui.style.attributes.Attribute;
import com.gmail.mararok.igui.style.attributes.AttributeType;
import com.gmail.mararok.igui.style.attributes.AttributeValue;

public class Style {
	private EnumMap<AttributeType,Attribute> attributes;
	
	private RegionImpl region;
	
	public Style() {
		attributes = new EnumMap<AttributeType,Attribute>(AttributeType.class);
	}
	
	public Style(RegionImpl region) {
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
	
	private void updateAttribute(AttributeType type) {
		region.updateAttribute(type,getAttribute(type));
	}
	
	private Attribute addAttribute(AttributeType attributeType) {
		return attributes.put(attributeType,attributeType.createValue());
	}
	
	private void removeAttribute(AttributeType attributeType) {
		attributes.remove(attributeType);
	}


}
