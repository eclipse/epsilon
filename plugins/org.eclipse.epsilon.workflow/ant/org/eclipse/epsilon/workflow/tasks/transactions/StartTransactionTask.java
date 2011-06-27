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
package org.eclipse.epsilon.workflow.tasks.transactions;

import org.apache.tools.ant.BuildException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelNotFoundException;
import org.eclipse.epsilon.eol.models.transactions.CompositeModelTransactionSupport;
import org.eclipse.epsilon.eol.models.transactions.IModelTransactionSupport;
import org.eclipse.epsilon.workflow.tasks.common.EpsilonTask;
import org.eclipse.epsilon.workflow.tasks.common.NamedTransactionSupport;

public class StartTransactionTask extends EpsilonTask {
	
	protected String name = null;
	protected String models = null;
	
	@Override
	public void executeImpl() throws BuildException {
		IModelTransactionSupport transactionSupport;
		if (models == null) {
			transactionSupport = getProjectRepository().getTransactionSupport();
		}
		else {
			transactionSupport = new CompositeModelTransactionSupport();
			for (String model : models.split(",")) {
				try {
					((CompositeModelTransactionSupport) transactionSupport).
					getModels().add(
					getProjectRepository().getModelByName(model.trim()));
				} catch (EolModelNotFoundException e) {
					throw new BuildException(e.getReason());
				}
			}
		}
		NamedTransactionSupport namedTransactionSupport = new 
			NamedTransactionSupport(name, transactionSupport);
		getActiveTransactions().add(namedTransactionSupport);
		namedTransactionSupport.startTransaction();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModels() {
		return models;
	}

	public void setModels(String models) {
		this.models = models;
	}
}
