/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Antonio Garcia-Dominguez - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.workflow.tasks.extensions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.RegistryFactory;
import org.eclipse.epsilon.eol.eunit.EUnitTestListener;

/**
 * Class which looks up and creates the instances of the classes referred to
 * through the EUnitListener extension point. These listeners will be subscribed to
 * the EUnitModule created by the Ant task, after the task itself (which is also a
 * listener).
 *
 * @author Antonio García-Domínguez
 * @version 1.0
 */
public class EUnitListenerExtension {

	private static final String CLASS_PROPERTY = "class";
	private final static String ID = "org.eclipse.epsilon.workflow.eunit.listener";
	private final IConfigurationElement configElement;

	/**
	 * Creates a new instance.
	 *
	 * @param configElement Configuration element from the extension element.
	 */
	public EUnitListenerExtension(IConfigurationElement configElement) {
		this.configElement = configElement;
	}

	/**
	 * Returns a list with the available extensions for this extension point.
	 */
	public static List<EUnitListenerExtension> getInstances() {
		List<EUnitListenerExtension> instances = new ArrayList<EUnitListenerExtension>();

		IExtensionRegistry registry = RegistryFactory.getRegistry();
		if (registry == null) {
			// We're running the task inside a JUnit test
			return instances;
		}

		IExtensionPoint point = registry.getExtensionPoint(ID);
		IConfigurationElement[] configElements = point
				.getConfigurationElements();

		for (IConfigurationElement configElement : configElements) {
			EUnitListenerExtension ext = new EUnitListenerExtension(
					configElement);
			instances.add(ext);
		}

		return instances;
	}

	/**
	 * Returns a list with the test listeners registered in the available
	 * extensions for this extension point.
	 */
	public static List<EUnitTestListener> getListeners() throws EUnitIllegalExtensionException {
		List<EUnitTestListener> listeners = new ArrayList<EUnitTestListener>();
		for (EUnitListenerExtension ext : getInstances()) {
			listeners.add(ext.createInstance());
		}
		return listeners;
	}

	/**
	 * Returns the fully qualified class name of the listener, as set in the extension.
	 */
	public String getClassName() {
		return configElement.getAttribute(CLASS_PROPERTY);
	}

	/**
	 * Instantiates the class referred to in the extension.
	 */
	public EUnitTestListener createInstance() throws EUnitIllegalExtensionException {
		try {
			Object instance = configElement.createExecutableExtension(CLASS_PROPERTY);
			if (instance instanceof EUnitTestListener) {
				return (EUnitTestListener) instance;
			} else {
				throw new EUnitIllegalExtensionException(
						getClassName()
								+ " was reported to be a EUnitTestListener, but it was not");
			}
		} catch (Exception ex) {
			throw new EUnitIllegalExtensionException(ex);
		}
	}
}
