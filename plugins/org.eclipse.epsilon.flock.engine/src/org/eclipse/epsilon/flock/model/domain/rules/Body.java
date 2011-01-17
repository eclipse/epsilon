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

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.flock.execution.EolExecutor;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;

public class Body {

	private final AST block;
	
	public Body(AST block) {
		this.block = block;
	}
	
	public void applyTo(EolExecutor executor, Variable... variables) throws FlockRuntimeException {
		if (block != null) {
			executor.executeBlock(block, variables);
		}
	}
	
	@Override
	public String toString() {
		return "Body: " + block;
	}
	
	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Body))
			return false;
		
		final Body other = (Body)object;
		
		return block == null ? other.block == null : block.equals(other.block);
	}
	
	@Override
	public int hashCode() {
		return block == null ? 0 : block.hashCode();
	}
}
