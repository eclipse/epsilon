/*******************************************************************************
 * Copyright (c) 2009 The University of York.
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
package org.eclipse.concordance.test.performance.generator.graph;

import org.eclipse.concordance.test.performance.generator.AbstractGenerator;

public class GraphGenerator extends AbstractGenerator {

	public GraphGenerator() {
		super("Graph", "graph", GraphGenerator.class.getResource("GenerateModel.eol"));
	}
}
