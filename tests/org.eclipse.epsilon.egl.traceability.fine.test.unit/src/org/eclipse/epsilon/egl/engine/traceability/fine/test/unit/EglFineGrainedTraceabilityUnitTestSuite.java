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
package org.eclipse.epsilon.egl.engine.traceability.fine.test.unit;

import org.eclipse.epsilon.egl.engine.traceability.fine.internal.EglOutputBufferPrintExecutionListenerTests;
import org.eclipse.epsilon.egl.engine.traceability.fine.internal.TraceLinkCreatingTemplateExecutionListenerTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({EglOutputBufferPrintExecutionListenerTests.class, TraceLinkCreatingTemplateExecutionListenerTests.class})
public class EglFineGrainedTraceabilityUnitTestSuite {

}
