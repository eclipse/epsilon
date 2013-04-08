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
package org.eclipse.epsilon.evl.execute;

import org.eclipse.epsilon.eol.execute.operations.OperationFactory;
import org.eclipse.epsilon.evl.execute.operations.SatisfiesOperation;

public class EvlOperationFactory extends OperationFactory{
	
	public EvlOperationFactory() {
		super();
		operationCache.put("satisfies", new SatisfiesOperation(true));
		operationCache.put("satisfiesOne", new SatisfiesOperation(false));
	}
	
	/*
	protected AbstractOperation getOperationFor(String name){
		
		if (name.equals("satisfies")){
			return new SatisfiesOperation();
		}
		
		return super.getOperationFor(name);
	}
	*/
}
