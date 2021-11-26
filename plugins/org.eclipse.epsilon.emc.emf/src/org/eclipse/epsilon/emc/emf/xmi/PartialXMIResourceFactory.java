package org.eclipse.epsilon.emc.emf.xmi;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class PartialXMIResourceFactory extends XMIResourceFactoryImpl {

	public Resource createResource(URI uri) {
		return new PartialXMIResource(uri);
	};

}
