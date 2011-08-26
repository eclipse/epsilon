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
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.TextLocation;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.Trace;

public class TraceCombiner {

	public Trace combine(Trace first, Trace second, Position current) {
		final Trace combined = new Trace();
		
		combined.elements.addAll(first.elements);
		combined.locations.addAll(first.locations);
		
		combined.elements.addAll(second.elements);

		System.out.println("incrementing: " + second.locations.size());
		System.out.println("incrementing by:  "  + current);
		for (TextLocation location : second.locations) {
			final Region region = location.region;
			
			region.start.line   = current.line + region.start.line;
			region.start.column = current.column + region.start.column;

			region.end.line = current.line + region.end.line;
			region.end.column = current.column + region.end.column;
		}
		
		combined.locations.addAll(second.locations);
		
		return combined;
	}

}
