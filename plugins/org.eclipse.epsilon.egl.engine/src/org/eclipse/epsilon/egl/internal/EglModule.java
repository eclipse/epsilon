/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Louis Rose - initial API and implementation
 *     Sina Madani - refactoring
 ******************************************************************************/
package org.eclipse.epsilon.egl.internal;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.parse.EpsilonTreeAdaptor;
import org.eclipse.epsilon.common.parse.problem.ParseProblem;
import org.eclipse.epsilon.common.util.UriUtil;
import org.eclipse.epsilon.egl.EglTemplate;
import org.eclipse.epsilon.egl.EglTemplateFactory;
import org.eclipse.epsilon.egl.exceptions.EglRuntimeException;
import org.eclipse.epsilon.egl.execute.context.EglContext;
import org.eclipse.epsilon.egl.execute.context.IEglContext;
import org.eclipse.epsilon.egl.formatter.Formatter;
import org.eclipse.epsilon.egl.model.EglMarkerSection;
import org.eclipse.epsilon.egl.parse.EglLexer;
import org.eclipse.epsilon.egl.parse.EglParser;
import org.eclipse.epsilon.egl.parse.EglToken.TokenType;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.dom.OperationList;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

/**
 * Used internally by {@link EglTemplateFactory} and {@link EglTemplate}
 * to parse and execute EGL, by transforming to EOL.
 * 
 * Most extensions should subclass {@link EglTemplateFactory} and/or
 * {@link EglTemplate} rather than this class.
 *
 * @author lrose
 */
public class EglModule extends EolModule implements IEglModule {

	protected EglParser parser;
	protected EglPreprocessorModule preprocessorModule;	
	private final List<EglMarkerSection> markers = new LinkedList<>();	
	private URI templateRoot;

	public EglModule() {
		this(new EglContext());
	}
	
	public EglModule(IEglContext context) {
		setContext(context);
		preprocessorModule = new EglPreprocessorModule(context);
	}

	@Override
	public boolean parse(String code) throws Exception {
		return parse(code, null);
	}
	
	@Override
	public boolean parse(String code, File file) throws Exception {
		return parseFromLexer(new EglLexer(code), file);
	}
	
	@Override
	public boolean parse(File file) throws Exception {
		return parse(file.toURI());
	}
	
	private boolean parseFromLexer(EglLexer lexer, File file) throws Exception {
		this.sourceFile = file;
		
		if (file != null) {
			this.sourceUri = file.toURI();

			try {
				templateRoot = UriUtil.fileToUri(file.getAbsoluteFile().getParentFile());
			}
			catch (URISyntaxException e) {}
		}
		
		return parseAndPreprocess(lexer, file);
	}
	
	@Override
	public boolean parse(URI uri) throws Exception {
		if (uri == null)
			throw new IllegalArgumentException("URI cannot be null");

		this.sourceUri = uri;
		this.templateRoot = uri;

		if (uri.getScheme() != null && uri.getScheme().equals("file")) {
			this.sourceFile = new File(uri);
		}

		try (Reader reader = new BufferedReader(new InputStreamReader(uri.toURL().openStream()))) {
			return parseAndPreprocess(new EglLexer(reader), this.sourceFile);
		}
	}
	
	private boolean parseAndPreprocess(EglLexer lexer, File file) throws Exception {
		EpsilonTreeAdaptor astFactory = new EpsilonTreeAdaptor(file, this);
		parser = new EglParser(lexer, astFactory);
		parser.parse();
		AST ast = parser.getAST();
		
		final boolean validEgl = parser.getParseProblems().isEmpty();
		final boolean validEol = preprocessorModule.preprocess(ast, sourceFile, sourceUri);

		if (validEgl && validEol) {
			for (AST child : ast.getChildren()) {
				if (child.getType() == TokenType.START_MARKER_TAG.getIdentifier()) {
					EglMarkerSection section = (EglMarkerSection) createAst(child, this);
					markers.add(section);
				}
			}
		}
		
		return validEgl && validEol;
	}
	
	@Override
	public ModuleElement adapt(AST cst, ModuleElement parentAst) {
		if (cst == null) return this;
		if (cst.getType() == TokenType.START_MARKER_TAG.getIdentifier()) return new EglMarkerSection();
		return null;
	}
	
	@Override
	public EglPreprocessorModule getPreprocessorModule() {
		return preprocessorModule;
	}
	
	@Override
	public List<EglMarkerSection> getMarkers() {
		return markers;
	}
	
	@Override
	public Object execute(EglTemplate template, Formatter postprocessor) throws EglRuntimeException {
		IEglContext context = getContext();
		context.enter(template);
		
		context.setModule(this);
		context.getTemplateFactory().initialiseRoot(templateRoot);
		
		preprocessorModule.execute();
		
		context.formatWith(postprocessor);
		
		final List<String> problems = context.getPartitioningProblems();
		if (problems.size() > 0) {
			throw new EglRuntimeException(problems.get(0), this);
		}
		
		String result = context.getOutputBuffer().toString();
		
		context.exit();
		return result;
	}

	@Override
	public List<ParseProblem> getParseProblems() {
		final List<ParseProblem> combinedErrors = new ArrayList<>(parser.getParseProblems());
		combinedErrors.addAll(preprocessorModule.getParseProblems());
		return combinedErrors;
	}
	
	@Override
	public OperationList getOperations() {
		return preprocessorModule.getOperations();
	}

	@Override
	public List<ModuleElement> getChildren() {
		final List<ModuleElement> children = new ArrayList<>();
		children.addAll(preprocessorModule.getImports());
		//children.addAll(sections);
		children.addAll(preprocessorModule.getDeclaredOperations());
		return children;
	}

	@Override
	public IEglContext getContext() {
		return (IEglContext) super.getContext();
	}
	
	@Override
	public void setContext(IEolContext context) {
		if (context instanceof IEglContext) {
			this.context = context;
		}
	}
}
