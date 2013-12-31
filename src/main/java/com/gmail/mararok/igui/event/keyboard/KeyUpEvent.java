/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.event.keyboard;

import java.util.BitSet;

public class KeyUpEvent extends KeyboardEvent {

	public KeyUpEvent(long time, int keyCode, BitSet modifiers) {
		super(time,keyCode,modifiers);
	}
}
