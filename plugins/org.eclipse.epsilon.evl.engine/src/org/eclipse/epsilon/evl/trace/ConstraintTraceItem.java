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
package org.eclipse.epsilon.evl.trace;

import org.eclipse.epsilon.evl.dom.Constraint;

public class ConstraintTraceItem {
	
	protected Object instance;
	protected Constraint constraint;
	protected boolean result;
	
	public ConstraintTraceItem(Object instance, Constraint constraint, boolean result) {
		this.instance = instance;
		this.constraint = constraint;
		this.result = result;
	}

	public Constraint getConstraint() {
		return constraint;
	}

	public void setConstraint(Constraint constraint) {
		this.constraint = constraint;
	}

	public Object getInstance() {
		return instance;
	}

	public void setInstance(Object instance) {
		this.instance = instance;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}
	
}
