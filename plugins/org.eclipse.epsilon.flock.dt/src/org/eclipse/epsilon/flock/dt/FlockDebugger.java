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
package org.eclipse.epsilon.flock.dt;

import org.eclipse.epsilon.eol.dt.debug.EolDebugger;
import org.eclipse.epsilon.flock.parse.FlockParser;

public class FlockDebugger extends EolDebugger {
	
	public FlockDebugger() {
		super();
		expressionOrStatementBlockContainers.add(FlockParser.GUARD);
		expressionOrStatementBlockContainers.add(FlockParser.MIGRATE);
		structuralBlocks.add(FlockParser.MIGRATE);
		structuralBlocks.add(FlockParser.DELETE);
		structuralBlocks.add(FlockParser.RETYPE);
	}
	
}
