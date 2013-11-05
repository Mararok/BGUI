/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.spi.sound;

public class NullSoundDevice implements SoundDevice {

	@Override
	public Sound loadMusic(String filename) {
		return new NullSound(filename);
	}

	@Override
	public Sound loadSound(String filename) {
		return new NullSound(filename);
	}

	@Override
	public void update(int delta) {

	}

}
