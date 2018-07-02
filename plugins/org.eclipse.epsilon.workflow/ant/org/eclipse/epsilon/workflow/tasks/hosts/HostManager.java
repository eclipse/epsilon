/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.workflow.tasks.hosts;

import java.util.ArrayList;

public class HostManager {
	
	protected static Host host = null;
	protected static ArrayList<Host> supportedHosts = new ArrayList<>();
	
	public static Host getHost() {
		if (host == null) {
			host = createHost();
		}
		return host;
	}
	
	public static void setHost(Host host) {
		HostManager.host = host;
	}
	
	protected static Host createHost() {
		try {
			supportedHosts.add(new EclipseHost());
		}
		catch (Throwable t) {}
		
		for (Host host : supportedHosts) {
			if (host.isRunning()) return host;
		}
		
		return new DefaultHost();
	}
	
	public static ArrayList<Host> getSupportedHosts() {
		return supportedHosts;
	}
	
}
