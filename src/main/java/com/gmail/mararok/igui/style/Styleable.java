/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.style;

import com.gmail.mararok.igui.render.RGBAColor;
import com.gmail.mararok.igui.spi.render.Font;
import com.gmail.mararok.igui.spi.render.Image;
import com.gmail.mararok.igui.style.attribute.BorderStyle;
import com.gmail.mararok.igui.style.attribute.FontStyle;
import com.gmail.mararok.igui.style.attribute.Gradient;
import com.gmail.mararok.igui.style.attribute.HAlign;
import com.gmail.mararok.igui.style.attribute.Margin;
import com.gmail.mararok.igui.style.attribute.Padding;
import com.gmail.mararok.igui.style.attribute.VAlign;

public interface Styleable {
	
	String getStyleSource();
	void setStyleSource(String newStyleSource);
	
	VAlign getVAlign();
	void setVAlign(VAlign newAlign);
	
	HAlign getHAlign();
	void setHAlign(HAlign newAlign);
	
	void setColor(RGBAColor newColor);
	RGBAColor getColor();
	
	Gradient getBackgroundColor();
	void setBackgroundColor(RGBAColor newColor);
	void setBackgroundColor(Gradient newGradient);
	
	Image getBackgroundimage();
	void setBackgroundimage(Image newImage);

	RGBAColor getBorderColor();
	void setBorderColor(RGBAColor newColor);
	
	BorderStyle getBorderStyle();
	void setBorderStyle(BorderStyle newStyle);
	
	int getBorderRadius();
	void setBorderRadius(int newRadius);
	
	int getMinWidth();
	void setMinWidth(int newMinWidth);
	
	int getWidth();
	void setWidth(int newWidth);
	
	int getMaxWidth();
	void setMaxWidth(int newMaxWidth);
	
	int getMinHeight();
	void setMinHeight(int newMinHeight);
	
	int getHeight();
	void setHeight(int newHeight);
	
	int getMaxHeight();
	void setMaxHeight(int newMaxHeight);
	
	float getOpacity();
	void setOpacity(float newOpacity);
	
	Font getFont();
	void setFont(Font newFont);
	
	int getFontSize();
	void setFontSize(int newSize);
	
	FontStyle getFontStyle();
	void setFontStyle(FontStyle newStyle);
	
	Margin getMargin();
	
	int getMarginLeft();
	void setMarginLeft(int newMargin);
	
	int getMarginTop();
	void setMarginTop(int newMargin);
	
	int getMarginRight();
	void setMarginRight(int newMargin);
	
	int getMarginBottom();
	void setMarginBottom(int newMargin);
	
	Padding getPadding();
	
	int getPaddingLeft();
	void setPaddingLeft(int newPadding);
	
	int getPaddingTop();
	void setPaddingTop(int newPadding);
	
	int getPaddingRight();
	void setPaddingRight(int newPadding);
	
	int getPaddingBottom();
	void setPaddingBottom(int newPadding);

}
