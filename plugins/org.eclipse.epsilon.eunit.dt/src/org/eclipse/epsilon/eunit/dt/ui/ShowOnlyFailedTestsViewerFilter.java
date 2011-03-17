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
package org.eclipse.epsilon.eunit.dt.ui;

import org.eclipse.epsilon.eol.eunit.EUnitTest;
import org.eclipse.epsilon.eol.eunit.EUnitTestResultType;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

/**
 * Viewer filter which only selects tests that have failed. This viewer can be
 * enabled and disabled at will, using {@link #setEnabled(boolean)}, but the
 * filtered viewer must be refreshed elsewhere.
 *
 * @author Antonio García-Domínguez
 * @version 1.0
 */
public class ShowOnlyFailedTestsViewerFilter extends ViewerFilter {

	boolean isEnabled = false;

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (isEnabled && element instanceof EUnitTest) {
			EUnitTest t = (EUnitTest)element;
			return t.getResult().equals(EUnitTestResultType.ERROR)
				|| t.getResult().equals(EUnitTestResultType.FAILURE);
		}
		return true;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean enabled) {
		this.isEnabled = enabled;
	}

}
