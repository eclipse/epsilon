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
package org.eclipse.epsilon.hutn.parse;

import java.io.FileInputStream;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.eclipse.epsilon.common.parse.Antlr3TreeViewer;

public class HutnParserWorkbench {
	
	public static void main(String[] args) throws Exception {
		new HutnParserWorkbench().work();
	}
	
	public void work() throws Exception {
		String basePath = "/local/d0p5/louis/eclipse-ide/workspaces/" +
				          "workspace-epsilon/org.eclipse.epsilon.hutn.engine/" +
				          "src/org/eclipse/epsilon/hutn/parse/hutn.test";
		
		//r = new StaticFieldNameResolver(EolParser.class);
		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(basePath));
		HutnLexer lexer = new HutnLexer(input);
		
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
		HutnParser parser = new HutnParser(stream);
		parser.prepareForGUnit();
		
		//EolModule module = new EolModule();
		//module.parse(new File(basePath));
		
		
		new Antlr3TreeViewer(parser.document().tree , HutnParser.class);
		
		//System.err.println(((CommonTree)parser.document().getTree()).toStringTree());
		
		//print(((Tree)parser.pathName().getTree()), 0);
	}

}
