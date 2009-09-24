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
package org.eclipse.epsilon.flock.model;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.flock.IFlockContext;
import org.eclipse.epsilon.flock.emc.wrappers.ModelElement;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;

public class Guard {
	
	private final AST blockOrExpession;
	
	public Guard(AST blockOrExpession) {
		this.blockOrExpession = blockOrExpession;
	}
	
	public boolean isSatisifedBy(ModelElement original, IFlockContext context) throws FlockRuntimeException {
		if (blockOrExpession == null)
			return true;
		
		return context.executeGuard(blockOrExpession, original.createReadOnlyVariable("original"));
	}
	
	@Override
	public String toString() {
		return "Guard: " + blockOrExpession;
	}
	
	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Guard))
			return false;
		
		final Guard other = (Guard)object;
		
		return blockOrExpession == null ?
		       other.blockOrExpession == null : 
		       blockOrExpession.equals(other.blockOrExpession);
	}
	
	@Override
	public int hashCode() {
		return blockOrExpession.hashCode();
	}
}
