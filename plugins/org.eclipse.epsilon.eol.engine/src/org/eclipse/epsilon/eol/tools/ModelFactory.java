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
package org.eclipse.epsilon.eol.tools;

import org.eclipse.epsilon.eol.exceptions.EolInternalException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.models.IModel;

public class ModelFactory extends AbstractTool{

	public ModelFactory() {
		super();
	}
	
	public IModel createModel(String name, String clazz) throws EolRuntimeException {
		IModel model = null;

		try {
			
			model = (IModel) Thread.currentThread().getContextClassLoader().loadClass(clazz).newInstance();
			model.setName(name);
			context.getModelRepository().addModel(model);
		} 
		catch (Exception e) {
			throw new EolInternalException(e);
		} 
		
		return model;
	}
	
}
