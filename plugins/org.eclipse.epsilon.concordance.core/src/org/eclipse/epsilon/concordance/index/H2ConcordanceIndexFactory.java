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
package org.eclipse.epsilon.concordance.index;

import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.concordance.db.ConcordanceH2Database;
import org.eclipse.epsilon.concordance.db.ConcordanceH2DatabaseUpdater;
import org.eclipse.epsilon.concordance.db.common.H2Database;
import org.eclipse.epsilon.concordance.db.common.H2DatabaseAccessException;
import org.eclipse.epsilon.concordance.reporter.model.ModelChangeReporter;

public final class H2ConcordanceIndexFactory {

	private final static H2ConcordanceIndexFactory INSTANCE = new H2ConcordanceIndexFactory();
	private H2Database h2db;
	
	private H2ConcordanceIndexFactory() {}
	
	public static H2ConcordanceIndexFactory getInstance() {
		return INSTANCE;  
	}

	public ConcordanceIndex createConcordanceIndex(String databasePath, ModelChangeReporter reporter) {
		try {
			h2db = new H2Database(databasePath);
			
			final ConcordanceH2Database concordanceDatabase = initalise(h2db);
			
			createDatabaseUpdater(concordanceDatabase, reporter);
			
			return new H2ConcordanceIndex(concordanceDatabase);
			
		} catch (H2DatabaseAccessException e) {
			LogUtil.log("Error encountered while creating H2ConcordanceIndex.", e);
			return new NullConcordanceIndex();
		}
	}
	
	private ConcordanceH2Database initalise(H2Database database) throws H2DatabaseAccessException {
		return ConcordanceH2Database.loadFromOrInitialiseIn(database);
	}
	
	private void createDatabaseUpdater(ConcordanceH2Database concordanceDatabase, ModelChangeReporter reporter) {
		new ConcordanceH2DatabaseUpdater(concordanceDatabase, reporter);
	}

	public void teardownConcordanceIndex() {
		try {
			if (h2db != null) {
				h2db.dispose();
			}
			
		} catch (H2DatabaseAccessException e) {
			LogUtil.log("Error encountered while disposing H2ConcordanceIndex.", e);
		}
	}
}
