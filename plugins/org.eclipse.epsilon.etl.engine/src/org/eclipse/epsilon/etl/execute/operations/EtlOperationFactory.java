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

import org.eclipse.epsilon.eol.execute.operations.EolOperationFactory;

public class EtlOperationFactory extends EolOperationFactory{
	
	public EtlOperationFactory() {
		super();
		operationCache.put("equivalent", new EquivalentOperation());
		operationCache.put("equivalents", new EquivalentsOperation());
	}
	
}
