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
package org.eclipse.epsilon.egl.internal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.commons.module.ModuleElement;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.commons.parse.EpsilonTreeAdaptor;
import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.commons.util.UriUtil;
import org.eclipse.epsilon.egl.EglTemplate;
import org.eclipse.epsilon.egl.EglTemplateFactory;
import org.eclipse.epsilon.egl.exceptions.EglRuntimeException;
import org.eclipse.epsilon.egl.execute.context.IEglContext;
import org.eclipse.epsilon.egl.parse.EglLexer;
import org.eclipse.epsilon.egl.parse.EglParser;
import org.eclipse.epsilon.egl.traceability.Template;
import org.eclipse.epsilon.eol.EolLibraryModule;
import org.eclipse.epsilon.eol.EolOperations;


/**
 * Used internally by {@link EglTemplateFactory} and {@link EglTemplate}
 * to parse and execute EGL, by transforming to EOL.
 * 
 * Most extensions should subclass {@link EglTemplateFactory} and/or
 * {@link EglTemplate} rather than this class.
 *
 * @author lrose
 */
public class EglModule extends EolLibraryModule implements IEglModule {

	protected EglParser parser = null;
	protected EglLexer lexer = null;
	protected IEglContext context = null;
	protected Reader reader;
	protected EglPreprocessorModule eolModule = null;
	
	private URI templateRoot;

	public EglModule() {		
		reset();
	}

	public EglModule(IEglContext context) {
		this.context = context;
		reset();
	}

	public boolean parse(String code) throws Exception {
		return parse(code, null);
	}
	
	@Override
	public boolean parse(String code, File file) throws Exception {
		return parseFromLexer(new EglLexer(code), file);
	}
	
	public boolean parse(File file) throws IOException {
		try {
			reader = new BufferedReader(new FileReader(file));
			return parseFromLexer(new EglLexer(reader), file);
			
		} finally {
			if (reader!=null) reader.close();
		}
	}

	private boolean parseFromLexer(EglLexer lexer, File file) {
		this.sourceFile = file;
		
		if (file != null) {
			this.sourceUri = file.toURI();

			try {
				templateRoot = UriUtil.fileToUri(file.getParentFile());
			} catch (URISyntaxException e) {}
		}
		
		return parseAndPreprocess(lexer, file);
	}
	
	public boolean parse(URI uri) throws IOException {
		if (uri == null)
			throw new IllegalArgumentException("URI cannot be null");

		try {
			this.sourceUri = uri;

			if (uri.getScheme() != null && uri.getScheme().equals("file")) {
				this.sourceFile = new File(uri);
			}

			templateRoot = uri;
			
			if (context != null)
				context.getTemplateFactory().setRoot(uri);

			reader = new BufferedReader(new InputStreamReader(uri.toURL().openStream()));

			return parseAndPreprocess(new EglLexer(reader), null);

		} finally {
			if (reader!=null) reader.close();
		}
	}
	
	private boolean parseAndPreprocess(EglLexer lexer, File file) {
		this.lexer = lexer;
		EpsilonTreeAdaptor astFactory = new EpsilonTreeAdaptor(file);
		parser = new EglParser(lexer, astFactory);
		parser.parse();
		ast = parser.getAST();
		
		boolean validEol = preprocess();
		
		return parser.getParseProblems().size() == 0 && validEol;
	}

	private boolean preprocess() {
		return eolModule.preprocess(ast, sourceFile, sourceUri);
	}


	public String execute() throws EglRuntimeException {
		context.setModule(this);
		context.getTemplateFactory().setRoot(templateRoot);

		// HACK : Talk to Louis and redesign properly
		context.copyInto(eolModule.getContext());

		eolModule.execute(); 
		
		checkOutput();

		return context.getOutputBuffer().toString();
	}
	
	public String execute(Template template) throws EglRuntimeException {
		context.enter(template);
		
		final String result = execute();
		
		context.exit();
		
		return result;
	}

	private void checkOutput() throws EglRuntimeException {
		final List<String> problems = context.getPartitioningProblems();

		if (problems.size() > 0)
			throw new EglRuntimeException(problems.get(0), ast);
	}

	@Override
	public void reset() {
		super.reset();
		eolModule = new EglPreprocessorModule();
	}

	public IEglContext getContext() {
		return context;
	}

	public List<ParseProblem> getParseProblems() {
		final List<ParseProblem> combinedErrors = new ArrayList<ParseProblem>(parser.getParseProblems());

		combinedErrors.addAll(eolModule.getParseProblems());

		return combinedErrors;

	}
	
	public EolOperations getOperations() {
		return eolModule.getOperations();
	}
	
	@Override
	public AST getAst() {
		// FIXME this AST provides incorrect line and column numbers
		return eolModule.getAst();
	}
	
	public List<ModuleElement> getChildren() {
		return eolModule.getChildren();
	}
	
	public EglPreprocessorModule getPreprocessorModule() {
		return eolModule;
	}
	
}
