/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.concordance.test.performance.generator.xrefs;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.common.util.FileUtil;
import org.eclipse.epsilon.concordance.test.performance.generator.graph.GraphGenerator;
import org.eclipse.epsilon.emc.emf.EmfUtil;

public class CrossReferencingGraphsGeneratorApp {

	public static void main(String[] args) throws Exception {
		EmfUtil.register(getMetamodelUri(), EPackage.Registry.INSTANCE);
		
		new CrossReferencingGraphsGenerator().generate(new File("/Users/louis/gen"), "Graph", 100);
		
		System.out.println("Generation complete.");
	}
	
	private static File getMetamodelFile() {
		return FileUtil.getFile("Graph.ecore", GraphGenerator.class);
	}
	
	private static URI getMetamodelUri() {
		return URI.createFileURI(getMetamodelFile().getAbsolutePath());
	}
}
