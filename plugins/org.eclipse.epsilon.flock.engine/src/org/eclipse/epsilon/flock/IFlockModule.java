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

import org.eclipse.epsilon.eol.IEolLibraryModule;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;

public interface IFlockModule extends IEolLibraryModule {
	
	public FlockResult execute(IFlockContext context) throws FlockRuntimeException;
	
	public FlockResult execute(IModel original, IModel migrated) throws FlockRuntimeException;
}
