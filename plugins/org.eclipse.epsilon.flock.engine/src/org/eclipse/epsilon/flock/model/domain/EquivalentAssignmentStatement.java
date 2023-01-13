package org.eclipse.epsilon.flock.model.domain;

import org.eclipse.epsilon.eol.dom.SpecialAssignmentStatement;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.flock.execute.context.IFlockContext;

public class EquivalentAssignmentStatement extends SpecialAssignmentStatement {
	
	@Override
	public Object getValueEquivalent(Object source, Object value, IEolContext context_) throws EolRuntimeException {
		return ((IFlockContext) context_).getConservativeCopyContext().getEquivalent(value);
	}
}
