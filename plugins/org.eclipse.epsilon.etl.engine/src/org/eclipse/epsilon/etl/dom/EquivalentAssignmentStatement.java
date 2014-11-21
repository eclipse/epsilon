package org.eclipse.epsilon.etl.dom;

import java.util.Collection;

import org.eclipse.epsilon.eol.dom.SpecialAssignmentStatement;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.etl.execute.context.IEtlContext;

public class EquivalentAssignmentStatement extends SpecialAssignmentStatement {
	
	@Override
	public Object getValueEquivalent(Object source, Object value,
			IEolContext context_) throws EolRuntimeException {
		IEtlContext context = (IEtlContext) context_;
		if (value instanceof Collection){
			return context.getTransformationStrategy().getEquivalent(((Collection<?>) value), context, null);
		}
		else {
			return context.getTransformationStrategy().getEquivalent(value,context, null);
		}
	}
	
}
