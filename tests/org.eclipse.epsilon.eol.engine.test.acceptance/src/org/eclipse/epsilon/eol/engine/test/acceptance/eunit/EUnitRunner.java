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

package org.eclipse.epsilon.eol.engine.test.acceptance.eunit;

import java.io.File;
import java.util.HashMap;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.commons.util.FileUtil;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.epsilon.eol.EolOperation;
import org.eclipse.epsilon.eunit.EUnitModule;
import org.eclipse.epsilon.eunit.EUnitTest;
import org.eclipse.epsilon.eunit.EUnitTestResultType;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;

public class EUnitRunner extends Runner {
	
	protected Class<?> clazz;
	protected EUnitModule module;
	protected HashMap<String, Description> descriptions = new HashMap<String, Description>();
	protected Description testSuiteDescription;
	protected File eolFile;
	
	public EUnitRunner(Class<?> clazz) {
		this.clazz = clazz;
	}
		
	@Override
	public Description getDescription() {
		
		module = new EUnitModule();
		testSuiteDescription = Description.createSuiteDescription(clazz);
		
		try {
			eolFile = FileUtil.getFile(clazz.getSimpleName() + ".eol", clazz);
			module.parse(eolFile);
		} catch (Exception e) {
			return testSuiteDescription;
		}
		
		
		if (module.getParseProblems().size() > 0) {
			return testSuiteDescription;
		}
		
		for (EolOperation test : module.getTests()) {
			Description testDescription = Description.createTestDescription(clazz, test.getName());
			testSuiteDescription.addChild(testDescription);
			descriptions.put(test.getName(), testDescription);
			
		}
		
		return testSuiteDescription;
	}

	@Override
	public void run(RunNotifier notifier) {
		
		notifier.fireTestStarted(testSuiteDescription);
		
		if (eolFile == null) {
			notifier.fireTestFailure(new Failure(testSuiteDescription, new Exception("EUnit file " + clazz.getSimpleName() + ".eol does not exist")));
			return;
		}
		
		if (module.getParseProblems().size() > 0) {
			StringBuilder sBuilder = new StringBuilder("Syntax errors in ");
			sBuilder.append(eolFile);
			sBuilder.append(": \n");
			for (ParseProblem problem : module.getParseProblems()) {
				sBuilder.append("- ");
				sBuilder.append(problem.toString());
				sBuilder.append('\n');
			}
			notifier.fireTestFailure(new Failure(testSuiteDescription, new Exception(sBuilder.toString())));
			return;
		}

		EUnitTest suiteRoot;
		try {
			module.getContext().getModelRepository().addModel(getEcoreModel());
			module.execute();
			suiteRoot = module.getSuiteRoot();

			for (EUnitTest result : suiteRoot.getChildren()) {
				String name = result.getOperation().getName();
				Description description = descriptions.get(name);
				notifier.fireTestStarted(description);
				if (result.getResult() == EUnitTestResultType.SUCCESS) {
					notifier.fireTestFinished(description);
				}
				else if (result.getResult() == EUnitTestResultType.FAILURE) {
					notifier.fireTestFailure(new Failure(description, result.getException()));
				}
				else if (result.getResult() == EUnitTestResultType.ERROR) {
					notifier.fireTestFailure(new Failure(description, result.getException()));
				}
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
			notifier.fireTestFailure(new Failure(testSuiteDescription, ex));
		}
		finally {
			module.getContext().dispose();
			module.getContext().getModelRepository().dispose();
		}
		
		notifier.fireTestFinished(testSuiteDescription);
		
	}
	
	public InMemoryEmfModel getEcoreModel() {
		ResourceSet rs = new ResourceSetImpl();
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		Resource r = rs.createResource(URI.createFileURI("foo.xmi"));
		EObject copy = EcoreUtil.copy(EcorePackage.eINSTANCE.eResource().getContents().get(0));
		r.getContents().add(copy);
		rs.getResources().add(r);
		InMemoryEmfModel ecore = new InMemoryEmfModel("Ecore", r);
		return ecore;
	}
	
}
 