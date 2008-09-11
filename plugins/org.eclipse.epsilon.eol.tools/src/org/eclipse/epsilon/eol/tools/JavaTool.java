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
package org.eclipse.epsilon.eol.tools;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class JavaTool {
	
	public Object getNull() {
		return null;
	}
		
	//TODO : Add parameter names too
	public List<String> getMethodSignatures(Object o) {
		List<String> signatures = new ArrayList<String>();
		
		if (o == null) return signatures;
		
		for (Method m : o.getClass().getMethods()) {
			signatures.add(getSignature(m));
		}
		
		return signatures;
	}
	
	protected String getSignature(Method m) {
		String signature = m.getName() + "(";
		for (Class c : m.getParameterTypes()) {
			signature = signature + c.getName() + ", ";
		}
		signature = signature + ")";
		return signature;
	}
	
}
