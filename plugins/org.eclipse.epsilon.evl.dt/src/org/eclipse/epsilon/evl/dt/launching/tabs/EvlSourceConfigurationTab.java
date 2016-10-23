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
package org.eclipse.epsilon.evl.dt.launching.tabs;

import org.eclipse.epsilon.common.dt.EpsilonPlugin;
import org.eclipse.epsilon.common.dt.launching.AbstractSourceConfigurationTab;
import org.eclipse.epsilon.evl.dt.EvlPlugin;

/**
 * Provides the specific details for selecting an EVL file for execution.
 *
 */
public class EvlSourceConfigurationTab extends AbstractSourceConfigurationTab {

	@Override
	public EpsilonPlugin getPlugin() {
		return EvlPlugin.getDefault();
	}

	@Override
	public String getImagePath() {
		return "icons/evl.gif";
	}

	@Override
	public String getFileExtension() {
		return "evl";
	}

	@Override
	public String getSelectionTitle() {
		return "Select an EVL Validation";
	}

	@Override
	public String getSelectionSubtitle() {
		return "EVL Validations in Workspace";
	}

	public String getLaunchConfigurationKey() {
		return "SOURCE.EVL";
	}

	//public String getTitle() {
	//	return "EVL Source";
	//}

}
