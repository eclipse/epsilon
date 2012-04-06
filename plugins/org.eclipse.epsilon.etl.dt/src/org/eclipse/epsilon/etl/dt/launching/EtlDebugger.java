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
package org.eclipse.epsilon.etl.dt.launching;

import org.eclipse.epsilon.eol.dt.debug.EolDebugger;
import org.eclipse.epsilon.etl.parse.EtlParser;

public class EtlDebugger extends EolDebugger {
	
	public EtlDebugger() {
		super();
		expressionOrStatementBlockContainers.add(EtlParser.TRANSFORM);
		expressionOrStatementBlockContainers.add(EtlParser.GUARD);
		expressionOrStatementBlockContainers.add(EtlParser.PRE);
		expressionOrStatementBlockContainers.add(EtlParser.POST);
		structuralBlocks.add(EtlParser.TRANSFORM);
	}
	
}
