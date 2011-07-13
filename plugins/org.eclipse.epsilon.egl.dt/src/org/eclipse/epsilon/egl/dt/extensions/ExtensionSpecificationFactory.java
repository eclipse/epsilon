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
package org.eclipse.epsilon.egl.dt.extensions;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

public abstract class ExtensionSpecificationFactory<T extends ExtensionSpecification<?>> {

	protected abstract String getExtensionPointIdentifier();
	protected abstract T createExtensionSpecification(IConfigurationElement extension);
	
	
	public int indexOf(String templateFactoryTypeIdentifier) {
		int specIndex = 0;
		
		for (T spec : loadAllFromExtensionPoints()) {
			if (spec.getIdentifier().equals(templateFactoryTypeIdentifier)) {
				return specIndex;
			}
			specIndex++;
		}
		
		return 0;
	}

	public T findByIndex(int index) {
		return loadAllFromExtensionPoints().get(index);
	}

	public Collection<T> findByIdentifiers(Collection<String> identifiers) {
		final Collection<T> specs = new LinkedList<T>();
		
		for (String identifier : identifiers) {
			specs.add(findByIdentifier(identifier));
		}
		
		return specs;
	}

	public T findByIdentifier(String identifier) {
		for (T spec : loadAllFromExtensionPoints()) {
			if (identifier.equals(spec.getIdentifier())) {
				return spec;
			}
		}
		
		throw new ExtensionLocatorException("Could not find extension with identifier '" + identifier + "'");
	}

	public List<T> loadAllFromExtensionPoints() {
		final List<T> specs = new LinkedList<T>();
		
		for (IConfigurationElement extension : getFormatterExtensionDefinitions()) {
			specs.add(createExtensionSpecification(extension));
		} 
		
		return specs;
	}

	private IConfigurationElement[] getFormatterExtensionDefinitions() {
		return Platform.getExtensionRegistry().getConfigurationElementsFor(getExtensionPointIdentifier());
	}
}
