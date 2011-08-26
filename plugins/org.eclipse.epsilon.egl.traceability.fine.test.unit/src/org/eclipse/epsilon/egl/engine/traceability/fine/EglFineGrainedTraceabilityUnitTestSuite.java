/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.engine.traceability.fine;

import org.eclipse.epsilon.egl.engine.traceability.fine.context.FeatureAccessRecorderTests;
import org.eclipse.epsilon.egl.engine.traceability.fine.operations.print.PrintOperationExecutionTests;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.builder.TraceBuilderTests;
import org.eclipse.epsilon.egl.engine.traceability.fine.wrappers.TraceablePropertyGetterTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ FeatureAccessRecorderTests.class, PrintOperationExecutionTests.class,
		        TraceablePropertyGetterTests.class, TraceBuilderTests.class })
public class EglFineGrainedTraceabilityUnitTestSuite {

}
