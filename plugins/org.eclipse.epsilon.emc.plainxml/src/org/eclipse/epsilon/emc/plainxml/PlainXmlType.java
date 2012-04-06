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

public class PlainXmlType {
	
	protected String tagName = null;
	
	public String getTagName() {
		return tagName;
	}
	
	public static PlainXmlType parse(String type) {
		PlainXmlType x = null;
		if (type.startsWith("t_")) {
			x = new PlainXmlType();
			x.tagName = type.substring(2);
		}
		return x;
	}
	
}
