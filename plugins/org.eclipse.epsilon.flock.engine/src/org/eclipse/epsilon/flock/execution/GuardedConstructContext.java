/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.flock.execution;

import org.eclipse.epsilon.flock.emc.wrappers.ModelElement;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;
import org.eclipse.epsilon.flock.model.domain.common.Guard;

public class GuardedConstructContext {

	private final ModelElement element;
	private final EolExecutor executor;
	
	public GuardedConstructContext(ModelElement element, EolExecutor executor) {
		this.element  = element;
		this.executor = executor;
	}
	
	public boolean originalConformsTo(String originalType, boolean strict) {
		if (strict)
			return element.isTypeOf(originalType);
		else
			return element.isKindOf(originalType);
	}
	
	public boolean satisfies(Guard guard) throws FlockRuntimeException {
		return guard.isSatisifedBy(executor, element.createReadOnlyVariable("original"));
	}
}
