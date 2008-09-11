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
package org.eclipse.epsilon.etl.dt.launching;

import org.eclipse.epsilon.eol.dt.launching.EolLaunchConfigurationAttributes;

public interface EtlLaunchConfigurationAttributes extends EolLaunchConfigurationAttributes{
	
	public static final String SOURCE_MODEL = "sourceModel";
	public static final String TARGET_MODEL = "targetModel";
	public static final String TRANSFORMATION_STRATEGY = "transformationStrategy";
	
}
