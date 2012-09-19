/*******************************************************************************
 * Copyright (c) 2010 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.emc.hutn;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

import java.io.File;

import org.eclipse.epsilon.common.util.FileUtil;
import org.eclipse.epsilon.eol.EolEvaluator;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.hutn.test.model.HutnTestWithFamiliesMetaModel;
import org.junit.Before;
import org.junit.Test;

public class HutnModelTests extends HutnTestWithFamiliesMetaModel {

	private static final String MODEL_PATH = FileUtil.getPath("temp.model", HutnModelTests.class);

	private static final String hutn = families("Person \"p\" {" +
	                                            "  name: \"John\" " +
	                                            "}");
	
	private static final String program = "Person.all.first.name = Person.all.first.name + ' Smith';";
	
	
	@Before
	public void deleteModelFile() {
		new File(MODEL_PATH).delete();
	}
	
	@Test
	public void loadAndCheckResult() throws EolModelLoadingException {
		assertThat(executeAndGetHutn(program, hutn), containsString("John Smith"));
	}
	
	@Test
	public void saveProducesHutnSource() throws Exception {
		final String fileContents = FileUtil.getFileContents(executeAndSave(program, hutn));
		
		assertThat(fileContents, containsString("@Spec"));
		assertThat(fileContents, containsString("John Smith"));

	}

	private static String executeAndGetHutn(String program, String hutn) throws EolModelLoadingException {
		return execute(program, hutn).toString();
	}
	
	private static File executeAndSave(String program, String hutn) throws EolModelLoadingException {
		final IModel model = execute(program, hutn);
		model.store(MODEL_PATH);
		return new File(MODEL_PATH);
	}
	
	private static IModel execute(String program, String hutn) throws EolModelLoadingException {
		final IModel model = new HutnModel("Model", hutn);
		model.load();

		new EolEvaluator(model).execute(program);
		
		return model;
	}
}
