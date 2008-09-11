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
package org.eclipse.epsilon.eml.execute.operations;

import org.eclipse.epsilon.ecl.execute.operations.MatchesOperation;
import org.eclipse.epsilon.eol.execute.operations.OperationFactory;

public class EmlOperationFactory extends OperationFactory{
	
	public EmlOperationFactory () {
		super();
		operationCache.put("matches", new MatchesOperation());
		operationCache.put("equivalent", new EquivalentOperation());
		operationCache.put("equivalents", new EquivalentsOperation());
	}
	
	/*
	protected AbstractOperation getOperationFor(String name) {
		if (name.equalsIgnoreCase("matches")){
			return new MatchesOperation();
		} 
		else if (name.equalsIgnoreCase("equivalents")){
			return new EquivalentsOperation();
		}
		else if (name.equalsIgnoreCase("equivalent")){
			return new EquivalentOperation();
		}
		return super.getOperationFor(name);
	}
	*/
}
