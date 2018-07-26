/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.eol.execute.operations.declarative;

public abstract class SelectBasedOperation extends FirstOrderOperation {

	private SelectOperation delegate = new SelectOperation();
	
	public void setSelectOperation(SelectOperation delegateOp) {
		this.delegate = delegateOp;
	}

	public SelectOperation getSelectOperation() {
		return delegate;
	}
	
}
