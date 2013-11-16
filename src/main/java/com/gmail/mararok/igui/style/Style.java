/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.style;

import java.util.HashMap;

import com.gmail.mararok.igui.render.RGBAColor;
import com.gmail.mararok.igui.spi.render.Font;
import com.gmail.mararok.igui.spi.render.Image;
import com.gmail.mararok.igui.style.attribute.AttributeType;
import com.gmail.mararok.igui.style.attribute.BorderStyle;
import com.gmail.mararok.igui.style.attribute.FontStyle;
import com.gmail.mararok.igui.style.attribute.Gradient;
import com.gmail.mararok.igui.style.attribute.HAlign;
import com.gmail.mararok.igui.style.attribute.Margin;
import com.gmail.mararok.igui.style.attribute.Padding;
import com.gmail.mararok.igui.style.attribute.VAlign;

public class Style implements Styleable {
	private Style parentStyle;
	private String styleSource;
	
	private HashMap<AttributeType,Object> attributes;
	
	@Override
	public String getStyleSource() {
		return styleSource;
	}

	@Override
	public void setStyleSource(String newStyleSource) {
		styleSource = newStyleSource;
	}

	@Override
	public VAlign getVAlign() {
		Object attribute = getAttribute(AttributeType.valign);
		if (attribute == null) {
			return parentStyle.getVAlign();
		}
		return (VAlign)attribute;
	}

	@Override
	public void setVAlign(VAlign newAlign) {
		setAttribute(AttributeType.valign,newAlign);
	}

	@Override
	public HAlign getHAlign() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setHAlign(HAlign newAlign) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setColor(RGBAColor newColor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RGBAColor getColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Gradient getBackgroundColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBackgroundColor(RGBAColor newColor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBackgroundColor(Gradient newGradient) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Image getBackgroundimage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBackgroundimage(Image newImage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RGBAColor getBorderColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBorderColor(RGBAColor newColor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BorderStyle getBorderStyle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBorderStyle(BorderStyle newStyle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getBorderRadius() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setBorderRadius(int newRadius) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getMinWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setMinWidth(int newMinWidth) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setWidth(int newWidth) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getMaxWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setMaxWidth(int newMaxWidth) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getMinHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setMinHeight(int newMinHeight) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setHeight(int newHeight) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getMaxHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setMaxHeight(int newMaxHeight) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float getOpacity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setOpacity(float newOpacity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Font getFont() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFont(Font newFont) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getFontSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setFontSize(int newSize) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public FontStyle getFontStyle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFontStyle(FontStyle newStyle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Margin getMargin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMarginLeft() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setMarginLeft(int newMargin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getMarginTop() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setMarginTop(int newMargin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getMarginRight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setMarginRight(int newMargin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getMarginBottom() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setMarginBottom(int newMargin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Padding getPadding() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPaddingLeft() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setPaddingLeft(int newPadding) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getPaddingTop() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setPaddingTop(int newPadding) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getPaddingRight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setPaddingRight(int newPadding) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getPaddingBottom() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setPaddingBottom(int newPadding) {
		// TODO Auto-generated method stub
		
	}
	
	private Object getAttribute(AttributeType attributeType) {
		return attributes.get(attributeType);
	}
	
	private void setAttribute(AttributeType attributeType, Object attributeValue) {
		attributes.put(attributeType,attributeValue);
	}

}
