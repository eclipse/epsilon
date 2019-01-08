package org.eclipse.epsilon.flexmi.actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

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
		Map<String, Object> variables = resource.getVariables();
		if (collection) {
			if (variables.containsKey(name)) {
				((Collection<Object>) variables.get(name)).add(eObject);
			}
			else {
				variables.put(name, new ArrayList<Object>(Arrays.asList(eObject)));
			}
		}
		else {
			variables.put(name, eObject);
		}
	}
}
