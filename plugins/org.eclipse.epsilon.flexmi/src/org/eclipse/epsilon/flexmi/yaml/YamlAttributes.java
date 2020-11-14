/*********************************************************************
 * Copyright (c) 2020 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.flexmi.yaml;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.w3c.dom.DOMException;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class YamlAttributes extends LinkedHashMap<String, String> implements NamedNodeMap {
	
	@Override
	public Node getNamedItem(String name) {
		if (containsKey(name)) return new YamlAttribute(name, get(name));
		else return null;
	}

	@Override
	public Node removeNamedItem(String name) throws DOMException {
		remove(name);
		return null;
	}
	
	@Override
	public Node item(int index) {
		return new YamlAttribute(new ArrayList<String>(keySet()).get(index),new ArrayList<String>(values()).get(index)) ;
	}

	@Override
	public int getLength() {
		return size();
	}

	@Override
	public Node setNamedItem(Node arg) throws DOMException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Node getNamedItemNS(String namespaceURI, String localName) throws DOMException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node setNamedItemNS(Node arg) throws DOMException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node removeNamedItemNS(String namespaceURI, String localName) throws DOMException {
		// TODO Auto-generated method stub
		return null;
	}

}
