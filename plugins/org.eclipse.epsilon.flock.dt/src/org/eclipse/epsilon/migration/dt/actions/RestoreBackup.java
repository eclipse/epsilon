package org.eclipse.epsilon.migration.dt.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.epsilon.common.dt.actions.AbstractObjectActionDelegate;
import org.eclipse.epsilon.common.dt.console.EpsilonConsole;
import org.eclipse.jface.action.IAction;

public class RestoreBackup extends AbstractObjectActionDelegate {

	private IFile backedUpFile;

	@Override
	public void run(IAction action) {
		try {
			if (getFirstElementInSelection() instanceof IFile) {
				backedUpFile = (IFile)getFirstElementInSelection();
				restoreBackup();
			}
		
		} catch (CoreException ex) {
			EpsilonConsole.getInstance().getErrorStream().println(ex.getLocalizedMessage());
		}
	}
	
	private void restoreBackup() throws CoreException {		
		final IPath originalPath = getOriginalPath();
		
		final IFile originalFile = backedUpFile.getProject().getFile(originalPath.removeFirstSegments(1));
		if (originalFile.exists())
			originalFile.delete(false, new NullProgressMonitor());
		
		backedUpFile.move(originalPath, false, new NullProgressMonitor());
	}

	private IPath getOriginalPath() {
		final IPath backedUpPath = backedUpFile.getFullPath();
		
		return backedUpPath
		       	.removeLastSegments(1)
		       	.append(backedUpPath.lastSegment().replace("_backup.", "."));
	}
}
