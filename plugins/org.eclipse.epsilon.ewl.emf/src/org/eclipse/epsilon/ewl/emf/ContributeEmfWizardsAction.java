/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.ewl.emf;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;

public class ContributeEmfWizardsAction extends AbstractContributeWizardsAction {
	
	protected EditingDomain getEditingDomain() {
		return ((IEditingDomainProvider) targetPart).getEditingDomain();
	}

	protected EObject getEObject(Object selected) {
		if (selected instanceof EObject) {
			return (EObject) selected;
		}
		else {
			return null;
		}
	}

	@Override
	protected WorkbenchPartRefresher getWorkbenchPartRefresher() {
		return new WorkbenchPartRefresher() {
			@Override
			public void refresh() {
				// Do nothing
			}
		};
	}

}
