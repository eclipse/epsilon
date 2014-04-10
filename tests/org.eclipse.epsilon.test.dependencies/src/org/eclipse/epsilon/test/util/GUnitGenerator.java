/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id: GUnitGenerator.java,v 1.1 2008/08/08 14:31:56 louis Exp $
 */
package org.eclipse.epsilon.test.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.antlr.gunit.GrammarInfo;
import org.antlr.gunit.Interp;
import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.RecognitionException;

public class GUnitGenerator {

	private final static String NEWLINE = System.getProperty("line.separator");
	
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, RecognitionException {
		Interp.main(args);
		
		final String testcaseFileName = getTestCaseName(Interp.parse(new ANTLRFileStream(args[1])));
		
		final StringBuilder output = new StringBuilder();
		final BufferedReader reader = new BufferedReader(new FileReader(testcaseFileName));
		try {

			String line;
			while ((line = reader.readLine()) != null) {
				output.append(line);
				output.append(NEWLINE);

				if (line.contains("parser = new")) {
					output.append(NEWLINE);
					output.append("\t\t\tparser.prepareForGUnit();");
					output.append(NEWLINE);
					output.append(NEWLINE);
				}
			}
		} finally {
			reader.close();
		}
		
		FileWriter fw = new FileWriter(testcaseFileName);
		try {
			fw.append(output.toString());
		} finally {
			fw.close();
		}
	}
	
	public static String getTestCaseName(GrammarInfo grammar) {
		if (grammar.getTreeGrammarName()!=null ) {
			return "Test"+grammar.getTreeGrammarName()+".java";
		}
		else {
			return "Test"+grammar.getGrammarName()+".java";
		}
	}
}
