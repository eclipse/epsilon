/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.flock;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.TokenStream;
import org.eclipse.epsilon.commons.module.ModuleElement;
import org.eclipse.epsilon.commons.parse.EpsilonParser;
import org.eclipse.epsilon.emc.emf.EmfPrettyPrinter;
import org.eclipse.epsilon.eol.EolLibraryModule;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;
import org.eclipse.epsilon.flock.model.MigrationStrategy;
import org.eclipse.epsilon.flock.model.loader.MigrationStrategyLoader;
import org.eclipse.epsilon.flock.parse.FlockLexer;
import org.eclipse.epsilon.flock.parse.FlockParser;

public class FlockModule extends EolLibraryModule implements IFlockModule {
	
	private MigrationStrategy strategy;
	
	// FIXME ! Could tidy up the next two methods with a generic?
	
	@Override
	public Lexer createLexer(InputStream inputStream) {
		ANTLRInputStream input = null;
		try {
			input = new ANTLRInputStream(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new FlockLexer(input);
	}

	@Override
	public EpsilonParser createParser(TokenStream tokenStream) {
		return new FlockParser(tokenStream);
	}
	
	@Override
	public String getMainRule() {
		return "flockModule";
	}

	@Override
	public void buildModel() throws Exception {
		super.buildModel();
		
		strategy = new MigrationStrategyLoader(ast).run();
	}

	public FlockResult execute(IModel original, IModel migrated) throws FlockRuntimeException {
		final FlockContext context = new FlockContext(original, migrated);
		
		context.getPrettyPrinterManager().addPrettyPrinter(new EmfPrettyPrinter());
		
		return execute(context);
	}

	public FlockResult execute(IFlockContext context) throws FlockRuntimeException {	
		context.setModule(this);
		return context.run(strategy);
	}
	
	@Override
	public List<ModuleElement> getChildren(){
		final List<ModuleElement> children = new ArrayList<ModuleElement>();
		
		children.addAll(getImports());
		children.addAll(strategy.getRules());
		children.addAll(getDeclaredOperations());
		
		return children;
	}
}

