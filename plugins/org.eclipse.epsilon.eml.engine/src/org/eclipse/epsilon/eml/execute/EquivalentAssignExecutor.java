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
package org.eclipse.epsilon.eml.execute;

import java.util.Collection;

import org.eclipse.epsilon.eml.execute.context.EmlContext;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.AssignExecutor;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class EquivalentAssignExecutor extends AssignExecutor{

	public EquivalentAssignExecutor() {

	}

	@Override
	public Object getRhsEquivalent(Object source, Object value, IEolContext context_) throws EolRuntimeException {
		EmlContext context = (EmlContext) context_;
		if (value instanceof Collection){
			return context.getMergingStrategy().getEquivalent(((Collection) value), context, null);
		}
		else {
			return context.getMergingStrategy().getEquivalent(value,context, null);
		}
	}

}
