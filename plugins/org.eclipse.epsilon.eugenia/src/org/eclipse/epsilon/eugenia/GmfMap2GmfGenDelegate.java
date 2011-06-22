package org.eclipse.epsilon.eugenia;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.gmf.internal.bridge.transform.TransformOptions;
import org.eclipse.gmf.internal.bridge.transform.TransformToGenModelOperation;
import org.eclipse.jface.action.IAction;

public class GmfMap2GmfGenDelegate extends EugeniaActionDelegate {

	@Override
	public void runImpl(IAction action) {
		// Transform GmfMap to GmfGen model
		ResourceSet resourceSet = new ResourceSetImpl();
		TransformToGenModelOperation transformToGenModelOperation = new TransformToGenModelOperation(resourceSet);

		TransformOptions options = transformToGenModelOperation.getOptions();
		options.setGenerateRCP(false);
		options.setUseMapMode(true);
		options.setUseRuntimeFigures(true);

		final IContainer parent = getSelectedFile().getParent();
		if (parent instanceof IFolder && parent.getParent() != null) {
			final IFolder fGmfmapTemplateDir = parent.getParent().getFolder(
				new Path("templates-gmfmap"));
			if (fGmfmapTemplateDir.exists()) {
				try {
					options.setFigureTemplatesPath(new URL(
						fGmfmapTemplateDir.getLocationURI().toString()));
				} catch (MalformedURLException e) {
					Activator.getDefault().getLog().log(new Status(
						IStatus.ERROR, Activator.PLUGIN_ID,
						"Could not set the path to the figure templates", e));
				}
			}
		}

		try {
			transformToGenModelOperation.loadMappingModel(URI.createURI(gmfFileSet.getGmfMapPath()), new NullProgressMonitor());
			transformToGenModelOperation.loadGenModel(URI.createURI(gmfFileSet.getGenModelPath()), new NullProgressMonitor());
		}
		catch (Exception ex) {
			Activator.getDefault().getLog().log(new Status(
				IStatus.ERROR, Activator.PLUGIN_ID, "Could not load the GmfMap and GmfGen models", ex));
		}
		transformToGenModelOperation.setGenURI(URI.createURI(gmfFileSet.getGmfGenPath()));

		transformToGenModelOperation.executeTransformation(new NullProgressMonitor());
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
	public List<EmfModel> getModels() throws Exception {
		return null;
	}

	@Override
	public String getTitle() {
		return "Generating .gmfgen model";
	}

}
