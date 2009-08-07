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

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.migration.emc.wrappers.ModelElement;
import org.eclipse.epsilon.migration.execution.exceptions.ConservativeCopyException;
import org.eclipse.epsilon.migration.execution.exceptions.MigrationExecutionException;
import org.eclipse.epsilon.migration.model.MigrationStrategy;

public interface IMigrationContext extends IEolContext {
	
	public void setOriginalModel(int indexInRepository);
	
	public void setMigratedModel(int indexInRepository);

	public Object executeBlock(AST block, Variable... variables) throws MigrationExecutionException;

	public boolean executeGuard(AST guard, Variable originalVar) throws MigrationExecutionException;
	
	public Iterable<ModelElement> getOriginalModelElements();

	public ModelElement createModelElementInMigratedModel(String type) throws MigrationExecutionException;
	
	public ModelElement safelyCreateModelElementInMigratedModel(String type) throws MigrationExecutionException;

	public boolean isElementInOriginalModel(ModelElement element);
	
	public boolean isElementInMigratedModel(ModelElement element);
	
	public void run(MigrationStrategy strategy) throws MigrationExecutionException;

	public ModelElement getEquivalent(ModelElement modelElement);
	
	public Object getUnwrappedEquivalent(Object unwrappedModelElement) throws ConservativeCopyException;
}