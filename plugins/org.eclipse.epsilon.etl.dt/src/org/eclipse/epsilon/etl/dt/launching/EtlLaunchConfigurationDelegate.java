/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.etl.dt.launching;

import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.dt.debug.EolDebugger;
import org.eclipse.epsilon.eol.dt.launching.EpsilonLaunchConfigurationDelegate;
import org.eclipse.epsilon.etl.EtlModule;

public class EtlLaunchConfigurationDelegate extends EpsilonLaunchConfigurationDelegate {
	
//	@Override
//	public IEolModule createModule() {
//		return new EtlModule();
//	}
	
	@Override
	protected EolDebugger createDebugger() {
		return new EtlDebugger();
	}
	
}

