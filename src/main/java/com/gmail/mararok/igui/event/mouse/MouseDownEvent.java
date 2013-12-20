/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.event.mouse;

import com.gmail.mararok.igui.event.EventsType;

public class MouseDownEvent extends MouseButtonEvent {
	
	public MouseDownEvent(long time, int x, int y, MouseButton button) {
		super(EventsType.MouseDownEvent,time,x,y,button);
	}
}
