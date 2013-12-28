/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.control.standard;

import com.gmail.mararok.igui.render.RGBAColor;
import com.gmail.mararok.igui.style.Region;

public interface Panel extends Region {

	RGBAColor getBackgroundColor();
	void setBackgroundColor(RGBAColor newColor);
}
