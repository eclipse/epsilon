/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.flock.execution.operations;

import org.eclipse.epsilon.eol.execute.operations.EolOperationFactory;

public class FlockOperationFactory extends EolOperationFactory {
	
	public FlockOperationFactory() {
		operationCache.put("equivalent", new EquivalentOperation());
	}
}
