package org.eclipse.epsilon.emc.uml.dt;

import org.eclipse.epsilon.emc.emf.dt.EmfModelConfigurationDialog;

public class UmlModelConfigurationDialog extends EmfModelConfigurationDialog {
	
	@Override
	protected String getModelName() {
		return "UML model";
	}
	
	@Override
	protected String getModelType() {
		return "UML";
	}
	
}
