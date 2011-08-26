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
package org.eclipse.epsilon.egl.engine.traceability.fine.trace;

public class ModelLocation {

	public final Object modelElement;
	public final String featureName;
	
	public ModelLocation(Object modelElement, String featureName) {
		this.modelElement = modelElement;
		this.featureName  = featureName;
	}
	
	
	// Getters for compatibility with JavaModel, which are used in acceptance tests

	public Object getModelElement() {
		return modelElement;
	}
	
	public String getFeatureName() {
		return featureName;
	}
}
