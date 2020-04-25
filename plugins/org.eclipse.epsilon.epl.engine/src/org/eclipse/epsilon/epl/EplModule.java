/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.epl;

import java.util.ArrayList;
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
import org.eclipse.epsilon.eol.dom.ExecutableBlock;
import org.eclipse.epsilon.eol.dom.Import;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.epl.dom.Cardinality;
import org.eclipse.epsilon.epl.dom.Domain;
import org.eclipse.epsilon.epl.dom.Pattern;
import org.eclipse.epsilon.epl.dom.Role;
import org.eclipse.epsilon.epl.execute.PatternMatchModel;
import org.eclipse.epsilon.epl.execute.PatternMatcher;
import org.eclipse.epsilon.epl.execute.context.EplContext;
import org.eclipse.epsilon.epl.execute.context.IEplContext;
import org.eclipse.epsilon.epl.parse.EplLexer;
import org.eclipse.epsilon.epl.parse.EplParser;
import org.eclipse.epsilon.erl.ErlModule;

public class EplModule extends ErlModule implements IEplModule{
	
	protected List<Pattern> declaredPatterns = new ArrayList<>();
	protected boolean repeatWhileMatchesFound = false;
	protected int maxLoops = INFINITE;
	protected String patternMatchModelName = "P";
	
	public static final int INFINITE = -1;
	
	public static void main(String[] args) throws Exception {
		EplModule module = new EplModule();
		//module.parse(new File("/Users/dimitrioskolovos/Downloads/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.epl.engine/src/org/eclipse/epsilon/epl/parse/test.epl"));
		//new AstExplorer(module.getAst(), EplParser.class);
		module.parse("pre{ System.user.prompt('foo?');}");
		module.execute();
	}
	
	public EplModule() {
		this(null);
	}
	
	protected EplModule(IEplContext context) {
		super(context != null ? context : new EplContext());
	}
	
	@Override
	protected Lexer createLexer(ANTLRInputStream inputStream) {
		return new EplLexer(inputStream);
	}

	@Override
	public EpsilonParser createParser(TokenStream tokenStream) {
		return new EplParser(tokenStream);
	}

	@Override
	public String getMainRule() {
		return "eplModule";
	}
	
	@Override
	public HashMap<String, Class<?>> getImportConfiguration() {
		HashMap<String, Class<?>> importConfiguration = super.getImportConfiguration();
		importConfiguration.put("epl", EplModule.class);
		return importConfiguration;
	}
	
	@Override
	public ModuleElement adapt(AST cst, ModuleElement parentAst) {
		switch (cst.getType()) {
			case EplParser.PATTERN: return new Pattern();
			case EplParser.CARDINALITY: return new Cardinality();
			case EplParser.GUARD: return new ExecutableBlock<Boolean>(Boolean.class);
			case EplParser.DOMAIN: return new Domain();
			case EplParser.ROLE: return new Role();
			case EplParser.ACTIVE: return new ExecutableBlock<Boolean>(Boolean.class);
			case EplParser.OPTIONAL: return new ExecutableBlock<Boolean>(Boolean.class);
			case EplParser.ONMATCH: return new ExecutableBlock<Void>(Void.class);
			case EplParser.NOMATCH: return new ExecutableBlock<Void>(Void.class);
			case EplParser.DO: return new ExecutableBlock<Void>(Void.class);
			//case EplParser.NOMATCH: return super.adapt(cst.getFirstChild(), parentAst);
			case EplParser.MATCH: return new ExecutableBlock<Boolean>(Boolean.class);			
//			case EplParser.DO: return new StatementBlock();
//			case EplParser.ONMATCH: return new StatementBlock();
//			case EplParser.NOMATCH: return new StatementBlock();
//			case EplParser.MATCH: return new ExecutableBlock<Boolean>(Boolean.class);
		}
		return super.adapt(cst, parentAst);
	}
	
	@Override
	public void build(AST cst, IModule module) {
		super.build(cst, module);
		for (AST patternAst : AstUtil.getChildren(cst, EplParser.PATTERN)) {
			declaredPatterns.add((Pattern) module.createAst(patternAst, this));
		}
	}
	
	@Override
	public List<Pattern> getDeclaredPatterns() {
		return declaredPatterns;
	}
	
	protected ArrayList<Pattern> patterns = null;
	
	@Override
	public List<Pattern> getPatterns() {
		if (patterns == null) {
			patterns = new ArrayList<>();
			for (Import import_ : imports) {
				if (import_.isLoaded() && (import_.getModule() instanceof EplModule)) {
					EplModule module = (EplModule) import_.getModule();
					patterns.addAll(module.getPatterns());
				}
			}
			patterns.addAll(declaredPatterns);
		}
		return patterns;
	}
	
	@Override
	public Object executeImpl() throws EolRuntimeException {
		execute(getPre(), getContext());
		
		PatternMatcher patternMatcher = null;
		if (getContext().getPatternMatcher() == null) {
			patternMatcher = new PatternMatcher();
			getContext().setPatternMatcher(patternMatcher);
		} else {
			patternMatcher = getContext().getPatternMatcher();
		}
		
		PatternMatchModel matchModel = null;
		try {
			int loops = 1;
			matchModel = patternMatcher.match(this);
			if (repeatWhileMatchesFound) {
				
				while (!matchModel.allContents().isEmpty()) {
					if (maxLoops != INFINITE) {
						if (loops == maxLoops) break;
					}
					matchModel = patternMatcher.match(this);
					loops++;
				}
			}
		}
		catch (Exception ex) {
			EolRuntimeException.propagate(ex);
		}
		
		execute(getPost(), getContext());
		
		getContext().setPatternMatchTrace(matchModel);
		
		return matchModel;
	}
	
	@Override
	public int getMaxLoops() {
		return maxLoops;
	}
	
	@Override
	public void setMaxLoops(int maxLoops) {
		this.maxLoops = maxLoops;
	}
	
	@Override
	public boolean isRepeatWhileMatches() {
		return repeatWhileMatchesFound;
	}
	
	@Override
	public void setRepeatWhileMatches(boolean repeatWhileMatches) {
		this.repeatWhileMatchesFound = repeatWhileMatches;
	}
	
	@Override
	public int getMaximumLevel() {
		int maximumLevel = 0;
		for (Pattern pattern : getPatterns()) {
			maximumLevel = Math.max(maximumLevel, pattern.getLevel());
		}
		return maximumLevel;
	}
	
	@Override
	public String getPatternMatchModelName() {
		return patternMatchModelName;
	}
	
	@Override
	public void setPatternMatchModelName(String patternMatchModelName) {
		this.patternMatchModelName = patternMatchModelName;
	}
	
	@Override
	public IEplContext getContext() {
		return (IEplContext) super.getContext();
	}
	
}
