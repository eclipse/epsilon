/*******************************************************************************
 * Copyright (c) 2008-2013 The University of York, Antonio Garcia-Dominguez.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Antonio Garcia-Dominguez - refactor parse(...) methods
 ******************************************************************************/
package org.eclipse.epsilon.eol;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.ParserRuleReturnScope;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.eclipse.epsilon.common.module.AbstractModuleElement;
import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.parse.EpsilonParseProblemManager;
import org.eclipse.epsilon.common.parse.EpsilonParser;
import org.eclipse.epsilon.common.parse.EpsilonTreeAdaptor;
import org.eclipse.epsilon.common.parse.problem.ParseProblem;
import org.eclipse.epsilon.common.util.AstUtil;
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
	
	@Override
	public AST getAst() {
		return ast;
	}

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
		return parse(sourceUri, new ByteArrayInputStream(code.getBytes()));
	}

	public boolean parse(File file) throws Exception {
		return parse(file.toURI());
	}

	public boolean parse(URI uri) throws Exception {
		this.sourceUri = uri;

		final String uriScheme = uri.getScheme();
		if ("file".equals(uriScheme)) {
			this.sourceFile = new File(uri);
		}

		return parse(uri, uri.toURL().openStream());
	}

	protected boolean invokeMainRule() throws Exception {
		EpsilonParseProblemManager.INSTANCE.reset();
		
		try {
			AST cst = (AST)((ParserRuleReturnScope) ReflectionUtil.executeMethod(parser,getMainRule(), new Object[]{})).getTree();
			ast = createAst(cst, null);
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
	
	protected AST createAst(AST cst, AST parentAst) {
		AST ast = adapt(cst, parentAst);
		ast.setToken(cst.getToken());
		ast.setUri(cst.getUri());
		ast.setModule(cst.getModule());
		
		ast.setExtraTokens(cst.getExtraTokens());
		ast.setImaginary(cst.isImaginary());
		
		for (Object childCst : cst.getChildren()) {
			if (!(childCst instanceof AST)) continue;
			AST childAst = createAst((AST) childCst, ast);
			childAst.setParent(ast);
			ast.addChild(childAst);
		}
		return ast;
	}
	
	public AST adapt(AST cst, AST parentAst) {
		return new AST();
	}
	
	private boolean parse(URI uri, final InputStream iStream) throws Exception {
		parseProblems.clear();
		try {
			
			// Replace tabs with spaces to get consistent column numbers in ASTs
			Scanner s = new java.util.Scanner(iStream).useDelimiter("\\A");
		    String contents = s.hasNext() ? s.next() : "";
		    ByteArrayInputStream noTabsStream = new ByteArrayInputStream(contents.replaceAll("\t", " ").getBytes());
		    
			final Lexer lexer = createLexer(noTabsStream);
			final CommonTokenStream stream = new CommonTokenStream(lexer);
			final EpsilonTreeAdaptor adaptor = new EpsilonTreeAdaptor(uri, this);

			parser = createParser(stream);
			parser.setDeepTreeAdaptor(adaptor);

			return invokeMainRule();
		}
		catch (Exception ex) {
			parseProblems.add(new ParseProblem("Exception during parsing: " + ex.getLocalizedMessage(), ParseProblem.ERROR));
			throw ex;
		}
		finally {
			iStream.close();
		}
	}
	
}
