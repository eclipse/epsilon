/*******************************************************************************

 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.examples.staticanalyser.eol;

import java.nio.file.Path;
import java.nio.file.Paths;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.launch.EolRunConfiguration;

/**
 * This example demonstrates applying static analysis on EOL programs,
 * in a stand-alone manner 
 * 
 * @author Sina Madani
 * @author Dimitrios Kolovos
 */
public class EolStaticAnalysisStandaloneExample {
	
	public static void main(String[] args) throws Exception {
		Path root = Paths.get(EolStaticAnalysisStandaloneExample.class.getResource("").toURI()),
			modelsRoot = root.getParent().resolve("models");
		
		String treeMM = modelsRoot.resolve("Tree.ecore").toAbsolutePath().toUri().toString();
		
		StringProperties modelProperties = new StringProperties();
		modelProperties.setProperty(EmfModel.PROPERTY_NAME, "test");
		modelProperties.setProperty(EmfModel.PROPERTY_FILE_BASED_METAMODEL_URI, treeMM);
		modelProperties.setProperty(EmfModel.PROPERTY_MODEL_URI,
			modelsRoot.resolve("Tree.xmi").toAbsolutePath().toUri().toString()
		);
		
		EolRunConfiguration runConfig = EolRunConfiguration.Builder()
			.withScript(root.resolve("Demo.eol"))
			.withModel(new EmfModel(), modelProperties)
			.withParameter("greeting", "Hello")
			.withProfiling()
			.build();
		
		EolPreExecuteConfiguration sm = new EolPreExecuteConfiguration(runConfig);
		sm.run();
		runConfig.dispose();
	}
}
