/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.evl.execute.operations;

import java.util.Collection;
import java.util.List;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.operations.simple.SimpleOperation;
import org.eclipse.epsilon.eol.types.EolNoType;
import org.eclipse.epsilon.evl.dom.Constraint;
import org.eclipse.epsilon.evl.dom.Constraints;
import org.eclipse.epsilon.evl.dom.GlobalConstraintContext;
import org.eclipse.epsilon.evl.execute.context.IEvlContext;
import org.eclipse.epsilon.evl.execute.exceptions.EvlConstraintNotFoundException;
import org.eclipse.epsilon.evl.trace.ConstraintTrace;

//TODO: Detect cyclic dependencies and throw EvlCircularAssumptionException
public class SatisfiesOperation extends SimpleOperation {
	
	protected boolean all = true;
	
	public SatisfiesOperation(boolean all) {
		super();
		this.all = all;
	}
	
	public boolean isAll() {
		return all;
	}
	
	public void setAll(boolean all) {
		this.all = all;
	}

	@Override
	public Object execute(Object source, List<?> parameters, IEolContext context_, ModuleElement ast) throws EolRuntimeException {
		if (source == null)
			return false;
		
		IEvlContext context = (IEvlContext) context_;
		Collection<Constraint> constraintsDependedOn = context.getConstraintsDependedOn();
		ConstraintTrace constraintTrace = context.getConstraintTrace();
		
		assert constraintTrace != null;
		assert constraintsDependedOn != null;
		
		Constraints constraints = context.getModule().getConstraints();
		
		for (Object parameter : parameters) {
			String constraintName = context.getPrettyPrinterManager().toString(parameter);

			Constraint constraint = constraints.getConstraint(constraintName, source, context)
				.orElseThrow(() -> new EvlConstraintNotFoundException(constraintName, ast));
			
			// This is to avoid duplication of global constraints
			if (constraint.getConstraintContext() instanceof GlobalConstraintContext) {
				source = EolNoType.Instance;
			}
			
			boolean valid;	//Check the trace first
			
			if (constraintsDependedOn.contains(constraint) && constraintTrace.isChecked(constraint, source)) {
				valid = constraintTrace.isSatisfied(constraint, source);
			}
			else {
				// Don't call execute() or shouldBeChecked because it might be a lazy constraint, so need to force appliesTo && check.
				if (constraint.appliesTo(source, context)) {
					valid = !constraint.check(source, context).isPresent();
				}
				else {
					valid = false;
				}
				
				constraintTrace.addChecked(constraint, source, valid);
				constraintsDependedOn.add(constraint);
				constraint.setCheckTrace(true);
			}
			
			if (all && !valid)
				return false;
			else if (valid)
				return true;
		}
		
		return true;
	}
}
