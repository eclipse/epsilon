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
package org.eclipse.epsilon.hutn.generate;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.hutn.exceptions.HutnGenerationException;
import org.eclipse.epsilon.hutn.util.EmfUtil;

public abstract class AbstractGenerator {

	public EmfModel generate() throws HutnGenerationException {
		return generate(EmfUtil.createResource());
	}
	
	public void generate(File path) throws HutnGenerationException {
		EmfModel target = null;
		
		try {
			final Resource resource = EmfUtil.createResource(URI.createFileURI(path.getAbsolutePath()));
			target = generate(resource);
			
			target.store(path.getAbsolutePath());
	
		} finally {
			// Ensure that the model is always disposed, so that
			// its contents don't remain in memory and included
			// in the next call to generate
			
			if (target != null)
				target.dispose();
		}
	}
	
	protected abstract EmfModel generate(Resource resource) throws HutnGenerationException;
}
