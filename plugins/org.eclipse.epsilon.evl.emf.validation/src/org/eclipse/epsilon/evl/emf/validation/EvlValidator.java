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
package org.eclipse.epsilon.evl.emf.validation;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.emc.emf.EmfPrettyPrinter;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.epsilon.eol.dt.launching.EclipseContextManager;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.evl.EvlFixInstance;
import org.eclipse.epsilon.evl.EvlModule;
import org.eclipse.epsilon.evl.EvlUnsatisfiedConstraint;
import org.eclipse.epsilon.evl.IEvlFixer;
import org.eclipse.epsilon.evl.IEvlModule;

public class EvlValidator implements EValidator {

	protected EvlModule module = null;
	protected URI source;
	protected EmfPrettyPrinter printer = new EmfPrettyPrinter();
	protected Resource currentResource = null;
	protected ValidationResults results;
	protected Collection<EObject> history = new ArrayList<EObject>();
	protected String modelName;
	protected String ePackageUri;
	
	public static final String DEFAULT_MODEL_NAME = "_Model";
	
	public EvlValidator(URI source, String modelName, String ePackageUri) {
		this.source = source;
		this.modelName = modelName;
		this.ePackageUri = ePackageUri;
	}
	
	public boolean validate(EObject object, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return true;
	}

	public boolean validate(EClass eClass, EObject eObject,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		
		//System.err.println("Validating " + eObject);
		
		if (eObject.eResource() == null) return false;
		
		EvlMarkerResolutionGenerator.INSTANCE.removeFixesFor(eObject);
		
		if (eObject.eResource() != currentResource || history.contains(eObject)) {
			results = validate(eObject.eResource());
			history.clear();
			currentResource = eObject.eResource();
		}
		
		history.add(eObject);
		
		Collection<EvlUnsatisfiedConstraint> unsatisfiedConstraints = results.get(eObject);
		
		if (unsatisfiedConstraints.size() > 0) {
			for (EvlUnsatisfiedConstraint unsatisfied : unsatisfiedConstraints) {
				diagnostics.add(createDiagnostic(unsatisfied));
				for (Object fix : unsatisfied.getFixes()) {
					EvlMarkerResolutionGenerator.INSTANCE.addResolution(unsatisfied.getMessage(),(EvlFixInstance) fix, modelName, ePackageUri);
				}
			}
			return false;
		}
		
		module.getContext().dispose();
		module.getContext().getModelRepository().dispose();
		
		return true;
	}
	
	protected Diagnostic createDiagnostic(EvlUnsatisfiedConstraint unsatisfied) {
		
		String source = "";
		int severity = 0;
		
		if (unsatisfied.getConstraint().isCritique()) severity = 2;
		else severity = 4;
		String message = unsatisfied.getMessage();
		int code = 0;
		
		BasicDiagnostic diagnostic = new BasicDiagnostic(severity,source,code,message,new Object[]{unsatisfied.getInstance()});
		
		return diagnostic;
	}
	
	protected ValidationResults validate(Resource resource) {
				
		module = new EvlModule();
		try {
			module.parse(source);
		} catch (Exception e) {
			return new ValidationResults();
		}
		
		if (module.getParseProblems().size() > 0) {
			LogUtil.log(source + " has one or more syntax errors : " + module.getParseProblems().get(0).toString(), null, true);			
		}
		
		InMemoryEmfModel model = new InMemoryEmfModel(modelName, resource, ePackageUri);
		//model.setName(modelName);
		module.getContext().getModelRepository().addModel(model);
		
		EclipseContextManager.setup(module.getContext()); 
		
		try {
			module.execute();
		} catch (EolRuntimeException e) {
			LogUtil.log("A runtime error was raised during the evaluation of " + source + " : " + e.getMessage(), e, true);
			return new ValidationResults();
		}
		
		module.setUnsatisfiedConstraintFixer(new IEvlFixer() {
			public void fix(IEvlModule module) throws EolRuntimeException {
				// Do nothing
			}
		});
		
		ValidationResults results = new ValidationResults();
		
		TreeIterator<EObject> allContents = resource.getAllContents();
		
		while (allContents.hasNext()) {
			EObject eObject = allContents.next();
			ArrayList<EvlUnsatisfiedConstraint> unsatisfied = new ArrayList<EvlUnsatisfiedConstraint>();
			results.put(eObject, unsatisfied);
		}
		
		for (EvlUnsatisfiedConstraint unsatisfied : module.getContext().getUnsatisfiedConstraints()) {
			results.get(unsatisfied.getInstance()).add(unsatisfied);
		}
		
		return results;
	}
	
	
	public boolean validate(EDataType dataType, Object value,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

}
