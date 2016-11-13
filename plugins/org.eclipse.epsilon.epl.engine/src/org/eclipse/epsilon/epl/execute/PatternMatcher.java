/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.epl.execute;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.eol.dom.ExecutableBlock;
import org.eclipse.epsilon.eol.dom.StatementBlock;
import org.eclipse.epsilon.eol.exceptions.EolIllegalReturnException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.Return;
import org.eclipse.epsilon.eol.execute.context.Frame;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.epl.EplModule;
import org.eclipse.epsilon.epl.combinations.CombinationGenerator;
import org.eclipse.epsilon.epl.combinations.CombinationGeneratorListener;
import org.eclipse.epsilon.epl.combinations.CompositeCombinationGenerator;
import org.eclipse.epsilon.epl.combinations.CompositeCombinationValidator;
import org.eclipse.epsilon.epl.combinations.DynamicListCombinationGenerator;
import org.eclipse.epsilon.epl.dom.NoMatch;
import org.eclipse.epsilon.epl.dom.Pattern;
import org.eclipse.epsilon.epl.dom.Role;

public class PatternMatcher {
	
	protected Frame frame = null;
	
	public PatternMatchModel match(EplModule module) throws Exception {
		frame = null;
		
		IEolContext context = module.getContext();
		PatternMatchModel model = new PatternMatchModel();
		
		if (module.getMaximumLevel() > 0) {
			model.setName(module.getPatternMatchModelName());
			context.getModelRepository().addModel(model);
		}
		
		model.setPatterns(module.getPatterns());
		
		for (int level=0;level<=module.getMaximumLevel();level++) {
			for (Pattern pattern : module.getPatterns()) {
				if (pattern.getLevel() == level) {
					for (PatternMatch match : match(pattern, context)) {
						model.addMatch(match);
					}
				}
			}
			
			for (PatternMatch match : model.getMatches()) {
				if (match.getPattern().getLevel() == level) {
					ExecutableBlock<Void> do_ = match.getPattern().getDo();
					if (do_ != null) {
						context.getFrameStack().enterLocal(FrameType.UNPROTECTED, do_);
						for (String componentName : match.getRoleBindings().keySet()) {
							context.getFrameStack().put(Variable.createReadOnlyVariable(componentName, match.getRoleBinding(componentName)));
						}
						context.getExecutorFactory().execute(do_, context);
						context.getFrameStack().leaveLocal(do_);
					}
				}
			}
		}
		
		return model;
	}
	
	public List<PatternMatch> match(final Pattern pattern, final IEolContext context) throws Exception {
		
		List<PatternMatch> patternMatches = new ArrayList<PatternMatch>();
		
		context.getFrameStack().enterLocal(FrameType.PROTECTED, pattern);
		
		CompositeCombinationGenerator<Object> generator = new CompositeCombinationGenerator<Object>();
		
		for (Role role : pattern.getRoles()) {
			generator.addCombinationGenerator(createCombinationGenerator(role, context));
		}

		generator.setValidator(new CompositeCombinationValidator<Object>() {
			
			@Override
			public boolean isValid(List<List<Object>> combination) throws Exception {
				
				for (Object o : combination.get(combination.size()-1)) {
					if (o instanceof NoMatch) return true;
				}
				
				frame = context.getFrameStack().enterLocal(FrameType.PROTECTED, pattern);
				boolean result = true;
				int i = 0;
				Role role = null;
				for (List<Object> values : combination) {
					role = pattern.getRoles().get(i);
					for (Variable variable : getVariables(values, role)) {
						frame.put(variable);
					}
					i++;
				}
				if (!role.isNegative() && role.getGuard() != null && role.isActive(context) && role.getCardinality().isOne()) {
					result = role.getGuard().execute(context);
				}
				context.getFrameStack().leaveLocal(pattern);
				return result;
			}
		});
		
		while (generator.hasMore()) {
			
			List<List<Object>> candidate = generator.getNext();
		
			boolean matches = true;
			
			frame = context.getFrameStack().enterLocal(FrameType.PROTECTED, pattern);
			
			if (pattern.getMatch() != null || pattern.getNoMatch() != null || pattern.getOnMatch() != null) {
				int i = 0;
				for (Role role : pattern.getRoles()) {
					for (Variable variable : getVariables(candidate.get(i), role)) {
						frame.put(variable);
					}
					i++;
				}
			}
			
			if (pattern.getMatch() != null) {
				Object result = context.getExecutorFactory().execute(pattern.getMatch(), context);
				if (result instanceof Return) result = ((Return) result).getValue();
				if (result instanceof Boolean) {
					matches = (Boolean) result;
				}
				else throw new EolIllegalReturnException("Boolean", result, pattern.getMatch(), context);
			}
			
			if (matches) { 
				context.getExecutorFactory().execute(pattern.getOnMatch(), context);
				patternMatches.add(createPatternMatch(pattern, candidate));
			}
			else context.getExecutorFactory().execute(pattern.getNoMatch(), context);
			
			context.getFrameStack().leaveLocal(pattern);
			
		}
		
		context.getFrameStack().leaveLocal(pattern);
		
		return patternMatches;
	}
	
	protected List<Variable> getVariables(List<Object> combination, Role role) {
		ArrayList<Variable> variables = new ArrayList<Variable>();
		int i = 0;
		for (String name : role.getNames()) {
			variables.add(Variable.createReadOnlyVariable(name, combination.get(i)));
			i++;
		}
		//if (component.getAlias() != null) {
		//	variables.add(Variable.createReadOnlyVariable(component.getAlias(), combination));
		//}
		return variables;
	}
	
	protected CombinationGenerator<Object> createCombinationGenerator(final Role role, final IEolContext context) throws EolRuntimeException {
		DynamicListCombinationGenerator<Object> combinationGenerator = null;
		
		combinationGenerator = new DynamicListCombinationGenerator<Object>(role.getInstances(context), role.getNames().size()) {
			@Override
			public Boolean checkOptional() {
				try {
					return role.isOptional(context);
				} catch (EolRuntimeException e) {
					throw new RuntimeException(e);
				}
			}
		};
		
		//FixedCombinationGenerator<Object> combinationGenerator = null;
		//combinationGenerator = new FixedCombinationGenerator<Object>(component.getInstances(context), component.getNames().size());
		
		combinationGenerator.addListener(new CombinationGeneratorListener<Object>() {			
			@Override
			public void generated(List<Object> next) {
				//if (next != null)
				
				if (next == null) {
					for (String name : role.getNames()) {
						context.getFrameStack().put(Variable.createReadOnlyVariable(name, NoMatch.INSTANCE));
					}
				}
				else {
				for (Variable variable : getVariables(next, role)) {
					context.getFrameStack().put(variable);
				}}
			}
			
			@Override
			public void reset() {
				for (String variableName : role.getNames()) {
					context.getFrameStack().remove(variableName);
				}
			}
		});
		
		return combinationGenerator;
	}
	
	protected PatternMatch createPatternMatch(Pattern pattern, List<List<Object>> combination) {
		
		PatternMatch patternMatch = new PatternMatch(pattern);
		int i = 0;
		for (Role role : pattern.getRoles()) {
			for (Variable variable : getVariables(combination.get(i), role)) {
				patternMatch.getRoleBindings().put(variable.getName(), variable.getValue());
			}
			
			i++;
		}
		return patternMatch;
	}
	
}
