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

import org.eclipse.core.resources.IFile;
import org.eclipse.ui.part.FileEditorInput;

public class ModeLinkInnerEditorInput extends FileEditorInput {

	protected ModelPosition position;
	
	public ModeLinkInnerEditorInput(IFile file, ModelPosition position) {
		super(file);
		setPosition(position);
	}
	
	public ModelPosition getPosition() {
		return position;
	}

	public void setPosition(ModelPosition position) {
		this.position = position;
	}

}
