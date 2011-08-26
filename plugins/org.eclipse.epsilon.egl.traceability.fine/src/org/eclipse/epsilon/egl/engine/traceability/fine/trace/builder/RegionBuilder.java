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

public class RegionBuilder {

	private final PositionBuilder builder = new PositionBuilder();
	private Position start, end;
	
	public RegionBuilder aRegion() {
		start = null;
		end   = null;
		
		return this;
	}

	public RegionBuilder startingAt(int line, int column) {
		start = createPosition(line, column);
		return this;
	}
	
	public RegionBuilder endingAt(int line, int column) {
		end = createPosition(line, column);
		return this;
	}
	
	public Region build() {
		return new Region(start, end);
	}
	
	private Position createPosition(int line, int column) {
		return builder.buildPosition(line, column);
	}
}
