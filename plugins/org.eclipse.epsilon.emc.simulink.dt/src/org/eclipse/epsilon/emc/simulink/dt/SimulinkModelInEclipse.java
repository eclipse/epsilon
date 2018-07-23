/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.emc.simulink.dt;

import org.eclipse.epsilon.common.dt.EpsilonCommonsPlugin;
import org.eclipse.epsilon.emc.simulink.model.SimulinkModel;

public class SimulinkModelInEclipse extends SimulinkModel {
	
	public SimulinkModelInEclipse() {
		this.engineJarPath = EpsilonCommonsPlugin.getDefault().getPreferenceStore().getString(SimulinkModel.PROPERTY_ENGINE_JAR_PATH);
		this.libraryPath = EpsilonCommonsPlugin.getDefault().getPreferenceStore().getString(SimulinkModel.PROPERTY_LIBRARY_PATH);
	}
	
}
