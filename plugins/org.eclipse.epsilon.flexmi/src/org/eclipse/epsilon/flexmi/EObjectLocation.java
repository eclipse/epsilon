package org.eclipse.epsilon.flexmi;

import org.eclipse.emf.common.util.URI;

public class EObjectLocation {
	
	protected URI uri;
	protected int line;
	
	public EObjectLocation(URI uri, int line) {
		super();
		this.uri = uri;
		this.line = line;
	}

	public URI getUri() {
		return uri;
	}
	
	public int getLine() {
		return line;
	}
	
	@Override
	public int hashCode() {
		return getUri().toString().hashCode() + line;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj.hashCode() == this.hashCode();
	}
	
}
