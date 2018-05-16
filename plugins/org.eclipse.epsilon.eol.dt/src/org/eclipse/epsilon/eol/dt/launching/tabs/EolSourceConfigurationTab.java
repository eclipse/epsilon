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
package org.eclipse.epsilon.eol.dt.launching.tabs;

import org.eclipse.epsilon.common.dt.EpsilonPlugin;
import org.eclipse.epsilon.common.dt.launching.tabs.AbstractSourceConfigurationTab;
import org.eclipse.epsilon.eol.dt.EolPlugin;

public class EolSourceConfigurationTab extends AbstractSourceConfigurationTab{

	@Override
	public EpsilonPlugin getPlugin() {
		return EolPlugin.getDefault();
	}

	@Override
	public String getImagePath() {
		return "icons/eol.gif";
	}

	@Override
	public String getFileExtension() {
		return "eol";
	}

	@Override
	public String getSelectionTitle() {
		return "Select EOL Program source";
	}

	@Override
	public String getSelectionSubtitle() {
		return "EOL Programs in Workspace";
	}

	//public String getTitle() {
	//	return "EOL Source";
	//}

}
