package org.eclipse.epsilon.etl.engine.test.acceptance;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.epsilon.commons.util.FileUtil;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.emc.emf.EmfUtil;

public class EtlTest {
	
	protected EmfModel loadModel(String name, String modelFile, String metamodelUri, boolean read, boolean store) throws Exception {
		EmfModel model = new EmfModel();
		model.setName(name);
		model.setModelFile(getFullPath(modelFile));
		model.setMetamodelUri(metamodelUri);
		model.setReadOnLoad(read);
		model.setStoredOnDisposal(store);
		model.load();
		return model;
	}
	
	protected Resource getResource(String path) throws Exception {
		ResourceSet rs = new ResourceSetImpl();
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		Resource r = rs.createResource(URI.createFileURI(getFullPath(path)));
		r.load(null);
		return r;
	}
	
	protected String getFullPath(String path) {
		return FileUtil.getFile(path, this.getClass()).getAbsolutePath();
	}
	
	protected void registerMetamodel(String path) throws Exception {
		EmfUtil.register(URI.createFileURI(getFullPath(path)), EPackage.Registry.INSTANCE);
	}

	
}
