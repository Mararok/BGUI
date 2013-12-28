/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.event.mouse;

import com.gmail.mararok.igui.scene.SceneNode;

public class MouseOutEvent extends MouseEvent {

	public MouseOutEvent(long time, int x, int y, SceneNode target) {
		super(time,x,y,target);
	}

	@Override
	public String getName() {
		return "MouseOutEvent";
	}

}
