/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.event.mouse;


public class MouseClickedEvent extends MouseButtonEvent {
	public MouseClickedEvent(long time, int x, int y, MouseButton button) {
		super(time,x,y,button);
	}
}
