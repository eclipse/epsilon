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
package org.eclipse.epsilon.concordance.db;

import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.concordance.db.common.H2DatabaseAccessException;
import org.eclipse.epsilon.concordance.model.IConcordanceModel;
import org.eclipse.epsilon.concordance.reporter.model.ModelChangeListener;
import org.eclipse.epsilon.concordance.reporter.model.ModelChangeReporter;

public class ConcordanceH2DatabaseUpdater implements ModelChangeListener {

	private final ConcordanceH2Database database;
	
	public ConcordanceH2DatabaseUpdater(ConcordanceH2Database database, ModelChangeReporter reporter) {
		this.database = database;
			
		reporter.addListener(this, true);
	}

	public void modelAdded(IConcordanceModel model) {
		try {
			database.addModel(model);
		
		} catch (H2DatabaseAccessException e) {
			LogUtil.log("Error encountered while adding a model to the H2 Concordance Database: " + model, e);
		}
	}

	public void modelRemoved(IConcordanceModel model) {
		try {
			database.deleteModel(model);
		
		} catch (H2DatabaseAccessException e) {
			LogUtil.log("Error encountered while deleting a model from the H2 Concordance Database: " + model, e);
		}
	}

	public void modelChanged(IConcordanceModel model) {
		modelRemoved(model);
		modelAdded(model);
	}

	public void modelMoved(IConcordanceModel original, IConcordanceModel moved) {
		try {
			database.moveModel(original, moved);

		} catch (H2DatabaseAccessException e) {
			LogUtil.log("Error encountered while changing the URI of a model from the H2 Concordance Database: " + original + " -> " + moved, e);
		}
	}
}
