package org.eclipse.epsilon.emc.emf;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class CachedResourceSet extends ResourceSetImpl {
	
	protected static final Cache cache = new Cache();
	
	public static Cache getCache() {
		return cache;
	}
	
	@Override
	public Resource createResource(URI uri) {
		Resource cachedResource = getCache().checkoutResource(uri);
		if (cachedResource == null) {
			cachedResource = super.createResource(uri);
			if (cachedResource == null) {
				cachedResource = new XMIResourceFactoryImpl().createResource(uri);
				getResources().add(cachedResource);
			}
			cachedResource.setTrackingModification(false);
			if (cachedResource instanceof XMLResource) {
				configure((XMLResource) cachedResource);
			}
			getCache().cacheResource(uri, cachedResource);
		}
		return cachedResource;
	}
	
	public void configure(XMLResource resource) {
		Map<Object, Object> loadOptions = resource.getDefaultLoadOptions();
		//loadOptions.put(XMLResource.OPTION_RECORD_UNKNOWN_FEATURE, Boolean.TRUE);
		//loadOptions.put(XMLResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE);
		loadOptions.put(XMLResource.OPTION_DEFER_IDREF_RESOLUTION, Boolean.TRUE);
		loadOptions.put(XMLResource.OPTION_LAX_FEATURE_PROCESSING, Boolean.TRUE);
		loadOptions.put(XMLResource.OPTION_PROCESS_DANGLING_HREF, XMLResource.OPTION_PROCESS_DANGLING_HREF_DISCARD);
	}

	public static class Cache {
		
		protected ArrayList<CacheItem> items = new ArrayList<CacheItem>();
		
		protected void cacheResource(URI uri, Resource resource) {
			CacheItem item = new CacheItem();
			item.setUri(uri);
			item.setResource(resource);
			item.incrementCheckedOut();
			items.add(item);
		}
		
		protected boolean isCached(URI uri) {
			for (CacheItem item : items) {
				if (item.getUri().equals(uri)) return item.getResource() != null;
			}
			return false;
		}
		
		protected Resource checkoutResource(URI uri) {
			CacheItem toCheckout = null;
			for (CacheItem item : items) {
				if (item.getUri().equals(uri)) toCheckout = item;
				break;
			}
			
			if (toCheckout == null) {
				return null;
			}
			else if (toCheckout.getResource() != null) {
				toCheckout.incrementCheckedOut();
				return toCheckout.getResource();
			}
			else {
				items.remove(toCheckout);
				return null;
			}
		}
		
		protected void returnResource(Resource resource) {
			CacheItem toReturn = null;
			for (CacheItem item : items) {
				if (resource.equals(item.getResource())) toReturn = item;
				break;
			}
			
			if (toReturn != null) {
				toReturn.decrementCheckedOut();
				if (toReturn.getCheckedOut() == 0) {
					items.remove(toReturn);
				}
			}
		}
		
		public void clear() {
			items.clear();
		}
		
		public int size() {
			return items.size();
		}
	
		class CacheItem {
			protected WeakReference<Resource> resourceReference;
			public URI uri;
			public int checkedOut = 0;
			
			public Resource getResource() {
				return resourceReference.get();
			}
			
			public void setResource(Resource resource) {
				resourceReference = new WeakReference<Resource>(resource);
			}
			
			public void setUri(URI uri) {
				this.uri = uri;
			}
			
			public URI getUri() {
				return uri;
			}
			
			public void incrementCheckedOut() {
				checkedOut ++;
			}
			
			public void decrementCheckedOut() {
				checkedOut--;
			}
			
			public int getCheckedOut() {
				return checkedOut;
			}
			
		}
	}
}
