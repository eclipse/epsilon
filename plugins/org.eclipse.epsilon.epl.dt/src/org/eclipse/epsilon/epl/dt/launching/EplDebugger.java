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
package org.eclipse.epsilon.epl.dt.launching;

import org.eclipse.epsilon.eol.dt.debug.EolDebugger;
import org.eclipse.epsilon.epl.parse.EplParser;

public class EplDebugger extends EolDebugger {
	
	public EplDebugger() {
		super();
		expressionOrStatementBlockContainers.add(EplParser.DO);
		expressionOrStatementBlockContainers.add(EplParser.GUARD);
		expressionOrStatementBlockContainers.add(EplParser.DOMAIN);
		expressionOrStatementBlockContainers.add(EplParser.MATCH);
		expressionOrStatementBlockContainers.add(EplParser.NOMATCH);
		structuralBlocks.add(EplParser.PATTERN);
	}
	
}
