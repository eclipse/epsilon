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
package org.eclipse.epsilon.concordance.reporter.model;

import org.eclipse.epsilon.concordance.model.IConcordanceModel;

/**
 * Clients must implement a no-argument constructor, which will be instantiated by Concordance.
 */
public interface ModelChangeListener {

	public void modelAdded(IConcordanceModel model);

	public void modelRemoved(IConcordanceModel model);

	public void modelChanged(IConcordanceModel model);
	
	public void modelMoved(IConcordanceModel original, IConcordanceModel moved);
}
