/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.egl.internal;

import java.io.File;
import java.net.URI;
import java.util.HashMap;
import java.util.List;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.egl.exceptions.EglRuntimeException;
import org.eclipse.epsilon.egl.exceptions.EglStoppedException;
import org.eclipse.epsilon.egl.parse.problem.EglParseProblem;
import org.eclipse.epsilon.egl.preprocessor.Preprocessor;
import org.eclipse.epsilon.eol.EolLibraryModule;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.exceptions.EolInternalException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

public class EglPreprocessorModule extends EolModule {

	private final Preprocessor preprocessor = new Preprocessor();
	
	public boolean preprocess(AST ast, File sourceFile, URI sourceUri) {
		this.sourceFile = sourceFile;
		this.sourceUri  = sourceUri;
		
		final String eol = preprocessor.convertToEol(ast);

		try {
			setOperationFactory(new EglOperationFactory());
			if (parse(eol, sourceFile)) {
				updateASTLocations(this.ast);
				return true;
			}

		} catch (Exception e) {
			// Ignore - clients are expected to call
			// getParseProblems in order to check for problems
		}

		return false;
	}
	
	protected void updateASTLocations(AST ast) {
		ast.setColumn(preprocessor.getTrace().getEglColumnNumberFor(ast.getLine(), ast.getColumn()));
		ast.setLine(preprocessor.getTrace().getEglLineNumberFor(ast.getLine()));
		for (AST child : ast.getChildren()) {
			updateASTLocations(child);
		}
	}
	
	@Override
	public Object execute() throws EglRuntimeException {
		try {
			return super.execute();

		} catch (EolInternalException ex) {
			if (ex.getInternal() instanceof EglStoppedException) {
				// Ignore exception caused by a call to out.stop()		
			} else if (ex.getInternal() instanceof EglRuntimeException) {
				throw new EglRuntimeException(ex);
			}
		} catch (EolRuntimeException ex) {
			if (ex instanceof EglRuntimeException) {
				throw (EglRuntimeException)ex;
			} else {
				throw new EglRuntimeException(ex);
			}
		}
		
		return null;
	}
	
	@Override
	public List<ParseProblem> getParseProblems() {
		final List<ParseProblem> parseProblems = super.getParseProblems();
		
		for (int index = 0; index < parseProblems.size(); index++) {
			final ParseProblem problem = parseProblems.get(index);
			
			if (!(problem instanceof EglParseProblem)) {
				parseProblems.remove(index);
				parseProblems.add(index, new EglParseProblem(problem, preprocessor.getTrace()));
			}
		}
		
		return parseProblems;
	}
	
	@SuppressWarnings("rawtypes")
	private static final HashMap<String, Class> importConfiguration = new HashMap<String, Class>();
	static {
		importConfiguration.put("eol", EolLibraryModule.class);
		importConfiguration.put("egl", EglModule.class);
	}
	
	/**
	 * Get the import configurations for this translation. Notice that when overriding this method, 
	 * it is illegal to call super and change the map received. To avoid this kind of problem, the
	 * method is declared final.
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public final HashMap<String, Class> getImportConfiguration() {
		return importConfiguration;
	}
}
