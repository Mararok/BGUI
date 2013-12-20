/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.event.mouse;

import com.gmail.mararok.igui.event.EventsType;

public class MouseMotionEvent extends MouseEvent {
	private int dx;
	private int dy;
	
	public MouseMotionEvent(long time, int x, int y, int dx, int dy) {
		super(EventsType.MouseMotionEvent,time,x,y);
		this.dx = dx;
		this.dy = dy;
	}
	
	public int getDX() {
		return dx;
	}
	
	public int getDY() {
		return dy;
	}

}
