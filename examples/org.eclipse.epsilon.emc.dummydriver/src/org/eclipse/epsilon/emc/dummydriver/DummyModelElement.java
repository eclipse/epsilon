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
package org.eclipse.epsilon.emc.dummydriver;

import java.util.HashMap;

public class DummyModelElement {
	
	protected String type = "";
	protected HashMap<String, Object> props = new HashMap<String, Object>();
	
	public DummyModelElement(String type) {
		super();
		this.type = type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	public HashMap<String, Object> getProps() {
		return props;
	}
	
	public DummyModelElement put(String name, Object value) {
		props.put(name, value);
		return this;
	}
	
	@Override
	public String toString() {
		return "Object of type " + type;
	}
	
}
