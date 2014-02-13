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


import java.util.Collection;

import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.concordance.db.ConcordanceH2Database;
import org.eclipse.epsilon.concordance.db.common.H2DatabaseAccessException;
import org.eclipse.epsilon.concordance.model.CrossReference;
import org.eclipse.epsilon.concordance.model.CrossReferenceVisitor;
import org.eclipse.epsilon.concordance.model.IConcordanceModel;
import org.eclipse.epsilon.concordance.model.ModelVisitor;

public class H2ConcordanceIndex implements ConcordanceIndex {
	
	private final ConcordanceH2Database database;
	
	H2ConcordanceIndex(ConcordanceH2Database database) {
		this.database = database;
	}

	public void visitAllInstancesOf(String nsUri, ModelVisitor visitor) {
		try {
			//Profiler.INSTANCE.start("FindingAllInstances");			
			final Collection<IConcordanceModel> instances = database.findAllInstancesOf(nsUri);
			//Profiler.INSTANCE.stop("FindingAllInstances");
			
			for (IConcordanceModel model : instances) {
				visitor.visit(model);
			}
			
		} catch (H2DatabaseAccessException e) {
			LogUtil.log("Error encountered whilst visiting all instances of '" + nsUri + "'", e);
		}
	}

	public void visitAllCrossReferencesWithTarget(IConcordanceModel target, CrossReferenceVisitor visitor) {
		try {
			for (CrossReference crossReference : database.findAllCrossReferencesTo(target)) {
				visitor.visit(crossReference);
			}
			
		} catch (H2DatabaseAccessException e) {
			LogUtil.log("Error encountered whilst visiting all cross references with target '" + target + "'", e);
		}
	}

	public void visitAllModelsWithCrossReferencesTo(IConcordanceModel target, ModelVisitor visitor) {
		try {
			for (IConcordanceModel model : database.findAllModelsWithCrossReferencesTo(target)) {
				visitor.visit(model);
			}
			
		} catch (H2DatabaseAccessException e) {
			LogUtil.log("Error encountered whilst visiting all models with cross references to '" + target + "'", e);

		}
	}
}
