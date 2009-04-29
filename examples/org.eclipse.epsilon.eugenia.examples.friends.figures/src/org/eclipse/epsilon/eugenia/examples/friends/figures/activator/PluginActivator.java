/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eugenia.examples.friends.figures.activator;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * @generated
 */
public class PluginActivator extends AbstractUIPlugin {

	/**
	 * @generated
	 */
	public static final String ID = "org.eclipse.epsilon.eugenia.examples.friends.figures"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static PluginActivator ourInstance;

	/**
	 * @generated
	 */
	public PluginActivator() {
	}

	/**
	 * @generated
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		ourInstance = this;
	}

	/**
	 * @generated
	 */
	public void stop(BundleContext context) throws Exception {
		ourInstance = null;
		super.stop(context);
	}

	/**
	 * @generated
	 */
	public static PluginActivator getDefault() {
		return ourInstance;
	}
}
