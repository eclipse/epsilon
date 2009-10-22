/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.test.acceptance;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.eclipse.epsilon.egl.EglModule;
import org.eclipse.epsilon.egl.IEglModule;
import org.eclipse.epsilon.egl.exceptions.EglRuntimeException;
import org.eclipse.epsilon.egl.status.StatusMessage;
import org.eclipse.epsilon.egl.test.models.Model;
import org.eclipse.epsilon.egl.traceability.Template;
import org.eclipse.epsilon.egl.util.FileUtil;
import org.eclipse.epsilon.egl.util.StringUtil;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;

public class AcceptanceTestUtil {
	
	private AcceptanceTestUtil() {}
	
	private final static IEglModule module = new EglModule();
	
	public static void test(File program, File expected, Model... models) throws IOException, EglRuntimeException, EolModelLoadingException {
		test(program, FileUtil.read(expected), models);
	}
	
	public static void test(File program, String expected, Model... models) throws IOException, EglRuntimeException, EolModelLoadingException {
		final String actual = run(program, models);
		
		assertEquals(StringUtil.normalizeNewlines(expected), StringUtil.normalizeNewlines(actual));
	}
	
	
	public static void testWithoutNormalizingNewlines(String program, String expected, Model... models) throws IOException, EglRuntimeException, EolModelLoadingException {
		final String actual = run(program, models);
		
		assertEquals(expected, actual);
	}
	
	
	
	public static String run(File program, Model... models) throws EglRuntimeException, IOException, EolModelLoadingException {
		return run((Object)program, models);
	}
	
	public static String run(String program, Model... models) throws EglRuntimeException, IOException, EolModelLoadingException {
		return run((Object)program, models);
	}
	
	private static String run(Object program, Model... models) throws EglRuntimeException, IOException, EolModelLoadingException {
		module.reset();
		
		loadModels(models);
		
		if (program instanceof File)
			module.parse((File)program);
		else if (program instanceof String)
			module.parse((String)program);
		else
			throw new IllegalArgumentException("Cannot run a program of type: " + program.getClass().getCanonicalName());
		
		final String result = module.execute();
		
		report();
		
		return result;
	}
	
	private static void loadModels(Model... models) throws EolModelLoadingException {
		for (Model model : models) {
			module.getContext().getModelRepository().addModel(model.loadEmfModel());
		}
	}
	
	private static void report() {
		for (StatusMessage message : module.getContext().getStatusMessages()) {
			System.out.println(message);
		}
	}
	
	public static List<StatusMessage> getStatusMessages() {
		return module.getContext().getStatusMessages();
	}
	
	public static Template getTemplate() {
		return module.getContext().getTemplate();
	}
}
