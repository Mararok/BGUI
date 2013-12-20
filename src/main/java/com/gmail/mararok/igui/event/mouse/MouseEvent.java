/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.event.mouse;

import com.gmail.mararok.igui.event.EventsType;
import com.gmail.mararok.igui.event.ImpactEvent;

public abstract class MouseEvent extends ImpactEvent {
	private int x;
	private int y;
	
	public MouseEvent(EventsType type, long time, int x, int y) {
		super(type,time);
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
