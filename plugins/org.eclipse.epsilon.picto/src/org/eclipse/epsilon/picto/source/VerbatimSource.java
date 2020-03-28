/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.picto.source;

import java.io.File;
import java.nio.file.Files;

import org.eclipse.core.resources.IFile;
import org.eclipse.epsilon.picto.ViewTree;
import org.eclipse.ui.IEditorPart;

public abstract class VerbatimSource extends SimpleSource {
	
	@Override
	public ViewTree getViewTree(IEditorPart editor) throws Exception {
		IFile iFile = waitForFile(editor);
		if (iFile == null) return createEmptyViewTree();
		File modelFile = new File(iFile.getLocation().toOSString());
		return new ViewTree(new String(Files.readAllBytes(modelFile.toPath())), getFormat());
	}
	
}
