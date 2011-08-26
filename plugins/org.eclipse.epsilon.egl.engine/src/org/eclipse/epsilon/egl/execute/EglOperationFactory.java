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
package org.eclipse.epsilon.egl.execute;

import org.eclipse.epsilon.egl.engine.traceability.fine.operations.print.PrintOperation;
import org.eclipse.epsilon.egl.execute.operations.IncludeOperation;
import org.eclipse.epsilon.eol.execute.operations.OperationFactory;

public class EglOperationFactory extends OperationFactory {
	
	@Override
	protected void createCache() {
		super.createCache();
		operationCache.put("include", new IncludeOperation());
		
		// TODO Speak to Dimitris: this might be better as an 
		// operation that has been contributed to OutputBuffer,
		// but contributed operations don't receive the full AST..
		operationCache.put("printy", new PrintOperation());
	}
	
}
