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
package org.eclipse.epsilon.egl.dt.extensions.formatter;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.epsilon.egl.dt.extensions.ExtensionSpecification;
import org.eclipse.epsilon.egl.formatter.Formatter;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;

public class FormatterSpecification extends ExtensionSpecification<Formatter> {

	private final Image icon;
	
	public FormatterSpecification(IConfigurationElement extension) {
		super(extension);
		
		if (extension.getAttribute("icon") != null) {
			this.icon = AbstractUIPlugin.imageDescriptorFromPlugin(extension.getContributor().getName(),
			                                                       extension.getAttribute("icon")).createImage();
		} else {
			this.icon = null;
		}
	}
	
	public Image getIcon() {
		return icon;
	}
}