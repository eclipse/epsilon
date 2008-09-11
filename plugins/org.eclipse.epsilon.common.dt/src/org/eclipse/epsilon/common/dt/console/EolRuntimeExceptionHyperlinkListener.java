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

import org.eclipse.ui.console.IOConsole;
import org.eclipse.ui.console.IPatternMatchListener;
import org.eclipse.ui.console.PatternMatchEvent;
import org.eclipse.ui.console.TextConsole;

public class EolRuntimeExceptionHyperlinkListener implements IPatternMatchListener {
	
	protected IOConsole ioConsole;
	
	public EolRuntimeExceptionHyperlinkListener(IOConsole ioConsole) {
		this.ioConsole = ioConsole;
	}
	
	public String getPattern() {
		return "\\(.*@(\\d)+:(\\d)+\\)";
	}

	public int getCompilerFlags() {
		return 0;
	}

	public String getLineQualifier() {
		return null;
	}

	public void connect(TextConsole console) {
		
	}

	public void disconnect() {
		
	}

	public void matchFound(PatternMatchEvent event) {
		
		try {
			matchFoundImpl(event);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//try {
			//messageConsole.addHyperlink(new TextEditorHyperlink(), event.getOffset(),event.getLength());
		//} catch (BadLocationException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
	}
	
	private void matchFoundImpl(PatternMatchEvent event) throws Exception {
		String matched = ioConsole.getDocument().get(event.getOffset(), event.getLength());
		matched = matched.substring(1,matched.length() -1);
		String file = matched.split("@")[0];
		int line = Integer.parseInt(matched.split("@")[1].split(":")[0]);
		int column = Integer.parseInt(matched.split("@")[1].split(":")[1]);
		ioConsole.addHyperlink(new ConsoleHyperlink(file,line,column), event.getOffset()+1, event.getLength()-2);
	}
	
}
