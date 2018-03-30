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

import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.Map;

public class Cache<K, V> {
	
	protected ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
	protected Map<IdentityBasedWeakReference, V> map = new HashMap<>();
	protected Thread cleanUpThread = null;
	
	public Map<IdentityBasedWeakReference, V> getMap() {
		return map;
	}
	
	protected Thread createCleanUpThread() {
		return new Thread(() -> {
			try {
				while (!map.isEmpty() && !Thread.currentThread().isInterrupted()) {
					IdentityBasedWeakReference reference = (IdentityBasedWeakReference) referenceQueue.remove();
					if (reference != null) {
						synchronized (map) {
							map.remove(reference);
						}
					}
				}
			} catch (InterruptedException ie) {}
		});
	}
	
	public V get(Object key) {
		synchronized (map) {
			return map.get(new IdentityBasedWeakReference(key, referenceQueue));
		}
	}
	
	public V put(K key, V value) {
		IdentityBasedWeakReference reference = new IdentityBasedWeakReference(key, referenceQueue);
		synchronized (map) {
			if (!map.containsKey(reference)) {
				map.put(reference, value);
				if (map.size() == 1) {
					try {
						cleanUpThread = createCleanUpThread();
						cleanUpThread.setDaemon(true);
						cleanUpThread.start();
					}
					catch (Exception ex) {}
				}
			}
			return value;
		}
	}
	
	public int size() {
		return map.size();
	}
	
	public void dispose() {
		if (cleanUpThread != null) {
			cleanUpThread.interrupt();
			cleanUpThread = null;
		}
		map.clear();
	}
}
