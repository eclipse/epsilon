/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.flock.parse;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.eclipse.epsilon.common.parse.Antlr3TreeViewer;

public class FlockParserWorkbench {
	
	public static void main(String[] args) throws Exception {
		new FlockParserWorkbench().work();
	}
	
	public void work() throws Exception {
		final String source = "@strict\n" + 
	                          "migrateÊPerson {\n" + 
		                      "	migrated.name := original.name + ' Smith';\n" +
		                      "}" +
		                      "@cached " +
		                      "operation String inc() { self := self + 1}";
		
		final FlockLexer lexer = new FlockLexer(new ANTLRStringStream(source));		
		
		FlockParser parser = new FlockParser(new CommonTokenStream(lexer));
		parser.prepareForGUnit();
			
		new Antlr3TreeViewer(parser.flockModule().tree , FlockParser.class);
	}
}

