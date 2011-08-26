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
package org.eclipse.epsilon.egl.output;

import org.eclipse.epsilon.egl.engine.traceability.fine.operations.print.Printer;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.Region;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.builder.RegionBuilder;

public class OutputBufferPrinterAdaptor implements Printer {

	private final OutputBuffer adaptee;
	
	public OutputBufferPrinterAdaptor(OutputBuffer adaptee) {
		this.adaptee = adaptee;
	}
	
	@Override
	public Region print(Object object, RegionBuilder builder) {
		buildStartOfRegion(builder);
		adaptee.print(object);
		buildEndOfRegion(builder);
		
		return builder.build();
	}
	
	@Override
	public Region printdyn(Object object, RegionBuilder builder) {
		buildStartOfRegion(builder);
		adaptee.printdyn(object);
		buildEndOfRegion(builder);
		
		return builder.build();
	}

	private void buildStartOfRegion(RegionBuilder builder) {
		builder.aRegion().startingAt(adaptee.getCurrentLineNumber(), adaptee.getCurrentColumnNumber());
	}
	
	private RegionBuilder buildEndOfRegion(RegionBuilder builder) {
		return builder.endingAt(adaptee.getCurrentLineNumber(), adaptee.getCurrentColumnNumber());
	}
}
