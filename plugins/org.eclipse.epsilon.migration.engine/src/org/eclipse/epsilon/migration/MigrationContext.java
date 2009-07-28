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
package org.eclipse.epsilon.migration;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.EolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.types.EolBoolean;
import org.eclipse.epsilon.migration.copy.Copier;
import org.eclipse.epsilon.migration.copy.CopyingException;
import org.eclipse.epsilon.migration.execution.Equivalence;
import org.eclipse.epsilon.migration.execution.Equivalences;
import org.eclipse.epsilon.migration.model.MigrationRule;
import org.eclipse.epsilon.migration.model.MigrationStrategy;

public class MigrationContext extends EolContext implements IMigrationContext {

	private final IModel originalModel;
	private final IModel targetModel;
	
	private final Equivalences equivalences = new Equivalences();
	
	public MigrationContext() {
		this(null, null);
	}
	
	public MigrationContext(IModel original, IModel target) {
		this.originalModel = original;
		this.targetModel   = target;
		
		addModel(original);
		addModel(target);
	}
	
	private void addModel(IModel model) {
		if (model != null)
			getModelRepository().addModel(model);
	}
	
	public String typeNameOfOriginalModelElement(Object original) {
		return originalModel.getTypeNameOf(original);
	}
	
	public Object createTargetModelElement(String type) throws EolRuntimeException {
		return targetModel.createInstance(type);
	}
	
	public Object executeBlock(AST block, Variable... variables) throws EolRuntimeException {
		enterProtectedFrame(block, variables);
		
		final Object result = getExecutorFactory().executeAST(block, this);
		
		leaveFrame(block);
		
		return result;
	}

	public boolean executeGuard(AST guard, Variable originalVar) {
		enterProtectedFrame(guard, originalVar);
		
		final EolBoolean guardSatisfied = (EolBoolean)getExecutorFactory().executeBlockOrExpressionAst(guard, this, EolBoolean.FALSE);
		
		leaveFrame(guard);
		
		return guardSatisfied.booleanValue();
	}
	
	
	public IModel execute(MigrationStrategy strategy) {
		try {
			reset();
			establishEquivalences(strategy);
			migrateUsing(strategy);
			
		} catch (EolRuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (CopyingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return targetModel;
	}

	private void reset() {
		equivalences.clear();
	}
	
	void establishEquivalences(MigrationStrategy strategy) throws EolRuntimeException {
		for (Object original : originalModel.contents()) {
			equivalences.add(establishEquivalence(strategy, original));
		}
	}
	
	Equivalence establishEquivalence(MigrationStrategy strategy, Object original) throws EolRuntimeException {
		final MigrationRule rule = strategy.ruleFor(original, this);
		
		return new Equivalence(original, createTargetModelElement(rule.getTargetType()));
	}
	
	private void migrateUsing(MigrationStrategy strategy) throws CopyingException {
		final Copier copier = new Copier(originalModel, targetModel, equivalences);
		
		for (Equivalence equivalence : equivalences) {
			copier.copy(equivalence.getOriginal(), equivalence.getCopy());
			strategy.migrate(equivalence.getOriginal(), equivalence.getCopy(), this);
		}
	}
}
