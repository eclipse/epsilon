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

import org.eclipse.epsilon.concordance.model.CrossReferenceVisitor;
import org.eclipse.epsilon.concordance.model.Model;
import org.eclipse.epsilon.concordance.model.ModelVisitor;

public interface ConcordanceIndex {
	
	public void visitAllInstancesOf(String nsUri, ModelVisitor visitor);

	public void visitAllCrossReferencesWithTarget(Model target, CrossReferenceVisitor visitor);

	public void visitAllModelsWithCrossReferencesTo(Model target, ModelVisitor visitor);
}
