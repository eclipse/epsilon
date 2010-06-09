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

import org.eclipse.epsilon.concordance.dt.ConcordancePlugin;
import org.eclipse.epsilon.concordance.history.ConcordanceHistory;
import org.eclipse.epsilon.concordance.index.ConcordanceIndex;
import org.eclipse.epsilon.concordance.model.Model;

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
	
	public void modelAdded(Model model) {}

	public void modelRemoved(Model model) {}

	public void modelChanged(Model model) {}
	
	public void modelMoved(Model original, Model moved) {}
}
