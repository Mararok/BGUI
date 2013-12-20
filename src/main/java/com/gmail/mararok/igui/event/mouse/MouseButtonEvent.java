/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.event.mouse;

import com.gmail.mararok.igui.event.EventsType;

public class MouseButtonEvent extends MouseEvent {
	private MouseButton button;
	
	public MouseButtonEvent(EventsType type, long time, int x, int y, MouseButton button) {
		super(type, time, x, y);
	}

	public MouseButton getButton() {
		return button;
	}
	
	public void setButton(MouseButton newButton) {
		button = newButton;
	}
}
