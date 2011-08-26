/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.egl.engine.traceability.fine.wrappers;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.egl.engine.traceability.fine.context.IEglContextWithFineGrainedTraceability;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyGetter;


public class TraceablePropertyGetter implements IPropertyGetter {

	private final IPropertyGetter delegate;
	
	public TraceablePropertyGetter(IPropertyGetter delegate) {
		this.delegate = delegate;
	}

	public Object invoke(Object modelElement, String featureName) throws EolRuntimeException {
		if (modelElement instanceof EObject) {
			getContext().getTraceabilityContext().recordPropertyAccess((EObject)modelElement, featureName);
		}
		
		return delegate.invoke(modelElement, featureName);
	}

	public IEglContextWithFineGrainedTraceability getContext() {
		return (IEglContextWithFineGrainedTraceability)delegate.getContext();
	}
	
	
	// The following methods simply delegate to the member

	public boolean hasProperty(Object object, String property) {
		return delegate.hasProperty(object, property);
	}

	public AST getAst() {
		return delegate.getAst();
	}

	public void setAst(AST ast) {
		delegate.setAst(ast);
	}

	public void setContext(IEolContext context) {
		delegate.setContext(context);
	}
}
