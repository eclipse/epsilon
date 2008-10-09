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
 * $Id: IntermediateModelGenerator.java,v 1.2 2008/08/07 12:44:20 louis Exp $
 */
package org.eclipse.epsilon.hutn.test.unit.util;

import java.io.IOException;
import java.io.StringReader;

import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.commons.parse.EpsilonParseProblemManager;
import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.hutn.exceptions.HutnTranslationException;
import org.eclipse.epsilon.hutn.parse.HutnLexer;
import org.eclipse.epsilon.hutn.parse.HutnParser;
import org.eclipse.epsilon.hutn.parse.postprocessor.HutnPostProcessor;
import org.eclipse.epsilon.hutn.translate.HutnTranslator;

public class IntermediateModelGenerator {

	public static IModel generate(String spec) throws HutnTranslationException {
		try {
			final HutnLexer  lexer  = new HutnLexer(new ANTLRReaderStream(new StringReader(spec)));
			final HutnParser parser = new HutnParser(new CommonTokenStream(lexer));
			
			final AST ast = new AST((CommonTree)parser.document().getTree());

			if (EpsilonParseProblemManager.INSTANCE.getParseProblems().isEmpty()) {
				return new InMemoryEmfModel(new HutnTranslator().createIntermediateModel(new HutnPostProcessor().process(ast)).eResource());
			
			} else {
				for (ParseProblem p : EpsilonParseProblemManager.INSTANCE.getParseProblems()) {
					System.err.println(p);
				}
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecognitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void main(String[] args) throws HutnTranslationException {
		generate("@Spec {"                              +
                "	MetaModel \"FamiliesMetaModel\" {" +
                "		nsUri = \"families\""          +
                "	}"                                 +
                "}"                                    +
                "Families {"                           +
                "	Family \"The Smiths\" {"           +
                "		name: \"The Smiths\""          +
                "	}"                                 +
                "}").store("Intermediate.model");
	}
}
