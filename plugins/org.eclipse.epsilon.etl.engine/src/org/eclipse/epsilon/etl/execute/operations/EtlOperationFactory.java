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
package org.eclipse.epsilon.etl.execute.operations;

public class EtlOperationFactory extends org.eclipse.epsilon.eol.execute.operations.OperationFactory{
	
	public EtlOperationFactory() {
		super();
		operationCache.put("equivalent", new EquivalentOperation());
		operationCache.put("equivalents", new EquivalentsOperation());
	}
	
	/*
	protected AbstractOperation getOperationFor(String name){
				
		if (name.equals("equivalent")){
			return new EquivalentOperation();
		}
		else if (name.equals("equivalents")){
			return new EquivalentsOperation();
		}
		return super.getOperationFor(name);
		
	}
	*/
}
