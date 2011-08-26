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
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.pojo.Region;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.builder.RegionBuilder;

public class OutputBufferPrinterAdaptor implements Printer {

	private final OutputBuffer adaptee;
	
	public OutputBufferPrinterAdaptor(OutputBuffer adaptee) {
		this.adaptee = adaptee;
	}
	
	@Override
	public Region print(Object object, RegionBuilder builder) {
		builder.aRegion().startingAt(adaptee.getCurrentLineNumber(), adaptee.getCurrentColumnNumber() + 1);
		adaptee.print(object);
		builder.endingAt(adaptee.getCurrentLineNumber(), adaptee.getCurrentColumnNumber() + 1);
		
		return builder.build();
	}

}
