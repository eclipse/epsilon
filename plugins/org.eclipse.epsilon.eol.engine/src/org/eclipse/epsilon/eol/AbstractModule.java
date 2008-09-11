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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.ParserRuleReturnScope;
import org.antlr.runtime.RecognitionException;
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
	
	//public abstract TokenStream createLexer(Reader reader);
	
	public abstract Lexer createLexer(InputStream inputStream);
	
	//public abstract LLkParser createParser(TokenStream tokenStream);
	
	public abstract EpsilonParser createParser(TokenStream tokenStream);
	
	public abstract void reset();

	public abstract List<ModuleElement> getChildren();
	
	public List<ParseProblem> getParseProblems() {
		
		/*
		try {
			return (List) ReflectionUtil.executeMethod(parser, "getParseProblems", new Object[]{}, false, null);
		} catch (EolRuntimeException e) {
			e.printStackTrace();
			return new ArrayList();
		}*/
		return parseProblems;
		//return new ArrayList<ParseProblem>();
	}
	
	public boolean parse(String code) throws Exception {
		return parse(code, null);
	}
	
	public boolean parse(String code, File file) throws Exception {
		this.sourceFile = file;
		Lexer lexer = createLexer(new ByteArrayInputStream(code.getBytes()));
		CommonTokenStream stream = new CommonTokenStream(lexer);
		EpsilonTreeAdaptor adaptor = new EpsilonTreeAdaptor(file);
		parser = createParser(stream);
		parser.setDeepTreeAdaptor(adaptor);
		return invokeMainRule();
	}
	
	public boolean parse(URI uri) throws Exception {
		this.sourceUri = uri;
		
		if (uri.getScheme() != null && uri.getScheme().equals("file")) {
			this.sourceFile = new File(uri);
		}
		
		Lexer lexer = null;
		BufferedReader fr = null;
		try {
			
			//fr = new BufferedReader(new InputStreamReader(uri.toURL().openStream()));
			lexer = createLexer(uri.toURL().openStream());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		EpsilonTreeAdaptor adaptor = new EpsilonTreeAdaptor(sourceFile);
		
		CommonTokenStream stream = new CommonTokenStream(lexer);
		parser = createParser(stream);
		parser.setDeepTreeAdaptor(adaptor);
		
		boolean mainRuleResult = invokeMainRule();
		
		try {
			fr.close();
		}
		catch (Throwable t) {
			// Ignore exception
		}
		
		return mainRuleResult;
	}
	
	public boolean parse(File file) throws Exception {
		this.sourceFile = file;
		Lexer lexer = null;
		FileReader fr = null;
		try {
			//fr = new FileReader(file);
			lexer = createLexer(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		EpsilonTreeAdaptor astFactory = new EpsilonTreeAdaptor(file);
		
		CommonTokenStream stream = new CommonTokenStream(lexer);
		parser = createParser(stream);
		parser.setDeepTreeAdaptor(astFactory);
		
		boolean mainRuleResult = invokeMainRule();
		
		try {
			fr.close();
		}
		catch (Throwable t) {
			// Ignore exception
		}
		
		return mainRuleResult;
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
		}/*
		catch (TokenStreamRecognitionException tex) {
			RecognitionException rex = tex.recog;
			ParseProblem problem = new ParseProblem();
			problem.setLine(rex.line);
			problem.setColumn(rex.column);
			problem.setReason(rex.getMessage());
			getParseProblems().add(problem);
		}*/
		catch (Throwable ex) {
			ex.printStackTrace();
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
