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

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Equivalences implements Iterable<Equivalence> {

	private final List<Equivalence> equivalences = new LinkedList<Equivalence>();
	
	public void add(Equivalence equivalence) {
		equivalences.add(equivalence);
	}
	
	public void clear() {
		equivalences.clear();
	}
	
	public Iterator<Equivalence> iterator() {
		return equivalences.iterator();
	}
	
	public boolean hasEquivalent(Object original) {
		return getEquivalent(original) != null;
	}
	
	public Object getEquivalent(Object original) {
		for (Equivalence candidate : equivalences) {
			if (candidate.getOriginal().equals(original))
				return candidate.getCopy();
		}
		
		return null;
	}
	
	public Collection<Object> getEquivalents(Collection<?> originals) {
		final List<Object> equivalents = new LinkedList<Object>();
		
		for (Object original : originals) {
			if (hasEquivalent(original))
				equivalents.add(getEquivalent(original));
		}
		
		return equivalents;
	}
}
