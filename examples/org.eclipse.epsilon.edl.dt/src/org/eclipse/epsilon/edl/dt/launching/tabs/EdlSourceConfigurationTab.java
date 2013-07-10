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
package org.eclipse.epsilon.edl.dt.launching.tabs;

import org.eclipse.epsilon.common.dt.EpsilonPlugin;
import org.eclipse.epsilon.common.dt.launching.AbstractSourceConfigurationTab;
import org.eclipse.epsilon.edl.dt.EdlPlugin;

public class EdlSourceConfigurationTab extends AbstractSourceConfigurationTab{

	@Override
	public EpsilonPlugin getPlugin() {
		return EdlPlugin.getDefault();
	}

	@Override
	public String getImagePath() {
		return "icons/ecl.gif";
	}

	@Override
	public String getFileExtension() {
		return "edl";
	}

	@Override
	public String getSelectionTitle() {
		return "Select an EDL Demo";
	}

	@Override
	public String getSelectionSubtitle() {
		return "EDL Demos in Workspace";
	}

	public String getLaunchConfigurationKey() {
		return "SOURCE";
	}

}
