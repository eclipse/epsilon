/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.flock;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.erl.IErlModule;
import org.eclipse.epsilon.flock.execution.exceptions.FlockUnsupportedModelException;

public interface IFlockModule extends IErlModule {
	
	@Override
	public IFlockContext getContext();
	
	public FlockResult execute(IModel original, IModel migrated) throws EolRuntimeException, FlockUnsupportedModelException;
}
