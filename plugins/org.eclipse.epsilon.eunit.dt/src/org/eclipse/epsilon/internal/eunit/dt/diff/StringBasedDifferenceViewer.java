/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Antonio Garcia-Dominguez - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.internal.eunit.dt.diff;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.CompareUI;
import org.eclipse.epsilon.eunit.dt.diff.IDifferenceViewer;

/**
 * Fallback difference viewer which converts both arguments to strings
 * and then compares them. If the  <code>delta</code> is not null, this
 * viewer will be disabled.
 *
 * @author Antonio Garcia-Dominguez
 */
public class StringBasedDifferenceViewer implements IDifferenceViewer {

	@Override
	public boolean canCompare(Object expected, Object actual, Object delta) {
		return delta == null;
	}

	@Override
	public void compare(Object expected, Object actual, Object delta) {
		CompareConfiguration cc = new CompareConfiguration();
		cc.setLeftLabel("Obtained value");
		cc.setRightLabel("Expected value");
		CompareUI.openCompareEditor(
			new StringCompareEditorInput(
				cc,
				"" + actual,
				"" + expected),
			true);
	}

}
