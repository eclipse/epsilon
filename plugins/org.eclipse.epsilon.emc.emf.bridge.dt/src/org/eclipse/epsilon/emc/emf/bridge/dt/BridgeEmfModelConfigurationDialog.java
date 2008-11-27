package org.eclipse.epsilon.emc.emf.bridge.dt;
import org.eclipse.epsilon.emc.emf.dt.EmfModelConfigurationDialog;

/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/

public class BridgeEmfModelConfigurationDialog extends EmfModelConfigurationDialog {

	@Override
	protected String getModelName() {
		return "EMF Bridge Model";
	}

	@Override
	protected String getModelType() {
		return "BridgeEMF";
	}
	
}
 