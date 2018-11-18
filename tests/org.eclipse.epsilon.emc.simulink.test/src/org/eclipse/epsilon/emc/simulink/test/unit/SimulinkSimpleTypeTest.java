/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.emc.simulink.test.unit;

import org.eclipse.epsilon.emc.simulink.test.util.AbstractSimulinkTest;
import org.eclipse.epsilon.emc.simulink.test.util.FileUtils;
import org.junit.Before;
import org.junit.Test;

public class SimulinkSimpleTypeTest extends AbstractSimulinkTest {

	@Before
	public void setup(){
		activeCache = false;
		modelFile = FileUtils.getModelFile("sldemo_varsize_basic_copy.slx");		
	}

	@Test
	public void testSID() {
		eol = "M.statement(\"a= Simulink.ID.getSID('sldemo_varsize_basic_copy/Constant')\"); M.getWorkspaceVariable('a').println();";
	}
	
	@Test
	public void testSIDwithResult() {
		eol = "M.statementWithResult(\"Simulink.ID.getSID('sldemo_varsize_basic_copy/Constant')\").println();";
	}
	
	@Test
	public void testNames() {
		eol = 	  "var selector = Selector.all().first();"
				+ "var params = selector.collect(c | c.ObjectParameters).first().println('params: '); "
				+ "var values = params.keySet().println('params: '); "
				+ "for (v in values){ "
				+ " var e = params.get(v); "
				+ " if (e.Type == 'matrix'){ "
				+ " (v + ' ' + e.Type).println();} "
				+ "}"
				+ "params.values().collect(v|v.Type).asSet().println('set: '); ";
	}
	
	@Test
	public void testTypes() {
		eol = 	  "var selector = Selector.all().first();"

				//+ "selector.Capabilities.println('matrix: '); " //matrix UNSPORTED BY MATLAB
				+ "selector.ModelParamTableInfo.println('matrix: '); " //matrix
				+ "selector.IndexOptionArray.println('matrix: '); " //matrix
				+ "selector.RuntimeObject.println('matrix: '); " //matrix
				
				+ "selector.Orientation.println('e num: ');" // enum
				
				+ "selector.Handle.println('real: ' );" // real
				+ "selector.FontSize.println('real: ');" // real
				
				+ "selector.MaskObject.println('object: ');" // object
				
				+ "selector.RTWdata.println('list: ');" // list
				
				// COPLEX
				+ "M.statement('z=roots([1.0, -1.0, 6.0])');"
				+ "M.statement('zc=conj(z)');"
				+ "M.statement('rat=z.*zc');"
				+ "M.getWorkspaceVariable('z').println('complex: ');"
				+ "M.getWorkspaceVariable('zc').println('complex: ');"
				+ "M.getWorkspaceVariable('rat').println('complex: ');"
				;
	}

}