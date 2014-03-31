/*******************************************************************************
 * Copyright (c) 2014 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egx.engine.test.acceptance;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.eclipse.epsilon.common.parse.problem.ParseProblem;
import org.eclipse.epsilon.common.util.FileUtil;
import org.eclipse.epsilon.egl.EglFileGeneratingTemplateFactory;
import org.eclipse.epsilon.egl.EgxModule;
import org.eclipse.epsilon.egx.engine.test.acceptance.util.FamiliesModelConstructor;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.hutn.test.model.HutnTestWithFamiliesMetaModel;

public class EgxAcceptanceTest extends HutnTestWithFamiliesMetaModel {

	public static void runEgx(File egxFile, String hutnModel) throws Exception {
		IModel m = new FamiliesModelConstructor().constructModel("MyFamily", hutnModel);
		
		EglFileGeneratingTemplateFactory factory = new EglFileGeneratingTemplateFactory();
		factory.setRoot(egxFile.getParentFile().toURI());
		
		EgxModule module = new EgxModule(factory);
		module.getContext().getModelRepository().addModel(m);
		module.parse(egxFile);
		
		if (!module.getParseProblems().isEmpty()) {
			for (ParseProblem p : module.getParseProblems()) {
				System.err.println(p);
			}
			throw new IllegalArgumentException("Error encountered whilst parsing EGX");
		}
		
		module.execute();
	}
}
