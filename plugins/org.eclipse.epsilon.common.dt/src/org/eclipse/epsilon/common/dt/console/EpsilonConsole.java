/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.common.dt.console;

import java.io.InputStream;
import java.io.PrintStream;

import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IOConsole;
import org.eclipse.ui.console.IOConsoleOutputStream;

public class EpsilonConsole {
	
	private IOConsole ioConsole = null;
	private static EpsilonConsole instance = null;
	private PrintStream infoPrintStream;
	private PrintStream debugPrintStream;
	private PrintStream errorPrintStream;
	private PrintStream warningPrintStream;
	private InputStream inputStream;
		
	private EpsilonConsole(){
		
		ioConsole = new IOConsole("Epsilon", null);
		
		// Necessary because colors are acquired through a non-UI thread
		// and that used to cause an SWT illegal thread exception
		final Display display = PlatformUI.getWorkbench().getDisplay();
		display.syncExec(new Runnable() {
			public void run() {
				//ioConsole.setWaterMarks(1000, 80000);
				debugPrintStream = newPrintStream(display.getSystemColor(SWT.COLOR_BLACK));
				errorPrintStream = newPrintStream(display.getSystemColor(SWT.COLOR_RED));
				warningPrintStream = newPrintStream(display.getSystemColor(SWT.COLOR_DARK_YELLOW));
				infoPrintStream = newPrintStream(display.getSystemColor(SWT.COLOR_BLUE));
				inputStream = ioConsole.getInputStream();				
				ioConsole.getInputStream().setColor(display.getSystemColor(SWT.COLOR_GREEN));
			}
		});
		
		ConsolePlugin.getDefault().getConsoleManager().addConsoles(new IConsole[]{ioConsole});
		ioConsole.addPatternMatchListener(new EolRuntimeExceptionHyperlinkListener(ioConsole));
		
		//getDebugStream().println("Epsilon console initialized...");
	}
	
	public static EpsilonConsole getInstance(){
		if (instance == null){
			instance = new EpsilonConsole();
		}
		return instance;
	}
	
	public PrintStream newPrintStream(Color color){
		IOConsoleOutputStream mcs = ioConsole.newOutputStream();
		mcs.setActivateOnWrite(true);
		mcs.setColor(color);
		return new PrintStream(mcs);
	}
	
	
	public void clear(){
		//This doesn't clear the console immediately
		//but schedules a job instead
		ioConsole.clearConsole();
		
		// Wait until the console is clear and then return
		// Update: Don't do this as it can it can lead to an infinite loop
		// while (ioConsole.getDocument().getLength() > 0){System.err.print("");};
	}
	
	public PrintStream getDebugStream() {
		return debugPrintStream;
	}
	
	public PrintStream getErrorStream() {
		return errorPrintStream;
	}
	
	public PrintStream getInfoStream() {
		return infoPrintStream;
	}
	
	public InputStream getInputStream() {
		return inputStream;
	}
	
	public void reportParseAnomaly (ParseProblem anomaly) {
		
	}

	public PrintStream getWarningStream() {
		return warningPrintStream;
	}
	
	
	
}
