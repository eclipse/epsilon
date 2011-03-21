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

import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.evl.EvlUnsatisfiedConstraint;
import org.eclipse.epsilon.evl.IEvlModule;
import org.eclipse.epsilon.evl.trace.ConstraintTrace;

public interface IEvlContext extends IEolContext {
	
	public IEvlModule getModule();
	public ConstraintTrace getConstraintTrace();
	public ArrayList<EvlUnsatisfiedConstraint> getUnsatisfiedConstraints();
	public boolean hasFixes();
	
}
