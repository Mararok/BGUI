/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.event.mouse;

import com.gmail.mararok.igui.event.ImpactEvent;

public class MouseEvent implements ImpactEvent {
	private int x;
	private int y;
	
	private int dx;
	private int dy;
	
	public MouseEvent(int x, int y, int dx, int dy) {
		this.x = x;
		this.y = y;
		
		this.dx = dx;
		this.dy = dy;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public int getDX() {
		return dx;
	}
	
	public int getDY() {
		return dy;
	}
}
