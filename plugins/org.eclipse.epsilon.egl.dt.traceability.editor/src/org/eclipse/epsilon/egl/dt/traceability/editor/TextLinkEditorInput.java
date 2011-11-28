/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.dt.traceability.editor;

import java.util.Collection;

import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.part.MultiEditorInput;

public class TextLinkEditorInput extends MultiEditorInput {

	public final TextLinkModel textlinkModel;
	
	public TextLinkEditorInput(Collection<String> editorIDs, Collection<IEditorInput> editorInputs, TextLinkModel textlinkModel) {
		this(editorIDs.toArray(new String[]{}), editorInputs.toArray(new IEditorInput[]{}), textlinkModel);
	}
	
	public TextLinkEditorInput(String[] editorIDs, IEditorInput[] editorInputs, TextLinkModel textlinkModel) {
		super(editorIDs, editorInputs);
		this.textlinkModel = textlinkModel;
	}
}
