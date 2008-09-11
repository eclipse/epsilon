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
package org.eclipse.epsilon.etl.execute;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.AssignExecutor;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.types.EolCollection;
import org.eclipse.epsilon.etl.execute.context.IEtlContext;

public class EquivalentAssignExecutor extends AssignExecutor{

	public EquivalentAssignExecutor() {
	}

	@Override
	public Object getRhsEquivalent(Object source, Object value, IEolContext context_) throws EolRuntimeException {
		IEtlContext context = (IEtlContext) context_;
		if (value instanceof EolCollection){
			return context.getTransformationStrategy().getEquivalent(((EolCollection) value).getStorage(), context, null);
		}
		else {
			return context.getTransformationStrategy().getEquivalent(value,context, null);
		}
	}

}
