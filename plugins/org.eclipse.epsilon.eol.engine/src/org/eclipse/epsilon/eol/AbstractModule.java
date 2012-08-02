/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.ParserRuleReturnScope;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.eclipse.epsilon.commons.module.AbstractModuleElement;
import org.eclipse.epsilon.commons.module.IModule;
import org.eclipse.epsilon.commons.module.ModuleElement;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.commons.parse.EpsilonParseProblemManager;
import org.eclipse.epsilon.commons.parse.EpsilonParser;
import org.eclipse.epsilon.commons.parse.EpsilonTreeAdaptor;
import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.eol.annotations.EolAnnotationsUtil;
import org.eclipse.epsilon.eol.util.ReflectionUtil;


public abstract class AbstractModule extends AbstractModuleElement implements IModule {
	
	protected EpsilonParser parser;
	
	protected ArrayList<ParseProblem> parseProblems = new ArrayList<ParseProblem>();
	
	public abstract void buildModel() throws Exception;
	
	public abstract String getMainRule();
	
	public abstract Lexer createLexer(InputStream inputStream);
	
	public abstract EpsilonParser createParser(TokenStream tokenStream);
	
	public abstract void reset();

	public abstract List<ModuleElement> getChildren();
	
	public List<ParseProblem> getParseProblems() {
		return parseProblems;
	}
	
	public boolean parse(String code) throws Exception {
		return parse(code, null);
	}
	
	public boolean parse(String code, File file) throws Exception {
		this.sourceFile = file;
		if (file != null) {
			this.sourceUri = file.toURI();
		}
		
		Lexer lexer = createLexer(new ByteArrayInputStream(code.getBytes()));
		CommonTokenStream stream = new CommonTokenStream(lexer);
		EpsilonTreeAdaptor adaptor = new EpsilonTreeAdaptor(file);
		parser = createParser(stream);
		parser.setDeepTreeAdaptor(adaptor);
		return invokeMainRule();
	}
	
	public boolean parse(URI uri) throws Exception {
		this.sourceUri = uri;
		
		final String uriScheme = uri.getScheme();
		if ("file".equals(uriScheme)) {
			this.sourceFile = new File(uri);
		}
		
		Lexer lexer = null;
		BufferedReader fr = null;
		try {
			lexer = createLexer(uri.toURL().openStream());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		EpsilonTreeAdaptor adaptor = new EpsilonTreeAdaptor(uri);
		
		CommonTokenStream stream = new CommonTokenStream(lexer);
		parser = createParser(stream);
		parser.setDeepTreeAdaptor(adaptor);
		
		boolean mainRuleResult = invokeMainRule();
		
		try {
			if (fr != null) {
				fr.close();
			}
		}
		catch (Throwable t) {
			// Ignore exception
		}
		
		return mainRuleResult;
	}
	
	public boolean parse(File file) throws Exception {
		return parse(file.toURI());
	}

	protected boolean invokeMainRule() throws Exception {
		
		parseProblems.clear();
		
		EpsilonParseProblemManager.INSTANCE.reset();
		
		try {
			ast = (AST)((ParserRuleReturnScope) ReflectionUtil.executeMethod(parser,getMainRule(), new Object[]{})).getTree();
		}
		
		catch (RecognitionException ex){
			ParseProblem problem = new ParseProblem();
			problem.setLine(ex.line);
			problem.setColumn(ex.charPositionInLine);
			problem.setReason(ex.getMessage());
			getParseProblems().add(problem);			
			ex.printStackTrace();
		}
		catch (Throwable ex) {
			ParseProblem problem = new ParseProblem();
			Token next = parser.input.LT(1);
			problem.setLine(next.getLine());
			problem.setColumn(next.getCharPositionInLine());
			problem.setReason("mismatched input: '" + next.getText() + "'");
			getParseProblems().add(problem);
		}
		
		parseProblems.addAll(EpsilonParseProblemManager.INSTANCE.getParseProblems());
		EpsilonParseProblemManager.INSTANCE.reset();
		
		if (getParseProblems().size() == 0){
			EolAnnotationsUtil.assignAnnotations(ast);
			buildModel();
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public AST getAst() {
		return ast;
	}
	
}
