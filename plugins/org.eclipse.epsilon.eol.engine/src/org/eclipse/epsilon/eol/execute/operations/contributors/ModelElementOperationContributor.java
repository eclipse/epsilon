/*******************************************************************************
 * Copyright (c) 2018 Aston University.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Antonio Garcia-Dominguez - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.execute.operations.contributors;

import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.models.ModelRepository;

public class ModelElementOperationContributor extends OperationContributor {
	
	@Override
	public boolean contributesTo(Object target) {
		if (context != null) {
			ModelRepository repository = context.getModelRepository();
			if (repository != null) {
				return repository.getOwningModel(target) != null;
			}
		}
		return false;
	}

	public String id() throws Exception {
		IModel model = context.getModelRepository().getOwningModel(target);
		return model.getElementId(target);
	}

}
