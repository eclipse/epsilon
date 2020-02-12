package org.eclipse.epsilon.emc.simuink.requirement.dt;
/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/


import org.eclipse.epsilon.emc.simulink.common.dt.AbstractSimulinkModelConfigurationDialog;
import org.eclipse.swt.widgets.Composite;

public class SimulinkRequirementModelConfigurationDialog extends AbstractSimulinkModelConfigurationDialog {

	protected String getModelName() {
		return "Simulink Requirement Model";
	}

	protected String getModelType() {
		return "SimulinkRequirement";
	}

	protected Composite createFilesGroup(Composite parent) {
		final Composite groupContent = super.createFilesGroup(parent);
		modelFileTextLabel.setText("Requirement file (?): ");
		return groupContent;
	}
	
}
