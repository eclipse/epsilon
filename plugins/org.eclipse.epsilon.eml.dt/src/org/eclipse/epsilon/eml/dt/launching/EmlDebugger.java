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
package org.eclipse.epsilon.eml.dt.launching;

import org.eclipse.epsilon.eml.parse.EmlParser;
import org.eclipse.epsilon.etl.dt.launching.EtlDebugger;

public class EmlDebugger extends EtlDebugger {

	public EmlDebugger() {
		super();
		expressionOrStatementBlockContainers.add(EmlParser.MERGE);
		structuralBlocks.add(EmlParser.MERGE);
	}
	
	
}
