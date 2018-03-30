/*******************************************************************************
 * Copyright (c) 2010 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 *     Sina Madani - concurrency support
 ******************************************************************************/
package org.eclipse.epsilon.eol.models;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.eclipse.epsilon.common.concurrent.ConcurrencyUtils;
import org.eclipse.epsilon.common.util.Multimap;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;

/**
 * A model that performs memoization of allContents, getAllOfType
 * and getAllOfKind. Subclasses should implement the template
 * methods, which compute real values from the model
 * or provide keys that can be used with a {@link Map}.
 * 
 * Although the collections used here are thread-safe, subclasses
 * should manage their own data structures in a thread-safe manner.
 * In particular, {@link #allContentsFromModel()} should be
 * managed appropriately by subclasses.
 */
public abstract class CachedModel<ModelElementType> extends Model {
	
	public static final String PROPERTY_CACHED = "cached";
	
	/*
	 * Implementations should return a thread-safe collection when appropriate!
	 */
	protected abstract Collection<ModelElementType> allContentsFromModel();
	
	protected abstract Collection<ModelElementType> getAllOfTypeFromModel(String type) throws EolModelElementTypeNotFoundException;
	protected abstract Collection<ModelElementType> getAllOfKindFromModel(String kind) throws EolModelElementTypeNotFoundException;
	protected abstract ModelElementType createInstanceInModel(String type) throws EolModelElementTypeNotFoundException, EolNotInstantiableModelElementTypeException;
	protected abstract void loadModel() throws EolModelLoadingException;
	protected abstract void disposeModel();
	
	/**
	 * Returns true iff the given instance was deleted from the model.
	 */
	protected abstract boolean deleteElementInModel(Object instance) throws EolRuntimeException;
	
	/**
	 * Returns an identity for the given type, 
	 * which will be used by {@link CachedModel}
	 * as a key for the memoization of model elements
	 * by type.
	 * 
	 * @throws EolModelElementTypeNotFoundException
	 */
	protected abstract Object getCacheKeyForType(String type) throws EolModelElementTypeNotFoundException;
	
	/**
	 * Returns the fully qualified names of every type to which the
	 * given object conforms. The values are used by
	 * by {@link CachedModel} for the memoization of
	 * model elements by their kind ({@link #getAllOfKind(String)}).
	 */
	protected abstract Collection<String> getAllTypeNamesOf(Object instance);
	
	
	protected Collection<ModelElementType> allContentsCache;
	protected final Collection<Object> cachedTypes, cachedKinds;
	protected final Multimap<Object, ModelElementType> typeCache, kindCache;
	protected boolean cachingEnabled, allContentsAreCached;
	
	protected CachedModel() {
		cachingEnabled = true;
		allContentsAreCached = false;
		allContentsCache = new ConcurrentLinkedQueue<>();
		cachedKinds = ConcurrencyUtils.concurrentSet();
		kindCache = new Multimap<>(true);
		cachedTypes = ConcurrencyUtils.concurrentSet();
		typeCache = new Multimap<>(true);
	}
	
	protected void addToCache(String type, ModelElementType instance) throws EolModelElementTypeNotFoundException {
		if (allContentsAreCached) {
			allContentsCache.add(instance);
		}

		Object typeCacheKey = getCacheKeyForType(type);
		if (typeCache.containsKey(typeCacheKey)) {
			typeCache.put(typeCacheKey, instance);
		}

		for (String kind : getAllTypeNamesOf(instance)) {
			Object kindCacheKey = getCacheKeyForType(kind);
			if (kindCache.containsKey(kindCacheKey)) {
				kindCache.put(kindCacheKey, instance);
			}
		}
	}

	protected void removeFromCache(ModelElementType instance) throws EolModelElementTypeNotFoundException {
		if (allContentsAreCached) {
			allContentsCache.remove(instance);
		}

		final Object typeCacheKey = getCacheKeyForType(getTypeNameOf(instance));
		if (typeCache.containsKey(typeCacheKey)) {
			typeCache.remove(typeCacheKey, instance);
		}

		for (String kind : getAllTypeNamesOf(instance)) {
			final Object kindCacheKey = getCacheKeyForType(kind);
			if (kindCache.containsKey(kindCacheKey)) {
				kindCache.remove(kindCacheKey, instance);
			}
		}
	}

	public void setCachingEnabled(boolean cachingEnabled) {
		this.cachingEnabled = cachingEnabled;
	}
	
	public boolean isCachingEnabled() {
		return cachingEnabled;
	}
	
	@Override
	public Collection<ModelElementType> allContents() {
		if (isCachingEnabled()) {
			if (!allContentsAreCached) {
				allContentsCache = allContentsFromModel();
				allContentsAreCached = true;				
			}
			return allContentsCache;
		}
		else {
			return allContentsFromModel();
		}
	}
	
	@Override
	public Collection<ModelElementType> getAllOfType(String type) throws EolModelElementTypeNotFoundException {
		if (isCachingEnabled()) {
			Object key = getCacheKeyForType(type);
			if (!cachedTypes.contains(key)) {
				typeCache.putAll(key, getAllOfTypeFromModel(type));
				cachedTypes.add(key);
			}
			return typeCache.get(key);
		}
		else {
			return getAllOfTypeFromModel(type);
		}
	}
	
	@Override
	public Collection<ModelElementType> getAllOfKind(String kind) throws EolModelElementTypeNotFoundException {
		if (isCachingEnabled()) {
			Object key = getCacheKeyForType(kind);
			if (!cachedKinds.contains(key)) {
				kindCache.putAll(key, getAllOfKindFromModel(kind));
				cachedKinds.add(key);
			}
			return kindCache.get(key);
		}
		else {
			return getAllOfKindFromModel(kind);
		}
		
	}
	
	@Override
	public ModelElementType createInstance(String type) throws EolModelElementTypeNotFoundException, EolNotInstantiableModelElementTypeException {
		ModelElementType instance = createInstanceInModel(type);
		
		if (isCachingEnabled()) {
			addToCache(type, instance);
		}
		
		return instance;
	}

	@Override
	public void deleteElement(Object o) throws EolRuntimeException {
		if (deleteElementInModel(o)) {
			if (isCachingEnabled()) {
				@SuppressWarnings("unchecked")
				ModelElementType instance = (ModelElementType) o;
				removeFromCache(instance);
			}
		}
	}

	@Override
	public void load() throws EolModelLoadingException {
		clearCache();
		loadModel();
	}
	
	@Override
	public void load(StringProperties properties, IRelativePathResolver resolver) throws EolModelLoadingException {
		super.load(properties, resolver);
		this.setCachingEnabled(properties.hasProperty(PROPERTY_CACHED));
	}

	@Override
	public void dispose() {
		super.dispose();
		clearCache();
		disposeModel();
	}

	public void clearCache() {
		allContentsCache.clear();
		allContentsAreCached = false;
		
		typeCache.clear();
		cachedTypes.clear();
		
		kindCache.clear();
		cachedKinds.clear();
	}
}
