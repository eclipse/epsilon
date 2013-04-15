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

import org.eclipse.epsilon.common.dt.AbstractEpsilonUIPlugin;
import org.eclipse.epsilon.concordance.history.ConcordanceHistory;
import org.eclipse.epsilon.concordance.index.ConcordanceIndex;
import org.eclipse.epsilon.concordance.index.H2ConcordanceIndexFactory;
import org.eclipse.epsilon.concordance.reporter.metamodel.MetamodelChangeReporter;
import org.eclipse.epsilon.concordance.reporter.model.ModelChangeReporter;
import org.osgi.framework.BundleContext;

/**
 * The main plugin class to be used in the desktop.
 */
public class ConcordancePlugin extends AbstractEpsilonUIPlugin {

	private final ConcordanceHistory history = new ConcordanceHistory();
	
	private final MetamodelChangeReporter metamodelChangeReporter = new MetamodelChangeReporter();
	private final MetamodelChangeReporterScheduler metamodelChangeReporterScheduler = new MetamodelChangeReporterScheduler(metamodelChangeReporter);
	private final ModelChangeReporter modelChangeReporter = new ModelChangeReporter();
	private ConcordanceIndex index;	
	
	/**
	 * This method is called upon plug-in activation
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
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
	}

	public ConcordanceIndex getIndex() {
		return index;
	}
	
	public MetamodelChangeReporter getMetamodelChangeReporter() {
		return metamodelChangeReporter;
	}
	
	public MetamodelChangeReporterScheduler getMetamodelChangeReporterScheduler() {
		return metamodelChangeReporterScheduler;
	}
	
	public ModelChangeReporter getModelChangeReporter() {
		return modelChangeReporter;
	}
	
	public ConcordanceHistory getHistory() {
		return history;
	}
	
	public static ConcordancePlugin getDefault() {
		return (ConcordancePlugin) plugins.get(ConcordancePlugin.class);
	}
}
