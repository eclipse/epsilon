package org.eclipse.epsilon.emc.simulink.test;

import org.junit.Test;

public class GetterSetterAndOperationTests extends AbstractSimulinkTest {
	
	@Test
	public void testSimulinkOperationContributor() {
		eol = "var gain = new `simulink/Math Operations/Gain`; "
				+ "assert(gain.get_param('BlockType').println = 'Gain');";
	}
	
	@Test
	public void testStateflowOperationContributorWithNoParams() {
		eol = "var chart = new `sflib/Chart`; "
				+ "var state = new `Stateflow.State`(chart); "
				+ "assert(state.isCommented().println = false);";
	}
	
	@Test
	public void testStateflowOperationContributorWithParams() {
		eol = "var chart = new `sflib/Chart`; "
				+ "var sA = new `Stateflow.State`(chart); "
				+ "sA.position = '[50 50 310 200]';"
				+ "sA.position.println;"
				+ "var sA1 = new `Stateflow.State`(chart); "
				+ "sA1.position = '[80 120 90 60]';"
				+ "sA1.position.println;"
				+ "sA.find('-depth',1).println;"
				+ "assert(sA.find('-isa','Stateflow.State').println<>null)";
	}
	
	@Test
	public void testSimulinkScriptProperty() {
		String script = "function y = fcn(x) \\\\n y = 2 * x;";
		eol = String.format(
				  "var multiply = new `simulink/User-Defined Functions/MATLAB Function`;"
				+ "multiply.script = '%s';"
				+ "assert(multiply.script = '%s')", 
				script, script);	
	}
	
	@Test
	public void testStateflowTypeProperty() {
		eol = "var chart = new `sflib/Chart`; "
			+ "var state = new `Stateflow.State`(chart); "
			+ "assert(state.type = 'State');"
			+ "assert(state.type = state.getSimpleType());";
	}
	
	@Test
	public void testSimulinkGainTypeProperty() {
		eol = "var gain = new `simulink/Math Operations/Gain`; "
			+ "assert(gain.type = 'Gain');"
			+ "assert(gain.type = gain.getSimpleType());";
	}
	
	@Test
	public void testSimulinkChartTypeProperty() {
		eol = "var chart = new `sflib/Chart`; "
			+ "assert(chart.type = 'Chart');"
			+ "assert(chart.type = chart.getSimpleType());";
	}
	
	@Test
	public void testStateflowIdProperty() {
		eol = "var chart = new `sflib/Chart`; "
			+ "var state = new `Stateflow.State`(chart); "
			+ "assert(state.id.println <> null);\"\n"
			+ "assert(state.id <> '');"
			+ "assert(state.id = state.getId());";
	}
	
	@Test
	public void testSimulinkGainIdProperty() {
		eol = "var gain = new `simulink/Math Operations/Gain`; "
			+ "assert(gain.id.println <> null);"
			+ "assert(gain.id <> '');"
			+ "assert(gain.id = gain.getId());";
	}
	
	@Test
	public void testSimulinkChartIdProperty() {
		eol = "var chart = new `sflib/Chart`; "
			+ "assert(chart.id.println <> null);"
			+ "assert(chart.id <> '');"
			+ "assert(chart.id = chart.getId());";
	}
	
}
