/*******************************************************************************
 * Copyright (c) 2008-2018 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Sina Madani - concurrency support
 ******************************************************************************/
package org.eclipse.epsilon.evl;

import java.util.List;
import org.eclipse.epsilon.erl.IErlModule;
import org.eclipse.epsilon.evl.dom.ConstraintContext;
import org.eclipse.epsilon.evl.dom.Constraints;
import org.eclipse.epsilon.evl.execute.context.IEvlContext;

public interface IEvlModule extends IErlModule {
	
	Constraints getConstraints();
	
	List<ConstraintContext> getDeclaredConstraintContexts();
	
	List<ConstraintContext> getConstraintContexts();
	
	@Override
	IEvlContext getContext();
	
	void setUnsatisfiedConstraintFixer(IEvlFixer fixer);
	
	IEvlFixer getUnsatisfiedConstraintFixer();
	
}
