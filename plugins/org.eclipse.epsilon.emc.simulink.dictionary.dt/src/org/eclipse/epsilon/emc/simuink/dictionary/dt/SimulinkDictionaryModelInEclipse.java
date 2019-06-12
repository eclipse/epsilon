/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.emc.simuink.dictionary.dt;

import org.eclipse.epsilon.common.dt.EpsilonCommonsPlugin;
import org.eclipse.epsilon.emc.simulink.dictionary.model.SimulinkDictionaryModel;
import org.eclipse.epsilon.emc.simulink.model.AbstractSimulinkModel;

public class SimulinkDictionaryModelInEclipse extends SimulinkDictionaryModel {
	
	public SimulinkDictionaryModelInEclipse() {
		this.engineJarPath = EpsilonCommonsPlugin.getDefault().getPreferenceStore().getString(AbstractSimulinkModel.PROPERTY_ENGINE_JAR_PATH);
		this.libraryPath = EpsilonCommonsPlugin.getDefault().getPreferenceStore().getString(AbstractSimulinkModel.PROPERTY_LIBRARY_PATH);
	}
	
}