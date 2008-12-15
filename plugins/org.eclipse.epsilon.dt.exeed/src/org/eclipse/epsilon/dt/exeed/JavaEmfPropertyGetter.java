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
import org.eclipse.epsilon.emc.emf.EmfPropertyGetter;
import org.eclipse.epsilon.eol.dt.launching.EclipseContextManager;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.EolContext;
import org.eclipse.epsilon.eol.execute.introspection.AbstractPropertyGetter;
import org.eclipse.epsilon.eol.execute.introspection.java.JavaPropertyGetter;

public class JavaEmfPropertyGetter extends AbstractPropertyGetter {
	
	EmfPropertyGetter emf = new EmfPropertyGetter();
	JavaPropertyGetter java = new JavaPropertyGetter();
	
	public JavaEmfPropertyGetter() {
		EolContext context = new EolContext();
		EclipseContextManager.setup(context);
		emf.setContext(context);
		java.setContext(context);
	}
	
	public Object invoke(Object object, String property) throws EolRuntimeException {
		
		if (object instanceof EObject) {
			return emf.invoke(object, property);
		}
		else {
			 return java.invoke(object, property);
		}
	}

}
