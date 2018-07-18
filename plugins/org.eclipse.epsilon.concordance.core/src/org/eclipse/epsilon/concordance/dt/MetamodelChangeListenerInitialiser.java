/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.concordance.dt;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.concordance.reporter.metamodel.MetamodelChangeListener;
import org.eclipse.epsilon.concordance.reporter.metamodel.MetamodelChangeReporter;

public class MetamodelChangeListenerInitialiser {

	private static final String METAMODEL_CHANGE_LISTENER_EXT_POINT_ID = "org.eclipse.epsilon.concordance.core.MetamodelChangeListener";
	
	public void attachClients(MetamodelChangeReporter reporter) {
		for (IConfigurationElement extPoint : getClientExtensionDefinitions()) {
			new MetamodelChangeListenerExtPoint(extPoint).attach(reporter);
		}
	}

	private static IConfigurationElement[] getClientExtensionDefinitions() {
		return Platform.getExtensionRegistry().getConfigurationElementsFor(METAMODEL_CHANGE_LISTENER_EXT_POINT_ID);
	}
	
	
	private static class MetamodelChangeListenerExtPoint {

		private final MetamodelChangeListener instance;
		
		public MetamodelChangeListenerExtPoint(IConfigurationElement extPoint) {
			instance = instantiateClient(extPoint);
		}

		private MetamodelChangeListener instantiateClient(IConfigurationElement extPoint) {
			try {
				return (MetamodelChangeListener) extPoint.createExecutableExtension("class");
				
			} catch (CoreException e) {
				LogUtil.log("Could not instantiate Concordance Client: " + extPoint.getAttribute("class"), e);
				return null;
			}
		}

		public void attach(MetamodelChangeReporter reporter) {
			if (instance != null) {
				reporter.addListener(instance);
			}
		}
	}
}
