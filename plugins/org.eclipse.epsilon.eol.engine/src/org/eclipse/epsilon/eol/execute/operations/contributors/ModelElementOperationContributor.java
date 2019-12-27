/*******************************************************************************
 * Copyright (c) 2018 Aston University.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
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
		IModel model = context.getModelRepository().getOwningModel(getTarget());
		return model.getElementId(getTarget());
	}

}
