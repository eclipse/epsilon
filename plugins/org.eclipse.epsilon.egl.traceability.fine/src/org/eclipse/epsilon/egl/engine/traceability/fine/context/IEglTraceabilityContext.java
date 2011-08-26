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
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.Region;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.Trace;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyAccessRecorder;


public interface IEglTraceabilityContext {

	public Object recordPropertyAccessesWhileEvaluating(AST ast) throws EolRuntimeException;

	public void addDestinationRegionForLatestPropertyAccesses(Region destination);
	
	public void addDestinationResourceForUnclaimedPropertyAccesses(String resource);

	public IPropertyAccessRecorder getPropertyAccessRecorder();

	public Trace getFineGrainedTrace();
}
