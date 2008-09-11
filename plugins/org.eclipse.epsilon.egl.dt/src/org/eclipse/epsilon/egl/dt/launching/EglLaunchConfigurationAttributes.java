/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.dt.launching;

import org.eclipse.epsilon.eol.dt.launching.EolLaunchConfigurationAttributes;

public interface EglLaunchConfigurationAttributes extends EolLaunchConfigurationAttributes {

	public static final String GENERATE_TO      = "generateTo";
	public static final String OUTPUT_FILE_PATH = "outputFilePath";
	public static final String APPEND_TO_FILE   = "appendToFile";
	
	public static final int GENERATE_TO_CONSOLE = 1;
	public static final int GENERATE_TO_FILE    = 2;
}
