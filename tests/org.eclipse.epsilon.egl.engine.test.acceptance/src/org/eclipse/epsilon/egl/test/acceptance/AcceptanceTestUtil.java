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
import java.net.URI;
import java.util.List;

import org.eclipse.epsilon.egl.EglTemplate;
import org.eclipse.epsilon.egl.EglFileGeneratingTemplateFactory;
import org.eclipse.epsilon.egl.exceptions.EglRuntimeException;
import org.eclipse.epsilon.egl.execute.context.IEglContext;
import org.eclipse.epsilon.egl.status.StatusMessage;
import org.eclipse.epsilon.egl.EglTemplateFactory;
import org.eclipse.epsilon.egl.test.models.Model;
import org.eclipse.epsilon.egl.traceability.Template;
import org.eclipse.epsilon.egl.util.FileUtil;
import org.eclipse.epsilon.egl.util.StringUtil;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;

public class AcceptanceTestUtil {
	
	private AcceptanceTestUtil() {}
	
	private static IEglContext context;
	
	public static void test(File program, File expected, Model... models) throws IOException, EglRuntimeException, EolModelLoadingException {
		test(program, FileUtil.read(expected), models);
	}
	
	public static void test(URI program, File expected, Model... models) throws IOException, EglRuntimeException, EolModelLoadingException {
		test(program, FileUtil.read(expected), models);
	}
	
	public static void test(Object program, String expected, Model... models) throws EglRuntimeException, EolModelLoadingException {
		final String actual = run(program, models);
		
		assertEquals(StringUtil.normalizeNewlines(expected), StringUtil.normalizeNewlines(actual));
	}
	
	
	public static void testWithoutNormalizingNewlines(String program, String expected, Model... models) throws EglRuntimeException, EolModelLoadingException {
		final String actual = run(program, models);
		
		assertEquals(expected, actual);
	}

	public static String run(Object program, Model... models) throws EolModelLoadingException, EglRuntimeException {
		return run(new EglFileGeneratingTemplateFactory(), program, models);
	}
	
	public static String run(EglTemplateFactory factory, Object program, Model... models) throws EglRuntimeException, EolModelLoadingException {
		context = factory.getContext();
		loadModels(models);

		final EglTemplate template;
		
		if (program instanceof File) {
			final File file = (File)program;
			
			factory.setRoot(file.getParentFile().toURI());
			template = factory.load(file.getName());
			
		} else if (program instanceof URI) {
			template = factory.load((URI)program);
			
		} else if (program instanceof String) {
			template = factory.prepare((String)program);

		} else
			throw new IllegalArgumentException("Cannot run a program of type: " + program.getClass().getCanonicalName());
				
		final String result = template.process();
		
		report();
		
		return result;
	}
	
	private static void loadModels(Model... models) throws EolModelLoadingException {
		for (Model model : models) {
			context.getModelRepository().addModel(model.loadEmfModel());
		}
	}
	
	private static void report() {
		for (StatusMessage message : context.getStatusMessages()) {
			System.out.println(message);
		}
	}
	
	public static List<StatusMessage> getStatusMessages() {
		return context.getStatusMessages();
	}
	
	public static Template getTemplate() {
		return context.getBaseTemplate();
	}
}
