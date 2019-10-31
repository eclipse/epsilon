/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.concordance.reporter.metamodel;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.concordance.core.hashing.hashers.ecore.EPackageHasher;

public class EPackageRegistryCache {

	private final Map<String, EPackage> cache = new HashMap<>();
	private final Map<String, EPackage> currentRegistry = new HashMap<>();
	private final Collection<String> erroringNsUris = new LinkedList<>();

	
	public EPackageRegistryCache() {
		refreshCurrentRegistry();
	}
	
	public Set<Entry<String, EPackage>> getCachedEntries() {
		return cache.entrySet();
	}
	
	public CacheDelta update() {
		refreshCurrentRegistry();
		return new CacheDelta(freshEntries(), expiredEntries(), changedEntries());
	}

	private Set<Entry<String, EPackage>> expiredEntries() {
		final Set<Entry<String, EPackage>> entriesNotInOther = new HashSet<>();
		
		for (Iterator<Entry<String, EPackage>> iterator = cache.entrySet().iterator(); iterator.hasNext();) {
			final Entry<String, EPackage> cachedEntry = iterator.next();
			
			if (!currentRegistry.containsKey(cachedEntry.getKey())) {
				entriesNotInOther.add(cachedEntry);
				iterator.remove();
			}
		}
		
		return entriesNotInOther;
	}


	private Set<Entry<String, EPackage>> freshEntries() {
		final Set<Entry<String, EPackage>> freshEntries = new HashSet<>();
		
		for (Entry<String, EPackage> currentRegistryEntry : currentRegistry.entrySet()){
			if (!cache.containsKey(currentRegistryEntry.getKey())) {
				cache.put(currentRegistryEntry.getKey(), currentRegistryEntry.getValue());
				freshEntries.add(currentRegistryEntry);
			}
		}
		
		return freshEntries;
	}


	private Set<Entry<EPackage, EPackage>> changedEntries() {
		final Map<EPackage, EPackage> changedEntries = new HashMap<>();
		
		for (Entry<String, EPackage> currentRegistryEntry : currentRegistry.entrySet()) {
			final String nsUri = currentRegistryEntry.getKey();
		
			final EPackage current = currentRegistryEntry.getValue();
			final EPackage cached  = cache.get(nsUri);
		
			if (different(cached, current)) {
				changedEntries.put(cached, current);
				cache.put(nsUri, current);
			}
		}
		
		return changedEntries.entrySet();
	}
	
	private boolean different(EPackage first, EPackage second) {
		return !equal(first, second);
	}
	
	private boolean equal(EPackage first, EPackage second) {
		return hash(first) == hash(second);
	}

	private int hash(EPackage first) {
		return first == null ? 0 : EPackageHasher.getInstance().hash(first);
	}
	
	
	private void refreshCurrentRegistry() {
		currentRegistry.clear();
		
		for (String key : new HashSet<>(EPackage.Registry.INSTANCE.keySet())) {
			if (getEPackage(key) != null)
				currentRegistry.put(key, getEPackage(key));
		}
	}

	private EPackage getEPackage(String nsUri) {
		try {
			final EPackage pkg = EPackage.Registry.INSTANCE.getEPackage(nsUri);
			
			erroringNsUris.remove(nsUri);
			
			return pkg;
		
		} catch (Throwable e) {
			if (!erroringNsUris.contains(nsUri)) {
				erroringNsUris.add(nsUri);
				LogUtil.logInfo("Exception encountered whilst trying to retrieve EPackage for nsUri: " + nsUri, false);
			}
			
			return null;
		}
	}
}
