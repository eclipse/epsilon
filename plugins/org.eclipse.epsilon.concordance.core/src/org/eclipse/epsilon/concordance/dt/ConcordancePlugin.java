/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.concordance.dt;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.epsilon.common.dt.EpsilonPlugin;
import org.eclipse.epsilon.concordance.history.ConcordanceHistory;
import org.eclipse.epsilon.concordance.index.ConcordanceIndex;
import org.eclipse.epsilon.concordance.index.H2ConcordanceIndexFactory;
import org.eclipse.epsilon.concordance.reporter.model.ModelChangeReporter;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The main plugin class to be used in the desktop.
 */
public class ConcordancePlugin extends AbstractUIPlugin implements EpsilonPlugin {

	//The shared instance.
	private static ConcordancePlugin plugin;
	
	private final ConcordanceHistory history = new ConcordanceHistory();
	
	private final ModelChangeReporter modelChangeReporter = new ModelChangeReporter();
	private ConcordanceIndex index;	
	
	/**
	 * The constructor.
	 */
	public ConcordancePlugin() {
		plugin = this;
	}

	/**
	 * This method is called upon plug-in activation
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		
//		index = new BruteForceConcordanceIndex();
		index = H2ConcordanceIndexFactory.getInstance().createConcordanceIndex(getH2DbStorage(), modelChangeReporter);
	}
	
	private String getH2DbStorage() {
		return getStateLocation().append("h2db").toFile().getAbsolutePath();
	}

	/**
	 * This method is called when the plug-in is stopped
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		H2ConcordanceIndexFactory.getInstance().teardownConcordanceIndex();
		
		super.stop(context);
		plugin = null;
	}

	/**
	 * Returns the shared instance.
	 */
	public static ConcordancePlugin getDefault() {
		return plugin;
	}

	public ConcordanceIndex getIndex() {
		return index;
	}
	
	public ModelChangeReporter getModelChangeReporter() {
		return modelChangeReporter;
	}
	
	public ConcordanceHistory getHistory() {
		return history;
	}
	
	/**
	 * Returns an image transformationStrategyExtension for the image file at the given
	 * plug-in relative path.
	 *
	 * @param path the path
	 * @return the image transformationStrategyExtension
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.epsilon.concordance", path);
	}
	
	/**
	 * This method returns an image from the path
	 * @param path
	 * @return
	 */
	public Image createImage(String path) {
		try {
			URL BASE_URL = ConcordancePlugin.getDefault().getBundle().getEntry("/");
			URL url = new URL(BASE_URL, path);
			return ImageDescriptor.createFromURL(url).createImage();
		}
		catch(MalformedURLException e) {}
		return null;
	}
}
