/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.hutn.xmi.dt.startup;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.epsilon.common.dt.nature.AbstractNature;

public class ConformanceCheckingNature extends AbstractNature {

	public static final String ID = "org.eclipse.epsilon.hutn.xmi.dt.nature.ConformanceCheckingNature";

	public void configure() throws CoreException {}

	public void deconfigure() throws CoreException {}
	
	public static boolean hasConformanceCheckingNature(IProject project) throws CoreException {
		return project.hasNature(ID);
	}
}
