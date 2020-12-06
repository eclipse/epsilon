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

import org.eclipse.epsilon.flexmi.yaml.base.YamlTextBase;
import org.w3c.dom.DOMException;

public class YamlText extends YamlTextBase {
	
	protected String text;
	
	public YamlText(String text) {
		this.text = text;
	}
	
	@Override
	public String getTextContent() throws DOMException {
		return text;
	}

}
