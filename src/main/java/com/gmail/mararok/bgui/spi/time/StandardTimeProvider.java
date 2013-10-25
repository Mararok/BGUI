/**
 * BGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.bgui.spi.time;

public class StandardTimeProvider implements TimeProvider {

	@Override
	public long getMiliTime() {
		return System.currentTimeMillis();
	}

}
