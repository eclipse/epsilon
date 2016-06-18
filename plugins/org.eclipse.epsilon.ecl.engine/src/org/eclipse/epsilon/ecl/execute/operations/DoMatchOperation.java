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
package org.eclipse.epsilon.ecl.execute.operations;

import java.util.Collection;
import java.util.List;

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.common.util.CollectionUtil;
import org.eclipse.epsilon.ecl.execute.context.IEclContext;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;


public class DoMatchOperation extends MatchesOperation{

	@Override
	public Object execute(Object source, List<?> parameters,
			IEolContext context_, ModuleElement ast) throws EolRuntimeException {
		
		IEclContext context = (IEclContext) context_;
		Object parameter = parameters.get(0);
		if (source == null && parameter == null) return null;
		
		Collection<?> leftCol = CollectionUtil.flatten(CollectionUtil.asCollection(source));
		Collection<?> rightCol = CollectionUtil.flatten(CollectionUtil.asCollection(parameter));
		
		for (Object left : leftCol) {
			for (Object right : rightCol) {
				matchInstances(left, right, context, true);
			}
		}

		return null;
	}
	
}
