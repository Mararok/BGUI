/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.event.mouse;

import com.gmail.mararok.igui.scene.SceneNode;

public class MouseOverEvent extends MouseEvent {

	public MouseOverEvent(long time, int x, int y, SceneNode target) {
		super(time,x,y,target);
	}

}
