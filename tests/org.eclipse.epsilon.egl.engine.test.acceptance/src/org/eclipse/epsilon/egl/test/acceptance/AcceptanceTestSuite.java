/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.test.acceptance;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;

import org.eclipse.epsilon.egl.test.acceptance.engine.Engine;
import org.eclipse.epsilon.egl.test.acceptance.exceptions.Exceptions;
import org.eclipse.epsilon.egl.test.acceptance.merge.Merge;
import org.eclipse.epsilon.egl.test.acceptance.output.Output;
import org.eclipse.epsilon.egl.test.acceptance.output.newlines.OutputNewlines;
import org.eclipse.epsilon.egl.test.acceptance.stop.Stop;
import org.eclipse.epsilon.egl.test.acceptance.traceability.Traceability;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({Engine.class,
               Output.class, OutputNewlines.class,
               Merge.class,
               Traceability.class,
               Exceptions.class,
               Stop.class})
public class AcceptanceTestSuite {

	public static Test suite() {
		return new JUnit4TestAdapter(AcceptanceTestSuite.class);
	}
}

