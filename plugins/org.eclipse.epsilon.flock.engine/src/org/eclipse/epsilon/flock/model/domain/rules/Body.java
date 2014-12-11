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
package org.eclipse.epsilon.flock.model.domain.rules;

import org.eclipse.epsilon.eol.dom.ExecutableBlock;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;

public class Body extends ExecutableBlock<Void> {

	// FIXME do these domain model classes still need to exist?
		// if so, what should they be responsible for?
		// for example, should the Guard now be responsible for caching its result
		//    (e.g., see tests relating to guards with side effects)
		
	public Body() {
		super(Void.class);
	}

	public void applyTo(IEolContext context, Variable... variables) throws FlockRuntimeException {
		try {
			this.execute(context, variables);
		
		} catch (EolRuntimeException e) { // FIXME shouldn't wrap
			throw new FlockRuntimeException(e);
		}
	}
}
