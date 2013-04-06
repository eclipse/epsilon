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
