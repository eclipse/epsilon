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

import org.eclipse.epsilon.concordance.dt.ConcordancePlugin;
import org.eclipse.epsilon.concordance.history.ConcordanceHistory;
import org.eclipse.epsilon.concordance.index.ConcordanceIndex;
import org.eclipse.epsilon.concordance.model.IConcordanceModel;

public abstract class DefaultModelChangeListener implements ModelChangeListener {

	protected final ConcordanceIndex   index;
	protected final ConcordanceHistory history;
	
	public DefaultModelChangeListener() {
		this(ConcordancePlugin.getDefault().getIndex(), ConcordancePlugin.getDefault().getHistory());
	}
	
	public DefaultModelChangeListener(ConcordanceIndex index, ConcordanceHistory history) {
		this.index   = index;
		this.history = history;
	}
	
	public void modelAdded(IConcordanceModel model) {}

	public void modelRemoved(IConcordanceModel model) {}

	public void modelChanged(IConcordanceModel model) {}
	
	public void modelMoved(IConcordanceModel original, IConcordanceModel moved) {}
}
