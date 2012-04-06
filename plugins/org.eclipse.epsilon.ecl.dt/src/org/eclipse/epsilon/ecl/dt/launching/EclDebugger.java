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
package org.eclipse.epsilon.ecl.dt.launching;

import org.eclipse.epsilon.ecl.parse.EclParser;
import org.eclipse.epsilon.eol.dt.debug.EolDebugger;

public class EclDebugger extends EolDebugger {
	
	public EclDebugger() {
		super();
		expressionOrStatementBlockContainers.add(EclParser.DO);
		expressionOrStatementBlockContainers.add(EclParser.COMPARE);
		structuralBlocks.add(EclParser.MATCH);
	}
	
}
