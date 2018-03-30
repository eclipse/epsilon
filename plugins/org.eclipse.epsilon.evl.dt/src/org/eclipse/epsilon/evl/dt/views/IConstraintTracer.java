package org.eclipse.epsilon.evl.dt.views;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.epsilon.evl.execute.UnsatisfiedConstraint;

public interface IConstraintTracer {
	
	void traceConstraint(UnsatisfiedConstraint constraint, ILaunchConfiguration configuration);

}
