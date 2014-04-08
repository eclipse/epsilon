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

import org.eclipse.epsilon.common.parse.problem.ParseProblem;

public class EolWorkbench {
	
	
	public static void main(String[] args) throws Exception {
		
		EolEvaluator evaluator = new EolEvaluator();
		evaluator.execute("var a : Foo;");
		
		if (true) return;
		
		EolModule module = new EolModule();
		
		String path = "E:\\Projects\\Eclipse\\3.4\\workspace3\\org.eclipse.epsilon.eol.engine\\src\\org\\eclipse\\epsilon\\eol\\test.eol";		
		try {
			//module.parse(new File(path));
			module.parse("var i : Integer; \r\n -- A comment \r\n -- Another comment \r\n //var b : String;");
		}
		catch (Exception ex) {
			int index = module.parser.getTokenStream().index();
			System.err.println(index);
		}
		//System.err.println(module.parser.);
		//System.err.println(module.parser.getNumberOfSyntaxErrors());
		
		for (ParseProblem problem : module.getParseProblems()) {
			System.err.println(problem);
		}
	}
	
}
