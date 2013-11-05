/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.spi.sound;

import com.gmail.mararok.igui.util.Disposable;

public interface Sound extends Disposable {
	void play();
	void stop();
	boolean isPlaying();
	
	void setVolume(float newVolume);
	float getVolume();
}
