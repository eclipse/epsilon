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
package org.eclipse.epsilon.ecl.dt.launching.tabs;

import org.eclipse.epsilon.common.dt.EpsilonPlugin;
import org.eclipse.epsilon.common.dt.launching.AbstractSourceConfigurationTab;
import org.eclipse.epsilon.ecl.dt.EclPlugin;

public class EclSourceConfigurationTab extends AbstractSourceConfigurationTab{

	@Override
	public EpsilonPlugin getPlugin() {
		return EclPlugin.getDefault();
	}

	@Override
	public String getImagePath() {
		return "icons/ecl.gif";
	}

	@Override
	public String getFileExtension() {
		return "ecl";
	}

	@Override
	public String getSelectionTitle() {
		return "Select an ECL Comparison";
	}

	@Override
	public String getSelectionSubtitle() {
		return "ECL Comparisons in Workspace";
	}

	public String getLaunchConfigurationKey() {
		return "SOURCE.ECL";
	}

	//public String getTitle() {
	//	return "ECL Source";
	//}

}
