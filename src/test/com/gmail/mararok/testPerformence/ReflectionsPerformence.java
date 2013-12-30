/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.testPerformence;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.esotericsoftware.reflectasm.MethodAccess;

public class ReflectionsPerformence {
	public void testMethod() {
	}
	
	public static void main(String[] args) {
		long start,end,javaRT,asmRT;
		ReflectionsPerformence obj = new ReflectionsPerformence();
		System.out.println("JAVA REFLECTION");
		Method m = null;
		try {
			m = ReflectionsPerformence.class.getMethod("testMethod");
		} catch (NoSuchMethodException | SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		start = System.nanoTime();
			try {
				m.invoke(obj);
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		end = System.nanoTime();
		javaRT = end-start;
		System.out.println("JAVA REFLECTION TIME: "+javaRT);
		
		System.out.println("ASM REFLECTION");
		MethodAccess m2 = MethodAccess.get(ReflectionsPerformence.class);
		int in = m2.getIndex("testMethod");
		start = System.nanoTime();
			m2.invoke(obj,in);
		end = System.nanoTime();
		asmRT = end-start;
		System.out.println("ASM REFLECTION TIME: "+asmRT);
		
		System.out.println("VS: "+(javaRT-asmRT));
	}

}
