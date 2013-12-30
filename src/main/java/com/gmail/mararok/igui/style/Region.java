/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.style;

import com.gmail.mararok.igui.style.attributes.Attribute;
import com.gmail.mararok.igui.style.attributes.AttributeType;

public interface Region extends Styleable {
	
	int getCenterX();
	int getCenterY();
	
	int getX();
	void setX(int newX);
	
	int getY();
	void setY(int newY);
	
	void setPosition(int newX, int newY);
	
	int getZ();
	void setZ(int newZ);
	
	
	int getLocalCenterX();
	int getLocalCenterY();
	
	int getLocalX();
	void setLocalX(int newX);
	
	int getLocalY();
	void setLocalY(int newY);
	
	void setLocalPosition(int newX, int newY);
	
	int getLocalZ();
	void setLocalZ(int newZ);
	
	int getWidth();
	void setWidth(int newWidth);
	
	int getHeight();
	void setHeight(int newHeight);
	
	void setSize(int newWidth, int newHeight);
	
	void updateAttribute(AttributeType type, Attribute attribute);
}
