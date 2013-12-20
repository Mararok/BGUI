/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.sc;

import com.gmail.mararok.igui.control.Region;
import com.gmail.mararok.igui.render.RGBAColor;

public interface Panel extends Region {

	RGBAColor getBackgroundColor();
	void setBackgroundColor(RGBAColor newColor);
}
