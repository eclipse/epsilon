/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.flock.engine.test.acceptance.builtins;


import java.io.File;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.epsilon.common.util.FileUtil;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.emc.emf.EmfModelFactory;
import org.eclipse.epsilon.emc.emf.EmfUtil;
import org.eclipse.epsilon.emc.emf.EmfModelFactory.AccessMode;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.epsilon.eol.IEolLibraryModule;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.flock.FlockModule;
import org.eclipse.epsilon.flock.IFlockModule;
import org.eclipse.epsilon.test.builtins.CanAccessBuiltinsTests;

public class FlockCanAccessBuiltinsTests extends CanAccessBuiltinsTests {

	@Override
	protected IEolLibraryModule createModule() throws EolModelLoadingException {
		final IFlockModule module = new FlockModule();
		
		module.getContext().getModelRepository().addModel(createOriginalModel());
		module.getContext().getModelRepository().addModel(createMigratedModel());
		
		return module;
	}

	private EmfModel createOriginalModel() throws EolModelLoadingException {
		return EmfModelFactory.getInstance().loadEmfModel("Original", FileUtil.getFile("Original.ecore", FlockCanAccessBuiltinsTests.class), EcorePackage.eINSTANCE, AccessMode.READ_ONLY);
	}

	private InMemoryEmfModel createMigratedModel() {
		return new InMemoryEmfModel("Migrated", EmfUtil.createResource(), EcorePackage.eINSTANCE);
	}
	
	@Override
	protected File getProgram() {
		return FileUtil.getFile(("System.mig"), FlockCanAccessBuiltinsTests.class);
	}

	@Override
	protected String getExpectedPrintedValue() {
		return "Running Flock";
	}
}
