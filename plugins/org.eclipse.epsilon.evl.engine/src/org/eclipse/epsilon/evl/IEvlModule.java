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
package org.eclipse.epsilon.evl;

import java.util.List;

import org.eclipse.epsilon.erl.IErlModule;
import org.eclipse.epsilon.evl.dom.ConstraintContext;
import org.eclipse.epsilon.evl.dom.Constraints;
import org.eclipse.epsilon.evl.execute.context.IEvlContext;

public interface IEvlModule extends IErlModule {
	
	public Constraints getConstraints();
	
	public List<ConstraintContext> getDeclaredConstraintContexts();
	
	public List<ConstraintContext> getConstraintContexts();
	
	public IEvlContext getContext();
	
	public void setUnsatisfiedConstraintFixer(IEvlFixer fixer);
	
	public IEvlFixer getUnsatisfiedConstraintFixer();
}
