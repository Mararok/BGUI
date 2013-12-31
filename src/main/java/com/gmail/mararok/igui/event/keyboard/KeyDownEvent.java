/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.event.keyboard;

import java.util.BitSet;

public class KeyDownEvent extends KeyboardEvent {

	public KeyDownEvent(long time, int keyCode, BitSet modifiers) {
		super(time,keyCode,modifiers);
	}

}
