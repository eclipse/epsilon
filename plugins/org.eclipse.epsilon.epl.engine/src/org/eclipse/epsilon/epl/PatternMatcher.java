package org.eclipse.epsilon.epl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolIllegalReturnException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.Return;
import org.eclipse.epsilon.eol.execute.context.Frame;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.epl.combinations.DynamicListCombinationGenerator;
import org.eclipse.epsilon.epl.combinations.CombinationGenerator;
import org.eclipse.epsilon.epl.combinations.CombinationGeneratorListener;
import org.eclipse.epsilon.epl.combinations.CompositeCombinationGenerator;
import org.eclipse.epsilon.epl.combinations.CompositeCombinationValidator;

public class PatternMatcher {
	
	protected Frame frame = null;
	
	public PatternMatchModel match(EplModule module) throws Exception {
		frame = null;
		
		IEolContext context = module.getContext();
		PatternMatchModel model = new PatternMatchModel();
		model.setPatterns(module.getPatterns());
		for (Pattern pattern : module.getPatterns()) {
			for (PatternMatch match : match(pattern, context)) {
				model.addMatch(match);
			}
		}
		
		for (PatternMatch match : model.getMatches()) {
			AST doAst = match.getPattern().getDoAst();
			if (doAst != null) {
				context.getFrameStack().enter(FrameType.UNPROTECTED, doAst);
				for (String componentName : match.getRoleBindings().keySet()) {
					context.getFrameStack().put(Variable.createReadOnlyVariable(componentName, match.getRoleBinding(componentName)));
				}
				context.getExecutorFactory().executeAST(doAst, context);
				context.getFrameStack().leave(doAst);
			}
		}
		
		return model;
	}
	
	public List<PatternMatch> match(final Pattern pattern, final IEolContext context) throws Exception {
		
		List<PatternMatch> patternMatches = new ArrayList<PatternMatch>();
		
		context.getFrameStack().enter(FrameType.PROTECTED, pattern.getAst());
		
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
				
				frame = context.getFrameStack().enter(FrameType.PROTECTED, pattern.getAst());
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
					Return ret = null;
					ret = (Return) context.getExecutorFactory().executeBlockOrExpressionAst(role.getGuard().getAst().getFirstChild(), context);
					if (ret.getValue() instanceof Boolean) result = (Boolean) ret.getValue();
				}
				context.getFrameStack().leave(pattern.getAst());
				return result;
			}
		});
		
		while (generator.hasMore()) {
			
			List<List<Object>> candidate = generator.getNext();
		
			boolean matches = true;
			
			frame = context.getFrameStack().enter(FrameType.PROTECTED, pattern.getAst());
			
			if (pattern.getMatchAst() != null || pattern.getNoMatchAst() != null || pattern.getOnMatchAst() != null) {
				int i = 0;
				for (Role role : pattern.getRoles()) {
					for (Variable variable : getVariables(candidate.get(i), role)) {
						frame.put(variable);
					}
					i++;
				}
			}
			
			if (pattern.getMatchAst() != null) {
				Object result = context.getExecutorFactory().executeAST(pattern.getMatchAst(), context);
				if (result instanceof Return) result = ((Return) result).getValue();
				if (result instanceof Boolean) {
					matches = (Boolean) result;
				}
				else throw new EolIllegalReturnException("Boolean", result, pattern.getMatchAst(), context);
			}
			
			if (matches) { 
				context.getExecutorFactory().executeAST(pattern.getOnMatchAst(), context);
				patternMatches.add(createPatternMatch(pattern, candidate));
			}
			else context.getExecutorFactory().executeAST(pattern.getNoMatchAst(), context);
			
			context.getFrameStack().leave(pattern.getAst());
			
		}
		
		context.getFrameStack().leave(pattern.getAst());
		
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
