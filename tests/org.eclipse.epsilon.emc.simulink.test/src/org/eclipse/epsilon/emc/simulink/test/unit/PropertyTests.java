package org.eclipse.epsilon.emc.simulink.test.unit;

import org.eclipse.epsilon.emc.simulink.test.util.AbstractSimulinkTest;
import org.junit.Test;

public class PropertyTests extends AbstractSimulinkTest {
	
	@Test
	public void testSimulinkScriptProperty() {
		eol = "var multiply = new `simulink/User-Defined Functions/MATLAB Function`; "
				+ "multiply.script = 'function y = fcn(x) \\\\n y = 2 * x';"
				+ "assert(multiply.script <> null); "
				+ "assert(multiply.script <> \"\");";	
	}
	
	@Test 
	public void testStateflowTypeProperty() {
		eol = "var chart = new `sflib/Chart`; "
			+ "var sfChart = `Stateflow.Chart`.all.first; " 
			+ "var state = new `Stateflow.State`(sfChart); "
			+ "assert(state.type = state.getType());";
	}
	
	@Test
	public void testSimulinkGainTypeProperty() {
		eol = "var gain = new `simulink/Math Operations/Gain`; "
			+ "assert(gain.type = 'Gain');";
	}
	
	@Test
	public void testSimulinkChartTypeProperty() {
		eol = "var chart = new `sflib/Chart`; "
			+ "assert(chart.type = 'SubSystem');";
	}
	
	@Test
	public void testStateflowIdProperty() {
		eol = "var chart = new `sflib/Chart`; "
				+ "var sfChart = `Stateflow.Chart`.all.first; " 
				+ "var state = new `Stateflow.State`(sfChart); "
				+ "assert(state.id <> null); "
				+ "assert(state.id <> ''); "
				+ "assert(state.id = state.getId());";
	}
	
	@Test
	public void testSimulinkGainIdProperty() {
		eol = "var gain = new `simulink/Math Operations/Gain`; "
			+ "assert(gain.getHandle() <> null); "
			+ "assert(gain.getHandle() <> ''); ";
	}
		
}
