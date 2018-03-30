/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.profiling;

public class ExecutionTime {
	
	protected long individual = 0;
	protected long aggregate = 0;
	
	public ExecutionTime() { }
	
	public ExecutionTime(long individual, long aggregate) {
		super();
		this.individual = individual;
		this.aggregate = aggregate;
	}

	public long getIndividual() {
		return individual;
	}
	
	public long getAggregate() {
		return aggregate;
	}
	
	public void setIndividual(long individual) {
		this.individual = individual;
	}
	
	public void setAggregate(long aggregate) {
		this.aggregate = aggregate;
	}
}
