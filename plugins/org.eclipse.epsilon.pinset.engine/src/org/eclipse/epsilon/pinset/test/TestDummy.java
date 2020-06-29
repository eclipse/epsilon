/*********************************************************************
 * Copyright (c) 2020 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *********************************************************************/
package org.eclipse.epsilon.pinset.test;

import java.io.File;
import java.net.URISyntaxException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.epsilon.common.parse.problem.ParseProblem;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.models.IRelativePathResolver;
import org.eclipse.epsilon.pinset.PinsetModule;

/**
 * TestDummy.
 *
 * @author Alfonso de la Vega
 * @since 2.1
 */
public class TestDummy {

	public static void main(String[] args) throws Exception {

		String rootPath = "src/org/eclipse/epsilon/pinset/test/";
		PinsetModule module = new PinsetModule();
		module.setOutputFolder("gen");
		module.parse(new File(rootPath + "dummy.pinset"));
		if (!module.getParseProblems().isEmpty()) {
			System.err.println("The following errors were identified");
			for (ParseProblem parseProblem : module.getParseProblems()) {
				System.err.println("- " + parseProblem);
			}
			return;
		}

		EmfModel emfModel = createEmfModel("M", rootPath + "dummy.model",
				rootPath + "dummy.ecore", true, false);
		module.getContext().getModelRepository().addModel(emfModel);

		module.execute();
		System.out.println("Done");
	}

	protected static EmfModel createEmfModel(String name, String model,
			String metamodel, boolean readOnLoad, boolean storeOnDisposal)
			throws EolModelLoadingException, URISyntaxException {
		EmfModel emfModel = new EmfModel();
		StringProperties properties = new StringProperties();
		properties.put(EmfModel.PROPERTY_NAME, name);
		properties.put(EmfModel.PROPERTY_FILE_BASED_METAMODEL_URI,
				URI.createFileURI(metamodel));
		properties.put(EmfModel.PROPERTY_MODEL_URI,
				URI.createFileURI(model));
		properties.put(EmfModel.PROPERTY_READONLOAD, readOnLoad + "");
		properties.put(EmfModel.PROPERTY_STOREONDISPOSAL,
				storeOnDisposal + "");
		emfModel.load(properties, (IRelativePathResolver) null);
		return emfModel;
	}
}
