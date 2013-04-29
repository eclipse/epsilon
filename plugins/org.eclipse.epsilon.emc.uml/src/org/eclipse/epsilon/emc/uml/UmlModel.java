package org.eclipse.epsilon.emc.uml;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.uml2.uml.util.UMLUtil;

public class UmlModel extends EmfModel {
	
	@Override
	protected ResourceSet createResourceSet() {
		ResourceSet resourceSet = super.createResourceSet();
		UMLUtil.init(resourceSet);
		return resourceSet;
	}
	
}
