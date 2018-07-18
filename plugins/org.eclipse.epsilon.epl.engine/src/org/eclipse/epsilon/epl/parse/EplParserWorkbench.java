/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.epl.parse;

import java.io.FileInputStream;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.Tree;
import org.eclipse.epsilon.common.parse.EpsilonParseProblemManager;
import org.eclipse.epsilon.common.parse.StaticFieldNameResolver;
import org.eclipse.epsilon.common.parse.problem.ParseProblem;
import org.eclipse.epsilon.eol.parse.AstExplorer;

public class EplParserWorkbench {
	
	public static void main(String[] args) throws Exception {
		new EplParserWorkbench().work();
	}
	
	static String basePath = "/Users/dimitrioskolovos/Projects/Eclipse/3.7.1/workspace-new/org.eclipse.epsilon.epl.engine/src/org/eclipse/epsilon/epl/parse/test.epl";
	
	StaticFieldNameResolver r;
	
	public void work() throws Exception {
		
		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(basePath));
		EplLexer lexer = new EplLexer(input);
		CommonTokenStream stream = new CommonTokenStream(lexer);
		EplParser parser = new EplParser(stream);
		
		EpsilonParseProblemManager.INSTANCE.reset();
		
		Tree tree = (Tree) parser.eplModule().getTree();
		for (ParseProblem problem : EpsilonParseProblemManager.INSTANCE.getParseProblems()) {
			System.err.println(problem);
		}
		
		new AstExplorer(tree, EplParser.class);
		
	}
	
	
}
