/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.epl.execute;

import java.util.HashMap;

import org.eclipse.epsilon.epl.dom.Pattern;

public class PatternMatch {
	
	protected Pattern pattern;
	protected HashMap<String, Object> roleBindings = new HashMap<String, Object>();
	
	public PatternMatch(Pattern pattern) {
		this.pattern = pattern;
	}
	
	public HashMap<String, Object> getRoleBindings() {
		return roleBindings;
	}
	
	public Object getRoleBinding(String name) {
		return getRoleBindings().get(name);
	}
	
	public Pattern getPattern() {
		return pattern;
	}
	
}
