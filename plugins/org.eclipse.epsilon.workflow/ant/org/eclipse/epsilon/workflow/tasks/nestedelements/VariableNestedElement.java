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
package org.eclipse.epsilon.workflow.tasks.nestedelements;

public class VariableNestedElement {
	
	protected String ref;
	protected String as;
	protected boolean optional;
	protected boolean ant;
	
	public String getRef() {
		return ref;
	}
	
	public void setRef(String ref) {
		this.ref = ref;
	}
	
	public String getAs() {
		return as;
	}
	
	public void setAs(String as) {
		this.as = as;
	}

	public boolean isOptional() {
		return optional;
	}

	public void setOptional(boolean optional) {
		this.optional = optional;
	}

	public boolean isAnt() {
		return ant;
	}
	
	public void setAnt(boolean ant) {
		this.ant = ant;
	}
	
}
