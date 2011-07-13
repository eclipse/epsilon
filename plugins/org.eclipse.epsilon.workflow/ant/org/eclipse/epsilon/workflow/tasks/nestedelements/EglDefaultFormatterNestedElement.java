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
package org.eclipse.epsilon.workflow.tasks.nestedelements;

import org.apache.tools.ant.BuildException;
import org.eclipse.epsilon.egl.formatter.Formatter;

public class EglDefaultFormatterNestedElement {

	private Class<? extends Formatter> implementation;

	public Class<? extends Formatter> getImplementation() {
		return implementation;
	}

	public void setImplementation(Class<? extends Formatter> implementation) {
		if (Formatter.class.isAssignableFrom(implementation)) {
			this.implementation = implementation;
			
		} else {
			throw new BuildException("The implementation parameter must be a class that subtypes org.eclipse.epsilon.egl.formatter.Formatter.");
		}
	}
}
