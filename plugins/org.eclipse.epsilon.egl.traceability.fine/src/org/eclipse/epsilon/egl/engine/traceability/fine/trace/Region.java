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

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Region {

	public final Position start, end;
	
	public Region(Position start, Position end) {
		this.start = start;
		this.end   = end;
	}

	
	// Getters for compatibility with JavaModel, which are used in acceptance tests

	public Position getStart() {
		return start;
	}
	
	public Position getEnd() {
		return end;
	}

	public Collection<? extends Object> getAllContents() {
		final List<Object> allContents = new LinkedList<Object>();
		allContents.add(this);
		allContents.addAll(start.getAllContents());
		allContents.addAll(end.getAllContents());
		return allContents;
	}
}
