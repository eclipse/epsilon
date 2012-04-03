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
	protected ValidationResults results = new ValidationResults();;
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
		
		if (eObject.eResource() == null) return false;
		
		EvlMarkerResolutionGenerator.INSTANCE.removeFixesFor(eObject);
		
		// If it is the root that is validated validate the whole resource and cache the results
		if (eObject.eContainer() == null) {
			validate(eObject.eResource());

			// Add problem markers for violations in objects in externally referenced models
			for (Map.Entry<Object, Collection<EvlUnsatisfiedConstraint>> entry : results.entrySet()) {
				if (!(entry.getKey() instanceof EObject)) {
					continue;
				}
				final EObject key = (EObject)entry.getKey();
				if (key.eResource() == eObject.eResource()) {
					continue;
				}

				addMarkers("[" + key.eResource().getURI() + "] ", key, diagnostics);
			}
		}

		addMarkers("", eObject, diagnostics);
		return true;
	}

	public boolean validate(EDataType dataType, Object value,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	protected Diagnostic createDiagnostic(String msgPrefix, EvlUnsatisfiedConstraint unsatisfied) {
		int severity = 0;

		if (unsatisfied.getConstraint().isCritique()) severity = 2;
		else severity = 4;
		String message = unsatisfied.getMessage();
		int code = 0;

		BasicDiagnostic diagnostic = new BasicDiagnostic(severity, "", code, msgPrefix + message, new Object[]{ unsatisfied.getInstance() });

		return diagnostic;
	}
	
	private void validate(Resource resource) {
		results.clear();

		module = new EvlModule();
		try {
			module.parse(source);
		} catch (Exception e) {
			LogUtil.log("An error was encountered while parsing " + source + " : " + e.getMessage(), e, true);
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
		}

		module.setUnsatisfiedConstraintFixer(new IEvlFixer() {
			public void fix(IEvlModule module) throws EolRuntimeException {
				// Do nothing
			}
		});

		for (EvlUnsatisfiedConstraint unsatisfied : module.getContext().getUnsatisfiedConstraints()) {
			Object key = unsatisfied.getInstance();
			if (!results.containsKey(key)) {
				results.put(key, new ArrayList<EvlUnsatisfiedConstraint>());
			}
			results.get(key).add(unsatisfied);
		}

		module.getContext().dispose();
		module.getContext().getModelRepository().dispose();
	}

	private void addMarkers(String msgPrefix, EObject eObject, DiagnosticChain diagnostics) {
		Collection<EvlUnsatisfiedConstraint> unsatisfiedConstraints = results.get(eObject);
		
		if (unsatisfiedConstraints != null && unsatisfiedConstraints.size() > 0) {
			for (EvlUnsatisfiedConstraint unsatisfied : unsatisfiedConstraints) {
				diagnostics.add(createDiagnostic(msgPrefix, unsatisfied));
				for (Object fix : unsatisfied.getFixes()) {
					EvlMarkerResolutionGenerator.INSTANCE.addResolution(unsatisfied.getMessage(),(EvlFixInstance) fix, modelName, ePackageUri);
				}
			}
		}
	}

}
