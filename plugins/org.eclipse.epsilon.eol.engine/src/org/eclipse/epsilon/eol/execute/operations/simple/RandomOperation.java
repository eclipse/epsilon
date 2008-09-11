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
package org.eclipse.epsilon.eol.execute.operations.simple;

import java.util.List;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolNotApplicableOperationException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.types.EolCollection;
import org.eclipse.epsilon.eol.types.EolCollectionType;
import org.eclipse.epsilon.eol.types.EolInteger;


public class RandomOperation extends AbstractSimpleOperation {

	public RandomOperation() {
		super();
	}

	@Override
	public Object execute(Object source, List parameters, IEolContext context, AST ast) throws EolRuntimeException {
		if (!(source instanceof EolCollection)) throw new EolNotApplicableOperationException("random", EolCollectionType.Collection, ast);	
		EolCollection col = (EolCollection) source;
		int index = (int) Math.round((Math.random() * col.size().intValue()) + 0.5);
		return col.at(new EolInteger(index-1));
	}

}
