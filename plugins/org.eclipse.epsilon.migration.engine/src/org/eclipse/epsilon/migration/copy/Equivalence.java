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
package org.eclipse.epsilon.migration.copy;

import org.eclipse.emf.ecore.EObject;

public class Equivalence {
	
	private final EObject original;
	private final EObject copy;
	
	public Equivalence(EObject original, EObject copy) {
		this.original = original;
		this.copy     = copy;
	}
	
	public EObject getOriginal() {
		return original;
	}

	public EObject getCopy() {
		return copy;
	}

	@Override
	public String toString() {
		return original + " <-> " + copy;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Equivalence))
			return false;
		
		final Equivalence other = (Equivalence)obj;
		
		return original.equals(other.original) &&
		       copy.equals(other.copy);
	}
	
	@Override
	public int hashCode() {
		return original.hashCode() + copy.hashCode();
	}
}