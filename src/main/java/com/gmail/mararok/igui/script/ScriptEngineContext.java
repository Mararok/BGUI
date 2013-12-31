/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.script;

import java.io.Reader;

import javax.script.ScriptContext;
import javax.script.SimpleScriptContext;

public class ScriptEngineContext {
	private ScriptContext realContext;
	
	private GUIScriptEngine engine;
	
	public ScriptEngineContext(GUIScriptEngine engine) {
		this.engine = engine;
		realContext = new SimpleScriptContext();
	}
	
	public Object eval(String script) {
		return engine.eval(script,this);
	}
	
	public Object eval(Reader reader) {
		return engine.eval(reader,this);
	}
	
	ScriptContext getRealContext() {
		return realContext;
	}
}
