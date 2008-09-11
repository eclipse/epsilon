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

import org.eclipse.epsilon.dt.exeed.ExeedEditor;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.ui.IEditorPart;

public class InnerEditorTabItem extends CTabItem {
	
	protected IEditorPart editor;
	
	public InnerEditorTabItem(CTabFolder parent, int style, IEditorPart editor) {
		super(parent, style);
		this.editor = editor;
	}

	public IEditorPart getEditor() {
		return editor;
	}

	public void setEditor(ExeedEditor editor) {
		this.editor = editor;
	}
	
	
	
}
