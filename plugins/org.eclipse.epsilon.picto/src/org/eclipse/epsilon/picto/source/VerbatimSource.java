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
