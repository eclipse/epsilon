/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.edl.dt.launching;

import org.eclipse.epsilon.edl.parse.EdlParser;
import org.eclipse.epsilon.eol.dt.debug.EolDebugger;

public class EdlDebugger extends EolDebugger {
	
	public EdlDebugger() {
		super();
		structuralBlocks.add(EdlParser.PROCESS);
	}
	
}
