package org.eclipse.epsilon.emc.simulink.dt;

import org.eclipse.epsilon.common.dt.EpsilonCommonsPlugin;
import org.eclipse.epsilon.emc.simulink.model.SimulinkModel;

public class SimulinkModelInEclipse extends SimulinkModel {
	
	public SimulinkModelInEclipse() {
		this.engineJarPath = EpsilonCommonsPlugin.getDefault().getPreferenceStore().getString(SimulinkModel.PROPERTY_ENGINE_JAR_PATH);
		this.libraryPath = EpsilonCommonsPlugin.getDefault().getPreferenceStore().getString(SimulinkModel.PROPERTY_LIBRARY_PATH);
	}
	
}
