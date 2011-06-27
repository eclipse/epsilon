/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.workflow.tasks.common.nestedelements;

public class ModelNestedElement {
	
	protected String ref;
	protected String as;
	protected String alias;
	
	public String getAlias() {
		return alias;
	}
	
	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	public String getRef() {
		return ref;
	}
	
	public void setRef(String name) {
		this.ref = name;
	}

	public String getAs() {
		return as;
	}

	public void setAs(String as) {
		this.as = as;
	}
	
}
