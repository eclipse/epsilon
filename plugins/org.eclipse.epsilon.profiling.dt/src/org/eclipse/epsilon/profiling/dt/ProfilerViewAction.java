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
package org.eclipse.epsilon.profiling.dt;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

public class ProfilerViewAction extends Action {
	
	protected ProfilerView profilerView;
	
	public ProfilerViewAction(ProfilerView profilerView) {
		this.profilerView = profilerView;
		setImageDescriptor(PlatformUI.getWorkbench().
					getSharedImages().getImageDescriptor(ISharedImages.IMG_OBJ_ELEMENT));
	}

	public ProfilerViewAction(ProfilerView profilerView, String text, int style) {
		super(text, style);
		this.profilerView = profilerView;
		setImageDescriptor(PlatformUI.getWorkbench().
					getSharedImages().getImageDescriptor(ISharedImages.IMG_OBJ_ELEMENT));

	}
	
}
