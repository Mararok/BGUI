/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.spi.input;

import com.gmail.mararok.igui.ImpactGUI;
import com.gmail.mararok.igui.spi.render.MouseCursor;
import com.jme3.math.Vector2f;

public interface InputDevice {
	Vector2f getCursorPosition();
	
	void setCursorVisible(boolean visible);
	
	void setDefaultMouseCursor();
	void setMouseCursor(MouseCursor newMouseCursor);
	
	void setGUI(ImpactGUI gui);
}
