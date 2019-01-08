package org.eclipse.epsilon.flexmi.actions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.epsilon.flexmi.FlexmiResource;

public class VariableDeclaration extends Action {
	
	protected EObject eObject;
	protected String name;
	protected boolean collection;
	
	public VariableDeclaration(EObject eObject, String name, boolean collection) {
		super();
		this.eObject = eObject;
		this.name = name;
		this.collection = collection;
	}
	
	@Override
	public void perform(FlexmiResource resource) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
