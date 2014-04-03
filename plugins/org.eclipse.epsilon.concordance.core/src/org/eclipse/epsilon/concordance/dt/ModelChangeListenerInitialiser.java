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
package org.eclipse.epsilon.concordance.dt;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.concordance.reporter.model.ModelChangeListener;
import org.eclipse.epsilon.concordance.reporter.model.ModelChangeReporter;

public class ModelChangeListenerInitialiser {

	private static final String MODEL_CHANGE_LISTENER_EXT_POINT_ID = "org.eclipse.epsilon.concordance.core.ModelChangeListener";
	private static final String MODEL_CHANGE_LISTENER_EXT_POINT_CHANGESDATABASE = "changesDatabase";
	
	public void attachAll(ModelChangeReporter reporter) {
		for (IConfigurationElement extPoint : getModelChangeListenerExtensionDefinitions()) {
			new ModelChangeListenerExtPoint(extPoint).attach(reporter);
		}
	}

	private static IConfigurationElement[] getModelChangeListenerExtensionDefinitions() {
		return Platform.getExtensionRegistry().getConfigurationElementsFor(MODEL_CHANGE_LISTENER_EXT_POINT_ID);
	}
	
	
	private static class ModelChangeListenerExtPoint {

		private boolean changesDatabase;
		private final ModelChangeListener instance;

		public ModelChangeListenerExtPoint(IConfigurationElement extPoint) {
			instance = instantiateListener(extPoint);
		}

		private ModelChangeListener instantiateListener(IConfigurationElement extPoint) {
			try {
				changesDatabase = Boolean
						.parseBoolean(extPoint
								.getAttribute(MODEL_CHANGE_LISTENER_EXT_POINT_CHANGESDATABASE));
				return (ModelChangeListener) extPoint.createExecutableExtension("class");

			} catch (CoreException e) {
				LogUtil.log("Could not instantiate Concordance ModelChangeListener: " + extPoint.getAttribute("class"), e);
				return null;
			}
		}

		public void attach(ModelChangeReporter reporter) {
			if (instance != null) {
				reporter.addListener(instance, changesDatabase);
			}
		}
	}
}
