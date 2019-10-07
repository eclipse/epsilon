/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.evl.launch;

import java.util.Collection;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.erl.launch.IErlRunConfiguration;
import org.eclipse.epsilon.evl.EvlModule;
import org.eclipse.epsilon.evl.IEvlModule;
import org.eclipse.epsilon.evl.concurrent.EvlModuleParallel;
import org.eclipse.epsilon.evl.concurrent.atomic.EvlModuleParallelContextAtoms;
import org.eclipse.epsilon.evl.execute.UnsatisfiedConstraint;
import org.eclipse.epsilon.evl.execute.context.IEvlContext;
import org.eclipse.epsilon.evl.execute.context.concurrent.EvlContextParallel;

/**
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class EvlRunConfiguration extends IErlRunConfiguration {
	
	@SuppressWarnings("unchecked")
	public static class Builder<R extends EvlRunConfiguration, B extends Builder<R, B>> extends IErlRunConfiguration.Builder<R, B> {
		
		public boolean optimizeTrace, optimizeConstraints, shortCircuit;
		
		public B withShortCircuiting() {
			return withShortCircuiting(true);
		}
		public B withShortCircuiting(boolean sc) {
			this.shortCircuit = sc;
			return (B) this;
		}
		
		public B withOptimizeConstraints() {
			return withOptimizeConstraints(true);
		}
		public B withOptimizeConstraints(boolean optimize) {
			this.optimizeConstraints = optimize;
			return (B) this;
		}
		
		public B withOptimizeConstraintTrace() {
			return withOptimizeConstraintTrace(true);
		}
		public B withOptimizeConstraintTrace(boolean optimize) {
			this.optimizeTrace = optimize;
			return (B) this;
		}
		
		protected Builder() {
			super();
		}
		protected Builder(Class<R> runConfigClass) {
			super(runConfigClass);
		}
		
		@Override
		protected IEvlModule createDefaultModule() {
			return new EvlModule();
		}
		
		@Override
		protected EvlModuleParallel createParallelModule() {
			return new EvlModuleParallelContextAtoms(new EvlContextParallel(parallelism));
		}
	}
	
	public static Builder<? extends EvlRunConfiguration, ?> Builder() {
		return new Builder<>(EvlRunConfiguration.class);
	}
	
	public EvlRunConfiguration(IErlRunConfiguration.Builder<? extends EvlRunConfiguration, ?> builder) {
		super(builder);
	}
	
	public EvlRunConfiguration(Builder<? extends EvlRunConfiguration, ?> builder) {
		super(builder);
		IEvlModule module = getModule();
		if (module instanceof EvlModule) {
			((EvlModule) module).setOptimizeConstraints(builder.optimizeConstraints);
		}
		module.getContext().setShortCircuit(builder.shortCircuit);
		module.getContext().setOptimizeConstraintTrace(builder.optimizeTrace);
	}
	
	public EvlRunConfiguration(EvlRunConfiguration other) {
		super(other);
		IEvlModule module = getModule(), otherModule = other.getModule();
		if (module instanceof EvlModule && otherModule instanceof EvlModule) {
			((EvlModule) module).setOptimizeConstraints(((EvlModule) otherModule).isOptimizeConstraints());
		}
		IEvlContext context = module.getContext(), otherContext = otherModule.getContext();
		context.setShortCircuit(otherContext.isShortCircuiting());
		context.setOptimizeConstraintTrace(otherContext.isOptimizeConstraintTrace());
	}
	
	@Override
	public IEvlModule getModule() {
		return (IEvlModule) super.getModule();
	}
	
	// METHOD VISIBILITY
	
	@Override
	public void preExecute() throws Exception {
		super.preExecute();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<UnsatisfiedConstraint> getResult() {
		return (Collection<UnsatisfiedConstraint>) super.getResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<UnsatisfiedConstraint> execute() throws EolRuntimeException {
		return (Collection<UnsatisfiedConstraint>) super.execute();
	}
	
	@Override
	public void postExecute() throws Exception {
		super.postExecute();
		
		if (showResults || profileExecution) {
			IEvlContext context = getModule().getContext();
			int numUnsatisfied = context.getUnsatisfiedConstraints().size();
			if (numUnsatisfied > 0) {
				writeOut(numUnsatisfied+" constraint"+(numUnsatisfied > 1 ? "s have" : " has")+" not been satisfied"+(showResults ? ':' : '.'));
				if (showResults) {
					writeOut(context.getUnsatisfiedConstraintsBySize().entrySet());
				}
			}
			else {
				writeOut("All constraints have been satisfied.");
			}
			
			writeOut(printMarker);
		}
	}
}