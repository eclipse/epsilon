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
package org.eclipse.epsilon.dt.exeed.modelink;

import org.eclipse.epsilon.dt.exeed.modelink.ModeLinkInnerEditorInput.Position;

public class LinkedModel {
	
	protected String path;
	protected Position position;
	
	public LinkedModel(String path, String position) {
		this.path = path;
		if (position.equalsIgnoreCase("right")) {
			this.position = Position.RIGHT;
		} else if (position.equalsIgnoreCase("middle")) {
			this.position = Position.MIDDLE;
		} else {
			this.position = Position.LEFT;
		}
		
	}
	
	public String getPath() {
		return path;
	}
	public void setPath(String file) {
		this.path = file;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	
	
	
}
