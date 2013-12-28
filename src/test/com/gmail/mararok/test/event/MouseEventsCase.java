/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.test.event;

import com.gmail.mararok.BUTJ.TEST;
import com.gmail.mararok.BUTJ.TestCase;
import com.gmail.mararok.igui.event.mouse.MouseButton;
import com.gmail.mararok.igui.event.mouse.MouseButtonEvent;
import com.gmail.mararok.igui.event.mouse.MouseClickedEvent;
import com.gmail.mararok.igui.event.mouse.MouseDownEvent;
import com.gmail.mararok.igui.event.mouse.MouseEvent;
import com.gmail.mararok.igui.event.mouse.MouseMovedEvent;
import com.gmail.mararok.igui.event.mouse.MouseOutEvent;
import com.gmail.mararok.igui.event.mouse.MouseOverEvent;
import com.gmail.mararok.igui.event.mouse.MouseUpEvent;

public class MouseEventsCase extends TestCase {

	public MouseEventsCase() {
		super("MouseEventsCase");
	}
	
	private static class TestMouseEvent extends MouseEvent {

		public TestMouseEvent(long time, int x, int y) {
			super(time,x,y);
		}

		@Override
		public String getName() {
			return "TestMouseEvent";
		}
		
	}
	
	@TEST
	public void mouseEvent() {
		TestMouseEvent event = new TestMouseEvent(1,2,3);
		it.expect(event.getX()).toBeEqual(2);
		it.expect(event.getY()).toBeEqual(3);
	}
	
	@TEST
	public void mouseMovedEvent() {
		MouseMovedEvent event = new MouseMovedEvent(1,2,3,4,5);
		it.expect(event.getName()).toBeEqual("MouseMovedEvent");
		it.expect(event.getDX()).toBeEqual(4);
		it.expect(event.getDY()).toBeEqual(5);
	}
	
	private static class TestMouseButtonEvent extends MouseButtonEvent {

		public TestMouseButtonEvent(long time, int x, int y, MouseButton button) {
			super(time,x,y,button);
		}

		@Override
		public String getName() {
			return "TestMouseButtonEvent";
		}
		
	}
	
	@TEST
	public void mouseButtonEvent() {
		TestMouseButtonEvent event = new TestMouseButtonEvent(1,2,3,MouseButton.PRIMARY);
		it.expect(event.getButton()).toBe(MouseButton.PRIMARY);
	}
	
	@TEST
	public void mouseDownEvent() {
		MouseButtonEvent event = new MouseDownEvent(1,2,3,MouseButton.PRIMARY);
		it.expect(event.getName()).toBeEqual("MouseDownEvent");
	}
	
	@TEST
	public void mouseUpEvent() {
		MouseButtonEvent event = new MouseUpEvent(1,2,3,MouseButton.PRIMARY);
		it.expect(event.getName()).toBeEqual("MouseUpEvent");
	}

	@TEST
	public void mouseClickedEvent() {
		MouseButtonEvent event = new MouseClickedEvent(1,2,3,MouseButton.PRIMARY);
		it.expect(event.getName()).toBeEqual("MouseClickedEvent");
	}
	
	@TEST
	public void mouseOverEvent() {
		MouseOverEvent event = new MouseOverEvent(1,2,3,null);
		it.expect(event.getName()).toBeEqual("MouseOverEvent");
	}
	
	@TEST
	public void mouseOutEvent() {
		MouseOutEvent event = new MouseOutEvent(1,2,3,null);
		it.expect(event.getName()).toBeEqual("MouseOutEvent");
	}
}
