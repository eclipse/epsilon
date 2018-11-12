/*******************************************************************************
 * Copyright (c) 2010 The University of York.
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
import java.util.concurrent.ConcurrentLinkedQueue;
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
 * Although the collections used here are optionally thread-safe,
 * subclasses should manage their own data structures according to the
 * isConcurrent flag. In particular, {@link #allContentsFromModel()} should
 * be managed appropriately by subclasses.
 */
public abstract class CachedModel<ModelElementType> extends Model {
	
	public static final String PROPERTY_CACHED = "cached";
	/**
	 * @since 1.6
	 */
	public static final String PROPERTY_CONCURRENT = "concurrent";
	
	/**
	 * Whether to use thread-safe collections by default. False for compatibility.
	 * @since 1.6
	 */
	protected static final boolean DEFAULT_CONCURRENT = false;
	
	/**
	 * Whether to cache allOf* calls by default. False for compatibility.
	 * @since 1.6
	 */
	protected static final boolean DEFAULT_CACHED = false;
	
	/**
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
	protected Multimap<Object, ModelElementType> typeCache;
	protected Multimap<Object, ModelElementType> kindCache;
	protected boolean concurrent;
	protected boolean cachingEnabled;
	protected boolean allContentsAreCached;
	
	/**
	 * @since 1.6
	 */
	protected CachedModel() {
		setConcurrent(DEFAULT_CONCURRENT);
		setCachingEnabled(DEFAULT_CACHED);
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
		
		if (concurrent) {
			allContentsCache = allContentsCache != null ?
				new ConcurrentLinkedQueue<>(allContentsCache) : new ConcurrentLinkedQueue<>();
		}
		else {
			allContentsCache = allContentsCache != null ?
				new ArrayList<>(allContentsCache) : new ArrayList<>();
		}
	}
	
	protected void addToCache(String type, ModelElementType instance) throws EolModelElementTypeNotFoundException {
		if (allContentsAreCached) {
			allContentsCache.add(instance);
		}

		Object typeCacheKey = getCacheKeyForType(type);
		if (typeCache.hasKey(typeCacheKey)) {
			typeCache.put(typeCacheKey, instance);
		}

		for (String kind : getAllTypeNamesOf(instance)) {
			Object kindCacheKey = getCacheKeyForType(kind);
			if (kindCache.hasKey(kindCacheKey)) {
				kindCache.put(kindCacheKey, instance);
			}
		}
	}

	protected void removeFromCache(ModelElementType instance) throws EolModelElementTypeNotFoundException {
		if (allContentsAreCached) {
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
	
	/**
	 * 
	 * @param isKind
	 * @param modelElementType
	 * @return
	 * @throws EolModelElementTypeNotFoundException
	 * @since 1.6
	 */
	protected Collection<ModelElementType> getAllOfKindOrType(boolean isKind, String modelElementType) throws EolModelElementTypeNotFoundException {
		if (isCachingEnabled()) {
			Object key = getCacheKeyForType(modelElementType);
			Multimap<Object, ModelElementType> cache = isKind ? kindCache : typeCache;
			Collection<ModelElementType> values = cache.getNullable(key);
			if (values == null) {
				values = isKind ? getAllOfKindFromModel(modelElementType) : getAllOfTypeFromModel(modelElementType);
				cache.putAll(key, values);
			}
			return values;
		}
		else {
			return isKind ? getAllOfKindFromModel(modelElementType) : getAllOfTypeFromModel(modelElementType);
		}
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
		this.setCachingEnabled(properties.getBooleanProperty(PROPERTY_CACHED, DEFAULT_CACHED));
		this.setConcurrent(properties.getBooleanProperty(PROPERTY_CONCURRENT, DEFAULT_CONCURRENT));
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
		kindCache.clear();
	}
}
