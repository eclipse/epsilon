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

import java.util.ArrayList;
import java.util.Collection;

public class ObjectUtil {
	
	public static boolean equals(Object o1, Object o2) {
		if (o1 == null && o2 == null) return true;
		if (o1 == null || o2 == null) return false;
		return o1.equals(o2);
	}
	
	public static Collection<?> asCollection(Object o) {
		if (o instanceof Collection) {
			return (Collection<?>) o;
		}
		else {
			ArrayList<Object> collection = new ArrayList<Object>();
			collection.add(o);
			return collection;
		}
	}
	
}
