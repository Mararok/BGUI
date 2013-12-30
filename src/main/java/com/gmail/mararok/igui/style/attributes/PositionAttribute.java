/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.style.attributes;

public class PositionAttribute extends Attribute {
	private int x;
	private int y;
	private int z;
	
	public int getX() {
		return x;
	}
	
	public void setX(int newX) {
		x = newX;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int newY) {
		y = newY;
	}
	
	public int getZ() {
		return z;
	}
	
	public void setZ(int newZ) {
		z = newZ;
	}

	@Override
	public void setValue(AttributeValue newValue) {
		Object value = newValue.getValue();
		if (value instanceof Object[]) {
			setFromArray((int[])value);
		} else {
			Integer subValue = (Integer)newValue.getSubValue("x");
			if (subValue != null) {
				setX(subValue);
			}
			
			subValue = (Integer)newValue.getSubValue("y");
			if (subValue != null) {
				setY(subValue);
			}
			
			subValue = (Integer)newValue.getSubValue("z");
			if (subValue != null) {
				setZ(subValue);
			}
		}
	}
	
	public void setFromArray(int[] values) {
		if (values.length > 1) {
			setX((int)values[0]);
			setY((int)values[1]);
			if (values.length == 3) {
				setZ((int)values[2]);
			}
		}
	}

	@Override
	public AttributeType getType() {
		return AttributeType.position;
	}
}
