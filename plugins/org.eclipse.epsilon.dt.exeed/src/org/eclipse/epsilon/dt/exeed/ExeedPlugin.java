/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.dt.exeed;

import org.eclipse.epsilon.common.dt.AbstractEpsilonUIPlugin;

public class ExeedPlugin extends AbstractEpsilonUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.epsilon.dt.exeed";

	public static ExeedPlugin getDefault() {
		return (ExeedPlugin) plugins.get(ExeedPlugin.class);
	}

	public static final String EXEED_EDITOR_ID = "org.eclipse.epsilon.dt.exeed.ExeedEditor";

	public static final String MODELINK_EDITOR_ID = "org.eclipse.epsilon.dt.exeed.modelink.ModeLinkEditor";
	


}
