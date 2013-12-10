/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.sc.impl;

import com.gmail.mararok.igui.ImpactGUI;
import com.gmail.mararok.igui.render.RGBAColor;
import com.gmail.mararok.igui.sc.Label;
import com.gmail.mararok.igui.spi.render.Font;
import com.gmail.mararok.igui.spi.render.TextVisualNode;

public class LabelImpl extends PanelImpl implements Label {
	private TextVisualNode textNode;
	private static int nextLabelID = 0;
	
	public LabelImpl(ImpactGUI gui) {
		super(gui);
		textNode = getGUI().getRenderDevice().createTextNode("LABEL:"+(++nextLabelID));
		mainVisualNode.attachChild(textNode);
	}

	@Override
	public void setText(String newText) {
		textNode.setText(newText);
	}

	@Override
	public String getText() {
		return textNode.getText();
	}

	@Override
	public void setColor(RGBAColor newColor) {
		textNode.setColor(newColor);
	}

	@Override
	public RGBAColor getColor() {
		return textNode.getColor();
	}

	@Override
	public Font getFont() {
		return textNode.getFont();
	}
	
	@Override
	public void setFont(Font newFont) {
		textNode.setFont(newFont);
	}
}
