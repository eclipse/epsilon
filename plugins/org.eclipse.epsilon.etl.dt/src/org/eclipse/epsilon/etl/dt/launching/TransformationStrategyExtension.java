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
package org.eclipse.epsilon.etl.dt.launching;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.epsilon.etl.strategy.ITransformationStrategy;

public class TransformationStrategyExtension {
	
	protected String type;
	protected String label;
	protected Class clazz;
	protected String dialog;
	protected IConfigurationElement configurationElement;
	
	public TransformationStrategyExtension() {
		super();
	}

	public IConfigurationElement getConfigurationElement() {
		return configurationElement;
	}

	public void setConfigurationElement(IConfigurationElement configurationElement) {
		this.configurationElement = configurationElement;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public Class getClazz() {
		return clazz;
	}

	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}

	public ITransformationStrategy createStrategy() {
		try {
			return (ITransformationStrategy) configurationElement.createExecutableExtension("class");
		} catch (CoreException e) {
			//PDE.logException(e);
			return null;
		}
	}
	
	public Object createDialog() {
		try {
			return configurationElement.createExecutableExtension("dialog");
		} catch (CoreException e) {
			//PDE.logException(e);
			return null;
		}
	}	
	
	public static TransformationStrategyExtension forType(String type) {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint extenstionPoint = registry.getExtensionPoint("org.eclipse.epsilon.etl.dt.transformationStrategy");
		
		IConfigurationElement[] configurationElements = extenstionPoint.getConfigurationElements();
		
		for (int i=0;i<configurationElements.length;i++) {
			IConfigurationElement configurationElement = configurationElements[i];
			if (configurationElement.getAttribute("type").equalsIgnoreCase(type)){
				TransformationStrategyExtension descriptor = new TransformationStrategyExtension();
				descriptor.setLabel(configurationElement.getAttribute("label"));
				descriptor.setType(configurationElement.getAttribute("type"));
				descriptor.setConfigurationElement(configurationElement);
				return descriptor;
			}
		}
		
		return null;
	}
	
}
