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
package org.eclipse.epsilon.flock;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.flock.emc.wrappers.ModelElement;
import org.eclipse.epsilon.flock.execution.exceptions.ConservativeCopyException;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;
import org.eclipse.epsilon.flock.model.MigrationStrategy;

public interface IFlockContext extends IEolContext {
	
	public void setOriginalModel(int indexInRepository);
	
	public void setMigratedModel(int indexInRepository);

	public Object executeBlock(AST block, Variable... variables) throws FlockRuntimeException;

	public boolean executeGuard(AST guard, Variable originalVar) throws FlockRuntimeException;
	
	public Iterable<ModelElement> getOriginalModelElements();

	public ModelElement createModelElementInMigratedModel(String type) throws FlockRuntimeException;
	
	public ModelElement safelyCreateModelElementInMigratedModel(String type) throws FlockRuntimeException;

	public boolean isTypeInOriginalMetamodel(String type);
	
	public boolean isElementInOriginalModel(ModelElement element);
	
	public boolean isElementInMigratedModel(ModelElement element);
	
	public FlockResult run(MigrationStrategy strategy) throws FlockRuntimeException;

	public ModelElement getEquivalent(ModelElement modelElement);
	
	public Object getUnwrappedEquivalent(Object unwrappedModelElement) throws ConservativeCopyException;
	
	public void addWarning(String message);
}