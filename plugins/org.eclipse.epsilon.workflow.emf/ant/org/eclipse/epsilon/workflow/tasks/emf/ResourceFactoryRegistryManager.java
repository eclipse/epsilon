package org.eclipse.epsilon.workflow.tasks.emf;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.eclipse.emf.ecore.resource.Resource.Factory.Registry;
import org.eclipse.epsilon.flexmi.FlexmiResourceFactory;

public class ResourceFactoryRegistryManager {
	
	public static void configure() {
		Registry resourceFactoryRegistry = Resource.Factory.Registry.INSTANCE;
		if (!resourceFactoryRegistry.getExtensionToFactoryMap().containsKey("flexmi")) {
			resourceFactoryRegistry.getExtensionToFactoryMap().put("flexmi", new FlexmiResourceFactory());
		}
		if (!resourceFactoryRegistry.getExtensionToFactoryMap().containsKey("emf")) {
			try {
				Resource.Factory emfaticResourceFactory = 
						(Factory) Class.forName("org.eclipse.emf.emfatic.core.EmfaticResourceFactory").newInstance();
				resourceFactoryRegistry.getExtensionToFactoryMap().put("emf", emfaticResourceFactory);
			}
			catch (Exception ex) {
				// Ignore exception
			}
		}
	}
	
}
