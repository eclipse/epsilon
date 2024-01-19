/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.examples.staticanalyser.ecl;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.ecl.launch.EclRunConfiguration;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.emc.emf.EmfUtil;

/**
 * This example demonstrates using the 
 * Epsilon Validation Language, the model validation language
 * of Epsilon, in a stand-alone manner
 * 
 * @author Qurat ul ain Ali
 */
public class EclStaticAnalysisStandaloneExample {

	public static void main(String... args) throws Exception {
		Path root = Paths.get(EclStaticAnalysisStandaloneExample.class.getResource("").toURI()),
			modelsRoot = root.getParent().resolve("models");
		
		StringProperties leftModel = StringProperties.Builder()
			.withProperty(EmfModel.PROPERTY_NAME, "T1")
			.withProperty(EmfModel.PROPERTY_FILE_BASED_METAMODEL_URI,
				modelsRoot.resolve("Tree.ecore").toAbsolutePath().toUri()
			)
			.withProperty(EmfModel.PROPERTY_MODEL_URI,
				modelsRoot.resolve("Tree.xmi").toAbsolutePath().toUri()
			)
			.withProperty(EmfModel.PROPERTY_CACHED, true)
			.withProperty(EmfModel.PROPERTY_CONCURRENT, true)
			.build();
		
		StringProperties rightModel = StringProperties.Builder()
				.withProperty(EmfModel.PROPERTY_NAME, "T2")
				.withProperty(EmfModel.PROPERTY_FILE_BASED_METAMODEL_URI,
					modelsRoot.resolve("Tree.ecore").toAbsolutePath().toUri()
				)
				.withProperty(EmfModel.PROPERTY_MODEL_URI,
					modelsRoot.resolve("Tree.xmi").toAbsolutePath().toUri()
				)
				.withProperty(EmfModel.PROPERTY_CACHED, true)
				.withProperty(EmfModel.PROPERTY_CONCURRENT, true)
				.build();
		
		EmfUtil.register(URI.createFileURI(modelsRoot.resolve("Tree.ecore").toAbsolutePath().toString()),
				EPackage.Registry.INSTANCE);
		
		EclRunConfiguration runConfig = EclRunConfiguration.Builder()
			.withScript(root.resolve("comparison.ecl"))
			.withModel(new EmfModel(), leftModel)
			.withModel(new EmfModel(), rightModel)
			.withProfiling()
//			.withResults()
			.withParallelism()
			.build();
		
		EclPreExecuteConfiguration sm = new EclPreExecuteConfiguration(runConfig);
		sm.run();
			
			
	}
}
