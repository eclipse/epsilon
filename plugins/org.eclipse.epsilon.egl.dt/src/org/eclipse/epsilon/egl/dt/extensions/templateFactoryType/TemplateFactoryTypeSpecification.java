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

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.epsilon.egl.EglTemplateFactory;
import org.eclipse.epsilon.egl.dt.extensions.formatter.FormatterLocatorException;

// FIXME duplication with FormatterSpecification
// FIXME generalise FormatterLocatorException, and use the generalised version
public class TemplateFactoryTypeSpecification {

	private static final String FORMATTER_EXT_POINT_ID = "org.eclipse.epsilon.egl.dt.templateFactoryType";

	public static int indexOf(String templateFactoryTypeIdentifier) {
		int specIndex = 0;
		
		for (TemplateFactoryTypeSpecification spec : loadAllFromExtensionPoints()) {
			if (spec.getIdentifier().equals(templateFactoryTypeIdentifier)) {
				return specIndex;
			}
			specIndex++;
		}
		
		return 0;
	}
	
	public static TemplateFactoryTypeSpecification findByIndex(int index) {
		return loadAllFromExtensionPoints().get(index);
	}
	
	public static Collection<TemplateFactoryTypeSpecification> findByIdentifiers(Collection<String> identifiers) {
		final Collection<TemplateFactoryTypeSpecification> specs = new LinkedList<TemplateFactoryTypeSpecification>();
		
		for (String identifier : identifiers) {
			specs.add(findByIdentifier(identifier));
		}
		
		return specs;
	}

	public static TemplateFactoryTypeSpecification findByIdentifier(String identifier) {
		for (TemplateFactoryTypeSpecification spec : loadAllFromExtensionPoints()) {
			if (identifier.equals(spec.getIdentifier())) {
				return spec;
			}
		}
		
		throw new FormatterLocatorException("Could not find formatter with idenifier '" + identifier + "'");
	}

	public static List<TemplateFactoryTypeSpecification> loadAllFromExtensionPoints() {
		final List<TemplateFactoryTypeSpecification> specs = new LinkedList<TemplateFactoryTypeSpecification>();
		
		for (IConfigurationElement extension : getFormatterExtensionDefinitions()) {
			specs.add(new TemplateFactoryTypeSpecification(extension));
		} 
		
		return specs;
	}
	
	private static IConfigurationElement[] getFormatterExtensionDefinitions() {
		return Platform.getExtensionRegistry().getConfigurationElementsFor(FORMATTER_EXT_POINT_ID);
	}

	
	private final EglTemplateFactory implementation;
	private final String name;
	
	public TemplateFactoryTypeSpecification(IConfigurationElement extension) {
		try {
			this.implementation = (EglTemplateFactory)extension.createExecutableExtension("implementation");
			this.name = extension.getAttribute("name");
		
		} catch (CoreException e) {
			throw new FormatterLocatorException("Error encountered whilst loading formatter from extension point in: " + 
			                                    extension.getDeclaringExtension().getNamespaceIdentifier(),
			                                    e);
		}
	}
	
	public String getName() {
		return name;
	}

	public String getIdentifier() {
		return implementation.getClass().getCanonicalName();
	}
	
	public EglTemplateFactory instantiate() {
		return implementation;
	}

	public static String getDefault() {
		return loadAllFromExtensionPoints().iterator().next().getIdentifier();
	}
}
