/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.common.dt.console;

import java.io.InputStream;
import java.io.PrintStream;

import org.eclipse.epsilon.common.dt.util.EclipseUtil;
import org.eclipse.epsilon.common.dt.util.ThemeChangeListener;
import org.eclipse.epsilon.common.parse.problem.ParseProblem;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
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
	
	private IOConsoleOutputStream debugOutputStream = null;
	private IOConsoleOutputStream errorOutputStream = null;
	private IOConsoleOutputStream warningOutputStream = null;
	private IOConsoleOutputStream infoOutputStream = null;
	
	private EpsilonConsole(){
		
		ioConsole = new IOConsole("Epsilon", null);
		
		// Necessary because colors are acquired through a non-UI thread
		// and that used to cause an SWT illegal thread exception
		
		debugOutputStream = createConsoleOutputStream();
		infoOutputStream = createConsoleOutputStream();
		warningOutputStream = createConsoleOutputStream();
		errorOutputStream = createConsoleOutputStream();
		
		debugPrintStream = new PrintStream(debugOutputStream);
		errorPrintStream = new PrintStream(errorOutputStream);
		warningPrintStream = new PrintStream(warningOutputStream);
		infoPrintStream = new PrintStream(infoOutputStream);
		inputStream = ioConsole.getInputStream();				
		
		PlatformUI.getWorkbench().getThemeManager().addPropertyChangeListener(new ThemeChangeListener() {
			
			@Override
			public void themeChange() {
				initialiseColours();
			}
		});
		initialiseColours();
		
		ConsolePlugin.getDefault().getConsoleManager().addConsoles(new IConsole[]{ioConsole});
		ioConsole.addPatternMatchListener(new EolRuntimeExceptionHyperlinkListener(ioConsole));
		
	}
	
	public static EpsilonConsole getInstance(){
		if (instance == null){
			instance = new EpsilonConsole();
		}
		return instance;
	}
	
	public void initialiseColours() {
		final Display display = PlatformUI.getWorkbench().getDisplay();
		display.syncExec(new Runnable() {
			public void run() {
			if (EclipseUtil.isDarkThemeEnabled()) {
				infoOutputStream.setColor(new Color(display, 190, 218, 0));
				errorOutputStream.setColor(new Color(display, 243, 0, 70));
				debugOutputStream.setColor(new Color(display, 235, 235, 235));
				warningOutputStream.setColor(new Color(display, 131, 176, 207));
				ioConsole.getInputStream().setColor(new Color(display, 118, 167, 37));				
			}
			else {
				infoOutputStream.setColor(display.getSystemColor(SWT.COLOR_BLUE));
				errorOutputStream.setColor(display.getSystemColor(SWT.COLOR_RED));
				debugOutputStream.setColor(display.getSystemColor(SWT.COLOR_BLACK));
				warningOutputStream.setColor(display.getSystemColor(SWT.COLOR_YELLOW));
				ioConsole.getInputStream().setColor(display.getSystemColor(SWT.COLOR_GREEN));
			}
		}});
	}
	
	public IOConsoleOutputStream createConsoleOutputStream(){
		IOConsoleOutputStream mcs = ioConsole.newOutputStream();
		mcs.setActivateOnWrite(true);
		return mcs;
	}
	
	
	public void clear(){
		//This doesn't clear the console immediately
		//but schedules a job instead
		ioConsole.clearConsole();
		
		// Wait until the console is clear and then return
		// Update: Don't do this as it can it can lead to an infinite loop
		// while (ioConsole.getDocument().getLength() > 0){System.out.print("");};
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
