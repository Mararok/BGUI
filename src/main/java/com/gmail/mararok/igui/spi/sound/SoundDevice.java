/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.spi.sound;

public interface SoundDevice {
	Sound loadMusic(String filename);
	Sound loadSound(String filenam);
	
	void update(int delta);
}
