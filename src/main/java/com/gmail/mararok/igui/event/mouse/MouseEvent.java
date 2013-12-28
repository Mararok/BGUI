/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.event.mouse;

import com.gmail.mararok.igui.event.ImpactEvent;
import com.gmail.mararok.igui.scene.SceneNode;

public abstract class MouseEvent extends ImpactEvent {
	private int x;
	private int y;
	
	public MouseEvent(long time, int x, int y) {
		this(time,x,y,null);
	}
	
	public MouseEvent(long time, int x, int y, SceneNode target) {
		super(time,target);
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int newX) {
		x = newX;
	}

	public int getY() {
		return y;
	}
	
	public void setY(int newY) {
		y = newY;
	}
	
	@Override
	public String toString() {
		return super.toString()+" MC["+x+","+y+"]";
	}
}
