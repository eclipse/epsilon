/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.migration.execution;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.migration.IMigrationContext;
import org.eclipse.epsilon.migration.copy.Copier;
import org.eclipse.epsilon.migration.copy.CopyingException;
import org.eclipse.epsilon.migration.model.MigrationRule;
import org.eclipse.epsilon.migration.model.MigrationStrategy;

public class Migration {

	private final MigrationStrategy strategy;
	private final IMigrationContext context;
	
	private final Equivalences equivalences = new Equivalences();
	
	public Migration(MigrationStrategy strategy, IMigrationContext context) {
		this.strategy = strategy;
		this.context  = context;
	}
	
	public void run() {
		try {
			reset();
			establishEquivalences();
			copyAndMigrate();
		
		} catch (EolRuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (CopyingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void reset() {
		equivalences.clear();
	}
	
	private void establishEquivalences() throws EolRuntimeException {
		for (Object original : context.getOriginalModelElements()) {
			equivalences.add(establishEquivalence(original));
		}
	}
	
	private Equivalence establishEquivalence(Object original) throws EolRuntimeException {
		final MigrationRule rule = strategy.ruleFor(original, context);
		final Object migrated = context.createTargetModelElement(rule.getTargetType());
		
		return new Equivalence(original, migrated);
	}
	
	private void copyAndMigrate() throws CopyingException {
		final Copier copier = new Copier(context.getOriginalModel(), context.getTargetModel(), equivalences);
		
		for (Equivalence equivalence : equivalences) {
			copier.copy(equivalence.getOriginal(), equivalence.getCopy());
			strategy.migrate(equivalence.getOriginal(), equivalence.getCopy(), context);
		}
	}
}
