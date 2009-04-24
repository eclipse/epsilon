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
package org.eclipse.epsilon.hutn.xmi.parser.sax;

import org.eclipse.epsilon.hutn.model.hutn.Spec;
import org.eclipse.epsilon.hutn.xmi.parser.generator.SpecGenerator;
import org.eclipse.epsilon.hutn.xmi.util.StringUtil;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SpecGeneratingContentHandler extends DefaultHandler {

	private final SpecGenerator generator = new SpecGenerator();
	
	public Spec getSpec() {
		return generator.getSpec();
	}
	
	@Override
	public void startPrefixMapping(String prefix, String uri) {
		if ("xmi".equals(prefix) || "xsi".equals(prefix))
			return;
		
		generator.initialise(uri);
	}

	private boolean firstElement = true;
	private boolean alreadyPoppedCurrentElement = false;
	private String currentElementName;
	
	@Override
    public void startElement (String uri, String name, String qName, Attributes atts) {
		currentElementName = name;
		
    	if (firstElement) {
	    	generator.generateTopLevelClassObject(atts.getValue("xmi:id"), name);
	    	firstElement = false;
    	
    	} else {
    		
    		if (atts.getIndex("xsi:type") >= 0) {
    			generator.generateContainedClassObject(name, atts.getValue("xmi:id"), getLocalName(atts.getValue("xsi:type")));
    			
			} else {
				// XMI doesn't include an xsi:type
				generator.generateContainedClassObject(name, atts.getValue("xmi:id"));
			}
    		
    		
    	}
    	
    	processAttributes(atts);
    }
	
    @Override
	public void characters(char[] ch, int start, int length) throws SAXException {
    	final String text = new String(ch, start, length);
    	
    	if (StringUtil.isNotWhitespace(text)) {
			processMultiValuedAttribute(text);
    	}
	}
    
    @Override
    public void endElement (String uri, String name, String qName) {
    	if (!alreadyPoppedCurrentElement) {
    		generator.stopGeneratingCurrentClassObject();
    	}
    	
    	alreadyPoppedCurrentElement = false;
    }
    
    private void processMultiValuedAttribute(String value) {
    	// At this point, startElement will have pushed a new class object
  
    	// remove the pushed class object
    	generator.stopGeneratingAndDeleteCurrentClassObject();
    	alreadyPoppedCurrentElement = true;
    	
    	// and replace with an attribute value
    	generator.addAttributeValue(currentElementName, value);
    }
    

	private void processAttributes(Attributes atts) {
		for (int index = 0; index < atts.getLength(); index++) {
			
			if (atts.getQName(index).startsWith("xmi") || atts.getQName(index).startsWith("xsi")) {
			  	  continue;
			}
			
			generator.addAttributeValue(atts.getLocalName(index), atts.getValue(index));
		}
	}
    
    
    private static String getLocalName(String qualifiedName) {
    	return qualifiedName.split(":")[1];
    }
    
}
