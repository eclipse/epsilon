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
package org.eclipse.epsilon.egl.engine.traceability.fine.trace.builder;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.ModelLocation;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.TraceFactory;

public class ModelLocationBuilder {
	
	public ModelLocation buildModelLocation(EObject modelElement, String featureName) {
		final ModelLocation modelLocation = TraceFactory.eINSTANCE.createModelLocation();		
		modelLocation.setModelElement(modelElement);
		modelLocation.setFeatureName(featureName);
		return modelLocation;
	}
}
