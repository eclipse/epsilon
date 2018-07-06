/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.execute.operations.contributors;

public class WrapperOperationContributor extends OperationContributor {

	@Override
	public boolean contributesTo(Object target) {
		return target instanceof IWrapper;
	}
	
	@Override
	public Object getReflectionTarget(Object target) {
		return ((IWrapper) target).getWrapped();
	}
	
	@Override
	protected boolean includeInheritedMethods() {
		return true;
	}
	
}