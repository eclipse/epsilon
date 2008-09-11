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

public class ToggleAutoRefreshAction extends ProfilerViewAction {

	public ToggleAutoRefreshAction(ProfilerView profilerView) {
		super(profilerView, "Auto refresh", AS_CHECK_BOX);
		setImageDescriptor(Activator.getImageDescriptor("icons/autorefresh.gif"));
	}
	
	@Override
	public void run() {
		profilerView.setAutoRefresh(!profilerView.isAutoRefresh());
	}
}
