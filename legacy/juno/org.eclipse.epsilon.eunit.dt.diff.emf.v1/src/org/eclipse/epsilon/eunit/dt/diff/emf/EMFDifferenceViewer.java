/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Antonio Garcia-Dominguez - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eunit.dt.diff.emf;

import org.eclipse.compare.CompareUI;
import org.eclipse.emf.compare.diff.metamodel.ComparisonSnapshot;
import org.eclipse.emf.compare.ui.editor.ModelCompareEditorInput;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eunit.dt.diff.IDifferenceViewer;

/**
 * Difference viewer which uses EMF Compare to show the differences
 * between two models. It requires that the differences have been previously
 * computed and stored as a {@link ComparisonSnapshot} instance.
 * 
 * @author Antonio Garcia-Dominguez
 */
public class EMFDifferenceViewer implements IDifferenceViewer {

	public boolean canCompare(Object expected, Object actual, Object delta) {
		return delta instanceof ComparisonSnapshot;
	}

	public void compare(Object expected, Object actual, Object delta) {
		ComparisonSnapshot snap = (ComparisonSnapshot)delta;

		// We need to create a copy before passing it to ModelCompareEditorInput, as
		// it sets diff and match to null, for some reason.
		ComparisonSnapshot copy = (ComparisonSnapshot)EcoreUtil.copy(snap);
		final ModelCompareEditorInput input = new ModelCompareEditorInput(copy);
		input.getCompareConfiguration().setLeftLabel("Expected model");
		input.getCompareConfiguration().setRightLabel("Obtained model");
		CompareUI.openCompareEditor(input, true);
	}

}
