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
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.TraceFactory;

public class TraceCombiner {

	public Trace combine(Trace first, Trace second, Position current) {
		final Trace combined = TraceFactory.eINSTANCE.createTrace();
		
		combined.getElements().addAll(first.getElements());
		combined.getLocations().addAll(first.getLocations());
		
		combined.getElements().addAll(second.getElements());

		System.out.println("incrementing: " + second.getLocations().size());
		System.out.println("incrementing by:  "  + current);
		for (TextLocation location : second.getLocations()) {
			final Region region = location.getRegion();
			
			region.getStart().setLine(region.getStart().getLine() + current.getLine());
			region.getStart().setColumn(region.getStart().getColumn() + current.getColumn());

			region.getEnd().setLine(region.getEnd().getLine() + current.getLine());
			region.getEnd().setColumn(region.getEnd().getColumn() + current.getColumn());
		}
		
		combined.getLocations().addAll(second.getLocations());
		
		return combined;
	}

}
