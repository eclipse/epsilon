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

