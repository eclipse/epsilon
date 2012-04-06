/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.emc.plainxml;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class DomUtil {
	
	public static List<Element> getChildren(Element parent) {
		List<Element> result = new ArrayList<Element>();
		NodeList childNodes = parent.getChildNodes();
		for (int i=0; i<childNodes.getLength(); i++) {
			Object o = childNodes.item(i);
			if (o instanceof Element) {
				result.add((Element) o);
			}
		}
		return result;
	}
	
}
