/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.concordance.clients.migration;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.epsilon.concordance.clients.test.ConcordanceClientIntegrationTest;

public abstract class AutomaticMigrationIntegrationTest extends ConcordanceClientIntegrationTest {
	
	protected static void registerMetamodel(EPackage metamodel) throws Exception {
		EPackage.Registry.INSTANCE.put(metamodel.getNsURI(), metamodel);
		waitForEPackageRegistryNotifications();
	}
	
	protected static EPackage dynamicallyLoadPackage(String pluginId, String pathToEcore) {
		URI uri = URI.createPlatformPluginURI(pluginId + pathToEcore, true);
        
		if (!uri.hasFragment()) {
          uri = uri.appendFragment("/");
        }
		
		return (EPackage)(new ResourceSetImpl().getEObject(uri, true));
	}
	
	protected static void waitForMigrationToComplete() throws InterruptedException {
		Thread.sleep(2000);
	}
}
