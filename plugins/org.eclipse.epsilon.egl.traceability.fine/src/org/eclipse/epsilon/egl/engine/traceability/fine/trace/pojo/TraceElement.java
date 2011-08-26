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
package org.eclipse.epsilon.egl.engine.traceability.fine.trace.pojo;

public class TraceElement {

	public final ModelLocation source;
	public final TextLocation destination;

	public TraceElement(ModelLocation source, TextLocation destination) {
		this.source = source;
		this.destination = destination;
	}

	
	// Getters for compatibility with JavaModel, which are used in acceptance tests
	
	public ModelLocation getSource() {
		return source;
	}
	
	public TextLocation getDestination() {
		return destination;
	}
}
