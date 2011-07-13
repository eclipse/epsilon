/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.dt.extensions.templateFactoryType;


import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.epsilon.egl.dt.extensions.ExtensionSpecificationFactory;

public class TemplateFactoryTypeSpecificationFactory extends ExtensionSpecificationFactory<TemplateFactoryTypeSpecification> {

	private static final String TEMPLATE_FACTORY_TYPE_EXT_POINT_ID = "org.eclipse.epsilon.egl.dt.templateFactoryType";
	
	@Override
	protected String getExtensionPointIdentifier() {
		return TEMPLATE_FACTORY_TYPE_EXT_POINT_ID;
	}

	@Override
	protected TemplateFactoryTypeSpecification createExtensionSpecification(IConfigurationElement extension) {
		return new TemplateFactoryTypeSpecification(extension);
	}
}
