package org.eclipse.epsilon.migration.dt.actions;

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
	private final String targetMetamodelFile;
	
	public MigrationStrategyExtension(IConfigurationElement extPoint) throws InvalidRegistryObjectException, URISyntaxException {
		final Bundle bundle = Platform.getBundle(extPoint.getDeclaringExtension().getNamespaceIdentifier());
		
		this.pluginId              = extPoint.getDeclaringExtension().getNamespaceIdentifier();
		this.strategyFile          = bundle.getResource(extPoint.getAttribute("strategyFile")).toURI();
		this.originalMetamodelFile = extPoint.getAttribute("originalMetamodelFile");
		this.targetMetamodelFile   = extPoint.getAttribute("targetMetamodelFile");

	}
	
	public URI getStrategyFile() {
		return strategyFile;
	}
	
	public EmfModel loadOriginalModel(IPath modelFilePath) throws EolModelLoadingException {
		return loadEmfModel(modelFilePath, getMetamodelUri(originalMetamodelFile), true, false);
	}

	public EmfModel loadTargetModel(IPath modelFilePath) throws EolModelLoadingException {
		return loadEmfModel(modelFilePath, getMetamodelUri(targetMetamodelFile), false, true);
	}
	
	private org.eclipse.emf.common.util.URI getMetamodelUri(String path) {
		return org.eclipse.emf.common.util.URI.createPlatformPluginURI("/" + pluginId + (path.startsWith("/") ? "" : "/") + path, true);
	}

	private static EmfModel loadEmfModel(IPath modelFile, org.eclipse.emf.common.util.URI metamodelUri, boolean readOnLoad, boolean storeOnDisposal) throws EolModelLoadingException {
		final EmfModel target = new EmfModel();
		target.setMetamodelFileBased(true);
		target.setMetamodelFileUri(metamodelUri);
		target.setModelFile(modelFile.toOSString());
		target.setReadOnLoad(readOnLoad);
		target.setStoredOnDisposal(storeOnDisposal);
		target.load();
		return target;
	}
}
