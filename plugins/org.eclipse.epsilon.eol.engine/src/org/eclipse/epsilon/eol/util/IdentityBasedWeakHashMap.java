/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.util;

import java.util.Map;
import java.util.WeakHashMap;

public class IdentityBasedWeakHashMap<K, V> {
	
	protected WeakHashMap<IdentityBasedWeakReference, V> map = new 
		WeakHashMap<IdentityBasedWeakReference, V>();
	
	public V get(Object key) {
		return map.get(new IdentityBasedWeakReference(key));
	}
	
	public V put(K key, V value) {
		return map.put(new IdentityBasedWeakReference(key), value);
	}
	
	public int size() {
		return map.size();
	}
	
}
