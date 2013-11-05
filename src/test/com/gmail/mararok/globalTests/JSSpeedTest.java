/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.globalTests;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JSSpeedTest {
	public static void main(String[] args) throws ScriptException {
		long start,end;
		System.setProperty("rhino.opt.level","9");
		ScriptEngineManager scriptEngineManager= new ScriptEngineManager();
		ScriptEngine engine = scriptEngineManager.getEngineByExtension("js");
		
		start = System.currentTimeMillis();
		engine.eval("for(var i = 0; i < 100000;++i) print('Hello World \\n')");
		end = System.currentTimeMillis();
		
		System.out.print(end-start);
	}

}
