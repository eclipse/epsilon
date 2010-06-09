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
package org.eclipse.epsilon.concordance.core.hashing.xmi2nsUri;

import java.io.IOException;
import java.io.StringReader;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class NsUriIdentifyingParser {

	private final String xmi;
	
	private XMLReader reader;
	private NsUriIdentifyingContentHandler handler;
		
	
	public NsUriIdentifyingParser(String xmi) {
		this.xmi = xmi;
	}

	public String parse() throws SAXException, IOException {
		initialiseXmlReader();
		
		doParse();
		
		return handler.getNsUri();
	}
	
	private void initialiseXmlReader() throws SAXException {
		reader  = XMLReaderFactory.createXMLReader();
		handler = new NsUriIdentifyingContentHandler();
		
		reader.setContentHandler(handler);
	}
	
	private void doParse() throws IOException, SAXException {
		reader.parse(new InputSource(new StringReader(xmi)));
	}
}
