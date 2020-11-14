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
import java.util.Arrays;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class YamlNodeList extends ArrayList<YamlNode> implements NodeList {
	
	public YamlNodeList(YamlNode... elements) {
		super(Arrays.asList(elements));
	}
	
	@Override
	public Node item(int index) {
		return get(index);
	}

	@Override
	public int getLength() {
		return size();
	}

}
