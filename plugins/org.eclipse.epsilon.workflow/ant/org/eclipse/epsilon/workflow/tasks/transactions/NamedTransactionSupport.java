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

import org.eclipse.epsilon.eol.models.transactions.IModelTransactionSupport;

public class NamedTransactionSupport implements IModelTransactionSupport {
	
	protected String name;
	protected IModelTransactionSupport transactionSupport;
	
	public NamedTransactionSupport(String name, IModelTransactionSupport transactionSupport) {
		this.name = name;
		this.transactionSupport = transactionSupport;
	}
	
	public void commitTransaction() {
		transactionSupport.commitTransaction();
	}

	public void rollbackTransaction() {
		transactionSupport.rollbackTransaction();
	}

	public void startTransaction() {
		transactionSupport.startTransaction();
	}

	public String getName() {
		return name;
	}

}
