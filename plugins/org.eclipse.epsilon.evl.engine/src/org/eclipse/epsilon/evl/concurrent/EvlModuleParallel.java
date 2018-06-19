package org.eclipse.epsilon.evl.concurrent;

import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.evl.EvlModule;
import org.eclipse.epsilon.evl.dom.Constraint;
import org.eclipse.epsilon.evl.dom.ConstraintContext;
import org.eclipse.epsilon.evl.execute.concurrent.*;
import org.eclipse.epsilon.evl.execute.context.concurrent.EvlContextParallel;
import org.eclipse.epsilon.evl.execute.context.concurrent.IEvlContextParallel;

public abstract class EvlModuleParallel extends EvlModule {

	public static final EvlModuleParallel getDefaultImpl() {
		return new EvlModuleParallelElements();
	}
	
	@Override
	protected abstract void checkConstraints() throws EolRuntimeException;
	
	public EvlModuleParallel() {
		context = new EvlContextParallel();
	}
	
	public EvlModuleParallel(int parallelism) {
		this(parallelism, true);
	}
	
	protected EvlModuleParallel(int parallelism, boolean threadSafeBaseFrames) {
		context = new EvlContextParallel(parallelism, threadSafeBaseFrames);
	}
	
	@Override
	protected void prepareExecution() throws EolRuntimeException {
		super.prepareExecution();
		getContext().goParallel();
	}
	
	@Override
	protected void postExecution() throws EolRuntimeException {
		getContext().endParallel();
		super.postExecution();
	}
	
	@Override
	public IEvlContextParallel getContext() {
		return (IEvlContextParallel) context;
	}
	
	@Override
	public void setContext(IEolContext context) {
		if (context instanceof IEvlContextParallel) {
			super.setContext(context);
		}
	}
	
	protected ArrayList<ConstraintAtom> getConstraintJobs() throws EolRuntimeException {
		IEvlContextParallel context = getContext();
		ArrayList<ConstraintAtom> atoms = new ArrayList<>();
		
		for (ConstraintContext constraintContext : getConstraintContexts()) {
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
	
	protected ArrayList<ConstraintContextAtom> getContextJobs() throws EolRuntimeException {
		IEvlContextParallel context = getContext();
		ArrayList<ConstraintContextAtom> atoms = new ArrayList<>();
		
		for (ConstraintContext constraintContext : getConstraintContexts()) {
			Collection<?> allOfKind = constraintContext.getAllOfSourceKind(context);
			atoms.ensureCapacity(atoms.size()+allOfKind.size());
			for (Object element : allOfKind) {
				atoms.add(new ConstraintContextAtom(constraintContext, element));
			}
		}
		
		return atoms;
	}
}
