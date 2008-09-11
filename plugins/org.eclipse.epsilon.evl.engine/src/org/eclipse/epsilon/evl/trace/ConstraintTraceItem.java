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

import org.eclipse.epsilon.evl.EvlConstraint;

public class ConstraintTraceItem {
	
	protected Object instance;
	protected EvlConstraint constraint;
	protected boolean result;
	
	public ConstraintTraceItem(Object instance, EvlConstraint constraint, boolean result) {
		this.instance = instance;
		this.constraint = constraint;
		this.result = result;
	}

	public EvlConstraint getConstraint() {
		return constraint;
	}

	public void setConstraint(EvlConstraint constraint) {
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
