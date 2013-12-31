/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.style;

import java.util.EnumMap;

import com.gmail.mararok.igui.scene.SceneNode;
import com.gmail.mararok.igui.style.attributes.Attribute;
import com.gmail.mararok.igui.style.attributes.AttributeType;
import com.gmail.mararok.igui.style.attributes.AttributeValue;

public class Style {
	private EnumMap<AttributeType,Attribute> attributes;
	private Region region;
	
	public Style(SceneNode region) {
		attributes = new EnumMap<AttributeType,Attribute>(AttributeType.class);
		this.region = region;
	}
	
	@SuppressWarnings("unchecked")
	public <T extends Attribute> T getAttribute(AttributeType type) {
		Attribute attribute = attributes.get(type);
		if (attribute == null) {
			attribute = addAttribute(type);
		}
		
		return (T)attribute;
	}
	
	public boolean hasAttribute(AttributeType type)  {
		return getAttribute(type) != null;
	}
	
	public void setAttribute(AttributeType type, AttributeValue newValue) {
		if (newValue == null) {
			if (hasAttribute(type)) {
				removeAttribute(type);
			}
			return;
		}
		
		Attribute attribute = getAttribute(type);
		attribute.setValue(newValue);
	}
	
	public void updateAttribute(AttributeType type) {
		region.updateAttribute(type,getAttribute(type));
	}
	
	private Attribute addAttribute(AttributeType type) {
		Attribute newValue = type.createValue();
		newValue.setStyle(this);
		attributes.put(type,newValue);
		return newValue;
	}
	
	private void removeAttribute(AttributeType type) {
		attributes.remove(type);
	}


}
