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
package org.eclipse.epsilon.ecl.dt.launching;

import org.eclipse.epsilon.ecl.EclModule;
import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.dt.debug.EolDebugger;
import org.eclipse.epsilon.eol.dt.launching.EpsilonLaunchConfigurationDelegate;

public class EclLaunchConfigurationDelegate extends EpsilonLaunchConfigurationDelegate {
	
	@Override
	public IEolModule createModule() {
		return new EclModule();
	}
	
	@Override
	protected EolDebugger createDebugger() {
		return new EclDebugger();
	}
	
}
