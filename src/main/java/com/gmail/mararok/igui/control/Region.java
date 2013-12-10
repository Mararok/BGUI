/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.control;

import com.gmail.mararok.igui.style.Styleable;

public interface Region extends Styleable {
	
	int getLocalCenterX();
	int getLocalCenterY();
	
	int getLocalZ();
	void setLocalZ(int newZ);
	
	int getLocalLeft();
	void setLocalLeft(int newLeft);
	
	int getLocalTop();
	void setLocalTop(int newTop);
	
	int getLocalRight();
	void setLocalRight(int newRight);
	
	int getLocalBottom();
	void setLocalBottom(int newBottom);
	
	int getWidth();
	void setWidth(int newWidth);
	
	int getHeight();
	void setHeight(int newHeight);
	
	void setSize(int newWidth, int newHeight);
		
}
