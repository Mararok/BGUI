/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.test.util;

import com.gmail.mararok.BUTJ.TEST;
import com.gmail.mararok.BUTJ.TestCase;
import com.gmail.mararok.igui.util.Rectangle;

public class RectangleCase extends TestCase {

	public RectangleCase() {
		super("Rectangle");
	}

	@TEST
	public void create() {
		it.describe("valid create Rectangle at 0x0 position and 100x100 size");
		Rectangle rect = new Rectangle();
		rect.setPosition(10,10);
		rect.setSize(100,100);
		
		it.expect(rect.getX()).toBeEqual(10);
		it.expect(rect.getY()).toBeEqual(10);
		
		it.expect(rect.getWidth()).toBeEqual(100);
		it.expect(rect.getHeight()).toBeEqual(100);
		
		it.expect(rect.getCenterX()).toBeEqual(60);
		it.expect(rect.getCenterY()).toBeEqual(60);
		
		it.expect(rect.getHalfWidth()).toBeEqual(50);
		it.expect(rect.getHalfHeight()).toBeEqual(50);

	}
	
	@TEST
	public void contains() {
		it.describe("checks points is inner rect");
		Rectangle rect = new Rectangle(0,0,100,100);
		it.expect(rect.contains(0,0)).toBeTrue();
		it.expect(rect.contains(-1,-1)).toBeFalse();
		
		it.expect(rect.contains(100,100)).toBeTrue();
		it.expect(rect.contains(101,101)).toBeFalse();
	}
}
