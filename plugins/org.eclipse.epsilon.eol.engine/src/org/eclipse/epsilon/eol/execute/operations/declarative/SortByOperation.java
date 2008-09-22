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
package org.eclipse.epsilon.eol.execute.operations.declarative;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.types.EolCollection;
import org.eclipse.epsilon.eol.types.EolInteger;


public class SortByOperation extends CollectOperation {

	public SortByOperation() {
		super();
	}

	@Override
	public Object execute(Object obj, AST operationAst, IEolContext context) throws EolRuntimeException {
		final EolCollection source = EolCollection.asCollection(obj);
		final EolCollection collected = (EolCollection)super.execute(obj, operationAst, context);
		
		// Determine which collected values correspond to which collection elements
		final Map<Object, Object> map = new HashMap<Object, Object>();
		
		for (int index = 0; index < collected.size().intValue(); index++)
			map.put(collected.at(new EolInteger(index)), source.at(new EolInteger(index)));
		
		// FIXME : Find a better way to sort the results
		//		   the current way compares them based on  
		//		   their string representations
		
		// Sort the collected values
		try {
			collected.sort(context.getPrettyPrinterManager());
		} catch (EolRuntimeException e) {
			throw new EolRuntimeException(e.getReason(), operationAst);
		}
		
		// Build a new collection of the original collection elements
		// ordered by the result of sorting the collected items
		final EolCollection result = source.createCollection();
		
		for (int index = 0; index < collected.size().intValue(); index++)
			result.add(map.get(collected.at(new EolInteger(index))));
		
		return result;
	}
}
