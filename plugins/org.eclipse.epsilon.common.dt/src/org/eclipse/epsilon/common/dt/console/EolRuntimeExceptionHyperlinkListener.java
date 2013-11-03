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

import org.eclipse.epsilon.common.parse.Position;
import org.eclipse.epsilon.common.parse.Region;
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
		return "\\(.*?@(\\d+):(\\d+)-(\\d+):(\\d+)\\)";
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
		String[] parts = matched.split("@");
		String file = parts[0];
		
		String[] regionParts = parts[1].split("-");
		
		Region region = new Region();
		region.setStart(parsePosition(regionParts[0]));
		region.setEnd(parsePosition(regionParts[1]));
		
		ioConsole.addHyperlink(new ConsoleHyperlink(file, region), event.getOffset()+1, event.getLength()-2);
	}
	
	protected Position parsePosition(String s) {
		String[] parts = s.split(":");
		return new Position(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
	}
	
}
