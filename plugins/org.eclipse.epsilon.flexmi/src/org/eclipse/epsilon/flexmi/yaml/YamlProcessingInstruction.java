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

import org.eclipse.epsilon.flexmi.yaml.base.BaseProcessingInstruction;
import org.w3c.dom.NodeList;

public class YamlProcessingInstruction extends BaseProcessingInstruction implements YamlNode {
	
	protected String target;
	protected String data;
	
	public YamlProcessingInstruction(String target, String data) {
		this.target = target;
		this.data = data;
	}
	
	@Override
	public NodeList getChildNodes() {
		return new YamlNodeList();
	}

	@Override
	public String getTarget() {
		return target;
	}

	@Override
	public String getData() {
		return data;
	}
	
}
