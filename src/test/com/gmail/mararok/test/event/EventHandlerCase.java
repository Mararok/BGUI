/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.test.event;

import com.gmail.mararok.BUTJ.TEST;
import com.gmail.mararok.BUTJ.TestCase;
import com.gmail.mararok.igui.event.Controller;
import com.gmail.mararok.igui.event.EventHandler;
import com.gmail.mararok.igui.event.ImpactEvent;

public class EventHandlerCase extends TestCase {

	public EventHandlerCase() {
		super("EventHandler");
	}

	private static class TestEvent1 extends ImpactEvent {
		public TestEvent1(long time) {
			super(time);
		}
		
	}
	
	private static class TestEvent2 extends ImpactEvent {
		public TestEvent2(long time) {
			super(time);
		}
		
	}
	
	private static class TestController extends Controller {
		ImpactEvent lastEvent;
		
		@SuppressWarnings("unused") // used by reflection
		public void onClick1(TestEvent1 event) {
			lastEvent = event;
		}
		
		@SuppressWarnings("unused") // used by reflection
		public void onClick2(TestEvent2 event) {
			lastEvent = event;
		}
	}
	
	@TEST
	public void createing() {
		TestController controller = new TestController();
		EventHandler handler1 = new EventHandler(controller,"onClick1");
		EventHandler handler2 = new EventHandler(controller,"onClick2");
		
		it.expect(handler1.getCallbackName()).toBeEqual("onClick1");
		it.expect(handler2.getCallbackName()).toBeEqual("onClick2");
	}
	
	@TEST
	public void calling() {
		TestController controller = new TestController();
		EventHandler handler1 = new EventHandler(controller,"onClick1");
		EventHandler handler2 = new EventHandler(controller,"onClick2");
		
		ImpactEvent event = new TestEvent1(1);
		handler1.onEvent(event);
		it.expect(controller.lastEvent).toBe(event);
		
		event = new TestEvent2(2);
		handler2.onEvent(event);
		it.expect(controller.lastEvent).toBeEqual(event);
	}
}
