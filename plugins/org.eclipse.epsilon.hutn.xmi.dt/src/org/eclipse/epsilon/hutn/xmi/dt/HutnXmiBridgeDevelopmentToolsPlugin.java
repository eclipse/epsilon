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
package org.eclipse.epsilon.hutn.xmi.dt;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class HutnXmiBridgeDevelopmentToolsPlugin extends AbstractUIPlugin {

	//The shared instance.
	private static HutnXmiBridgeDevelopmentToolsPlugin plugin;
	
	private ModelHashCache modelHashCache;
	
	/**
	 * The constructor.
	 */
	public HutnXmiBridgeDevelopmentToolsPlugin() {
		plugin = this;
	}

	/**
	 * This method is called upon plug-in activation
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		
		modelHashCache = new ModelHashCache(getStateLocation().append("hashCache"));
	}

	/**
	 * This method is called when the plug-in is stopped
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		modelHashCache.store();
		
		super.stop(context);
		plugin = null;
	}

	/**
	 * Returns the shared instance.
	 */
	public static HutnXmiBridgeDevelopmentToolsPlugin getDefault() {
		return plugin;
	}
	
	public ModelHashCache getModelHashCache() {
		return modelHashCache;
	}
}
