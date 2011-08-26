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

import org.eclipse.epsilon.egl.engine.traceability.fine.trace.Position;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.Region;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.TraceFactory;

public class RegionBuilder {

	private Region currentRegion;
	
	public RegionBuilder aRegion() {
		currentRegion = TraceFactory.eINSTANCE.createRegion();
		return this;
	}

	public RegionBuilder startingAt(int line, int column) {
		currentRegion.setStart(createPosition(line, column));
		return this;
	}
	
	public RegionBuilder endingAt(int line, int column) {
		currentRegion.setEnd(createPosition(line, column));
		return this;
	}
	
	public Region build() {
		return currentRegion;
	}
	
	private static Position createPosition(int line, int column) {
		final Position position = TraceFactory.eINSTANCE.createPosition();
		position.setLine(line);
		position.setColumn(column);
		return position;
	}
}
