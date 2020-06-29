/*********************************************************************
 * Copyright (c) 2020 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *********************************************************************/
package org.eclipse.epsilon.pinset.dt.launching.tabs;

import org.eclipse.epsilon.common.dt.EpsilonPlugin;
import org.eclipse.epsilon.common.dt.launching.tabs.AbstractSourceConfigurationTab;
import org.eclipse.epsilon.pinset.dt.PinsetPlugin;

/**
 * PinsetSourceConfigurationTab.
 *
 * @author Alfonso de la Vega
 * @since 2.1
 */
public class PinsetSourceConfigurationTab extends AbstractSourceConfigurationTab {

	@Override
	public EpsilonPlugin getPlugin() {
		return PinsetPlugin.getDefault();
	}

	@Override
	public String getImagePath() {
		return "icons/edl.png";
	}

	@Override
	public String getFileExtension() {
		return "pinset";
	}

	@Override
	public String getSelectionTitle() {
		return "Select a Pinset file";
	}

	@Override
	public String getSelectionSubtitle() {
		return "Pinset files in Workspace";
	}

	public String getLaunchConfigurationKey() {
		return "SOURCE";
	}

}
