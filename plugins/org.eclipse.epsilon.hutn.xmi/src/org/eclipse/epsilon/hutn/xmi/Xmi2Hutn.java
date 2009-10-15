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
 * $Id$
 */
package org.eclipse.epsilon.hutn.xmi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.hutn.exceptions.HutnValidationException;
import org.eclipse.epsilon.hutn.model.hutn.Spec;
import org.eclipse.epsilon.hutn.unparser.HutnUnparser;
import org.eclipse.epsilon.hutn.validation.model.HutnValidator;
import org.eclipse.epsilon.hutn.xmi.parser.XmiParser;
import org.eclipse.epsilon.hutn.xmi.postprocessor.CoercionPostProcessor;
import org.eclipse.epsilon.hutn.xmi.postprocessor.IdentifierPostProcessor;
import org.eclipse.epsilon.hutn.xmi.postprocessor.UriFragmentPostProcessor;
import org.xml.sax.SAXException;

public class Xmi2Hutn {

	private static final String NEW_LINE = System.getProperty("line.separator");

	private final Spec spec;
	private final HutnUnparser unparser;
	
	public Xmi2Hutn(String xmi) throws HutnXmiBridgeException {
		try {
			spec     = new XmiParser(xmi).parse();

			// URI fragments become UUIDs
			new UriFragmentPostProcessor(spec).process();
			
			// so no need to specify coercion logic for URI fragments,
			// just for string to int, float, boolean and UUIDs
			new CoercionPostProcessor(spec).process();
			
			// convert UUIDs to human friendly identifiers
			new IdentifierPostProcessor(spec).process();
			
			unparser = new HutnUnparser(spec);
		
		} catch (SAXException e) {
			throw new HutnXmiBridgeException(e);
			
		} catch (IOException e) {
			throw new HutnXmiBridgeException(e);
		}
	}
	

	public Xmi2Hutn(URI uri) throws HutnXmiBridgeException {
		this(readXmiFromUri(uri));		
	}
	
	private static String readXmiFromUri(URI uri) throws HutnXmiBridgeException {
		BufferedReader reader = null;
		
		try {
			final InputStream stream = uri.toURL().openStream();
			reader = new BufferedReader(new InputStreamReader(stream));
			
			final StringBuilder xmi = new StringBuilder();
			
			String line = null;
			while ((line = reader.readLine()) != null) {
				xmi.append(line);
				xmi.append(NEW_LINE);
			}
			
			return xmi.toString();
			
		} catch (MalformedURLException e) {
			throw new HutnXmiBridgeException(e);

		} catch (IOException e) {
			throw new HutnXmiBridgeException(e);
		
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
				
			} catch (IOException e) {
				throw new HutnXmiBridgeException(e);
			}
		}
	}


	public Spec getSpec() {
		return spec;
	}
	
	public String getHutn() {
		return unparser.unparse();
	}
	
	public Collection<ParseProblem> checkConformanceWithRegisteredMetamodel() throws HutnXmiBridgeException {
		if (spec == null)
			return Collections.emptyList();
		
		try {
			return improveReasonsOf(new HutnValidator().getProblemsForIntermediateModel(spec));
		
		} catch (HutnValidationException e) {
			throw new HutnXmiBridgeException(e);
		}
	}

	private List<ParseProblem> improveReasonsOf(List<ParseProblem> problems) {
		for (ParseProblem problem : problems) {
			improveReason(problem);
		}
		
		return problems;
	}
		
	private void improveReason(ParseProblem problem) {
		if ("Unrecognised classifier: UnknownType".equals(problem.getReason())) {
			problem.setReason("Unable to determine the type of this model element.");
		}
	}
}
