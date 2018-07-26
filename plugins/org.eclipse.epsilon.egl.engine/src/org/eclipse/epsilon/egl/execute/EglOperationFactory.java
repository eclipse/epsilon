/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.execute;

import org.eclipse.epsilon.egl.execute.operations.IncludeOperation;
import org.eclipse.epsilon.eol.execute.operations.EolOperationFactory;

public class EglOperationFactory extends EolOperationFactory {
	
	@Override
	protected void createCache() {
		super.createCache();
		operationCache.put("include", new IncludeOperation());
	}
	
}
