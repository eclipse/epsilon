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

import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EPackage;

public class MetamodelChangeReporter {

	private final List<MetamodelChangeListener> listeners = new LinkedList<>();
	private final EPackageRegistryCache cache = new EPackageRegistryCache();
	
	
	public MetamodelChangeReporter(MetamodelChangeListener... listeners) {
		for (MetamodelChangeListener listener : listeners) {
			addListener(listener);
		}
	}

	public void addListener(MetamodelChangeListener listener) {
		listeners.add(listener);
		
		for (Entry<String, EPackage> entryInCurrentRegistry : cache.getCachedEntries()) {
			listener.ePackageAdded(entryInCurrentRegistry.getValue());
		}
	}
	
	public void removeListener(MetamodelChangeListener listener){
		listeners.remove(listener);
	}
	
	public void pollRegistry(){
		CacheDelta delta = cache.update();
		
		for (Entry<String, EPackage> freshEntry : delta.freshEntries) {
			notifyObservers(freshEntry.getValue(), freshEntry.getValue(), NotificationType.ADDED); 			
		}
		
		for (Entry<EPackage, EPackage> changedEntry : delta.changedEntries) {
			notifyObservers(changedEntry.getKey(), changedEntry.getValue(), NotificationType.CHANGED); 			
		}
		
		for (Entry<String, EPackage> expiredEntry : delta.expiredEntries) {
			notifyObservers(expiredEntry.getValue(), expiredEntry.getValue(), NotificationType.REMOVED); 			
		}	
	}
	
	// TODO : notification should happen in its own background job to prevent polling job from being blocked?
	private void notifyObservers(EPackage oldEPackage, EPackage newEPackage, NotificationType type) {
		for (MetamodelChangeListener listener : listeners) {
			if (type == NotificationType.ADDED)
				listener.ePackageAdded(oldEPackage);
			else if (type == NotificationType.REMOVED)
				listener.ePackageRemoved(oldEPackage);
			else if (type == NotificationType.CHANGED)
				listener.ePackageChanged(oldEPackage, newEPackage);
		} 
	}
	
	private static enum NotificationType {
		ADDED, CHANGED, REMOVED;
	}
}
