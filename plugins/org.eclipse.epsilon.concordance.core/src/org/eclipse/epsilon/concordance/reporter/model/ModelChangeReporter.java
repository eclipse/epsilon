/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * Copyright (c) 2009 University of Twente.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 *     Maarten Bezemer - make difference between database and regular listeners
 ******************************************************************************/
package org.eclipse.epsilon.concordance.reporter.model;

import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.epsilon.concordance.model.IConcordanceModel;

/**
 * This reporter notified listeners that an {@link IConcordanceModel} has been
 * changed/updated.
 *
 * Listeners that change the (H2) database are notified after all other listeners
 * are notified, so the other listeners are able to use the database as it was
 * in the original situation (before the modification).
 */
public class ModelChangeReporter {

	private final Collection<ModelChangeListener> listeners = new LinkedList<ModelChangeListener>();
	private final Collection<ModelChangeListener> databaseListeners = new LinkedList<ModelChangeListener>();

	/**
	 * Adds listener, so it get notified on changes. This listener should not
	 * modify the (H2) database. If it does, use
	 * {@link #addListener(ModelChangeListener, boolean)} to register it.
	 *
	 * @param listener
	 *            to add
	 * @deprecated use {@link #addListener(ModelChangeListener, boolean)}
	 *             instead
	 */
	@Deprecated
	public void addListener(ModelChangeListener listener) {
		addListener(listener, false);
	}

	/**
	 * Adds listener, so it get notified on changes.
	 *
	 * @param listener
	 *            to add
	 * @param changesDatabase
	 *            when true, this listener will change/update the backing
	 *            database, that is/might be used by other listeners, and is
	 *            notified last.
	 */
	public void addListener(ModelChangeListener listener,
			boolean changesDatabase) {
		if (changesDatabase) {
			this.databaseListeners.add(listener);
		} else {
			this.listeners.add(listener);
		}
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
	
	private void notifyListeners(final NotificationType type,
			final IConcordanceModel originalModel,
			final IConcordanceModel newModel) {
		for (ModelChangeListener listener : listeners) {
			notifyListener(listener, type, originalModel, newModel);
		}
		for (ModelChangeListener listener : databaseListeners) {
			notifyListener(listener, type, originalModel, newModel);
		}
	}

	private void notifyListener(final ModelChangeListener listener,
			final NotificationType type, final IConcordanceModel originalModel,
			final IConcordanceModel newModel) {
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

	private static enum NotificationType {
		ADDED, REMOVED, CHANGED, MOVED;
	}
}
