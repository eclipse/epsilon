package org.eclipse.epsilon.flexmi;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

public abstract class Computation {
	
	protected EObject eObject;
	protected String expression;
	protected int lineNumber;
	protected URI uri;
	
	public abstract void compute() throws Exception;
	
	public EObject getEObject() {
		return eObject;
	}
	
	public String getExpression() {
		return expression;
	}
	
	public int getLineNumber() {
		return lineNumber;
	}
	
	public URI getUri() {
		return uri;
	}
}
