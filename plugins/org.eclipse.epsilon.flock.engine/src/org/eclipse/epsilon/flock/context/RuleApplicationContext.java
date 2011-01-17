/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.flock.context;

import org.eclipse.epsilon.flock.equivalences.Equivalence;
import org.eclipse.epsilon.flock.execution.EolExecutor;
import org.eclipse.epsilon.flock.execution.MigrateRuleContext;

public class RuleApplicationContext {

	private final EolExecutor executor;
	
	public RuleApplicationContext(EolExecutor executor) {
		this.executor = executor;
	}
	
	public MigrateRuleContext getMigrateRuleContextFor(Equivalence equivalence) {
		return new MigrateRuleContext(equivalence, executor);
	}
}
