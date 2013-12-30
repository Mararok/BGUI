/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.control.standard;

import com.gmail.mararok.igui.render.Gradient;
import com.gmail.mararok.igui.render.SolidGradient;
import com.gmail.mararok.igui.spi.render.Font;
import com.gmail.mararok.igui.spi.render.TextVisualNode;
import com.gmail.mararok.igui.style.attributes.Attribute;
import com.gmail.mararok.igui.style.attributes.AttributeType;
import com.gmail.mararok.igui.style.attributes.ColorAttribute;

public class Label extends Panel {
	private TextVisualNode labelTextNode;
	private String text;
	private Font font;
	private Gradient color;
	
	@Override
	public void updateAttribute(AttributeType type, Attribute value) {
		super.updateAttribute(type,value);
		switch (type) {
		case color: {
			setColor(((ColorAttribute)value).getColor());
		}
		default:
			break;
		}
	}
	
	private void setColor(Gradient newColor) {
		color = newColor;
		if (getScene() == null) {
			return;
		}
		
		if (labelTextNode != null) {
			labelTextNode.setColor(((SolidGradient)color).getColor());
		}
	}
	
	private void setFont(Font newFont) {
		font = newFont;
		if (getScene() == null) {
			return;
		}
		
		if (labelTextNode != null) {
			labelTextNode.setFont(font);
		}
	}

	@Override
	protected void onAttachToScene() {
		super.onAttachToScene();
		createLabelText();
	}

	protected void createLabelText() {
		labelTextNode = getScene().getRenderDevice().createTextNode();
		setColor(color);
		setFont(font);
		setText(getText());	
		getScene().getVisualRoot().attachChild(labelTextNode);
	}
	
	@Override
	protected void onDetachFromScene() {
		super.onDetachFromScene();
	}
	
	protected void destroyLabelText() {
		if (labelTextNode != null) {
			getScene().getVisualRoot().detachChild(labelTextNode);
			labelTextNode = null;
		}
	}

	@Override
	protected void updateBounds() {
		super.updateBounds();
		if (labelTextNode != null) {
			labelTextNode.setTranslation(getCenterX(),getCenterY(),getZ()+1);
			labelTextNode.setScale(getWidth()/2,getHeight()/2,1);
		}
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String newText) {
		text = newText;
		if (newText == null || newText == "") {
			destroyLabelText();
			destroyPanelGeometry();
			return;
		}
		
		if (labelTextNode == null) {
			createLabelText();
		} else {
			labelTextNode.setText(text);
		}
		
	}
}
