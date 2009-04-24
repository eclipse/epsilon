/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.hutn.dt.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.epsilon.common.dt.actions.AbstractObjectActionDelegate;
import org.eclipse.epsilon.hutn.dt.util.HutnBuilderHelper;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IObjectActionDelegate;

public class GenerateModelAction extends AbstractObjectActionDelegate implements IObjectActionDelegate {
	
	
	public void run(IAction action) {
		if (getFirstElementInSelection() instanceof IFile) {
			new HutnBuilderHelper((IFile)getFirstElementInSelection()).buildHutn();
		}
	}
}
