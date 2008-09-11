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

public class ToggleShowAggregatedWorkAction extends ProfilerViewAction {

	public ToggleShowAggregatedWorkAction(ProfilerView profilerView) {
		super(profilerView, "Show aggregated execution time", AS_CHECK_BOX);
		setImageDescriptor(Activator.getImageDescriptor("icons/aggregatedtime.gif"));
		setChecked(true);
	}

	@Override
	public void run() {
		profilerView.setShowAggregatedWork(!profilerView.isShowAggregatedWork());
		profilerView.refresh();
	}
	
}
