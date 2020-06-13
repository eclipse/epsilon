/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.examples.standalone.etl;

import java.nio.file.Path;
import java.nio.file.Paths;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.etl.launch.EtlRunConfiguration;

/**
 * This example demonstrates using the 
 * Epsilon Transformation Language, the M2M language
 * of Epsilon, in a stand-alone manner 
 * 
 * @author Sina Madani
 * @author Dimitrios Kolovos
 */
public class EtlStandaloneExample {
	
	public static void main(String[] args) throws Exception {
		Path root = Paths.get(EtlStandaloneExample.class.getResource("").toURI()),
			modelsRoot = root.getParent().resolve("models");
		
		String treeMM = modelsRoot.resolve("Tree.ecore").toAbsolutePath().toUri().toString();
		
		StringProperties sourceProperties = new StringProperties();
		sourceProperties.setProperty(EmfModel.PROPERTY_NAME, "Source");
		sourceProperties.setProperty(EmfModel.PROPERTY_FILE_BASED_METAMODEL_URI, treeMM);
		sourceProperties.setProperty(EmfModel.PROPERTY_MODEL_URI,
			modelsRoot.resolve("Tree.xmi").toAbsolutePath().toUri().toString()
		);
		
		StringProperties targetProperties = new StringProperties();
		targetProperties.setProperty(EmfModel.PROPERTY_NAME, "Target");
		targetProperties.setProperty(EmfModel.PROPERTY_FILE_BASED_METAMODEL_URI, treeMM);
		targetProperties.setProperty(EmfModel.PROPERTY_MODEL_URI,
			modelsRoot.resolve("Copy.xmi").toAbsolutePath().toUri().toString()
		);
		targetProperties.setProperty(EmfModel.PROPERTY_READONLOAD, "false");
		targetProperties.setProperty(EmfModel.PROPERTY_STOREONDISPOSAL, "true");
		
		EtlRunConfiguration runConfig = EtlRunConfiguration.Builder()
			.withScript(root.resolve("Demo.etl"))
			.withModel(new EmfModel(), sourceProperties)
			.withModel(new EmfModel(), targetProperties)
			.withParameter("parameterPassedFromJava", "Hello from pre")
			.withProfiling()
			.build();
		
		runConfig.run();
	}
}
