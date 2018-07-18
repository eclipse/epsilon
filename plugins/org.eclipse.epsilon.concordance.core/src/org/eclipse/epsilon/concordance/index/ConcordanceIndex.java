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
package org.eclipse.epsilon.concordance.index;

import org.eclipse.epsilon.concordance.model.CrossReferenceVisitor;
import org.eclipse.epsilon.concordance.model.IConcordanceModel;
import org.eclipse.epsilon.concordance.model.ModelVisitor;

public interface ConcordanceIndex {
	
	public void visitAllInstancesOf(String nsUri, ModelVisitor visitor);

	public void visitAllCrossReferencesWithTarget(IConcordanceModel target, CrossReferenceVisitor visitor);

	public void visitAllModelsWithCrossReferencesTo(IConcordanceModel target, ModelVisitor visitor);
}
