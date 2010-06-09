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
package org.eclipse.epsilon.concordance.model.nsuri;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.epsilon.concordance.model.UriContentReader;
import org.xml.sax.SAXException;

public class XmiParsingNsUriAnalyser implements NsUriAnalyser {

	private final URI uri;
	
	public XmiParsingNsUriAnalyser(URI uri) {
		this.uri = uri;
	}

	public Set<String> determineNsUris() {
		try {
			final String contents = contents();
			
			if (contents.isEmpty())
				return Collections.emptySet();
			else
				return Collections.singleton(new NsUriIdentifyingParser(contents).parse());
		
		} catch (SAXException e) {	
		} catch (IOException e) {}
		
		return null;
	}
	
	private String contents() {
		try {
			return new UriContentReader(uri).readContents();
		
		} catch (MalformedURLException e) {
		} catch (IOException e) {}
		
		return "";
	}

}
