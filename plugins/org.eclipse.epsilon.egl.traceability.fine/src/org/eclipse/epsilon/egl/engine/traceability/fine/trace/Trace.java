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

import java.util.LinkedList;
import java.util.List;

public class Trace {

	public final List<TextLocation> locations = new LinkedList<TextLocation>();
	public final List<TraceElement> elements = new LinkedList<TraceElement>();
	
	
	// Getters for compatibility with JavaModel, which are used in acceptance tests 
	
	public List<TraceElement> getElements() {
		return elements;
	}
	
	public List<TextLocation> getLocations() {
		return locations;
	}
}
