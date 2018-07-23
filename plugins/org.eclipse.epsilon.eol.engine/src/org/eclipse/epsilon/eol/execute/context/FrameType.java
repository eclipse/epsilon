/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
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
