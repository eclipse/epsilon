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
package org.eclipse.epsilon.flock.execution;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.epsilon.flock.emc.wrappers.ModelElement;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;

public class Equivalences {

	private final List<Equivalence> equivalences = new LinkedList<Equivalence>();
	
	void add(Equivalence equivalence) {
		equivalences.add(equivalence);
	}
	
	public ModelElement getEquivalent(ModelElement original) {
		for (Equivalence candidate : equivalences) {
			if (candidate.getOriginal().equals(original))
				return candidate.getEquivalent();
		}
		
		return null;
	}

	public void populateEachEquivalent() throws FlockRuntimeException {		
		for (Equivalence equivalence : equivalences) {
			equivalence.automaticallyPopulateEquivalence();
		}
		
		for (Equivalence equivalence : equivalences) {
			equivalence.applyStrategyToPopulateEquivalence();
		}
	}
	
	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		
		for (Equivalence equivalence : equivalences) {
			builder.append(equivalence);
			builder.append('\n');
		}
		
		return builder.toString();
	}
}
