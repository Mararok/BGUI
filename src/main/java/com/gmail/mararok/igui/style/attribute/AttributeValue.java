/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.style.attribute;

import javax.script.Bindings;

public class AttributeValue {
	private Object rawValue;
	private Bindings rawSubValues;
	
	public AttributeValue(Object rawValue) {
		this.rawValue = rawValue;
	}
	
	public AttributeValue(Bindings rawValues) {
		this.rawSubValues = rawValues;
	}
	
	public Object getValue() {
		return rawValue;
	}
	
	public Object getSubValue(String subAttributeName) {
		return rawSubValues.get(subAttributeName);
	}
}
