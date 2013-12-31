/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.test.event;

import java.util.BitSet;

import com.gmail.mararok.BUTJ.TEST;
import com.gmail.mararok.BUTJ.TestCase;
import com.gmail.mararok.igui.event.keyboard.KeyModifierType;
import com.gmail.mararok.igui.event.keyboard.KeyboardEvent;

public class KeyboardEventsCase extends TestCase {

	public KeyboardEventsCase() {
		super("KeybordEvents");
	}
	
	private static class TestKeyboardEvent extends KeyboardEvent {

		public TestKeyboardEvent(long time, int keyCode, BitSet modifiers) {
			super(time, keyCode, modifiers);
		}
		
	}
	
	@TEST
	public void keyboardEvent() {
		BitSet modifiers = new BitSet(KeyModifierType.values().length);
		KeyboardEvent event = new TestKeyboardEvent(1,(int)'a',modifiers);
		
		it.expect(event.getName()).toBeEqual("TestKeyboardEvent");
		it.expect(event.getKeyCode()).toBeEqual((int)'a');
		it.expect(event.getKeyChar()).toBeEqual('a');
		
		it.expect(event.isControlDown()).toBeFalse();
		it.expect(event.isShiftDown()).toBeFalse();
		it.expect(event.isAltDown()).toBeFalse();
		
		modifiers.set(KeyModifierType.CONTROL.ordinal());
		it.expect(event.isControlDown()).toBeTrue();
		modifiers.clear(KeyModifierType.CONTROL.ordinal());
		
		modifiers.set(KeyModifierType.SHIFT.ordinal());
		it.expect(event.isShiftDown()).toBeTrue();
		modifiers.clear(KeyModifierType.SHIFT.ordinal());
		
		modifiers.set(KeyModifierType.ALT.ordinal());
		it.expect(event.isAltDown()).toBeTrue();
		modifiers.clear(KeyModifierType.ALT.ordinal());
	}

}
