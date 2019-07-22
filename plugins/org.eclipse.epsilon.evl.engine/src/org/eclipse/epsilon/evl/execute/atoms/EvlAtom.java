/*********************************************************************
 * Copyright (c) 2019 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.evl.execute.atoms;

import org.eclipse.epsilon.erl.dom.IExecutableDataRuleElement;
import org.eclipse.epsilon.erl.execute.data.ExecutableRuleAtom;
import org.eclipse.epsilon.evl.execute.context.IEvlContext;

/**
 * 
 *
 * @author Sina Madani
 * @since 1.6
 * @param <T>
 */
class EvlAtom<T extends IExecutableDataRuleElement> extends ExecutableRuleAtom<T> {

	public EvlAtom(T construct, Object modelElement) {
		super(construct, modelElement);
	}

	public EvlAtom(T construct, Object modelElement, IEvlContext context) {
		super(construct, modelElement, context);
	}
	
	public void setContext(IEvlContext context) {
		this.context = context;
	}

	public IEvlContext getContext() {
		return (IEvlContext) context;
	}
}
