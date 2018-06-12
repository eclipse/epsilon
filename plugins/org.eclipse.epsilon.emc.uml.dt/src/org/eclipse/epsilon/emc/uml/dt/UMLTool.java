package org.eclipse.epsilon.emc.uml.dt;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLPlugin;

public class UMLTool {
	
	public UMLPlugin getUMLPlugin() {
		return UMLPlugin.INSTANCE;
	}
	
	public Profile getProfile(String uri) {
		return getProfileFromPathmapURI(UMLPlugin.getEPackageNsURIToProfileLocationMap().get(uri) + "");		
	}
	
	public Profile getProfileFromPathmapURI(String uri) {
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(URI.createURI(uri));
		try {
			resource.load(null);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return (Profile) resource.getContents().get(0);

	}
	
}
