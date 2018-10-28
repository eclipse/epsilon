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
import java.util.Set;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.erl.IErlModule;
import org.eclipse.epsilon.evl.dom.ConstraintContext;
import org.eclipse.epsilon.evl.dom.Constraints;
import org.eclipse.epsilon.evl.execute.UnsatisfiedConstraint;
import org.eclipse.epsilon.evl.execute.context.IEvlContext;

public interface IEvlModule extends IErlModule {
	
	Constraints getConstraints();
	
	List<ConstraintContext> getDeclaredConstraintContexts();
	
	List<ConstraintContext> getConstraintContexts();
	
	/**
	 * 
	 * @param name
	 * @return
	 * @since 1.6
	 */
	default ConstraintContext getConstraintContext(String name) {
		return getConstraintContexts()
			.stream()
			.filter(cc -> cc.getTypeName().equals(name))
			.findAny()
			.orElse(null);
	}
	
	@Override
	default IEvlContext getContext() {
		return (IEvlContext) ((IErlModule)this).getContext();
	}
	
	/**
	 * @since 1.6
	 */
	@Override
	Set<UnsatisfiedConstraint> execute() throws EolRuntimeException;
	
	void setUnsatisfiedConstraintFixer(IEvlFixer fixer);
	
	IEvlFixer getUnsatisfiedConstraintFixer();
	
}
