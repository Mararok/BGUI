/**
 * BGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.bgui.render;

import java.awt.Color;

public class RGBAColor {
	private float[] color;
	
	public RGBAColor() {
		this(1f,1f,1f,1f);
	}
	
	public RGBAColor(float red, float green, float blue) {
		this(red,green,blue,1f);
	}
	
	public RGBAColor(float red, float green, float blue, float alpha) {
		color = new float[] {red,green,blue,alpha};
	}
	
	public RGBAColor(int red, int green, int blue) {
		this(red,green,blue,1f);
	}
	
	public RGBAColor(int red, int green, int blue, int alpha) {
		this(((float)red)/256f,((float)green)/256f,((float)blue)/256f,((float)alpha)/256f);
	}
	
	public static RGBAColor fromAWTColor(Color color) {
		return new RGBAColor(color.getRed(),color.getGreen(),color.getBlue(),color.getAlpha());
	}
	
	public float r() {
		return color[0];
	}
	
	public void r(float newValue) {
		color[0] = newValue;
	}
	
	public float g() {
		return color[1];
	}
	
	public void g(float newValue) {
		color[1] = newValue;
	}
	
	public float b() {
		return color[2];
	}
	
	public void b(float newValue) {
		color[2] = newValue;
	}
	
	public float a() {
		return color[3];
	}
	
	public void a(float newValue) {
		color[3] = newValue;
	}
	
	public float[] getComponents() {
		return color;
	}
	
	public static final RGBAColor WHITE = new RGBAColor();
	public static final RGBAColor BLACK = new RGBAColor(0f,0f,0f);
	public static final RGBAColor RED = new RGBAColor(1f,0f,0f);
	public static final RGBAColor GREEN = new RGBAColor(0f,1f,0f);
	public static final RGBAColor BLUE = new RGBAColor(0f,0f,1f);
}
