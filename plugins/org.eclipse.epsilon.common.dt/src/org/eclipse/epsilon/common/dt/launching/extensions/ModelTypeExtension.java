/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.common.dt.launching.extensions;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.epsilon.common.dt.launching.dialogs.AbstractModelConfigurationDialog;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;

public class ModelTypeExtension {
	
	protected String label;
	protected String type;
	protected Image image;
	protected String clazz;
	protected IConfigurationElement configurationElement;
	protected boolean stable;
	
	public ModelTypeExtension() {
		
	}
	
	public ModelTypeExtension(String label, String type, Image image, boolean stable){
		this.label = label;
		this.type = type;
		this.image = image;
		this.stable = stable;
	}

	public void setStable(boolean stable) {
		this.stable = stable;
	}
	
	public boolean isStable() {
		return stable;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image icon) {
		this.image = icon;
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
	
	public AbstractModelConfigurationDialog createDialog() throws CoreException {
		return (AbstractModelConfigurationDialog) configurationElement.createExecutableExtension("dialog");
	}

	public IModel createModel() throws CoreException {
		return (IModel) configurationElement.createExecutableExtension("class");
	}
	
	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	
	public static ModelTypeExtension forType(String type) {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint extensionPoint = registry.getExtensionPoint("org.eclipse.epsilon.common.dt.modelType");
		IConfigurationElement[] configurationElements =  extensionPoint.getConfigurationElements();
		for (int i=0;i<configurationElements.length; i++){
			IConfigurationElement configurationElement = configurationElements[i];
			
			if (configurationElement.getAttribute("type").equalsIgnoreCase(type)) {
				ModelTypeExtension modelType = new ModelTypeExtension();
				modelType.configurationElement = configurationElement;
				modelType.setClazz(configurationElement.getAttribute("class"));
				modelType.setType(configurationElement.getAttribute("type"));
				modelType.setLabel(configurationElement.getAttribute("label"));
				String contributingPlugin = configurationElement.getDeclaringExtension().getNamespaceIdentifier();
				//URL iconUrl = Platform.getBundle(contributingPlugin).getResource(configurationElement.getAttribute("icon"));
				Image image = AbstractUIPlugin.imageDescriptorFromPlugin(contributingPlugin,configurationElement.getAttribute("icon")).createImage();
				modelType.setImage(image);
				return modelType;
			}
		}
		return null;
	}

	public IConfigurationElement getConfigurationElement() {
		return configurationElement;
	}

	public void setConfigurationElement(IConfigurationElement configurationElement) {
		this.configurationElement = configurationElement;
	}
	
}
