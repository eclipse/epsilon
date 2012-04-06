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
package org.eclipse.epsilon.evl.dt.launching;

import org.eclipse.epsilon.eol.dt.debug.EolDebugger;
import org.eclipse.epsilon.evl.parse.EvlParser;

public class EvlDebugger extends EolDebugger {
	
	public EvlDebugger() {
		super();
		expressionOrStatementBlockContainers.add(EvlParser.GUARD);
		expressionOrStatementBlockContainers.add(EvlParser.TITLE);
		expressionOrStatementBlockContainers.add(EvlParser.MESSAGE);
		expressionOrStatementBlockContainers.add(EvlParser.CHECK);
		expressionOrStatementBlockContainers.add(EvlParser.DO);
		structuralBlocks.add(EvlParser.CONTEXT);
		structuralBlocks.add(EvlParser.CONSTRAINT);
		structuralBlocks.add(EvlParser.CRITIQUE);
		structuralBlocks.add(EvlParser.FIX);
	}	
}
