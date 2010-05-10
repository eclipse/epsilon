package org.eclipse.epsilon.eugenia;

import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.gmf.internal.bridge.transform.TransformOptions;
import org.eclipse.gmf.internal.bridge.transform.TransformToGenModelOperation;
import org.eclipse.jface.action.IAction;

public class GmfMap2GmfGenDelegate extends EugeniaActionDelegate {
	
	@Override
	public void run(IAction action) {
		// Transform GmfMap to GmfGen model
		ResourceSet resourceSet = new ResourceSetImpl();
		TransformToGenModelOperation transformToGenModelOperation = new TransformToGenModelOperation(resourceSet);
		
		TransformOptions options = transformToGenModelOperation.getOptions();
		options.setGenerateRCP(false);
		options.setUseMapMode(true);
		options.setUseRuntimeFigures(true);
		
		try {
			transformToGenModelOperation.loadMappingModel(URI.createURI(gmfFileSet.getGmfMapPath()), new NullProgressMonitor());
			transformToGenModelOperation.loadGenModel(URI.createURI(gmfFileSet.getGenModelPath()), new NullProgressMonitor());
		}
		catch (Exception ex) {
			ex.printStackTrace();
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
