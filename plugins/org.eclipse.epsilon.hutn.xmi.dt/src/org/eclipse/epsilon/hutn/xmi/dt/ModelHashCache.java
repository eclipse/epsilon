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
package org.eclipse.epsilon.hutn.xmi.dt;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IPath;

public class ModelHashCache {
	
	private final ObjectPersistor<Map<URI, Integer>> cacheStorage;
	private final Map<URI, Integer> cache;
	
	ModelHashCache(IPath storagePath) {
		cacheStorage = new ObjectPersistor<Map<URI,Integer>>(storagePath.toFile());
		cache = cacheStorage.load(emptyCache());
	}
	
	private static Map<URI, Integer> emptyCache() {
		return new HashMap<URI, Integer>();
	}
	
	public boolean noHashFor(URI model) {
		return !cache.containsKey(model);
	}

	public void updateHashFor(URI model, int currentHash) {
		cache.put(model, currentHash);
	}

	public int getHashFor(URI model) {
		return cache.get(model);
	}
	
	public void store() throws IOException {
		cacheStorage.store(cache);
	}
}
