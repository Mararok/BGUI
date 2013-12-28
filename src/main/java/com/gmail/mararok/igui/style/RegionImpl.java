/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.style;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.gmail.mararok.igui.ImpactGUI;
import com.gmail.mararok.igui.scene.impl.ParentSceneNodeImpl;
import com.gmail.mararok.igui.style.attributes.Attribute;
import com.gmail.mararok.igui.style.attributes.AttributeType;
import com.gmail.mararok.igui.util.Rectangle;

public abstract class RegionImpl extends ParentSceneNodeImpl implements Region {
	private Style style;
	private List<StyleClass> styleClasses;
	
	private Rectangle localBounds;
	private int localZ;
	
	public RegionImpl(ImpactGUI gui) {
		super(gui);
		createVisualNode();
		localBounds = new Rectangle();
	}

	public Style getStyle() {
		if (style == null) {
			style = new Style(this);
		}
		
		return style;
	}
	
	public void updateAttribute(AttributeType type, Attribute attribute) {
		
	}
	
	@Override
	public void setStyle(Style newStyle) {
		style = newStyle;
	}

	@Override
	public StyleClass getStyleClass(String className) {
		for (StyleClass styleClass: styleClasses) {
			if (className == styleClass.getName()) {
				return styleClass;
			}
		}
		return null;
	}

	@Override
	public boolean hasStyleClass(String className) {
		return getStyleClass(className) != null;
	}

	@Override
	public void addStyleClass(StyleClass newClass) {
		if (hasStyleClass(newClass.getName())) {
			return;
		}
		
		if (styleClasses == null) {
			styleClasses = new LinkedList<StyleClass>();
		}
		styleClasses.add(newClass);
	}

	@Override
	public void removeStyleClass(String className) {
		if (styleClasses != null) {
			Iterator<StyleClass> it = styleClasses.iterator();
			while (it.hasNext()) {
				if (it.next().getName() == className) {
					it.remove();
					return;
				}
			}
		}
	}
	
	@Override
	public int getLocalCenterX() {
		return localBounds.getCenterX();
	}
	
	@Override
	public int getLocalCenterY() {
		return localBounds.getCenterY();
	}
	
	@Override
	public int getLocalX() {
		return localBounds.getX();
	}
	
	@Override
	public void setLocalX(int newX) {
		localBounds.setX(newX);
		updateBounds();
	}
	
	@Override
	public int getLocalY() {
		return localBounds.getY();
	}
	
	@Override
	public void setLocalY(int newY) {
		localBounds.setY(newY);
		updateBounds();
	}
	
	@Override
	public void setLocalPosition(int newX, int newY) {
		localBounds.setX(newX);
		localBounds.setY(newY);
		updateBounds();
	}
	
	@Override
	public int getLocalZ() {
		return localZ;
	}
	
	@Override
	public void setLocalZ(int newZ) {
		localZ = newZ;
		updateBounds();
	}
	
	@Override
	public int getWidth() {
		return localBounds.getWidth();
	}
	
	@Override
	public void setWidth(int newWidth) {
		localBounds.setWidth(newWidth);
		updateBounds();
	}
	
	@Override
	public int getHeight() {
		return localBounds.getHeight();
	}
	
	@Override
	public void setHeight(int newHeight) {
		localBounds.setHeight(newHeight);
		
	}
	
	@Override
	public void setSize(int newWidth, int newHeight) {
		localBounds.setWidth(newWidth);
		localBounds.setHeight(newHeight);
		updateBounds();
	}
	
	private void updateBounds() {
		mainVisualNode.setTranslation(getLocalCenterX(),getGUI().getRenderDevice().getHeight()-getLocalCenterY(),getLocalZ());
		mainVisualNode.setScale(getWidth()/2,getHeight()/2,1);
	}
	
	public boolean contains(int px, int py) {
		return localBounds.contains(px, py);
	}

}
