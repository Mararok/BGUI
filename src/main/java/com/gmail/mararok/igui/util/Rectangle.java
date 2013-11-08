/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.util;

public class Rectangle implements Cloneable {
	public int x;
	public int y;
	public int width;
	public int height;
	
	public Rectangle(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		
		this.width = width;
		this.height = height;
	}
	
	public Rectangle clone() {
        try {
            return (Rectangle) super.clone();
        } catch (CloneNotSupportedException e) {        
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

	public void set(int newX, int newY, int newWidth, int newHeight) {
		x = newX;
		y = newY;
		width = newWidth;
		height = newHeight;
	}
	
}
