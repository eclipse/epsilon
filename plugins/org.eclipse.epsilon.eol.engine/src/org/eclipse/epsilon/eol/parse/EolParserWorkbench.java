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
package org.eclipse.epsilon.eol.parse;

import java.io.File;
import java.io.FileInputStream;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;
import org.eclipse.epsilon.common.parse.EpsilonParseProblemManager;
import org.eclipse.epsilon.common.parse.StaticFieldNameResolver;
import org.eclipse.epsilon.common.parse.problem.ParseProblem;
import org.eclipse.epsilon.common.util.FileUtil;
import org.eclipse.epsilon.eol.EolModule;

public class EolParserWorkbench {
	
	public static void main(String[] args) throws Exception {
		new EolParserWorkbench().work();
	}
	
	static String basePath = FileUtil.getPath("test.eol", EolParserWorkbench.class);
	
	
	public void workPathName() throws Exception {
		//String basePath = "E:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.eol.engine\\src\\org\\eclipse\\epsilon\\eol\\parse\\test.eol";
		
		//r = new StaticFieldNameResolver(EolParser.class);
		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(basePath));
		EolLexer lexer = new EolLexer(input);
		
		/*
		Token t = lexer.nextToken();
		StaticFieldNameResolver r = new StaticFieldNameResolver(EolLexer.class);
		while (t.getText()!=null) {
			System.err.println(t.getText() + "->" + r.getField(t.getType()));
			t = lexer.nextToken();
		}
		
		if (1 > 0) return;
		*/
		
		CommonTokenStream stream = new CommonTokenStream(lexer);
		EolParser parser = new EolParser(stream);
		
		//EolModule module = new EolModule();
		//module.parse(new File(basePath));
		
		
		//new V2V3Viewer(module.getAst(),parser.eolModule().tree ,EolParserTokenTypes.class, EolParser.class);
		
		System.err.println(((CommonTree)parser.eolModule().getTree()).toStringTree());
		
		//print(((Tree)parser.pathName().getTree()), 0);
	}
	
	StaticFieldNameResolver r;
	
	public void work() throws Exception {
		
		/*
		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(basePath));
		EolLexer lexer = new EolLexer(input);
		CommonTokenStream stream = new CommonTokenStream(lexer);
		EolParser parser = new EolParser(stream);

		EpsilonParseProblemManager.INSTANCE.reset();
		
		Tree tree = parser.eolModule().tree;
		for (ParseProblem problem : EpsilonParseProblemManager.INSTANCE.getParseProblems()) {
			System.err.println(problem);
		}*/
		
		EolModule module = new EolModule();
		module.parse(new File(basePath));
		
		if (module.getParseProblems().size() > 0) {
			for (ParseProblem pp : module.getParseProblems()) {
				System.err.println(pp);
			}
			//return;
		}
		
		new AstExplorer(module.getAst(), EolParser.class);
	}
	
	public void print(Tree tree, int indent) {
		System.err.println(getIndent(indent) + tree.getText());// + "->" + r.getField(tree.getType()) + " [" + tree.getLine() + ":" + tree.getCharPositionInLine() + "]");
		for (int i=0;i<tree.getChildCount();i++) {
			print(tree.getChild(i), indent+1);
		}
	}
	
	public String getIndent(int indent){
		String str = "";
		for (int i=0;i<indent;i++) {
			str += "--";
		}
		return str;
	}

	
}
