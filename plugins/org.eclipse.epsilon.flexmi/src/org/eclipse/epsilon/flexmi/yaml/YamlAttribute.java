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

import org.eclipse.epsilon.flexmi.yaml.base.BaseNode;
import org.w3c.dom.DOMException;

public class YamlAttribute extends BaseNode {
	
	protected String name;
	protected String value;
	
	public YamlAttribute(String name, String value) {
		this.name = name;
		this.value = value;
	}
	
	@Override
	public String getNodeName() {
		return name;
	}

	@Override
	public String getNodeValue() throws DOMException {
		return value;
	}
}
