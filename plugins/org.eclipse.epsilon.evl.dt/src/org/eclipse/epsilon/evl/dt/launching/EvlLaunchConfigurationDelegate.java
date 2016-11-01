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
package org.eclipse.epsilon.evl.dt.launching;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.epsilon.eol.IEolExecutableModule;
import org.eclipse.epsilon.eol.dt.debug.EolDebugger;
import org.eclipse.epsilon.eol.dt.launching.EpsilonLaunchConfigurationDelegate;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.evl.EvlModule;
import org.eclipse.epsilon.evl.dt.launching.tabs.EvlAdvancedOptionsTab;
import org.eclipse.epsilon.evl.dt.views.ValidationViewFixer;

public class EvlLaunchConfigurationDelegate extends EpsilonLaunchConfigurationDelegate {
	
	@Override
	public IEolExecutableModule createModule() {
		return new EvlModule();
	}
	
	@Override
	protected EolDebugger createDebugger() {
		return new EvlDebugger();
	}
	
	@Override
	protected void preExecute(IEolExecutableModule module) throws CoreException, EolRuntimeException {
		super.preExecute(module);
		((EvlModule)module).setUnsatisfiedConstraintFixer(new ValidationViewFixer(configuration));
		((EvlModule)module).setOptimizeConstraints(configuration.getAttribute(EvlAdvancedOptionsTab.OPTIMIZE_CONSTRAINTS, false));
	}
	
}

