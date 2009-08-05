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
package org.eclipse.epsilon.migration.execution;

import org.eclipse.epsilon.migration.IMigrationContext;
import org.eclipse.epsilon.migration.execution.exceptions.MigrationExecutionException;

public interface EquivalenceEstablisher {

	public Equivalences establishEquivalences(IMigrationContext context) throws MigrationExecutionException;

}