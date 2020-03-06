/*******************************************************************************
 * Copyright (c) 2009-2019 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *	  Louis Rose - initial API and implementation
 *	  Antonio Garcia-Dominguez - added WorkflowTestSuite
 *	  Sina Madani - advanced tests
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.test;

import org.eclipse.epsilon.commons.test.*;
import org.eclipse.epsilon.concordance.test.*;
import org.eclipse.epsilon.ecl.engine.test.acceptance.*;
import org.eclipse.epsilon.egl.dt.test.*;
import org.eclipse.epsilon.egl.dt.traceability.editor.*;
import org.eclipse.epsilon.egl.engine.traceability.fine.test.acceptance.*;
import org.eclipse.epsilon.egl.engine.traceability.fine.test.unit.*;
import org.eclipse.epsilon.egl.test.*;
import org.eclipse.epsilon.egx.engine.test.acceptance.*;
import org.eclipse.epsilon.emc.bibtex.*;
import org.eclipse.epsilon.emc.csv.test.*;
import org.eclipse.epsilon.emc.emf.test.*;
import org.eclipse.epsilon.emc.graphml.tests.*;
import org.eclipse.epsilon.emc.hutn.test.*;
import org.eclipse.epsilon.emc.plainxml.test.*;
import org.eclipse.epsilon.emc.simulink.test.suite.*;
import org.eclipse.epsilon.emc.spreadsheets.test.*;
import org.eclipse.epsilon.eml.engine.test.acceptance.*;
import org.eclipse.epsilon.eol.engine.test.acceptance.*;
import org.eclipse.epsilon.eol.test.unit.*;
import org.eclipse.epsilon.epl.engine.test.acceptance.*;
import org.eclipse.epsilon.etl.engine.test.acceptance.*;
import org.eclipse.epsilon.evl.engine.test.acceptance.*;
import org.eclipse.epsilon.ewl.engine.test.acceptance.*;
import org.eclipse.epsilon.flexmi.test.FlexmiTestSuite;
import org.eclipse.epsilon.flock.test.*;
import org.eclipse.epsilon.hutn.test.*;
import org.eclipse.epsilon.hutn.unparser.*;
import org.eclipse.epsilon.hutn.xmi.test.*;
import org.eclipse.epsilon.workflow.test.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;

@RunWith(Suite.class)
@SuiteClasses({
	CommonsTestSuite.class,
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
	//SimulinkTestSuite.class,
	SpreadsheetDriverTestSuite.class,
	CsvModelTestSuite.class,
	FlexmiTestSuite.class,
	//EvlAdvancedTestSuite.class
})
public class EpsilonTestSuite {
	public static Test suite() {
		return new JUnit4TestAdapter(EpsilonTestSuite.class);
	}
}
