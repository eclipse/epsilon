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
package org.eclipse.epsilon.egl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.epsilon.commons.module.ModuleElement;
import org.eclipse.epsilon.commons.parse.EpsilonTreeAdaptor;
import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.commons.util.UriUtil;
import org.eclipse.epsilon.egl.exceptions.EglRuntimeException;
import org.eclipse.epsilon.egl.exceptions.EglStoppedException;
import org.eclipse.epsilon.egl.execute.EglExecutorFactory;
import org.eclipse.epsilon.egl.execute.context.EglContext;
import org.eclipse.epsilon.egl.execute.context.IEglContext;
import org.eclipse.epsilon.egl.merge.output.Output;
import org.eclipse.epsilon.egl.parse.EglLexer;
import org.eclipse.epsilon.egl.parse.EglParser;
import org.eclipse.epsilon.egl.parse.problem.EglParseProblem;
import org.eclipse.epsilon.egl.preprocessor.Preprocessor;
import org.eclipse.epsilon.egl.traceability.Template;
import org.eclipse.epsilon.eol.EolLibraryModule;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.EolOperations;
import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.exceptions.EolInternalException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

public class EglModule extends EolLibraryModule implements IEglModule {

	protected EglParser parser = null;
	protected EglLexer lexer = null;
	protected IEglContext context = null;
	protected Reader reader;
	protected String eol = null;
	protected IEolModule eolModule = null;
	protected Preprocessor preprocessor = null;

	public EglModule() {
		reset();
	}

	public EglModule(IEglContext callersContext) {
		reset(callersContext);
	}

	@Override
	public boolean parse(String code) {
		lexer = new EglLexer(code);
		EpsilonTreeAdaptor astFactory = new EpsilonTreeAdaptor(null);
		parser = new EglParser(lexer, astFactory);
		parser.parse();

		if (parser.getParseProblems().isEmpty()){
			this.ast = parser.getAST();
			boolean validEol = preprocess();
			return validEol;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean parse(URI uri) throws IOException {
		if (uri == null)
			throw new IllegalArgumentException("URI cannot be null");

		try {
			this.sourceUri = uri;

			if (uri.getScheme() != null && uri.getScheme().equals("file")) {
				this.sourceFile = new File(uri);
			}

			context.getTemplateFactory().setRoot(uri);

			reader = new BufferedReader(new InputStreamReader(uri.toURL().openStream()));
			lexer = new EglLexer(reader);
			EpsilonTreeAdaptor astFactory = new EpsilonTreeAdaptor(null);
			parser = new EglParser(lexer, astFactory);
			parser.parse();
			ast = parser.getAST();

			boolean validEol = preprocess();

			return parser.getParseProblems().size() == 0 && validEol;
		} finally {
			if (reader!=null) reader.close();
		}
	}

	@Override
	public boolean parse(File file) throws IOException {
		try {
			this.sourceFile = file;

			// Attempt to set the root of the template factory to the source file
			try {
				context.getTemplateFactory().setRoot(UriUtil.fileToUri(file.getParentFile()));
			} catch (URISyntaxException e) {}

			reader = new BufferedReader(new FileReader(file));
			lexer = new EglLexer(reader);
			EpsilonTreeAdaptor astFactory = new EpsilonTreeAdaptor(file);
			parser = new EglParser(lexer, astFactory);
			parser.parse();
			ast = parser.getAST();

			boolean validEol = preprocess();

			return parser.getParseProblems().size() == 0 && validEol;
		} finally {
			if (reader!=null) reader.close();
		}
	}

	private boolean preprocess() {
		// Default to an empty template
		context.setTemplate(new Template());

		try {
			// Do better if we can
			if (sourceFile != null)
				context.setTemplate(new Template(UriUtil.fileToUri(sourceFile)));

		} catch (URISyntaxException e) {}



		// Convert EGL to EOL
		eol = preprocessor.convertToEol(ast);

		try {
			eolModule.setOperationFactory(new EglOperationFactory());
			return eolModule.parse(eol, sourceFile);

		} catch (Exception e) {
			// Ignore - clients are expected to call
			// getParseProblems in order to check for problems
		}

		return false;
	}


	public String execute() throws EglRuntimeException {
		context.setModule(this);

		context.clearOutputBuffer();

//		context.getOutputStream().print(eol);
//		context.getOutputStream().print(preprocessor.getTrace());

		// HACK : Talk to Louis and redesign properly
		/**
		 * @see EglContextImpl.copyInto(IEolContext context)
		 */
		context.copyInto(eolModule.getContext());

		// Parse generated EOL
		try {
			eolModule.execute();

		} catch (EolInternalException ex) {
			if (ex.getInternal() instanceof EglStoppedException) {
				// Ignore exception caused by a call to out.stop()

			} else if (ex.getInternal() instanceof EglRuntimeException) {
				throw new EglRuntimeException(ex, preprocessor.getTrace());

			} else if (ex instanceof EolRuntimeException) {
				throw new EglRuntimeException((EolRuntimeException)ex, preprocessor.getTrace());
			}
			else {
				context.getErrorStream().print(ex.getStackTrace());
			}

		} catch (EolRuntimeException ex){
			if (!(ex instanceof EglRuntimeException))
				throw new EglRuntimeException(ex, preprocessor.getTrace());
		}

		checkOutput();

		return context.getOutputBuffer().toString();
	}

	private void checkOutput() throws EglRuntimeException {
		final String       text     = context.getOutputBuffer().toString();
		final Output       output   = context.getPartitioner().partition(text);
		final List<String> problems = output.getProblems();

		if (problems.size() > 0)
			throw new EglRuntimeException(problems.get(0), ast);
	}

	@Override
	public void reset() {
		reset(null);
	}

	@Override
	public EolOperations getOperations() {
		return eolModule.getOperations();
	}

	private void reset(IEglContext existingContext) {
		super.reset();

		// Added .egl to the types of import files the internal eol module can handle
		eolModule = new EolModule() {
			public HashMap<String, Class> getImportConfiguration() {
				HashMap<String, Class> importConfiguration = new HashMap();
				importConfiguration.put("eol", EolLibraryModule.class);
				importConfiguration.put("egl", EglModule.class);
				return importConfiguration;
			}
		};
		eol = null;
		preprocessor = new Preprocessor();

		if (existingContext==null) {
			context = createContext(null);

			// Configure context to use EGL Executor Factory (for extra types)
			context.setExecutorFactory(new EglExecutorFactory());


		} else {
			context = createContext(existingContext);
		}

		context.setModule(this);

		// If we add something on the EGL context, it is not added to the EOL context :(
		context.copyInto(eolModule.getContext());
	}

	// TODO - wouldn't a context factory be better, no need for each subclass
	//        to implement this method then
   /**
	 * Create a new context, possibly initialising it from the given caller context.
	 *
	 * @param callerContext
	 * @return
	 */
	protected IEglContext createContext(IEglContext callerContext) {
		if (callerContext != null) {
			return new EglContext(callerContext);
		} else {
			return new EglContext();
		}
	}

	@Override
	public IEglContext getContext(){
		return context;
	}

	@Override
	public List<ParseProblem> getParseProblems() {
		List<ParseProblem> combinedErrors = new ArrayList<ParseProblem>(parser.getParseProblems());

		for (ParseProblem anomaly : eolModule.getParseProblems()){
			combinedErrors.add(new EglParseProblem(anomaly, preprocessor.getTrace()));
		}

		return combinedErrors;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ModuleElement> getChildren() {
		return eolModule.getChildren();
	}
}
