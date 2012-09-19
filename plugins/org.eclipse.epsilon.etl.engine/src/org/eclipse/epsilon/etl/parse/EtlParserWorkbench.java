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
package org.eclipse.epsilon.etl.parse;

import java.io.File;
import java.io.FileInputStream;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;
import org.eclipse.epsilon.common.parse.EpsilonParseProblemManager;
import org.eclipse.epsilon.common.parse.StaticFieldNameResolver;
import org.eclipse.epsilon.common.parse.problem.ParseProblem;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.parse.AstExplorer;

public class EtlParserWorkbench {
	
	public static void main(String[] args) throws Exception {
		
		new EtlParserWorkbench().work();
	}
	
	public void workPathName() throws Exception {
		String basePath = "F:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.etl.engine\\src\\org\\eclipse\\epsilon\\etl\\parse\\test.etl";
		
		//r = new StaticFieldNameResolver(EolParser.class);
		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(basePath));
		EtlLexer lexer = new EtlLexer(input);
		
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
		EtlParser parser = new EtlParser(stream);
		
		//EolModule module = new EolModule();
		//module.parse(new File(basePath));
		
		
		//new V2V3Viewer(module.getAst(),parser.eolModule().tree ,EolParserTokenTypes.class, EolParser.class);
		
		System.err.println(((CommonTree)parser.etlModule().getTree()).toStringTree());
		
		//print(((Tree)parser.pathName().getTree()), 0);
	}
	
	
	StaticFieldNameResolver r;
	
	
	public void work() throws Exception {
		String basePath = "E:\\Projects\\Eclipse\\3.5.1\\workspace\\org.eclipse.epsilon.etl.engine\\src\\org\\eclipse\\epsilon\\etl\\parse\\test.etl";
		
		//r = new StaticFieldNameResolver(EolParser.class);
		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(basePath));
		EtlLexer lexer = new EtlLexer(input);
		CommonTokenStream stream = new CommonTokenStream(lexer);
		EtlParser parser = new EtlParser(stream);
		
		//EolModule module = new EolModule();
		//module.parse(new File(basePath));
		
		EpsilonParseProblemManager.INSTANCE.reset();
		
		Tree tree = parser.etlModule().tree;
		
		for (ParseProblem problem : EpsilonParseProblemManager.INSTANCE.getParseProblems()) {
			System.err.println(problem);
		}
		
		new AstExplorer(tree, EtlParser.class);
		
		print(((Tree)parser.etlModule().getTree()), 0);
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
