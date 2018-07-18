/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.evl.execute;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.epsilon.evl.dom.Constraint;

public class UnsatisfiedConstraint {
	
	protected Constraint constraint;
	protected String message;
	protected Object instance;
	protected ArrayList<FixInstance> fixes = new ArrayList<FixInstance>();
	protected boolean fixed = false;
	protected HashMap<String, Object> extras = new HashMap<String, Object>();
	
	public boolean isFixed() {
		return fixed;
	}

	public void setFixed(boolean fixed) {
		this.fixed = fixed;
	}

	public UnsatisfiedConstraint() {
		super();
	}

	public Constraint getConstraint() {
		return constraint;
	}

	public void setConstraint(Constraint constraint) {
		this.constraint = constraint;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getInstance() {
		return instance;
	}

	public void setInstance(Object result) {
		this.instance = result;
	}
	
	public ArrayList<FixInstance> getFixes() {
		return fixes;
	}
	
	public HashMap<String, Object> getExtras() {
		return extras;
	}
	
	public void setExtras(HashMap<String, Object> extras) {
		this.extras = extras;
	}
	
	@Override
	public String toString() {
		return getMessage();
	}
}
