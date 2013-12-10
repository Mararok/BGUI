/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.control;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.gmail.mararok.igui.ImpactGUI;
import com.gmail.mararok.igui.scene.impl.ParentSceneNodeImpl;
import com.gmail.mararok.igui.style.Style;
import com.gmail.mararok.igui.style.StyleClass;
import com.gmail.mararok.igui.style.Styleable;
import com.gmail.mararok.igui.util.Rectangle;

public abstract class RegionImpl extends ParentSceneNodeImpl implements Styleable {
	private Style style;
	private List<StyleClass> styleClasses;
	
	private Rectangle localBounds;
	private int localZ;
	
	public RegionImpl(ImpactGUI gui) {
		super(gui);
		localBounds = new Rectangle();
	}

	//@Override
	public Style getStyle() {
		if (style == null) {
			style = new Style(this);
		}
		
		return style;
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
	
	public int getLocalCenterX() {
		return localBounds.getCenterX();
	}
	
	public int getLocalCenterY() {
		return localBounds.getCenterY();
	}
	
	public int getLocalZ() {
		return localZ;
	}
	
	public void setLocalZ(int newZ) {
		localZ = newZ;
		updateBounds();
	}
	
	public int getLocalLeft() {
		return localBounds.getLeft();
	}
	
	public void setLocalLeft(int newLeft) {
		localBounds.setLeft(newLeft);
		updateBounds();
	}
	
	public int getLocalTop() {
		return localBounds.getTop();
	}
	
	public void setLocalTop(int newTop) {
		localBounds.setTop(newTop);
		updateBounds();
	}
	
	public int getLocalRight() {
		return localBounds.getRight();
	}
	
	public void setLocalRight(int newRight) {
		localBounds.setRight(newRight);
		updateBounds();
	}
	
	public int getLocalBottom() {
		return localBounds.getBottom();
	}
	
	public void setLocalBottom(int newBottom) {
		localBounds.setBottom(newBottom);
		updateBounds();
	}
	
	public int getWidth() {
		return localBounds.getWidth();
	}
	
	public void setWidth(int newWidth) {
		localBounds.setWidth(newWidth);
		updateBounds();
	}
	
	public int getHeight() {
		return localBounds.getHeight();
	}
	
	public void setHeight(int newHeight) {
		localBounds.setHeight(newHeight);
		
	}
	
	public void setSize(int newWidth, int newHeight) {
		localBounds.setWidth(newWidth);
		localBounds.setHeight(newHeight);
		updateBounds();
	}
	
	private void updateBounds() {
		mainVisualNode.setTranslation(getLocalCenterX(),getGUI().getRenderDevice().getHeight()-getLocalCenterY(),getLocalZ());
		mainVisualNode.setScale(getWidth()/2,getHeight()/2,1);
	}
}
