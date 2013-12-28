/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.event.mouse;

public class MouseMovedEvent extends MouseEvent {
	private int dx;
	private int dy;
	
	public MouseMovedEvent(long time, int x, int y, int dx, int dy) {
		super(time,x,y);
		this.dx = dx;
		this.dy = dy;
	}
	
	public int getDX() {
		return dx;
	}
	
	public int getDY() {
		return dy;
	}

	@Override
	public String getName() {
		return "MouseMovedEvent";
	}

}
