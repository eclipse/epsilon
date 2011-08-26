/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.egl.engine.traceability.fine.operations.print;

import org.eclipse.epsilon.egl.engine.traceability.fine.trace.Region;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.builder.RegionBuilder;



public interface Printer {
	
	public Region print(Object object, RegionBuilder builder);
}