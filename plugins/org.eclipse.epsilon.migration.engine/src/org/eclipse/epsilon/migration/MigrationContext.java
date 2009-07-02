/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.migration;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.emc.emf.AbstractEmfModel;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.execute.context.EolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.types.EolBoolean;

public class MigrationContext extends EolContext {

	private final AbstractEmfModel original;
	private final AbstractEmfModel target;
	
	public MigrationContext() {
		original = null;
		target   = null;
	}
	
	public MigrationContext(AbstractEmfModel original, AbstractEmfModel target) {
		this.original = original;
		this.target   = target;
		
		getModelRepository().addModel(original);
		getModelRepository().addModel(target);
	}

	AbstractEmfModel getOriginalModel() {
		return original;
	}
	
	public AbstractEmfModel getTargetModel() {
		return target;
	}
	
	public Collection<EObject> getOriginalModelElements() {
		return getOriginalModel().allContents();
	}
	
	public Object executeBlock(AST block, Variable... variables) throws EolRuntimeException {
		enterProtectedFrame(block, variables);
		
		final Object result = getExecutorFactory().executeAST(block, this);
		
		leaveFrame(block);
		
		return result;
	}

	public boolean executeGuard(final AST guard, Variable originalVar) {
		enterProtectedFrame(guard, originalVar);
		
		final EolBoolean guardSatisfied = (EolBoolean)getExecutorFactory().executeBlockOrExpressionAst(guard, this, EolBoolean.FALSE);
		
		leaveFrame(guard);
		
		return guardSatisfied.booleanValue();
	}
}
