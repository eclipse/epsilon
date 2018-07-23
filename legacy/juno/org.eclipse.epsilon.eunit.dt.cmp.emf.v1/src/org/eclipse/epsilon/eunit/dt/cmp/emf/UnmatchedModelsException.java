/*******************************************************************************
 * Copyright (c) 2012 Antonio García-Domínguez.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Antonio García-Domínguez - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eunit.dt.cmp.emf;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.match.metamodel.UnmatchModel;

/**
 * Exception thrown when unmatched models are remaining after comparing
 * two resource sets.
 */
public class UnmatchedModelsException extends Exception {

	private static final long serialVersionUID = 1L;
	private EList<UnmatchModel> unmatchedModels;

	public UnmatchedModelsException(EList<UnmatchModel> unmatchedModels) {
		this.unmatchedModels = unmatchedModels;
	}

	public EList<UnmatchModel> getUnmatched() {
		return unmatchedModels;
	}

	@Override
	public String getMessage() {
		final StringBuilder sb = new StringBuilder("There were unmatched models among the two resource sets to be compared:");
		for (UnmatchModel um : unmatchedModels) {
			sb.append("\n - ");
			sb.append(um);
		}
		return sb.toString();
	}

}
