/*******************************************************************************
 * Copyright (c) 2014 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitris Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.emc.graphml;

import java.util.ArrayList;
import java.util.List;

import org.jdom.Element;

public class DomUtil {
	
	public static List<Element> getChildren(Element parent, String name) {
		List<Element> children = new ArrayList<Element>();
		for (Object o : parent.getChildren()) {
			if (o instanceof Element) {
				Element e = (Element) o;
				if (e.getName().equals(name)) {
					children.add(e);
				}
			}
		}
		return children;
	}
	
}
