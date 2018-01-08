/*******************************************************************************
 * Copyright (c) 2008-2018 The University of York, Aston University.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Antonio Garcia-Dominguez - allow custom reason, add accessors
 ******************************************************************************/
package org.eclipse.epsilon.eol.exceptions.models;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

public class EolModelElementTypeNotFoundException extends EolRuntimeException{
	
	private static final long serialVersionUID = 1L;

	private final String model;
	private final String metaClass;

	public EolModelElementTypeNotFoundException(String model, String metaClass) {
		this(model, metaClass, "Cannot find meta-class '" + metaClass + "' in model '" + model + "'");
	}

	public String getModel() {
		return model;
	}

	public String getMetaClass() {
		return metaClass;
	}

	public EolModelElementTypeNotFoundException(String model, String metaClass, String reason){
		super(reason);
		this.model = model;
		this.metaClass = metaClass;
	}

}
