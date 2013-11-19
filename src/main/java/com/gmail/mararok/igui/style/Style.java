/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.style;

import java.util.HashMap;
import java.util.List;

import com.gmail.mararok.igui.control.Region;
import com.gmail.mararok.igui.style.attribute.Attribute;
import com.gmail.mararok.igui.style.attribute.AttributeType;

public class Style {
	private HashMap<AttributeType,Attribute> attributes;
	
	public Style() {
		attributes = new HashMap<AttributeType,Attribute>();
	}
	
	public Attribute getAttribute(AttributeType attributeType) {
		if (attributeType.isMain())
			return attributes.get(attributeType);
		else {
			return attributes.get(attributeType.getMainType());
		}
	}
	
	public Attribute addAttribute(AttributeType attributeType) {
		if (attributeType.isMain()) {
			return attributes.put(attributeType,attributeType.createValue());
		} else {
			return attributes.put(attributeType.getMainType(),attributeType.createValue());
		}
	}
	
	public void setAttribute(AttributeType attributeType, String newValue) {
		Attribute attribute = getAttribute(attributeType);
		if (attribute == null) {
			attribute = addAttribute(attributeType);
			attribute.setValue(newValue);
			
			notifyRegions(attributeType);
		}
	}
	
	private void notifyRegions(AttributeType attributeType) {
		for (Region region : regionsUsedStyle) {
			region.updateStyleAttribute(attributeType);
		}
	}

	public void addRegion(Region region) {
		regionsUsedStyle.add(region);
	}
	
	public void removeRegion(Region region) {
		regionsUsedStyle.remove(region);
	}

}
