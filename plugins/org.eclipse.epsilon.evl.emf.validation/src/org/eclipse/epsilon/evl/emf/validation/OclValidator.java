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
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.ocl.OCLInput;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.OCL;

public class OclValidator implements EValidator {
	
	protected URI source;
	
	public OclValidator(URI source) {
		this.source = source;
	}
	
	public boolean validate(EObject object, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		
		return true;
	}

	public boolean validate(EClass class1, EObject object,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		
		try {
			OCLInput oclInput = new OCLInput(source.toURL().openStream());
			
			
			class GlobalEnvironment extends EcoreEnvironment{
				
				public GlobalEnvironment() {
					super(EPackage.Registry.INSTANCE);
				}
				
			}
			
			OCL ocl = OCL.newInstance(new GlobalEnvironment());
			
			List<Constraint> constraints = ocl.parse(oclInput);
			
			for (Constraint constraint : constraints) {
				if (constraint.getSpecification().getContextVariable().getType().isInstance(object)) {
					if (!ocl.check(object, constraint)) {
						BasicDiagnostic diagnostic = new BasicDiagnostic(4,"",0,"Constraint " + constraint.getName() + " failed for object " + object ,new Object[]{object});
						diagnostics.add(diagnostic);
					}
				}
			}
			
			
			
		}
		catch (Exception ex) {
			LogUtil.log(ex);
		}
		
		return true;
	}

	public boolean validate(EDataType dataType, Object value,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		
		return true;
	}

}
 