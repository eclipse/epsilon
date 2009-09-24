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
import org.eclipse.epsilon.flock.execution.Equivalence;
import org.eclipse.epsilon.flock.execution.NoEquivalence;

public class DeleteRule extends GuardedRule {

	public DeleteRule(AST ast, String type, AST guard) {
		super(ast, type, guard);
	}
	
	public DeleteRule(String type, AST guard) {
		this(null, type, guard);
	}
	
	public Equivalence createEquivalence(ModelElement original, IFlockContext context) {
		return new NoEquivalence(original);
	}
	
	@Override
	public String toString() {
		return "delete " + getOriginalType() + " when " + guard;
	}
	
	@Override
	public boolean equals(Object object) {
		if (!(object instanceof DeleteRule))
			return false;
		
		return super.equals(object);
	}
}
