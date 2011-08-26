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
package org.eclipse.epsilon.egl.engine.traceability.fine.context;


import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.pojo.Region;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.pojo.Trace;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;


public interface IEglTraceabilityContext {

	public Object recordPropertyAccessesWhileExecuting(AST ast) throws EolRuntimeException;

	public void recordPropertyAccess(Object modelElement, String featureName);
	
	public void traceLatestPropertyAccesses(Region destination);
	
	public void addTargetResourceToTrace(String resource);

	public Trace getFineGrainedTrace();

}
