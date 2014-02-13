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
package org.eclipse.epsilon.concordance.reporter.model;

import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.epsilon.concordance.model.IConcordanceModel;


public class ModelChangeReporter {

	private final Collection<ModelChangeListener> listeners = new LinkedList<ModelChangeListener>();
	

	public void addListener(ModelChangeListener listener) {
		this.listeners.add(listener);
	}
	
	public void reportAddition(IConcordanceModel model) {
		notifyListeners(NotificationType.ADDED, model);
	}

	public void reportRemoval(IConcordanceModel model) {
		notifyListeners(NotificationType.REMOVED, model);
	}
	
	public void reportChange(IConcordanceModel model) {
		notifyListeners(NotificationType.CHANGED, model);
	}

	public void reportMove(IConcordanceModel oldModel, IConcordanceModel newModel) {
		notifyListeners(NotificationType.MOVED, oldModel, newModel);
	}
	
	private void notifyListeners(NotificationType type, IConcordanceModel model) {
		notifyListeners(type, model, null);
	}
	
	private void notifyListeners(NotificationType type, IConcordanceModel originalModel, IConcordanceModel newModel) {
		for (ModelChangeListener listener : listeners) {
			switch (type) {
				case ADDED:
					listener.modelAdded(originalModel);
					break;
				case REMOVED:
					listener.modelRemoved(originalModel);
					break;
				case CHANGED:
					listener.modelChanged(originalModel);
					break;
				case MOVED:
					listener.modelMoved(originalModel, newModel);
					break;
			}
		}
	}
	
	private static enum NotificationType {
		ADDED, REMOVED, CHANGED, MOVED;
	}
}
