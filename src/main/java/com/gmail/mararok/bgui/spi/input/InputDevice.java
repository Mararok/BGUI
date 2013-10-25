/**
 * BGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.bgui.spi.input;

public interface InputDevice {
	void update();
	void setMousePosition(int x, int y);
}
