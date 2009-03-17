/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.evl.emf.validation;

import java.net.URISyntaxException;
import java.net.URL;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.epsilon.common.dt.util.LogUtil;
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
				
				
				EValidator evlValidator = null;
				if (url.toString().endsWith("evl")) {
					String modelName = configurationElement.getAttribute("modelName");
					if (modelName == null || modelName.trim().length() == 0) modelName = EvlValidator.DEFAULT_MODEL_NAME;
					evlValidator = new EvlValidator(url.toURI(), modelName, ePackageUri);
				}
				else {
					evlValidator = new OclValidator(url.toURI());
				}
				
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
				
			} catch (Exception e) {
				LogUtil.log(e);
			}
		}
		
	}

}
