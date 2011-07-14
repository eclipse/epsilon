package org.eclipse.epsilon.workflow.tasks.hosts;

import java.util.ArrayList;

public class HostManager {
	
	protected static Host host = null;
	protected static ArrayList<Host> supportedHosts = new ArrayList<Host>();
	
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
