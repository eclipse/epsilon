/*********************************************************************
 * Copyright (c) 2019 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.erl.dom;

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.erl.execute.RuleExecutorFactory;
import org.eclipse.epsilon.erl.execute.context.IErlContext;

/**
 * 
 *
 * @author Sina Madani
 * @since 1.6
 */
public interface IExecutableDataRuleElement extends ModuleElement {

	default Object execute(Object self, IErlContext context) throws EolRuntimeException {
		return context.getExecutorFactory().execute(this, self, context);
	}
	
	/**
	 * Used to execute this rule on a given model element through the {@link RuleExecutorFactory}.
	 * This method is usually only invoked by the {@linkplain RuleExecutorFactory}.
	 * 
	 * @param self The model element to execute this rule for.
	 * @param context The execution context.
	 * @return The result of {@link RuleExecutorFactory#execute(IExecutableDataRule, Object, IErlContext)}
	 * @throws EolRuntimeException If an exception is raised by the ExecutorFactory.
	 */
	Object executeImpl(Object self, IErlContext context) throws EolRuntimeException;
	
}
