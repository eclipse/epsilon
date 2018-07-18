/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.evl.execute;

import org.eclipse.epsilon.eol.execute.operations.EolOperationFactory;
import org.eclipse.epsilon.evl.execute.operations.SatisfiesOperation;

public class EvlOperationFactory extends EolOperationFactory{
	
	public EvlOperationFactory() {
		super();
		operationCache.put("satisfies", new SatisfiesOperation(true));
		operationCache.put("satisfiesAll", new SatisfiesOperation(true));
		operationCache.put("satisfiesOne", new SatisfiesOperation(false));
	}
	
}
