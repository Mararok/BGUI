/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.spi.input;

import com.jme3.math.Vector2f;

public interface InputDevice {
	void update();
	Vector2f getMousePosition();
	void setMousePosition(int x, int y);
}
