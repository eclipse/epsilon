/*******************************************************************************
 * Copyright (c) 2009 The University of York.
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
package org.eclipse.epsilon.concordance.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;


public class UriContentReader {

	private static final String NEW_LINE = System.getProperty("line.separator");
	
	private final URI uri;
	
	public UriContentReader(URI uri) {
		this.uri = uri;
	}
	
	private BufferedReader reader;
	
	public String readContents() throws IOException {
		try {
			prepareReader();
			
			return readContentsOfUri();
		
		} finally {
			closeReader();
		}
	}

	private void prepareReader() throws IOException {
		reader = new BufferedReader(new InputStreamReader(URIConverter.INSTANCE.createInputStream(uri)));
	}
	
	private String readContentsOfUri() throws IOException {
		final StringBuilder contents = new StringBuilder();
		
		String line = null;
		while ((line = reader.readLine()) != null) {
			contents.append(line);
			contents.append(NEW_LINE);
		}
		
		return contents.toString();
	}

	private void closeReader() throws IOException {
		if (reader != null) {
			reader.close();
		}
	}
}
