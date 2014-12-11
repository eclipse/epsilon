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
	
	public boolean originalBelongsTo(String originalPackage) {
		return element.belongsTo(originalPackage);
	}
	
	public boolean satisfies(Guard guard) throws FlockRuntimeException {
		if (guard == null) {
			return true;
		} else {
			return guard.isSatisifedBy(executor, element.createReadOnlyVariable("original"));
		}
	}

	/**
	 * Returns true if and only if it's possible to create a context for the parent of
	 * the model element in this context. Returns false otherwise, such as when the 
	 * model element in this context has no parent model element.
	 */
	public boolean isContextForParentElement() {
		return element.getContainer() != null;
	}
	
	public GuardedConstructContext getContextForParentElement() {
		return new GuardedConstructContext(element.getContainer(), executor);
	}
}
