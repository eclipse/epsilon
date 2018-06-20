package org.eclipse.epsilon.evl.execute.concurrent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.evl.dom.Constraint;
import org.eclipse.epsilon.evl.dom.ConstraintContext;
import org.eclipse.epsilon.evl.execute.UnsatisfiedConstraint;
import org.eclipse.epsilon.evl.execute.context.IEvlContext;

public class ConstraintAtom extends EvlAtom<Constraint> {
	
	public ConstraintAtom(Constraint constraint, Object modelElement, IEvlContext evlContext) {
		super(constraint, modelElement, evlContext);
	}
	
	public ConstraintAtom(Constraint constraint, Object modelElement) {
		super(constraint, modelElement);
	}
	
	public Optional<UnsatisfiedConstraint> execute(IEvlContext context) throws EolRuntimeException {
		return unit.execute(element, context);
	}
	
	public static ArrayList<ConstraintAtom> getConstraintJobs(IEvlContext context) throws EolRuntimeException {
		ArrayList<ConstraintAtom> atoms = new ArrayList<>();
		
		for (ConstraintContext constraintContext : context.getModule().getConstraintContexts()) {
			Collection<?> allOfKind = constraintContext.getAllOfSourceKind(context);
			for (Object element : allOfKind) {
				if (constraintContext.shouldBeChecked(element, context)) {
					Collection<Constraint> constraints = constraintContext.getConstraints();
					atoms.ensureCapacity(atoms.size()+(constraints.size()*allOfKind.size()));
					
					for (Constraint constraint : constraints) {
						atoms.add(new ConstraintAtom(constraint, element));
					}
				}
			}
		}
		
		return atoms;
	}
}
