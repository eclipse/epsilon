/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.types;


public class EolObjectComparator {
	
	public static boolean equals(Object o1, Object o2) {
		if (o1 == null && o2 == null) return true;
		if (o1 == null || o2 == null) return false;

		if (o1 instanceof Number && o2 instanceof Number) {
			return NumberUtil.isEqual((Number)o1, (Number)o2);
		}

		/*
		if (o1 instanceof Collection && o2 instanceof Collection) {
			Collection c1 = (Collection) o1;
			Collection c2 = (Collection) o2;
			
			if (!EolCollectionType.getTypeName(c1).equals(EolCollectionType.getTypeName(c2))) return false;
			boolean isOrdered = EolCollectionType.isOrdered(c1);
			
			if (c1.size() != c2.size()) { return false; } 
			else {
				Iterator it1 = c1.iterator();
				Iterator it2 = c2.iterator();
				while (it1.hasNext()) {
					Object next = it1.next();
					if (isOrdered) {
						if (!equals(next, it2.next())) return false;
					}
					else {
						if (!c2.contains(next)) return false;
					}
				}
				return true;
			}
		}*/
		
		return o1.equals(o2);
	}
	
}
