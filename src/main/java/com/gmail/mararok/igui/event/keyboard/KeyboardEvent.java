/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.event.keyboard;

import java.util.BitSet;

import com.gmail.mararok.igui.event.ImpactEvent;

public abstract class KeyboardEvent extends ImpactEvent {
	private int keyCode;
	private BitSet modifiers;
	
	public KeyboardEvent(long time, int keyCode, BitSet modifiers) {
		super(time);
		this.keyCode = keyCode;
		this.modifiers = modifiers;
	}

	public int getKeyCode() {
		return keyCode;
	}
	
	public char getKeyChar() {
		return (char)keyCode;
	}
	
	public boolean isControlDown() {
		return isModifierDown(KeyModifierType.CONTROL);
	}
	
	public boolean isAltDown() {
		return isModifierDown(KeyModifierType.ALT);
	}
	
	public boolean isShiftDown() {
		return isModifierDown(KeyModifierType.SHIFT);
	}
	
	private boolean isModifierDown(KeyModifierType modifier) {
		return modifiers.get(modifier.ordinal());
		
	}
	
	public String toString() {
		return String.format("%s, kc: %s, kch:%s, km:C%b|A%b|S%b",
			super.toString(),getKeyCode(),getKeyChar(),isControlDown(),isAltDown(), isShiftDown());
		
	}
}
