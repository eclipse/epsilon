/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.erl.execute;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.ExecutorFactory;
import org.eclipse.epsilon.erl.dom.IExecutableDataRuleElement;
import org.eclipse.epsilon.erl.dom.IExecutableMultiParameterRuleElement;
import org.eclipse.epsilon.erl.execute.context.IErlContext;

/**
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class RuleExecutorFactory extends ExecutorFactory {

	protected RuleProfiler ruleProfiler;
	
	public RuleExecutorFactory() {
		this(null, false);
	}

	public RuleExecutorFactory(ExecutorFactory parent) {
		this(parent, parent != null ? parent.isThreadSafe() : false);
	}
	
	public RuleExecutorFactory(ExecutorFactory parent, boolean concurrent) {
		super(parent, concurrent);
		setRuleProfiler(new RuleProfiler());
		if (base instanceof RuleExecutorFactory) {
			executionListeners.remove(((RuleExecutorFactory) base).getRuleProfiler());
		}
	}
	
	public RuleProfiler getRuleProfiler() {
		return ruleProfiler;
	}
	
	public void setRuleProfiler(RuleProfiler ruleProfiler) {
		if (this.ruleProfiler != null) {
			removeExecutionListener(this.ruleProfiler);
		}
		
		addExecutionListener(this.ruleProfiler = ruleProfiler);
	}
	
	@Override
	public void merge(MergeMode mode) {
		ExecutorFactory from = getFrom(mode), to = getTo(mode);
		
		if (to instanceof RuleExecutorFactory && from instanceof RuleExecutorFactory) {
			((RuleExecutorFactory)to).getRuleProfiler()
				.mergeExecutionTimes(
					((RuleExecutorFactory)from).getRuleProfiler().getExecutionTimes()
				);
		}
		
		super.merge(mode);
	}

	public Object execute(IExecutableDataRuleElement rule, Object element, IErlContext context) throws EolRuntimeException {
		if (rule == null) return null;
		
		preExecute(rule, context);
		
		Object result = null;
		
		try {
			result = rule.executeImpl(element, context);
			postExecuteSuccess(rule, result, context);
		}
		catch (Exception ex) {
			postExecuteFailure(rule, ex, context);
		}
		finally {
			postExecuteFinally(rule, context);
		}
		
		return result;
	}
	
	public Object execute(IExecutableMultiParameterRuleElement rule, IErlContext context, Object... elements) throws EolRuntimeException {
		if (rule == null) return null;
		
		preExecute(rule, context);
		
		Object result = null;
		
		try {
			result = rule.executeImpl(context, elements);
			postExecuteSuccess(rule, result, context);
		}
		catch (Exception ex) {
			postExecuteFailure(rule, ex, context);
		}
		finally {
			postExecuteFinally(rule, context);
		}
		
		return result;
	}
	
}
