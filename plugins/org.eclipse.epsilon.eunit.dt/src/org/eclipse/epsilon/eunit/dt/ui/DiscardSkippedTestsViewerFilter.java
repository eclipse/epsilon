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

import org.eclipse.epsilon.eol.eunit.EUnitModule;
import org.eclipse.epsilon.eol.eunit.EUnitTest;
import org.eclipse.epsilon.eol.eunit.EUnitTestResultType;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eunit.dt.EUnitPlugin;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

/**
 * Viewer filter which discards skipped tests.
 *
 * @author Antonio García-Domínguez
 * @version 1.0
 */
class DiscardSkippedTestsViewerFilter extends ViewerFilter {
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (element instanceof EUnitTest) {
			EUnitTest t = (EUnitTest)element;
			if (EUnitTestResultType.SKIPPED.equals(t.getResult())) {
				return false;
			}
		}
		else if (element instanceof EUnitModule) {
			EUnitModule m = (EUnitModule)element;
			try {
				return select(viewer, m, m.getSuiteRoot());
			} catch (EolRuntimeException e) {
				EUnitPlugin.getDefault().logException(e);
			}
		}
		return true;
	}
}
