/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.emc.emf;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;

public class ContainmentChangeAdapter implements Adapter {
	
	protected EObject instance;
	protected Resource resource;
	
	public ContainmentChangeAdapter(EObject instance, Resource resource) {
		this.instance = instance;
		this.resource = resource;
	}
	
	public Notifier getTarget() {
		return null;
	}

	public boolean isAdapterForType(Object arg0) {
		return false;
	}

	public void notifyChanged(Notification notification) {
		
		if (!(notification instanceof ENotificationImpl)) return;
		
		ENotificationImpl notificationImpl = (ENotificationImpl) notification;
		
		if (notificationImpl.getFeature() instanceof EReference) {
			EReference reference = (EReference) notification.getFeature();
			
			if (reference.isContainer()) {
				if (instance.eContainer() != null && resource != null && resource.getContents().contains(instance)){
					resource.getContents().remove(instance);
				}
			}
			else if (reference.isContainment()) {
				Object value = instance.eGet(reference);
				if (value instanceof EObject) {
					EObject eObject = (EObject) value;
					if (resource!= null && resource.getContents().contains(eObject)) {
						resource.getContents().remove(eObject);
					}
				}
				else if (value instanceof Collection) {
					Collection<?> col = (Collection<?>) value;
					Iterator<?> it = col.iterator();
					while (it.hasNext()){
						Object next = it.next();
						if (next instanceof EObject) {
							EObject eObject = (EObject) next;
							if (resource!=null && resource.getContents().contains(eObject)) {
								resource.getContents().remove(eObject);
							}
						}
					}
				}
			}
		}
	}

	public void setTarget(Notifier arg0) {
		
	}
	
}

