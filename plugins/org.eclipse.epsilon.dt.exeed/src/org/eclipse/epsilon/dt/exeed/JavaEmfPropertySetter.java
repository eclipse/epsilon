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
package org.eclipse.epsilon.dt.exeed;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.epsilon.emc.emf.EmfPropertySetter;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.introspection.AbstractPropertySetter;
import org.eclipse.epsilon.eol.execute.introspection.java.JavaPropertySetter;

public class JavaEmfPropertySetter extends AbstractPropertySetter {
	
	EmfPropertySetter emf = new EmfPropertySetter();
	JavaPropertySetter java = new JavaPropertySetter();
	
	public void invoke(Object value) throws EolRuntimeException {
		if (object instanceof EObject) {
			emf.invoke(value);
		}
		else {
			java.invoke(value);
		}
	}

}
