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

import java.io.File;

import org.eclipse.epsilon.common.dt.util.EclipseUtil;
import org.eclipse.ui.console.IHyperlink;

public class ConsoleHyperlink implements IHyperlink {
	
	String file;
	int line;
	int column;
	
	public ConsoleHyperlink(String file, int line, int column){
		this.file = file;
		this.line = line;
		this.column = column;
	}
	
	public void linkEntered() {
		// TODO Auto-generated method stub
		
	}

	public void linkExited() {
		// TODO Auto-generated method stub
		
	}

	public void linkActivated() {
		
		EclipseUtil.openEditorAt(new File(file), line, column, false);
		
		/*
		try {
			linkActivatedImpl();
		}
		catch (Exception ex){
			
		}*/
	}

}
