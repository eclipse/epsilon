package org.eclipse.epsilon.epl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.TokenStream;
import org.eclipse.epsilon.commons.module.ModuleElement;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.commons.parse.EpsilonParser;
import org.eclipse.epsilon.commons.util.AstUtil;
import org.eclipse.epsilon.eol.EolImport;
import org.eclipse.epsilon.eol.EolLibraryModule;
import org.eclipse.epsilon.eol.IEolExecutableModule;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.EolContext;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyGetter;
import org.eclipse.epsilon.epl.parse.EplLexer;
import org.eclipse.epsilon.epl.parse.EplParser;

public class EplModule extends EolLibraryModule implements IEolExecutableModule{
	
	protected List<Pattern> declaredPatterns = new ArrayList<Pattern>();
	protected EolContext context;
	protected boolean repeatWhileMatchesFound = false;
	protected int maxLoops = INFINITE;
	
	public static final int INFINITE = -1;
	
	public EplModule() {
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
		return new EplLexer(input);
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
	public void buildModel() throws Exception {
		super.buildModel();
		for (AST patternAst : AstUtil.getChildren(ast, EplParser.PATTERN)) {
			declaredPatterns.add(new Pattern(patternAst));
		}
	}
	
	public List<Pattern> getDeclaredPatterns() {
		return declaredPatterns;
	}
	
	protected ArrayList<Pattern> patterns = null;
	
	public List<Pattern> getPatterns() {
		if (patterns == null) {
			patterns = new ArrayList<Pattern>();
			for (EolImport import_ : imports) {
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
	public List<ModuleElement> getChildren() {
		final List<ModuleElement> children = new ArrayList<ModuleElement>();
		children.addAll(getImports());
		//children.addAll(getDeclaredPre());
		children.addAll(getDeclaredPatterns());
		//children.addAll(getDeclaredPost());
		children.addAll(getDeclaredOperations());
		return children;
	}
	
	@Override
	public IEolContext getContext() {
		return context;
	}
	
	public void setContext(EolContext context) {
		this.context = context;
	}
	
	@Override
	public void reset() {
		super.reset();
		declaredPatterns.clear();
		context = new EolContext();
	}

	@Override
	public Object execute() throws EolRuntimeException {
		this.getContext().setModule(this);
		PatternMatcher patternMatcher = new PatternMatcher();
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
			else {
				
				return matchModel;
			}
		}
		catch (Exception ex) {
			EolRuntimeException.propagate(ex);
		}
		// Never gets here. Statement above always throws an exception
		return matchModel;
	}
	
	public int getMaxLoops() {
		return maxLoops;
	}
	
	public void setMaxLoops(int maxLoops) {
		this.maxLoops = maxLoops;
	}
	
	public boolean isRepeatWhileMatches() {
		return repeatWhileMatchesFound;
	}
	
	public void setRepeatWhileMatches(boolean repeatWhileMatches) {
		this.repeatWhileMatchesFound = repeatWhileMatches;
	}
	
}
