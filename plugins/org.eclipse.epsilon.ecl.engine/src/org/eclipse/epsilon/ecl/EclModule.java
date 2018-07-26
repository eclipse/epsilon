/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.ecl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.TokenStream;
import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.parse.EpsilonParser;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.ecl.dom.MatchRule;
import org.eclipse.epsilon.ecl.execute.EclOperationFactory;
import org.eclipse.epsilon.ecl.execute.context.EclContext;
import org.eclipse.epsilon.ecl.execute.context.IEclContext;
import org.eclipse.epsilon.ecl.parse.EclLexer;
import org.eclipse.epsilon.ecl.parse.EclParser;
import org.eclipse.epsilon.ecl.trace.Match;
import org.eclipse.epsilon.ecl.trace.MatchTrace;
import org.eclipse.epsilon.eol.dom.ExecutableBlock;
import org.eclipse.epsilon.eol.dom.Import;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.erl.ErlModule;
import org.eclipse.epsilon.erl.dom.NamedRuleList;

public class EclModule extends ErlModule implements IEclModule {
	
	protected NamedRuleList<MatchRule> matchRules, declaredMatchRules = new NamedRuleList<>();
	
	public EclModule() {
		this.context = new EclContext();
	}
	
	@Override
	protected Lexer createLexer(ANTLRInputStream inputStream) {
		return new EclLexer(inputStream);
	}

	@Override
	public EpsilonParser createParser(TokenStream tokenStream) {
		return new EclParser(tokenStream);
	}

	@Override
	public String getMainRule() {
		return "eclModule";
	}
	
	@Override
	public void build(AST cst, IModule module) {
		super.build(cst, module);
		
		// Parse the match rules
		Collection<AST> matchChildren = AstUtil.getChildren(cst, EclParser.MATCH);
		declaredMatchRules.ensureCapacity(matchChildren.size());
		for (AST matchRuleAst : matchChildren) {
			declaredMatchRules.add((MatchRule) module.createAst(matchRuleAst, this));
		}
		
		getParseProblems().addAll(calculateSuperRules(getMatchRules()));
	}
	
	@Override
	public ModuleElement adapt(AST cst, ModuleElement parentAst) {
		switch (cst.getType()) {
			case EclParser.MATCH: return new MatchRule();
			case EclParser.GUARD:
			case EclParser.COMPARE:
				return new ExecutableBlock<Boolean>(Boolean.class);
			case EclParser.DO: return new ExecutableBlock<Void>(Void.class);
		}
		
		return super.adapt(cst, parentAst);
	}
	
	@Override
	public HashMap<String, Class<?>> getImportConfiguration() {
		HashMap<String, Class<?>> importConfiguration = super.getImportConfiguration();
		importConfiguration.put("ecl", EclModule.class);
		return importConfiguration;
	}
	
	@Override
	public List<MatchRule> getMatchRules() {
		if (matchRules == null) {
			matchRules = new NamedRuleList<>();
			for (Import import_ : imports) {
				if (import_.isLoaded() && (import_.getModule() instanceof IEclModule)) {
					IEclModule module = (IEclModule) import_.getModule();
					matchRules.addAll(module.getMatchRules());
				}
			}
			matchRules.addAll(declaredMatchRules);
		}
		return matchRules;
	}

	@Override
	protected void prepareExecution() throws EolRuntimeException {
		super.prepareExecution();
		IEclContext context = getContext();
		context.setOperationFactory(new EclOperationFactory());
		context.getFrameStack().put(
			Variable.createReadOnlyVariable("matchTrace", context.getMatchTrace()),
			Variable.createReadOnlyVariable("context", context),
			Variable.createReadOnlyVariable("self", this)
		);
	}
	
	@Override
	public MatchTrace executeImpl() throws EolRuntimeException {
		prepareExecution();
		matchModels();
		postExecution();
		return getContext().getMatchTrace();
	}
	
	@Override
	public void matchModels() throws EolRuntimeException {
		matchAllRules(true);
		matchAllRules(false);
	}

	protected void matchAllRules(boolean greedy) throws EolRuntimeException {
		boolean ofTypeOnly = !greedy;
		IEclContext context = getContext();
		
		for (MatchRule matchRule : getMatchRules()) {
			if (!matchRule.isAbstract() && !matchRule.isLazy(context) && (ofTypeOnly || matchRule.isGreedy())) {
				for (Object left : matchRule.getLeftInstance(context, ofTypeOnly)) {
					for (Object right : matchRule.getRightInstance(context, ofTypeOnly)) {
						matchRule.matchPair(context, ofTypeOnly, left, right);
					}
				}
			}
		}
	}
	
	@Override
	public Match match(Object left, Object right, boolean forcedMatch) throws EolRuntimeException {
		IEclContext context = getContext();
		
		Match traceMatch = context.getMatchTrace().getMatch(left, right);
		if (traceMatch != null) return traceMatch;
		
		List<MatchRule> matchRules = getRulesFor(left, right, context, true);
		
		if (!matchRules.isEmpty()) {
			MatchRule matchRule = (MatchRule) matchRules.iterator().next();
			return matchRule.match(left, right, context, false, null, forcedMatch);
		}
		else {
			matchRules = getRulesFor(left, right, context, false);
			boolean matchRulesNotEmpty = !matchRules.isEmpty();
			Match match = new Match(left, right, matchRulesNotEmpty, null);
			
			if (matchRulesNotEmpty) {
				for (MatchRule matchRule : matchRules) {
					if (matchRule.isGreedy()) {
						Match tempMatch = matchRule.match(left, right, context, true, match.getInfo(), forcedMatch);
						match.setMatching(match.isMatching() && tempMatch.isMatching());
						match.setRule(matchRule);
					}
				}
			}
			
			context.getMatchTrace().getMatches().add(match);
			return match;
		}
	}
	
	@Override
	public IEclContext getContext() {
		return (IEclContext) context;
	}
	
	public List<MatchRule> getDeclaredMatchRules() {
		return declaredMatchRules;
	}

	@Override
	protected int getPostBlockTokenType() {
		return EclParser.POST;
	}

	@Override
	protected int getPreBlockTokenType() {
		return EclParser.PRE;
	}

	@Override
	public void setContext(IEolContext context) {
		if (context instanceof IEclContext) {
			this.context = (IEclContext) context;
		}
	}
	
	public List<MatchRule> getRulesFor(Object obj1, Object obj2, IEclContext context, boolean ofClassOnly) throws EolRuntimeException {
		List<MatchRule> rules = new ArrayList<>();
		for (MatchRule matchRule : getMatchRules()) {
			if (!matchRule.isAbstract() && matchRule.appliesTo(obj1, obj2, context, ofClassOnly)) {
				rules.add(matchRule);
			}
		}
		return rules;
	}
}
