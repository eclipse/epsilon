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

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.introspection.java.JavaPropertyGetter;

public class PatternMatchPropertyGetter extends JavaPropertyGetter {
	
	@Override
	public Object invoke(Object object, String property) throws EolRuntimeException {
		if (object instanceof PatternMatch) {
			PatternMatch match = (PatternMatch) object;
			return match.getRoleBinding(property);
		}
		return super.invoke(object, property);
	}

}
