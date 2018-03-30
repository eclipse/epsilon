/*******************************************************************************
 * Copyright (c) 2009-2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 *     Antonio Garcia-Dominguez - added WorkflowTestSuite
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.test;

import org.eclipse.epsilon.commons.test.CommonsTestSuite;
import org.eclipse.epsilon.concordance.test.ConcordanceTestSuite;
import org.eclipse.epsilon.ecl.engine.test.acceptance.EclAcceptanceTestSuite;
import org.eclipse.epsilon.egl.dt.test.EglDevelopmentToolsTestSuite;
import org.eclipse.epsilon.egl.dt.traceability.editor.EglTraceabilityEditorTestSuite;
import org.eclipse.epsilon.egl.engine.traceability.fine.test.acceptance.EglFineGrainedTraceabilityAcceptanceTestSuite;
import org.eclipse.epsilon.egl.engine.traceability.fine.test.unit.EglFineGrainedTraceabilityUnitTestSuite;
import org.eclipse.epsilon.egl.test.EglTestSuite;
import org.eclipse.epsilon.egx.engine.test.acceptance.EgxAcceptanceTestSuite;
import org.eclipse.epsilon.emc.bibtex.BibtexModelTestSuite;
import org.eclipse.epsilon.emc.csv.test.CsvModelTestSuite;
import org.eclipse.epsilon.emc.emf.test.EmfTestSuite;
import org.eclipse.epsilon.emc.graphml.tests.GraphmlTestSuite;
import org.eclipse.epsilon.emc.hutn.test.HutnEmcDriverTestSuite;
import org.eclipse.epsilon.emc.plainxml.test.PlainXmlTestSuite;
import org.eclipse.epsilon.emc.spreadsheets.test.SpreadsheetDriverTestSuite;
import org.eclipse.epsilon.eml.engine.test.acceptance.EmlAcceptanceTestSuite;
import org.eclipse.epsilon.eol.engine.test.acceptance.EolAcceptanceTestSuite;
import org.eclipse.epsilon.eol.test.unit.EolUnitTestSuite;
import org.eclipse.epsilon.epl.engine.test.acceptance.EplAcceptanceTestSuite;
import org.eclipse.epsilon.etl.engine.test.acceptance.EtlAcceptanceTestSuite;
import org.eclipse.epsilon.evl.engine.test.acceptance.EvlAcceptanceTestSuite;
import org.eclipse.epsilon.ewl.engine.test.acceptance.EwlAcceptanceTestSuite;
import org.eclipse.epsilon.flock.test.EpsilonFlockEngineTestSuite;
import org.eclipse.epsilon.hutn.test.HutnTestSuite;
import org.eclipse.epsilon.hutn.unparser.HutnUnparserUnitTestSuite;
import org.eclipse.epsilon.hutn.xmi.test.HutnXmiTestSuite;
import org.eclipse.epsilon.profiling.test.ProfilingTestSuite;
import org.eclipse.epsilon.workflow.test.WorkflowTestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;

@RunWith(Suite.class)
@SuiteClasses({CommonsTestSuite.class,
			   ProfilingTestSuite.class,
               EolUnitTestSuite.class, 
               EolAcceptanceTestSuite.class,
               EvlAcceptanceTestSuite.class,
               EtlAcceptanceTestSuite.class,
               EclAcceptanceTestSuite.class,
               EmlAcceptanceTestSuite.class,
               EwlAcceptanceTestSuite.class,
               EglTestSuite.class,
               EplAcceptanceTestSuite.class,
               EglDevelopmentToolsTestSuite.class,
               EglTraceabilityEditorTestSuite.class,
               EglFineGrainedTraceabilityAcceptanceTestSuite.class,
               EglFineGrainedTraceabilityUnitTestSuite.class,
               EgxAcceptanceTestSuite.class,
               HutnTestSuite.class,
               HutnUnparserUnitTestSuite.class,
               HutnXmiTestSuite.class,
               HutnEmcDriverTestSuite.class,
               PlainXmlTestSuite.class,
               BibtexModelTestSuite.class,
               EpsilonFlockEngineTestSuite.class,
               ConcordanceTestSuite.class,
               WorkflowTestSuite.class,
               GraphmlTestSuite.class,
               EmfTestSuite.class,
               SpreadsheetDriverTestSuite.class,
               CsvModelTestSuite.class})
public class EpsilonTestSuite {
	public static Test suite() {
		return new JUnit4TestAdapter(EpsilonTestSuite.class);
	}
}
