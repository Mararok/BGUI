/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.test;

import com.gmail.mararok.BUTJ.TestsRunner;
import com.gmail.mararok.BUTJ.ReportOutput.ConsoleReportOutput;

public class Tests {
	public static void main(String[] args) {
		TestsRunner runner = new TestsRunner("ImpactGUI Tests",Tests.class.getPackage());
		runner.addReportOutput(new ConsoleReportOutput());
		runner.run();
	}
}
