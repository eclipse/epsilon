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
