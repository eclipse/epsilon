/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.concordance.dt;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.resource.Resource;

//  FIXME : duplication with HUTN XMI DT's RegisteredMetamodels
public class ResourceCategoriser {
	
	public boolean isModel(IResource resource) {
		final String extension = resource.getFileExtension();
		
		return isARegisterMetamodelFileExtension(extension) || isAnExplicitModelFileExtension(extension);
	}

	private boolean isARegisterMetamodelFileExtension(String resourceExtension) {
		return getFileExtensionsOfAllRegisteredMetamodels().contains(resourceExtension);
	}
	
	private Collection<String> getFileExtensionsOfAllRegisteredMetamodels() {
		return Collections.unmodifiableCollection(Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().keySet());
	}

	private boolean isAnExplicitModelFileExtension(String resourceExtension) {
		return "model".equals(resourceExtension) || "xmi".equals(resourceExtension);
	}
}
