/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.picto;

public class StringContentPromise implements ContentPromise {

	protected String content;

	public StringContentPromise(String content) {
		super();
		this.content = content;
	}

	@Override
	public String getContent() throws Exception {
		return content;
	}
}