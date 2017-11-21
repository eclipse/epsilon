package org.eclipse.epsilon.flexmi;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;

public class FlexmiDiagnostic implements Diagnostic {

	protected String message;
	protected int line;
	protected Resource resource;
	
	public FlexmiDiagnostic(String message, int line, Resource resource) {
		super();
		this.message = message;
		this.line = line;
		this.resource = resource;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public String getLocation() {
		return resource.getURI().toString();
	}

	@Override
	public int getLine() {
		return line;
	}

	@Override
	public int getColumn() {
		return 0;
	}

}
