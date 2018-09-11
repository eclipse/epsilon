/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.TokenStream;
import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.parse.EpsilonParser;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.egl.dom.GenerationRule;
import org.eclipse.epsilon.egl.execute.context.EgxContext;
import org.eclipse.epsilon.egl.parse.EgxLexer;
import org.eclipse.epsilon.egl.parse.EgxParser;
import org.eclipse.epsilon.egl.traceability.Content;
import org.eclipse.epsilon.egl.traceability.Template;
import org.eclipse.epsilon.eol.dom.ExecutableBlock;
import org.eclipse.epsilon.eol.dom.Import;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.control.IExecutionListener;
import org.eclipse.epsilon.erl.ErlModule;
import org.eclipse.epsilon.erl.dom.NamedRuleList;

public class EgxModule extends ErlModule {
	
	protected NamedRuleList<GenerationRule> declaredGenerationRules = new NamedRuleList<GenerationRule>();
	protected NamedRuleList<GenerationRule> generationRules = null;
	protected EgxContext context = null;
	protected EglTemplateFactory templateFactory = null;
	protected List<Content<Template>> invokedTemplates = new ArrayList<Content<Template>>();
	
	public static void main(String[] args) throws Exception {
		final EgxModule module = new EgxModule();
		module.parse("");
		module.getContext().getExecutorFactory().addExecutionListener(new IExecutionListener() {
			
			@Override
			public void finishedExecutingWithException(ModuleElement ast,
					EolRuntimeException exception, IEolContext context) {}
			
			@Override
			public void finishedExecuting(ModuleElement ast, Object result,
					IEolContext context) {
				if (ast == module) System.out.println("Finished executing.");
			}
			
			@Override
			public void aboutToExecute(ModuleElement ast, IEolContext context) {
				if (ast == module) System.out.println("About to execute ...");
			}
		});
		
		module.execute();
	}
	
	public EgxModule() {
		this(new EglTemplateFactory());
	}
	
	public EgxModule(EglTemplateFactory templateFactory) {
		this.templateFactory = templateFactory;
		context = new EgxContext(templateFactory);
	}
	
	public EglTemplateFactory getTemplateFactory() {
		return templateFactory;
	}
	
	public void setTemplateFactory(EglTemplateFactory templateFactory) {
		this.templateFactory = templateFactory;
	}

	public List<Content<Template>> getInvokedTemplates() {
		return invokedTemplates;
	}
	
	@Override
	protected Lexer createLexer(ANTLRInputStream inputStream) {
		return new EgxLexer(inputStream);
	}
	
	@Override
	public EpsilonParser createParser(TokenStream tokenStream) {
		return new EgxParser(tokenStream);
	}

	@Override
	public String getMainRule() {
		return "egxModule";
	}
	
	@Override
	public void build(AST cst, IModule module) {
		super.build(cst, module);
		
		// Parse the transform rules
		for (AST generationRuleAst : AstUtil.getChildren(cst, EgxParser.GENERATE)) {
			declaredGenerationRules.add((GenerationRule) module.createAst(generationRuleAst, this));
		}
		
		getParseProblems().addAll(calculateSuperRules(getGenerationRules()));
	}
	
	
	@Override
	public ModuleElement adapt(AST cst, ModuleElement parentAst) {
		switch (cst.getType()) {
			case EgxParser.GENERATE: return createGenerationRule(cst);
			case EgxParser.TEMPLATE: return new ExecutableBlock<String>(String.class);
			case EgxParser.PARAMETERS: return new ExecutableBlock<Map<?, ?>>(Map.class);
			case EgxParser.OVERWRITE: return new ExecutableBlock<Boolean>(Boolean.class);
			case EgxParser.GUARD: return new ExecutableBlock<Boolean>(Boolean.class);
			case EgxParser.MERGE: return new ExecutableBlock<Boolean>(Boolean.class);
			case EgxParser.APPEND: return new ExecutableBlock<Boolean>(Boolean.class);
			case EgxParser.TARGET: return new ExecutableBlock<String>(String.class);
			case EgxParser.PRE:
			case EgxParser.POST: {
				if (parentAst instanceof GenerationRule) {
					return new ExecutableBlock<Void>(Void.class);
				}
			}
		}
	
		return super.adapt(cst, parentAst);
	}
	
	/**
	 * Subclasses may override this method to change the implementation of
	 * {@link GenerationRule} that is instantiated after parsing an EGX
	 * program.
	 */
	protected GenerationRule createGenerationRule(AST generationRuleAst) {
		return new GenerationRule();
	}
	
	public List<GenerationRule> getDeclaredGenerationRules() {
		return declaredGenerationRules;
	}
	
	@Override
	public boolean parse(File file) throws Exception {
		boolean result = super.parse(file);
		if (result) templateFactory.initialiseRoot(file.getAbsoluteFile().getParentFile().toURI());
		return result;
	}
	
	
	@Override
	public boolean parse(URI uri) throws Exception {
		boolean result = super.parse(uri);
		if (result) templateFactory.initialiseRoot(uri);
		return result;
	}
	
	@Override
	public boolean parse(String code, File file) throws Exception {
		boolean result = super.parse(code, file);
		if (result && file != null) templateFactory.initialiseRoot(file.getAbsoluteFile().getParentFile().toURI());
		return result;
	}
	
	public Object executeImpl() throws EolRuntimeException {
		context.copyInto(templateFactory.getContext(), true);
		
		execute(getPre(), context);
		
		for (GenerationRule rule : getGenerationRules()) {
			rule.generateAll(context, templateFactory, this);
		}
		
		execute(getPost(), context);
		
		return null;
		
	}
	
	@Override
	public HashMap<String, Class<?>> getImportConfiguration() {
		HashMap<String, Class<?>> importConfiguration = super.getImportConfiguration();
		importConfiguration.put("egx", EgxModule.class);
		return importConfiguration;
	}

	@Override
	public EgxContext getContext(){
		return context;
	}
	
	public void setContext(EgxContext context){
		this.context = context;
	}
	
	public List<GenerationRule> getGenerationRules() {
		if (generationRules == null) {
			generationRules = new NamedRuleList<GenerationRule>();
			for (Import import_ : imports) {
				if (import_.isLoaded() && (import_.getModule() instanceof EgxModule)) {
					EgxModule module = (EgxModule) import_.getModule();
					generationRules.addAll(module.getGenerationRules());
				}
			}
			generationRules.addAll(declaredGenerationRules);
		}
		return generationRules;
	}

	@Override
	protected int getPostBlockTokenType() {
		return EgxParser.POST;
	}

	@Override
	protected int getPreBlockTokenType() {
		return EgxParser.PRE;
	}

	@Override
	public void setContext(IEolContext context) {
		if (context instanceof EgxContext) {
			this.context = (EgxContext) context;
		}
	}
	
}
