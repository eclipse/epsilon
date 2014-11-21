package org.eclipse.epsilon.eml.dom;

import java.util.Collection;

import org.eclipse.epsilon.eml.execute.context.EmlContext;
import org.eclipse.epsilon.eol.dom.SpecialAssignmentStatement;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class EquivalentAssignmentStatement extends SpecialAssignmentStatement {
	
	@Override
	public Object getValueEquivalent(Object source, Object value,
			IEolContext context_) throws EolRuntimeException {
		EmlContext context = (EmlContext) context_;
		if (value instanceof Collection){
			return context.getMergingStrategy().getEquivalent(((Collection<?>) value), context, null);
		}
		else {
			return context.getMergingStrategy().getEquivalent(value,context, null);
		}
	}
}
