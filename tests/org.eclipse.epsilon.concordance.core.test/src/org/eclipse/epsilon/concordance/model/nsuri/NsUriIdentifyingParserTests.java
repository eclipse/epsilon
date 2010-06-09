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

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.eclipse.epsilon.concordance.model.nsuri.NsUriIdentifyingParser;
import org.junit.Test;
import org.xml.sax.SAXException;

public class NsUriIdentifyingParserTests {
	
	private static String VALID_MODEL = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "\n" +
	                                    "<families:Person xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:families=\"families\"/>";
	
	@Test
	public void shouldIdentifyPrefixAsNsUri() throws SAXException, IOException {
		assertEquals("families", parseNsUri(VALID_MODEL));
	}
	
	@Test
	public void shouldBeNullForEmptyModel() throws SAXException, IOException {
		assertEquals(null, parseNsUri(""));
	}
	
	private static String INVALID_MODEL = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "\n" +
	                                      "<families:Person xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\"";
	
	@Test
	public void shouldBeNullForInvalidModel() throws SAXException, IOException {
		assertEquals(null, parseNsUri(INVALID_MODEL));
	}
	

	private String parseNsUri(final String xmi) throws SAXException, IOException {
		return new NsUriIdentifyingParser(xmi).parse();
	}
}
