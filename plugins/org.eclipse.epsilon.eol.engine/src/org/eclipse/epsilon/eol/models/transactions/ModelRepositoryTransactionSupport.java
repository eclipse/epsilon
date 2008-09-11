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
package org.eclipse.epsilon.eol.models.transactions;

import java.util.List;

import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.models.ModelRepository;

public class ModelRepositoryTransactionSupport extends CompositeModelTransactionSupport {
	
	protected ModelRepository repository;
	
	public ModelRepositoryTransactionSupport(ModelRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<IModel> getModels() {
		return repository.getModels();
	}
	
}
