/*******************************************************************************
 * Copyright (c) 2013 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eugenia.patches;

import java.util.List;

import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eugenia.EugeniaActionDelegate;
import org.eclipse.epsilon.eugenia.EugeniaActionDelegateStep;
import org.eclipse.jface.action.IAction;

public class ApplyPatchesDelegate extends EugeniaActionDelegate {
	
	@Override
	public String getTitle() {
		return "Applying patches";
	}

	@Override
	public EugeniaActionDelegateStep getStep() {
		return EugeniaActionDelegateStep.applypatches;
	}

	@Override
	public List<IModel> getModels() throws Exception {
		return null;
	}

	@Override
	public String getBuiltinTransformation() {
		return null;
	}

	@Override
	public String getCustomizationTransformation() {
		return null;
	}
	
	@Override
	public void runImpl(IAction action) {
		new Patcher(getSelection().getProject()).runForwards();
	}
}
