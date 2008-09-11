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
package org.eclipse.epsilon.ecl.execute;

import org.eclipse.epsilon.ecl.execute.operations.DoMatchOperation;
import org.eclipse.epsilon.ecl.execute.operations.MatchesOperation;
import org.eclipse.epsilon.eol.execute.operations.OperationFactory;

public class EclOperationFactory extends OperationFactory{
	
	public EclOperationFactory() {
		super();
		operationCache.put("matches", new MatchesOperation());
		operationCache.put("doMatch", new DoMatchOperation());
	}
	
	/*
	protected AbstractOperation getOperationFor(String name){
		
		if (name.equals("matches")){
			return new MatchesOperation();
		}
		
		return super.getOperationFor(name);
	}
	*/
}
