/**
 * *******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 * ******************************************************************************
 *
 * $Id: HutnParserWorkbench.java,v 1.2 2008/08/07 12:44:22 louis Exp $
 */
package org.eclipse.epsilon.hutn.parse;

import java.io.IOException;
import java.io.StringReader;

import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.eclipse.epsilon.commons.parse.AST;

public class HutnParserWorkbench {

	private static AST parse(String program) throws IOException {
		final HutnLexer lexer          = new HutnLexer(new ANTLRReaderStream(new StringReader(program)));
		final CommonTokenStream tokens = new CommonTokenStream(lexer);
		final HutnParser parser        = new HutnParser(tokens);
		
		try {
			final CommonTree tree = (CommonTree)parser.document().getTree();
			
			System.err.println(tree.getType());
			System.err.println(tree.getText());
			
			System.err.println(tree);
			System.err.println(tree.toStringTree());
			System.err.println(tree.getChildren());
			
			
			return tree == null ? null : new AST(tree);
		} catch (RecognitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	private static void print(AST ast) {
		if (ast == null) {
			System.err.println("null");
		} else {
			System.err.println(ast);
			System.err.println(ast.toStringTree());
			System.err.println(ast.getChildren());
		}
			
	}
	
	public static void main(String[] args) throws IOException, RecognitionException {
		print(parse("@Spec {} FamilyPackage {} VehiclePackage {}"));
	}
}
