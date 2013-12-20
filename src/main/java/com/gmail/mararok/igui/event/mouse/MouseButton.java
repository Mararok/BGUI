/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.event.mouse;

public enum MouseButton {
	PRIMARY,
	MIDDLE,
	SECONDARY,
	
	BUTTON4,
	BUTTON5;
	
	public static MouseButton fromIndex(int index) {
		return MouseButton.values()[index];
	}
}
