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

import org.eclipse.epsilon.egl.engine.traceability.fine.trace.TextLocation;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.Trace;

public class TraceCombiner {

	public Trace combine(Trace first, Trace second, int currentOffset) {
		final Trace combined = new Trace();
		
		combined.elements.addAll(first.elements);
		combined.locations.addAll(first.locations);
		
		combined.elements.addAll(second.elements);

		for (TextLocation location : second.locations) {
			location.region.offset += currentOffset;
		}
		
		combined.locations.addAll(second.locations);
		
		return combined;
	}

}
