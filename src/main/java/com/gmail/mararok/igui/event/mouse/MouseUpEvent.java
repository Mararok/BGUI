/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.event.mouse;

import com.gmail.mararok.igui.event.EventsType;

public class MouseUpEvent extends MouseButtonEvent {
	public MouseUpEvent(long time, int x, int y, MouseButton button) {
		super(EventsType.MouseUpEvent,time,x,y,button);
	}
}
