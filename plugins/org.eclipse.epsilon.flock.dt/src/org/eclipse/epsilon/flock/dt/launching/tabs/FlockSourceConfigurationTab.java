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
package org.eclipse.epsilon.flock.dt.launching.tabs;

import org.eclipse.epsilon.common.dt.EpsilonPlugin;
import org.eclipse.epsilon.common.dt.launching.AbstractSourceConfigurationTab;
import org.eclipse.epsilon.flock.dt.FlockDevelopmentToolsPlugin;

public class FlockSourceConfigurationTab extends AbstractSourceConfigurationTab{

	@Override
	public EpsilonPlugin getPlugin() {
		return FlockDevelopmentToolsPlugin.getDefault();
	}

	@Override
	public String getImagePath() {
		return "icons/flock16.png";
	}

	@Override
	public String getFileExtension() {
		return "mig";
	}

	@Override
	public String getSelectionTitle() {
		return "Select an Epsilon Flock Migration Strategy";
	}

	@Override
	public String getSelectionSubtitle() {
		return "Epsilon Flock Migration Strategies in Workspace";
	}

	public String getLaunchConfigurationKey() {
		return "SOURCE.MIG";
	}

}
