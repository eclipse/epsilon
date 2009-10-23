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
package org.eclipse.epsilon.hutn.dt.nature;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.epsilon.common.dt.nature.ResourceBuildingIncrementalProjectBuilder;
import org.eclipse.epsilon.hutn.dt.util.HutnBuilderHelper;

public class HutnBuilder extends ResourceBuildingIncrementalProjectBuilder {
	
	static final String ID = "org.eclipse.epsilon.hutn.dt.builder.HutnBuilder";

	protected void buildResource(IResource resource, IProgressMonitor monitor) {
		if (resource instanceof IFile && "hutn".equals(resource.getFileExtension())) {
			new HutnBuilderHelper((IFile)resource, monitor).buildHutn();
		}	
	}
}
