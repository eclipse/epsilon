/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.hutn;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.TokenStream;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.epsilon.antlr.postprocessor.model.antlrAst.Ast;
import org.eclipse.epsilon.commons.parse.EpsilonParser;
import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.emc.emf.AbstractEmfModel;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.emc.emf.EmfUtil;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.epsilon.eol.EolLibraryModule;
import org.eclipse.epsilon.hutn.exceptions.HutnConfigFileNotFoundException;
import org.eclipse.epsilon.hutn.exceptions.HutnException;
import org.eclipse.epsilon.hutn.exceptions.HutnGenerationException;
import org.eclipse.epsilon.hutn.exceptions.HutnUnrecognisedNsUriException;
import org.eclipse.epsilon.hutn.generate.metamodel.MetaModelGenerator;
import org.eclipse.epsilon.hutn.generate.model.ModelGenerator;
import org.eclipse.epsilon.hutn.model.hutn.HutnPackage;
import org.eclipse.epsilon.hutn.model.hutn.NsUri;
import org.eclipse.epsilon.hutn.model.hutn.Spec;
import org.eclipse.epsilon.hutn.parse.HutnLexer;
import org.eclipse.epsilon.hutn.parse.HutnParser;
import org.eclipse.epsilon.hutn.parse.postprocessor.HutnPostProcessor;
import org.eclipse.epsilon.hutn.translate.HutnTranslator;
import org.eclipse.epsilon.hutn.validation.model.HutnValidator;

public class HutnModule extends EolLibraryModule implements IHutnModule {

	protected IHutnContext context;
	protected HutnDocument document;
	protected Spec spec;
	protected boolean metaModelIsValid = true;
	protected File configFileDirectory;
	protected boolean hutnIsValid = false;
	
	/*
	public TokenStream createLexer(Reader reader) {
		return new HutnLexer(reader);
	}

	public LLkParser createParser(TokenStream tokenStream) {
		return new HutnParser(tokenStream);
	}
	*/
	
	
	@Override
	public Lexer createLexer(InputStream inputStream) {
		ANTLRInputStream input = null;
		try {
			input = new ANTLRInputStream(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new HutnLexer(input);
	}

	@Override
	public EpsilonParser createParser(TokenStream tokenStream) {
		return new HutnParser(tokenStream);
	}
	
	
	public String getMainRule() {
		return "document";
	}
	
	public IHutnContext getContext(){
		return context;
	}
	
	public void reset(){
		super.reset();
		context = new HutnContext(this);
		metaModelIsValid = true;
		hutnIsValid = false;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.epsilon.eol.AbstractModule#invokeMainRule()
	 * 
	 * Overridden to ensure that errors found during building
	 * the HUTN model cause parse() to return false.
	 */
	@Override
	protected boolean invokeMainRule() throws Exception {
		boolean buildModelWasCalled = super.invokeMainRule();
		
		if (buildModelWasCalled) {
			return parsingWasSuccessful();
		}
		
		return false; // parsing must have failed before build model was called
	}
	
	protected boolean parsingWasSuccessful() {
		for (ParseProblem p : getParseProblems()) {
			if (p.getSeverity() == ParseProblem.ERROR)
				return false;
		}
		
		return true;
	}

	public void buildModel() throws Exception {
		super.buildModel();
		document = new HutnDocument();
		document.setAst(ast);
		translateAst();
	}

	protected void translateAst() throws HutnException {
		try {
			final Ast astModel = new HutnPostProcessor(getParseProblems()).process(ast);
			
			final HutnTranslator translator = new HutnTranslator(configFileDirectory);
			getParseProblems().addAll(translator.validateConfigModel(astModel));
			
			hutnIsValid = parsingWasSuccessful();
			
			if (hutnIsValid) {
				spec = translator.createIntermediateModel(astModel);
					
				if (spec == null)
					throw new IllegalArgumentException("Could not generate Intermediate model for specified text.");
				
				getParseProblems().addAll(new HutnValidator().getProblemsForIntermediateModel(spec));
			}
		
		} catch (HutnConfigFileNotFoundException e) {
			getParseProblems().add(new ParseProblem(e.getLine(), e.getColumn(), "Configuration file not found: " + e.getPath()));
		
		} catch (HutnUnrecognisedNsUriException e) {
			getParseProblems().add(new ParseProblem(e.getLine(), e.getColumn(), "Unrecognised namespace URI: " + e.getUri()));
			metaModelIsValid = false;
		}
	}

	public boolean hasValidHutn() {
		if (spec == null) throw new IllegalStateException("No HUTN has been parsed.");
		
		return hutnIsValid;
	}
	
	public void setConfigFileDirectory(File configFileDirectory) {
		this.configFileDirectory = configFileDirectory;
	}
	
	public void generateEmfMetaModel(File destination) throws HutnGenerationException {
		if (spec == null) throw new IllegalStateException("No HUTN has been parsed.");
		new MetaModelGenerator(spec).generate(destination);
	}
	
	public boolean hasValidMetaModel() {
		return metaModelIsValid;
	}
	
	public boolean hasInferredMetaModel() {
		if (spec == null) throw new IllegalStateException("No HUTN has been parsed.");
		return spec.getNsUris().isEmpty();
	}
	
	public List<String> getNsUris() {
		final List<String> nsUris = new LinkedList<String>();
		
		if (spec != null) {
			for (NsUri uri : spec.getNsUris()) {
				nsUris.add(uri.getValue());
			}
		}
		
		return Collections.unmodifiableList(nsUris);
	}
	
	public void generateEmfModel(File destination) throws HutnGenerationException {
		if (spec == null) throw new IllegalStateException("No HUTN has been parsed.");
		if (hasInferredMetaModel()) {
			// TODO : Generate inferred meta-model and use it to generate model
			throw new IllegalStateException("Support for inferred meta-models is not yet included.");
		} else {
			new ModelGenerator(spec).generate(destination);
		}
	}

	public AbstractEmfModel generateEmfModel() throws HutnGenerationException {
		if (spec == null) throw new IllegalStateException("No HUTN has been parsed.");
		if (hasInferredMetaModel()) {
			// TODO : Generate inferred meta-model and use it to generate model
			throw new IllegalStateException("Support for inferred meta-models is not yet included.");
		} else {
			return new ModelGenerator(spec).generate();
		}
	}
	
	public void generateEmfModel(File destination, File metamodel) throws HutnGenerationException {
		if (spec == null) throw new IllegalStateException("No HUTN has been parsed.");
		
		new ModelGenerator(spec, metamodel).generate(destination);
	}
	
	public Spec getIntermediateModel() {
		if (spec == null) throw new IllegalStateException("No HUTN has been parsed.");
		
		return spec;
	}
	
	public void storeIntermediateModel(File destination) {
		if (spec == null) throw new IllegalStateException("No HUTN has been parsed.");
		
		final Resource resource = EmfUtil.createResource(URI.createFileURI(destination.getAbsolutePath()));
		resource.getContents().add(spec);
		
		final EmfModel model = new InMemoryEmfModel("Intermediate", resource, HutnPackage.eINSTANCE);
		model.store(destination.getAbsolutePath());
		model.dispose();
	}
	
	public void storeIntermediateModelTransformation(File destination) throws HutnGenerationException {
		if (spec == null) throw new IllegalStateException("No HUTN has been parsed.");
		
		try {
			final FileWriter writer = new FileWriter(destination);
			writer.write(new ModelGenerator(spec).generateTransformation());
			writer.close();
		} catch (IOException e) {
			throw new HutnGenerationException(e);
		}
	}
}
