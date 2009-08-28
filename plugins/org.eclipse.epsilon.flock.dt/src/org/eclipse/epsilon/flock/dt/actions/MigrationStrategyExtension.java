package org.eclipse.epsilon.flock.dt.actions;

import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.osgi.framework.Bundle;

public class MigrationStrategyExtension {
	
	private final String pluginId;
	private final URI strategyFile;
	private final String originalMetamodelFile;
	private final String migratedMetamodelFile;
	
	public MigrationStrategyExtension(IConfigurationElement extPoint) throws InvalidRegistryObjectException, URISyntaxException {
		final Bundle bundle = Platform.getBundle(extPoint.getDeclaringExtension().getNamespaceIdentifier());
		
		this.pluginId              = extPoint.getDeclaringExtension().getNamespaceIdentifier();
		this.strategyFile          = bundle.getResource(extPoint.getAttribute("strategyFile")).toURI();
		this.originalMetamodelFile = extPoint.getAttribute("originalMetamodelFile");
		this.migratedMetamodelFile = extPoint.getAttribute("migratedMetamodelFile");

	}
	
	public URI getStrategyFile() {
		return strategyFile;
	}
	
	public EmfModel loadOriginalModel(IPath modelFilePath) throws EolModelLoadingException {
		return loadEmfModel("Original", modelFilePath, getMetamodelUri(originalMetamodelFile), true, false);
	}

	public EmfModel loadMigratedModel(IPath modelFilePath) throws EolModelLoadingException {
		return loadEmfModel("Migrated", modelFilePath, getMetamodelUri(migratedMetamodelFile), false, true);
	}
	
	private org.eclipse.emf.common.util.URI getMetamodelUri(String path) {
		return org.eclipse.emf.common.util.URI.createPlatformPluginURI("/" + pluginId + (path.startsWith("/") ? "" : "/") + path, true);
	}

	private static EmfModel loadEmfModel(String name, IPath modelFile, org.eclipse.emf.common.util.URI metamodelUri, boolean readOnLoad, boolean storeOnDisposal) throws EolModelLoadingException {
		final EmfModel model = new EmfModel();
		model.setName(name);
		model.setMetamodelFileBased(true);
		model.setMetamodelFileUri(metamodelUri);
		model.setModelFile(modelFile.toOSString());
		model.setReadOnLoad(readOnLoad);
		model.setStoredOnDisposal(storeOnDisposal);
		model.load();
		return model;
	}
}
