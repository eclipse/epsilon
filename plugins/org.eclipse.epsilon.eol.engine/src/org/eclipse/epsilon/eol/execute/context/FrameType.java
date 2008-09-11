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
package org.eclipse.epsilon.eol.execute.context;

public class FrameType {
	
	private String title = "";
	
	public static final FrameType UNPROTECTED = new FrameType("Unprotected");
	public static final FrameType PROTECTED = new FrameType("Protected");
	
	private FrameType(String title){this.title = title;}
	
	public String getTitle(){
		return title;
	}
	
	@Override
	public String toString(){
		return title;
	}
	
}
