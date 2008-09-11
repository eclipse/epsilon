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
package org.eclipse.epsilon.egl.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.eclipse.epsilon.egl.merge.partition.CommentBlockPartitioner;
import org.eclipse.epsilon.egl.merge.partition.CompositePartitioner;
import org.xml.sax.Attributes;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLConfigFileReader extends DefaultHandler implements ConfigFileReader {

	private final String DTD_FILE_NAME = "ContentTypes.dtd";
	private final String DTD_URL       = "http://www.epsilon.org/egl/ContentTypes.dtd";
	private final String ROOT_ELEMENT  = "ContentTypes";
	
	private final Map<String, CompositePartitioner> contentTypes = new HashMap<String, CompositePartitioner>();
	
	private boolean correctRootFound = false;
	private String currentContentType;
	
	public Map<String, CompositePartitioner> read(InputStream stream) throws PersistenceException {		
		try {
			correctRootFound = false;
			
			// Instantiate a parser factory to produce validating parsers
			final SAXParserFactory factory = SAXParserFactory.newInstance();
			factory.setValidating(true);
			
			// Create a new parser for the specified file
			final SAXParser parser = factory.newSAXParser();
			
			// Utilise an entity resolver that always uses the local DTD
			parser.getXMLReader().setEntityResolver(new EntityResolver() {

				public InputSource resolveEntity(String publicId,
				                                 String systemId)
				throws SAXException, IOException {
					
					// Intercept the reference to the fictional URL and 
					// load the DTD from the file system
					if (systemId.equals(DTD_URL)) {
						return new InputSource(XMLConfigFileReader.class.getResourceAsStream(DTD_FILE_NAME));
					}
					
					return null;
				}
				
			});
			
			// Use this object for handling any errors
			parser.getXMLReader().setErrorHandler(this);
			
			// Parse the stream, using this class to handle the events
			parser.getXMLReader().setContentHandler(this);
			parser.getXMLReader().parse(new InputSource(stream));
			
			if (!correctRootFound)
				throw new PersistenceException("Did not find the expected root element: " + ROOT_ELEMENT);
			
			return contentTypes;
		
		} catch (SAXParseException e) {
			// Create a meaningful message for ill-formed or invalid XML files
			final String message = "Parse error at line "+e.getLineNumber()+", "+
			                       "column "+e.getColumnNumber()+":\n\n"+e.getMessage();
			
			throw new PersistenceException(message, e);
			
		} catch (SAXException e) {
			throw new PersistenceException(e);
			
		} catch (IOException e) {
			throw new PersistenceException(e);
			
		} catch (ParserConfigurationException e) {
			throw new PersistenceException(e);
		
		} finally {
			try {
				stream.close();
			} catch (IOException e) {}
		}
	}
	
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		
		// If this is the correct root element
		if (qName.equals(ROOT_ELEMENT)) {
			correctRootFound = true;
			
		// If this element is a contentType
		} else if (correctRootFound && qName.equals("ContentType")) {

			// Determine the name of this content type
			currentContentType = attributes.getValue("name");
			
			contentTypes.put(currentContentType, new CompositePartitioner());
		
		// If this element is a commentStyle
		} else if (correctRootFound && qName.equals("CommentStyle")) {
			// Retrieve the startsWith and endsWith attributes for this commentStyle
			final String startsWith = attributes.getValue("startsWith");
			final String endsWith   = attributes.getValue("endsWith");
			
			final CommentBlockPartitioner partitioner = new CommentBlockPartitioner(startsWith, endsWith);
			
			
			if (currentContentType !=null)
				contentTypes.get(currentContentType).addPartitioner(partitioner);
		
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (correctRootFound && qName.equals("ContentType")) {
			currentContentType = null;
		}
	}


	@Override
	public void error(SAXParseException e) throws SAXParseException {
		// Propogate all parse errors up the stack
	    throw e;
	}
}
