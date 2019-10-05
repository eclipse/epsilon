/*******************************************************************************
 * Copyright (c) 2010-2019 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 *     Sina Madani - concurrency support
 ******************************************************************************/
package org.eclipse.epsilon.eol.models;

import java.util.*;
import org.eclipse.epsilon.common.concurrent.ConcurrencyUtils;
import org.eclipse.epsilon.common.util.Multimap;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.*;

/**
 * A model that performs memoization of allContents, getAllOfType
 * and getAllOfKind. Subclasses should implement the template
 * methods, which compute real values from the model
 * or provide keys that can be used with a {@link Map}.
 * 
 * Although the collections used here are optionally thread-safe,
 * subclasses should manage their own data structures according to the
 * isConcurrent flag. In particular, {@link #allContentsFromModel()} should
 * be managed appropriately by subclasses.
 */
public abstract class CachedModel<ModelElementType> extends Model {
	
	/**
	 * Whether to cache allOf* calls by default. False for compatibility.
	 */
	public static final String PROPERTY_CACHED = "cached";
	
	/**
	 * Whether to use thread-safe collections by default. False for compatibility.
	 * @since 1.6
	 */
	public static final String PROPERTY_CONCURRENT = "concurrent";
	
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
	
	
	Collection<ModelElementType> allContentsCache;
	protected Multimap<Object, ModelElementType> typeCache;
	protected Multimap<Object, ModelElementType> kindCache;
	protected boolean concurrent;
	protected boolean cachingEnabled;
	
	/**
	 * @since 1.6
	 */
	protected CachedModel() {
		setConcurrent(false);
		setCachingEnabled(false);
	}
	
	/**
	 * 
	 * @return
	 * @since 1.6
	 */
	public boolean isConcurrent() {
		return concurrent;
	}
	
	/**
	 * 
	 * @param concurrent
	 * @since 1.6
	 */
	public void setConcurrent(boolean concurrent) {
		this.concurrent = concurrent;
		
		typeCache = typeCache != null ?
			new Multimap<>(concurrent, typeCache) : new Multimap<>(concurrent);	
		kindCache = kindCache != null ?
			new Multimap<>(concurrent, kindCache) : new Multimap<>(concurrent);
		
		if (allContentsCache != null) {
			allContentsCache = wrap(allContentsCache);
		}
	}
	
	/**
	 * 
	 * @param contents The model elements
	 * @return
	 * @since 1.6
	 */
	protected Collection<ModelElementType> wrap(Collection<ModelElementType> contents) {
		Collection<ModelElementType> result = contents; //!= null ? new ArrayList<>(contents) : new ArrayList<>();
		if (isConcurrent()) {
			result = ConcurrencyUtils.concurrentOrderedCollection(contents);
		}
		return result;
	}
	
	protected void addToCache(String type, ModelElementType instance) throws EolModelElementTypeNotFoundException {
		if (allContentsCache != null) {
			allContentsCache.add(instance);
		}
		
		Object typeCacheKey = getCacheKeyForType(type);
		typeCache.putIfPresent(typeCacheKey, instance);

		for (String kind : getAllTypeNamesOf(instance)) {
			Object kindCacheKey = getCacheKeyForType(kind);
			kindCache.putIfPresent(kindCacheKey, instance);
		}
	}

	protected void removeFromCache(ModelElementType instance) throws EolModelElementTypeNotFoundException {
		if (allContentsCache != null) {
			allContentsCache.remove(instance);
		}

		Object typeCacheKey = getCacheKeyForType(getTypeNameOf(instance));
		typeCache.remove(typeCacheKey, instance);

		for (String kind : getAllTypeNamesOf(instance)) {
			Object kindCacheKey = getCacheKeyForType(kind);
			kindCache.remove(kindCacheKey, instance);
		}
	}

	public void setCachingEnabled(boolean cachingEnabled) {
		this.cachingEnabled = cachingEnabled;
	}
	
	public boolean isCachingEnabled() {
		return cachingEnabled;
	}
	
	/**
	 * Convenience method for determining when a model has been loaded.
	 * @return Whether the cache has been populated.
	 * @since 1.6
	 */
	public boolean isLoaded() {
		return allContentsCache != null;
	}
	
	@Override
	public Collection<ModelElementType> allContents() {
		boolean cached = isCachingEnabled();
		if (cached && allContentsCache != null) {
			return allContentsCache;
		}
		Collection<ModelElementType> allContents = wrap(allContentsFromModel());
		if (cached) {
			allContentsCache = allContents;
		}
		return allContents;
	}
	
	/**
	 * 
	 * @param isKind
	 * @param modelElementType
	 * @return
	 * @throws EolModelElementTypeNotFoundException
	 * @since 1.6
	 */
	protected Collection<ModelElementType> getAllOfKindOrType(boolean isKind, String modelElementType) throws EolModelElementTypeNotFoundException {
		Collection<ModelElementType> values = null;
		Object key = null;
		Multimap<Object, ModelElementType> cache = null;
		
		if (isCachingEnabled()) {
			cache = isKind ? kindCache : typeCache;
			values = cache.getMutable(key = getCacheKeyForType(modelElementType));
		}
		if (values == null) {
			values = wrap(isKind ?
				getAllOfKindFromModel(modelElementType) :
				getAllOfTypeFromModel(modelElementType)
			);
			if (cache != null) {
				cache.putAll(key, values);
				//return cache.getMutable(key);
			}
		}
		return values;
	}
	
	@Override
	public Collection<ModelElementType> getAllOfType(String type) throws EolModelElementTypeNotFoundException {
		return getAllOfKindOrType(false, type);
	}
	
	@Override
	public Collection<ModelElementType> getAllOfKind(String kind) throws EolModelElementTypeNotFoundException {
		return getAllOfKindOrType(true, kind);
	}
	
	@Override
	public ModelElementType createInstance(String type) throws EolModelElementTypeNotFoundException, EolNotInstantiableModelElementTypeException {
		ModelElementType instance = createInstanceInModel(type);
		if (isCachingEnabled()) {
			addToCache(type, instance);
		}
		return instance;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void deleteElement(Object o) throws EolRuntimeException {
		if (deleteElementInModel(o) && isCachingEnabled()) {
			removeFromCache((ModelElementType) o);
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
		this.setCachingEnabled(properties.getBooleanProperty(PROPERTY_CACHED, false));
		this.setConcurrent(properties.getBooleanProperty(PROPERTY_CONCURRENT, false));
	}

	@Override
	public void dispose() {
		super.dispose();
		clearCache();
		disposeModel();
	}

	public void clearCache() {
		allContentsCache = null;
		if (typeCache != null) typeCache.clear();
		if (kindCache != null) kindCache.clear();
	}
}
