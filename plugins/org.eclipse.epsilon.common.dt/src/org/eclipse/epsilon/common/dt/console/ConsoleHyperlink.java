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

import org.eclipse.epsilon.common.dt.util.EclipseUtil;
import org.eclipse.epsilon.common.parse.Region;
import org.eclipse.ui.console.IHyperlink;

public class ConsoleHyperlink implements IHyperlink {
	
	protected String file;
	protected Region region;
	
	public ConsoleHyperlink(String file, Region region){
		this.file = file;
		this.region = region;
	}
	
	public void linkEntered() {
		// TODO Auto-generated method stub
		
	}

	public void linkExited() {
		// TODO Auto-generated method stub
		
	}

	public void linkActivated() {
		
		EclipseUtil.openEditorAt(file, region);
		
		/*
		try {
			linkActivatedImpl();
		}
		catch (Exception ex){
			
		}*/
	}

}
