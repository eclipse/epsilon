/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.etl.engine.test.acceptance;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.epsilon.common.util.FileUtil;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.emc.emf.EmfUtil;
import org.eclipse.epsilon.test.util.ResourceComparator;

public abstract class EtlTest {
	
	protected EmfModel loadModel(String name, String modelFile, String metamodelUri, boolean read, boolean store) throws Exception {
		EmfModel model = new EmfModel();
		model.setConcurrent(true);
		model.setCachingEnabled(false);
		model.setName(name);
		model.setModelFile(getFullPath(modelFile));
		model.setMetamodelUri(metamodelUri);
		model.setReadOnLoad(read);
		model.setStoredOnDisposal(store);
		model.load();
		return model;
	}
	
	protected void testForEquivalence(Resource expected, Resource actual) throws Exception {
		ResourceComparator.compare(expected, actual);
		String dirty = expected.getURI().toFileString(),
			clean = dirty.replace("/bin/", "/src/").replace("\\bin\\", "\\src\\");
		actual.delete(null);
		Path target = Files.copy(Paths.get(clean), Paths.get(dirty), StandardCopyOption.REPLACE_EXISTING);
		assert target.toFile().exists();
	}
	
	protected Resource getResource(String path) throws Exception {
		return getResource(path, getClass());
	}
	
	protected static Resource getResource(String path, Class<?> currentClass) throws Exception {
		ResourceSet rs = new ResourceSetImpl();
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		Resource r = rs.createResource(URI.createFileURI(getFullPath(path, currentClass)));
		r.load(null);
		return r;
	}
	
	protected String getFullPath(String path) {
		return getFullPath(path, getClass());
	}
	
	protected static String getFullPath(String path, Class<?> currentClass) {
		return FileUtil.getFile(path, currentClass).getAbsolutePath();
	}
	
	protected static void registerMetamodel(String path, Class<?> currentClass) throws Exception {
		EmfUtil.register(URI.createFileURI(getFullPath(path, currentClass)), EPackage.Registry.INSTANCE);
	}
	
}
