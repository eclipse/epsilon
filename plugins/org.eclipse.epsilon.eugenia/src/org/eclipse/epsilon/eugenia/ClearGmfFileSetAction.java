package org.eclipse.epsilon.eugenia;

import java.net.URI;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.jface.action.IAction;

public class ClearGmfFileSetAction extends EugeniaActionDelegate {
	
	@Override
	public void runImpl(IAction action) throws Exception {
		delete(gmfFileSet.getGenModelPath());
		delete(gmfFileSet.getGmfGraphPath());
		delete(gmfFileSet.getGmfToolPath());
		delete(gmfFileSet.getGmfMapPath());
		delete(gmfFileSet.getGmfGenPath());
		refresh();
	}
	
	public void delete(String path) {
		try {
			IFile[] files = ResourcesPlugin.getWorkspace().getRoot().findFilesForLocationURI(new URI(path));
			for (IFile file : files) {
				file.delete(true, new NullProgressMonitor());
			}
		} catch (Exception ex) {
			// Ignore
		}
		
	}
	
	@Override
	public String getBuiltinTransformation() {
		return null;
	}

	@Override
	public String getCustomizationTransformation() {
		return null;
	}

	@Override
	public List<IModel> getModels() throws Exception {
		return null;
	}

	@Override
	public String getTitle() {
		return "Cleaning up generating models";
	}
	
}
