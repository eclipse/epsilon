package org.eclipse.epsilon.evl.emf.validation;

import java.net.URISyntaxException;
import java.net.URL;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.ui.IStartup;

public class EValidatorPopulator implements IStartup {
	
	protected final String extensionPoint = "org.eclipse.epsilon.evl.emf.validation";
	
	public void earlyStartup() {
		
		//EcoreValidator vv;
		//for (Object key : EPackage.Registry.INSTANCE.keySet()) {
		//	System.err.println(key + " -> " + EPackage.Registry.INSTANCE.get(key));
		//}
		
		//for (Object key : EValidator.Registry.INSTANCE.keySet()) {
		//	System.err.println(key + " -> " + EValidator.Registry.INSTANCE.get(key));
		//}
		
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint extenstionPoint = registry.getExtensionPoint(extensionPoint);
		
		for (IConfigurationElement configurationElement : extenstionPoint.getConfigurationElements()) {
			
			try {
				String ePackageUri = configurationElement.getAttribute("namespaceURI");
				EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(ePackageUri);
				if (ePackage == null) continue;
				
				String bundleId = configurationElement.getAttribute("bundleId");
				
				if (bundleId == null || bundleId.trim().length() == 0) {
					bundleId = configurationElement.getDeclaringExtension().getNamespaceIdentifier();
				}
				
				URL url = Platform.getBundle(bundleId).getResource(configurationElement.getAttribute("constraints"));
				
				String modelName = configurationElement.getAttribute("modelName");
				
				if (modelName == null || modelName.trim().length() == 0) modelName = EvlValidator.DEFAULT_MODEL_NAME;
				
				EvlValidator evlValidator = new EvlValidator(url.toURI(), modelName, ePackageUri);
				EValidator newValidator = null;
				EValidator existingValidator = EValidator.Registry.INSTANCE.getEValidator(ePackage);
				
				//System.err.println("Existing : " + existingValidator);
				
				if (existingValidator == null) {
					newValidator = evlValidator;
				}
				else if (existingValidator instanceof CompositeEValidator) {
					((CompositeEValidator) existingValidator).getDelegates().add(evlValidator);
					newValidator = existingValidator;
				}
				else {
					//newValidator = existingValidator;
					newValidator = new CompositeEValidator();
					((CompositeEValidator) newValidator).getDelegates().add(evlValidator);
					((CompositeEValidator) newValidator).getDelegates().add(existingValidator);
				}
				
				if (newValidator != existingValidator) {
					EValidator.Registry.INSTANCE.put(ePackage, newValidator);
				}
				
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		}
		
	}

}
