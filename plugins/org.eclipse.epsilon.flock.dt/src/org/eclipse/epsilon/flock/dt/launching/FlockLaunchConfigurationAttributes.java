/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.flock.dt.launching;

import org.eclipse.epsilon.eol.dt.launching.EolLaunchConfigurationAttributes;

public interface FlockLaunchConfigurationAttributes extends EolLaunchConfigurationAttributes{
	
	public static final String ORIGINAL_MODEL = "originalModel";
	public static final String MIGRATED_MODEL = "migratedModel";	
}
