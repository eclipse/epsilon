/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.evl.concurrent;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.evl.dom.ConstraintContext;
import org.eclipse.epsilon.evl.execute.context.IEvlContext;

/**
 * A non-parallel implementation of {@link EvlModuleParallel}.
 * This is used to test the context and module under single-threaded execution.
 * 
 * @author Sina Madani
 * @deprecated Provided for testing purposes only.
 */
@Deprecated
public class EvlModuleParallelNot extends EvlModuleParallel {

	public EvlModuleParallelNot() {
		super();
	}

	public EvlModuleParallelNot(int parallelism) {
		super(parallelism);
	}

	@Override
	protected void checkConstraints() throws EolRuntimeException {
		IEvlContext context = getContext();
		for (ConstraintContext constraintContext : getConstraintContexts()) {
			constraintContext.execute(preProcessConstraintContext(constraintContext), context);
		}
	}

}
