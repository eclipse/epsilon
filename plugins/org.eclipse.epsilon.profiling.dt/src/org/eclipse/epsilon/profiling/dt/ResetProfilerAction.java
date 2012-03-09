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

import org.eclipse.epsilon.profiling.Profiler;


public class ResetProfilerAction extends ProfilerViewAction {

	public ResetProfilerAction(ProfilerView profilerView) {
		super(profilerView);
		setText("Reset the profiler");
		setImageDescriptor(Activator.getImageDescriptor("icons/reset.gif"));
	}

	@Override
	public void run() {
		Profiler.INSTANCE.reset();
		profilerView.refresh(); 
	}
	
}
