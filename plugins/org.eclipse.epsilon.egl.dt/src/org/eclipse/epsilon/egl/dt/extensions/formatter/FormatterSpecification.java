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

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.epsilon.egl.formatter.Formatter;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;

public class FormatterSpecification {

	private static final String FORMATTER_EXT_POINT_ID = "org.eclipse.epsilon.egl.dt.formatter";

	public static Collection<FormatterSpecification> findByIdentifiers(Collection<String> identifiers) {
		final Collection<FormatterSpecification> specs = new LinkedList<FormatterSpecification>();
		
		for (String identifier : identifiers) {
			specs.add(findByIdentifier(identifier));
		}
		
		return specs;
	}

	private static FormatterSpecification findByIdentifier(String identifier) {
		for (FormatterSpecification spec : loadAllFromExtensionPoints()) {
			if (identifier.equals(spec.getIdentifier())) {
				return spec;
			}
		}
		
		throw new FormatterLocatorException("Could not find formatter with idenifier '" + identifier + "'");
	}

	public static Collection<FormatterSpecification> loadAllFromExtensionPoints() {
		final List<FormatterSpecification> specs = new LinkedList<FormatterSpecification>();
		
		for (IConfigurationElement formatterExtension : getFormatterExtensionDefinitions()) {
			specs.add(new FormatterSpecification(formatterExtension));
		} 
		
		return specs;
	}
	
	private static IConfigurationElement[] getFormatterExtensionDefinitions() {
		return Platform.getExtensionRegistry().getConfigurationElementsFor(FORMATTER_EXT_POINT_ID);
	}

	
	private final Formatter implementation;
	private final String name;
	private final Image icon;
	
	public FormatterSpecification(IConfigurationElement formatterExtension) {
		try {
			this.implementation = (Formatter)formatterExtension.createExecutableExtension("implementation");
			this.name = formatterExtension.getAttribute("name");
			
			if (formatterExtension.getAttribute("icon") != null) {
				this.icon = AbstractUIPlugin.imageDescriptorFromPlugin(formatterExtension.getContributor().getName(),
				                                                       formatterExtension.getAttribute("icon")).createImage();
			} else {
				this.icon = null;
			}
		
		} catch (CoreException e) {
			throw new FormatterLocatorException("Error encountered whilst loading formatter from extension point in: " + 
			                                    formatterExtension.getDeclaringExtension().getNamespaceIdentifier(),
			                                    e);
		}
	}
	
	public String getName() {
		return name;
	}

	public String getIdentifier() {
		return implementation.getClass().getCanonicalName();
	}
	
	public Formatter instantiate() {
		return implementation;
	}

	public Image getIcon() {
		return icon;
	}
}