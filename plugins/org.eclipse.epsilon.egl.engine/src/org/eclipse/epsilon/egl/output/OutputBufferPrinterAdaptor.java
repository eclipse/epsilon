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

public abstract class OutputBufferPrinterAdaptor extends Printer {

	protected final OutputBuffer adaptee;
	
	public OutputBufferPrinterAdaptor(OutputBuffer adaptee) {
		this.adaptee = adaptee;
	}

	@Override
	protected final Region print(Object object, RegionBuilder builder) {
		buildStartOfRegion(builder);
		basicPrint(object);
		buildEndOfRegion(builder);
		
		return builder.build();
	}
	
	private void buildStartOfRegion(RegionBuilder builder) {
		builder.aRegion().startingAt(adaptee.getCurrentLineNumber(), adaptee.getCurrentColumnNumber());
	}

	protected abstract void basicPrint(Object object);

	private RegionBuilder buildEndOfRegion(RegionBuilder builder) {
		return builder.endingAt(adaptee.getCurrentLineNumber(), adaptee.getCurrentColumnNumber());
	}
	
	static class NormalPrinter extends OutputBufferPrinterAdaptor {
		public NormalPrinter(OutputBuffer adaptee) {
			super(adaptee);
		}

		public void basicPrint(Object object) {
			adaptee.print(object);
		}
	}
	
	static class DynamicPrinter extends OutputBufferPrinterAdaptor {
		public DynamicPrinter(OutputBuffer adaptee) {
			super(adaptee);
		}

		public void basicPrint(Object object) {
			adaptee.printdyn(object);
		}
	}
	
	static class LinePrinter extends OutputBufferPrinterAdaptor {
		public LinePrinter(OutputBuffer adaptee) {
			super(adaptee);
		}

		public void basicPrint(Object object) {
			adaptee.println(object);
		}
	}
}
