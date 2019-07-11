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
import org.eclipse.epsilon.erl.execute.context.IErlContext;

/**
 * Allows for execution of rules with multiple parameters. This
 * is essentially the same as {@link IExecutableDataRuleElement} but
 * with more than one "self".
 * 
 * @author Sina Madani
 * @since 1.6
 */
public interface IExecutableMultiParameterRuleElement extends ModuleElement {

	default Object execute(IErlContext context, Object...parameters) throws EolRuntimeException {
		return context.getExecutorFactory().execute(this, context, parameters);
	}
	
	Object executeImpl(IErlContext context, Object... parameters) throws EolRuntimeException;
	
}
