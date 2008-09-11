/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.ecl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.TokenStream;
import org.eclipse.epsilon.commons.module.ModuleElement;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.commons.parse.EpsilonParser;
import org.eclipse.epsilon.commons.util.AstUtil;
import org.eclipse.epsilon.ecl.execute.EclOperationFactory;
import org.eclipse.epsilon.ecl.execute.context.EclContext;
import org.eclipse.epsilon.ecl.execute.context.IEclContext;
import org.eclipse.epsilon.ecl.parse.EclLexer;
import org.eclipse.epsilon.ecl.parse.EclParser;
import org.eclipse.epsilon.ecl.trace.Match;
import org.eclipse.epsilon.eol.EolImport;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.erl.ErlModule;
import org.eclipse.epsilon.erl.rules.INamedRule;


public class EclModule extends ErlModule implements IEclModule {
	
	protected MatchRules matchRules = null;
	protected MatchRules declaredMatchRules = null;
	protected IEclContext context = null;
	//protected IModel leftModel;
	//protected IModel rightModel;
	
	public EclModule(){
		reset();
	}
	
	@Override
	public Lexer createLexer(InputStream inputStream) {
		ANTLRInputStream input = null;
		try {
			input = new ANTLRInputStream(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new EclLexer(input);
	}

	@Override
	public EpsilonParser createParser(TokenStream tokenStream) {
		// TODO Auto-generated method stub
		return new EclParser(tokenStream);
	}

	@Override
	public String getMainRule() {
		return "eclModule";
	}
	
	@Override
	public void buildModel() throws Exception {
		
		super.buildModel();
		
		// Parse the match rules
		Iterator it = AstUtil.getChildren(ast, EclParser.MATCH).iterator();
		while (it.hasNext()){
			AST matchRuleAst = (AST) it.next();
			MatchRule matchRule = new MatchRule(matchRuleAst);
			declaredMatchRules.add(matchRule);
		}
		
		getParseProblems().addAll(getMatchRules().calculateSuperRules(getMatchRules()));
	}

	@Override
	public HashMap<String, Class> getImportConfiguration() {
		HashMap<String, Class> importConfiguration = super.getImportConfiguration();
		importConfiguration.put("ecl", EclModule.class);
		return importConfiguration;
	}
	
	public MatchRules getMatchRules() {
		if (matchRules == null) {
			matchRules = new MatchRules();
			for (EolImport import_ : imports) {
				if (import_.isLoaded() && (import_.getModule() instanceof IEclModule)) {
					IEclModule module = (IEclModule) import_.getModule();
					matchRules.addAll(module.getMatchRules());
				}
			}
			matchRules.addAll(declaredMatchRules);
		}
		return matchRules;
	}

	public Object execute() throws EolRuntimeException {
		
		// Initialize the context

		context.setModule(this);
		context.setOperationFactory(new EclOperationFactory());
		
		//context.getModelRepository().addModel(leftModel);
		//context.getModelRepository().addModel(rightModel);
		
		context.getFrameStack().put(Variable.createReadOnlyVariable("matchTrace", context.getMatchTrace()));
		context.getFrameStack().put(Variable.createReadOnlyVariable("context", context));
		context.getFrameStack().put(Variable.createReadOnlyVariable("self", this));
		
		execute(getPre(), context);
		//context.getMatchingStrategy().matchModels(context);
		matchModels();
		execute(getPost(), context);
		
		return context.getMatchTrace();
	}
	
	public void matchModels() throws EolRuntimeException {
		
		for (INamedRule rule : getMatchRules()) {
			MatchRule matchRule = (MatchRule) rule;
			if (!matchRule.isAbstract() && !matchRule.isLazy()) {
				matchRule.matchAll(context, true);
			}
		}
		
		for (INamedRule rule : getMatchRules()) {
			MatchRule matchRule = (MatchRule) rule;
			if (!matchRule.isAbstract() && !matchRule.isLazy() && matchRule.isGreedy()) {
				matchRule.matchAll(context, false);
			}
		}
		
	}

	public Match match(Object left, Object right, boolean forcedMatch) throws EolRuntimeException {
		
		Match traceMatch = context.getMatchTrace().getMatch(left,right);
		if (traceMatch != null) return traceMatch;
		
		MatchRules matchRules = getMatchRules().getRulesFor(left,right,context,true);
		
		MatchRule matchRule = null;
		
		if (matchRules.size() > 0) {
			matchRule = (MatchRule) matchRules.iterator().next();
			return matchRule.match(left,right,context,false, null, forcedMatch);
		}
		else {
			matchRules = getMatchRules().getRulesFor(left, right, context, false);
			
			if (matchRules.size() > 0){
				
				Match match = context.getMatchTrace().createMatch(left, right, true);
				Iterator it = matchRules.iterator();
				while (it.hasNext()){
					matchRule = (MatchRule) it.next();
					if (matchRule.isGreedy()) {
						Match tempMatch = matchRule.match(left,right,context,true, match.getInfo(), forcedMatch);
						match.setMatching(match.isMatching() && tempMatch.isMatching());
						match.setRule(matchRule);
					}
				}
				context.getMatchTrace().getMatches().add(match);
				return match;
			}
			else {
				Match match = context.getMatchTrace().createMatch(left, right, false);
				context.getMatchTrace().getMatches().add(match);
				return match;
			}
		}
		
	}
	
	@Override
	public IEclContext getContext(){
		return context;
	}
	
	@Override
	public List<ModuleElement> getChildren(){
		List children = new ArrayList();
		children.addAll(getImports());
		children.addAll(getDeclaredPre());
		children.addAll(getDeclaredMatchRules());
		children.addAll(getDeclaredOperations());
		children.addAll(getDeclaredPost());
		return children;
	}
	
	@Override
	public void reset(){
		super.reset();
		matchRules = null;
		declaredMatchRules = new MatchRules();
		context = new EclContext();
	}

	//public void setLeftModel(IModel leftModel) {
	//	this.leftModel = leftModel;
	//}

	//public IModel getLeftModel() {
	//	return leftModel;
	//}

	//public void setRightModel(IModel rightModel) {
	//	this.rightModel = rightModel;
	//}

	//public IModel getRightModel() {
	//	return rightModel;
	//}

	public MatchRules getDeclaredMatchRules() {
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
		
}
