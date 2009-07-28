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

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.models.IModel;

public interface IMigrationContext extends IEolContext {

	public IModel getOriginalModel();
	
	public IModel getTargetModel();

	public Collection<?> getOriginalModelElements();

	public String typeNameOfOriginalModelElement(Object original);

	public Object createTargetModelElement(String type) throws EolRuntimeException;

	public Object executeBlock(AST block, Variable... variables) throws EolRuntimeException;

	public boolean executeGuard(AST guard, Variable originalVar);
}