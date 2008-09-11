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
package org.eclipse.epsilon.evl.execute.context;

import java.util.ArrayList;

import org.eclipse.epsilon.eol.execute.context.EolContext;
import org.eclipse.epsilon.evl.IEvlModule;
import org.eclipse.epsilon.evl.trace.ConstraintTrace;

public class EvlContext extends EolContext implements IEvlContext{

	protected ConstraintTrace constraintTrace = new ConstraintTrace();
	protected ArrayList unsatisfiedConstraints = new ArrayList();
	
	public EvlContext() {
		super();
	}

	public ConstraintTrace getConstraintTrace() {
		return constraintTrace;
	}
	
	public ArrayList getUnsatisfiedConstraints() {
		return unsatisfiedConstraints;
	}
	
	@Override
	public IEvlModule getModule(){
		return (IEvlModule) module;
	}
}
