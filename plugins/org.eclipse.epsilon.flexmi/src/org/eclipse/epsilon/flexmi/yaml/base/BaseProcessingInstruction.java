/*********************************************************************
 * Copyright (c) 2020 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.flexmi.yaml.base;

import org.w3c.dom.DOMException;
import org.w3c.dom.ProcessingInstruction;

public class BaseProcessingInstruction extends BaseNode implements ProcessingInstruction {

	@Override
	public String getTarget() {
		return null;
	}

	@Override
	public String getData() {
		return null;
	}

	@Override
	public void setData(String data) throws DOMException {
		
	}

}
