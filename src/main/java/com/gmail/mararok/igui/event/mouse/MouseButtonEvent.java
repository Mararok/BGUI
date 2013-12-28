/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.event.mouse;


abstract public class MouseButtonEvent extends MouseEvent {
	private MouseButton button;
	
	public MouseButtonEvent(long time, int x, int y, MouseButton button) {
		super(time,x,y);
	}

	public MouseButton getButton() {
		return button;
	}
	
	public void setButton(MouseButton newButton) {
		button = newButton;
	}
}
