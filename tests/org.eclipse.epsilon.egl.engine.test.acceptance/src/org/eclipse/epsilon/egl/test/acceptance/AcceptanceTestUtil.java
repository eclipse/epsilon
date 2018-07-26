/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.test.acceptance;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.net.URI;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.epsilon.common.parse.problem.ParseProblem;
import org.eclipse.epsilon.egl.EglFileGeneratingTemplate;
import org.eclipse.epsilon.egl.EglFileGeneratingTemplateFactory;
import org.eclipse.epsilon.egl.EglTemplate;
import org.eclipse.epsilon.egl.EglTemplateFactory;
import org.eclipse.epsilon.egl.execute.context.IEglContext;
import org.eclipse.epsilon.egl.status.StatusMessage;
import org.eclipse.epsilon.egl.test.models.Model;
import org.eclipse.epsilon.egl.traceability.Template;
import org.eclipse.epsilon.egl.util.FileUtil;
import org.eclipse.epsilon.egl.util.StringUtil;
import org.eclipse.epsilon.eol.models.IModel;

public class AcceptanceTestUtil {
	
	private AcceptanceTestUtil() {}
	
	private static IEglContext context;
	
	public static void test(File program, File expected, Model... models) throws Exception {
		test(program, FileUtil.read(expected), models);
	}
	
	public static void test(URI program, File expected, Model... models) throws Exception {
		test(program, FileUtil.read(expected), models);
	}
	
	public static void test(Object program, String expected, Model... models) throws Exception {
		final String actual = run(program, models);
		
		assertEquals(StringUtil.normalizeNewlines(expected), StringUtil.normalizeNewlines(actual));
	}
	
	
	public static String run(Object program, Model... models) throws Exception {
		return run(new EglFileGeneratingTemplateFactory(), program, models);
	}
	
	public static String run(Object program, IModel model) throws Exception {
		return run(new EglFileGeneratingTemplateFactory(), program, model);
	}
	
	private static EglTemplate current;
	
	public static String run(EglTemplateFactory factory, Object program, Model... modelSpecs) throws Exception {
		final List<IModel> models = new LinkedList<IModel>();
		
		for (Model modelSpec : modelSpecs) {
			models.add(modelSpec.loadEmfModel());
		}
	
		return run(factory, program, models.toArray(new IModel[]{}));
	}
	
	public static String run(EglTemplateFactory factory, Object program, IModel... models) throws Exception {
		context = factory.getContext();
		
		for (IModel model : models) {
			context.getModelRepository().addModel(model);
		}

		current = loadTemplate(factory, program);
		
		for (ParseProblem problem : current.getParseProblems()) {
			System.err.println(problem);
		}
		
		final String result = current.process();
		
		report();
		
		return result;
	}
	
	public static void generate(EglTemplateFactory factory, Object program, String destination, IModel... models) throws Exception {
		context = factory.getContext();
		
		for (IModel model : models) {
			context.getModelRepository().addModel(model);
		}

		current = loadTemplate(factory, program);
		
		for (ParseProblem problem : current.getParseProblems()) {
			System.err.println(problem);
		}
		
		((EglFileGeneratingTemplate)current).generate(destination);
		
		report();
	}

	private static EglTemplate loadTemplate(EglTemplateFactory factory, Object program) throws Exception {
		final EglTemplate template;
		
		if (program instanceof File) {
			final File file = (File)program;
			
			factory.initialiseRoot(file.getParentFile().toURI());
			template = factory.load(file.getName());
			
		} else if (program instanceof URI) {
			template = factory.load((URI)program);
			
		} else if (program instanceof String) {
			template = factory.prepare((String)program);

		} else
			throw new IllegalArgumentException("Cannot run a program of type: " + program.getClass().getCanonicalName());

		return template;
	}
	
	public static Collection<ParseProblem> getParseProblems() {
		return current.getParseProblems();
	}
	
	private static void report() {
		for (StatusMessage message : context.getStatusMessages()) {
			System.out.println(message);
		}
	}
	
	public static List<StatusMessage> getStatusMessages() {
		return context.getStatusMessages();
	}
	
	public static Template getTrace() {
		return context.getTrace();
	}
}
