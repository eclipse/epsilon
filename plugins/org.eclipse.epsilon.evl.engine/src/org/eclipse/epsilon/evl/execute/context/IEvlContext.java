/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.evl.execute.context;

import java.util.List;

import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.evl.IEvlModule;
import org.eclipse.epsilon.evl.execute.UnsatisfiedConstraint;
import org.eclipse.epsilon.evl.trace.ConstraintTrace;

public interface IEvlContext extends IEolContext {
	
	public IEvlModule getModule();
	public ConstraintTrace getConstraintTrace();
	public List<UnsatisfiedConstraint> getUnsatisfiedConstraints();
	public boolean hasFixes();
	
}
