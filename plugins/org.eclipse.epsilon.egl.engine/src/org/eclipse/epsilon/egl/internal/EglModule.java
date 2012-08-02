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
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedList;
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
import org.eclipse.epsilon.egl.formatter.Formatter;
import org.eclipse.epsilon.egl.model.EglSection;
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
	protected EglPreprocessorModule preprocessorModule = null;
	
	private final List<EglSection> sections = new LinkedList<EglSection>();	
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
	
	public boolean parse(File file) throws Exception {
		return parse(file.toURI());
	}

	private boolean parseFromLexer(EglLexer lexer, File file) throws Exception {
		this.sourceFile = file;
		
		if (file != null) {
			this.sourceUri = file.toURI();

			try {
				templateRoot = UriUtil.fileToUri(file.getParentFile());
			} catch (URISyntaxException e) {}
		}
		
		return parseAndPreprocess(lexer, file);
	}
	
	public boolean parse(URI uri) throws Exception {
		if (uri == null)
			throw new IllegalArgumentException("URI cannot be null");

		try {
			this.sourceUri = uri;
			this.templateRoot = uri;

			if (uri.getScheme() != null && uri.getScheme().equals("file")) {
				this.sourceFile = new File(uri);
			}

			reader = new BufferedReader(new InputStreamReader(uri.toURL().openStream()));
			return parseAndPreprocess(new EglLexer(reader), this.sourceFile);
		} finally {
			if (reader!=null) reader.close();
		}
	}
	
	private boolean parseAndPreprocess(EglLexer lexer, File file) throws Exception {
		this.lexer = lexer;
		EpsilonTreeAdaptor astFactory = new EpsilonTreeAdaptor(file);
		parser = new EglParser(lexer, astFactory);
		parser.parse();
		ast = parser.getAST();
		
		final boolean validEgl = parser.getParseProblems().size() == 0;
		final boolean validEol = preprocess();
		
		if (validEgl && validEol) {
			buildModel();
		}
		
		return validEgl && validEol;
	}

	private boolean preprocess() {
		return preprocessorModule.preprocess(ast, sourceFile, sourceUri);
	}
	
	public void buildModel() throws Exception {
		for (AST child : ast.getChildren()) {
			final EglSection section = EglSection.createFrom(child);
			
			if (section != null) {
				sections.add(section);
			}
		}
	}
	
	public EglResult execute(Template template, Formatter postprocessor) throws EglRuntimeException {
		context.enter(template);
		
		final String generatedText = execute(postprocessor);
		
		context.exit();
		
		return new EglResult(generatedText);
	}

	private String execute(Formatter postprocessor) throws EglRuntimeException {
		context.setModule(this);
		context.getTemplateFactory().initialiseRoot(templateRoot);

		// HACK : Talk to Louis and redesign properly
		context.copyInto(preprocessorModule.getContext());

		preprocessorModule.execute(); 
		context.formatWith(postprocessor);
		context.getFineGrainedTraceManager().appendToFineGrainedTrace(preprocessorModule.getContext().getTraceabilityContext().getFineGrainedTrace());
		
		checkOutput();
		
		return context.getOutputBuffer().toString();
	}


	private void checkOutput() throws EglRuntimeException {
		final List<String> problems = context.getPartitioningProblems();

		if (problems.size() > 0)
			throw new EglRuntimeException(problems.get(0), ast);
	}

	@Override
	public void reset() {
		super.reset();
		preprocessorModule = new EglPreprocessorModule();
	}

	public IEglContext getContext() {
		return context;
	}

	public List<ParseProblem> getParseProblems() {
		final List<ParseProblem> combinedErrors = new ArrayList<ParseProblem>(parser.getParseProblems());

		combinedErrors.addAll(preprocessorModule.getParseProblems());

		return combinedErrors;

	}
	
	public EolOperations getOperations() {
		return preprocessorModule.getOperations();
	}
	
	@Override
	public AST getAst() {
		return preprocessorModule.getAst();
	}
	
	public List<ModuleElement> getChildren() {
		final List<ModuleElement> children = new LinkedList<ModuleElement>();
		
		children.addAll(preprocessorModule.getImports());
		children.addAll(sections);
		children.addAll(preprocessorModule.getDeclaredOperations());
		
		return children;
	}
}
