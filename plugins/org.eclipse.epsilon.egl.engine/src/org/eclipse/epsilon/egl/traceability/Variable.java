/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.traceability;

public class Variable extends Content<Template> {

	private final String name;
	private final Object value;
	
	protected Variable(Template parent, String name, Object value) {
		super(parent);
		
		if (name == null)
			throw new NullPointerException("name cannot be null");
		
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public Object getValue() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) return false;
		if (!(o instanceof Variable)) return false;
		
		final Variable that = (Variable)o;
		
		return name.equals(that.name)  &&
		       value == null ? that.value == null : value.equals(that.value);
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		
		result += 37 * result + name.hashCode();
		result += 37 * result + (value == null ? 0 : value.hashCode());
		
		return result;
	}
	
	@Override
	public String toString() {
		return name + "=" + (value == null ? "null" : value.toString());
	}

}
