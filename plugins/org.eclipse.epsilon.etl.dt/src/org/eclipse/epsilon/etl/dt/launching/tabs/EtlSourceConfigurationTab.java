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
package org.eclipse.epsilon.etl.dt.launching.tabs;

import org.eclipse.epsilon.common.dt.EpsilonPlugin;
import org.eclipse.epsilon.common.dt.launching.AbstractSourceConfigurationTab;
import org.eclipse.epsilon.etl.dt.EtlPlugin;

public class EtlSourceConfigurationTab extends AbstractSourceConfigurationTab{

	@Override
	public EpsilonPlugin getPlugin() {
		return EtlPlugin.getDefault();
	}

	@Override
	public String getImagePath() {
		return "icons/etl.gif";
	}

	@Override
	public String getFileExtension() {
		return "etl";
	}

	@Override
	public String getSelectionTitle() {
		return "Select an ETL Transformation";
	}

	@Override
	public String getSelectionSubtitle() {
		return "ETL Transformations in Workspace";
	}

	public String getLaunchConfigurationKey() {
		return "SOURCE.ETL";
	}

	//public String getTitle() {
	//	return "ETL Source";
	//}

}
