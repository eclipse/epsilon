/*******************************************************************************
 * Copyright (c) 2014 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.execute.introspection.recording;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PropertyAccesses implements IPropertyAccesses {

	private final List<IPropertyAccess> storage = new LinkedList<>();

	public PropertyAccesses(IPropertyAccess... propertyAccesses) {
		storage.addAll(Arrays.asList(propertyAccesses));
	}
	
	@Override
	public Collection<? extends IPropertyAccess> all() {
		// defensive copy
		return new LinkedList<>(storage);
	}
	
	@Override
	public Set<? extends IPropertyAccess> unique() {
		return new HashSet<>(storage);
	}

	public void add(IPropertyAccess propertyAccess) {
		storage.add(propertyAccess);
	}
	
	public boolean isEmpty() {
		return storage.isEmpty();
	}
	
	public void clear() {
		storage.clear();
	}
	
	@Override
	public boolean equals(Object object) {
		if (!(object instanceof PropertyAccesses))
			return false;
		
		final PropertyAccesses other = (PropertyAccesses)object;
		
		return storage.equals(other.storage);
	}
	
	@Override
	public int hashCode() {
		return storage.hashCode();
	}
	
	@Override
	public String toString() {
		return storage.toString();
	}
}
