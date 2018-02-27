package org.eclipse.epsilon.emc.simulink.test.unit;

import org.eclipse.epsilon.emc.simulink.test.util.AbstractSimulinkTest;
import org.junit.Test;

public class InheritanceTests extends AbstractSimulinkTest {
	
	// CHART PARENT
	
	@Test
	public void testChartStateflowConstParent() {
		eol = "var parent = new `sflib/Chart`; "
				+ "var sA = new `Stateflow.State`(parent); "
				+ "assert(sA.parent = parent);";
	}
	
	@Test
	public void testChartStateflowAttrParent() {
		eol = "var parent = new `sflib/Chart`; "
				+ "var sA = new `Stateflow.State`; "
				+ "sA.parent = parent; "
				+ "assert(sA.parent = parent);";
	}
	
	@Test
	public void testChartStateflowAddParent() {
		eol = "var parent = new `sflib/Chart`; "
				+ "var sA = new `Stateflow.State`; "
				+ "parent.add(sA); "
				+ "assert(sA.parent = parent);";
	}
	
	@Test
	public void testStateflowConstChartChildren() {
		eol = "var parent = new `sflib/Chart`; "
				+ "var sA = new `Stateflow.State`(parent); "
				+ "assert(parent.blocks.includes(sA));";
	}
	
	@Test
	public void testStateflowAttrChartChildren() {
		eol = "var parent = new `sflib/Chart`; "
				+ "var sA = new `Stateflow.State`; "
				+ "sA.parent = parent; "
				+ "assert(parent.blocks.includes(sA));";
	}
	
	@Test
	public void testAddStateflowChartChildren() {
		eol = "var parent = new `sflib/Chart`; "
				+ "var sA = new `Stateflow.State`; "
				+ "parent.add(sA); "
				+ "assert(parent.blocks.includes(sA));";
	}
	
	// STATEFLOW PARENT
	
	@Test
	public void testSfStateflowConstParent() {
		eol = "var function = new `simulink/User-Defined Functions/MATLAB Function`;"
				+ "var parent = EMChart.all.first(); "
				+ "var sA = new `Stateflow.State`(parent); "
				+ "assert(sA.parent = parent);";
	}
	
	@Test
	public void testSfStateflowAttrParent() {
		eol = "var function = new `simulink/User-Defined Functions/MATLAB Function`;"
				+ "var parent = EMChart.all.first(); "
				+ "var sA = new `Stateflow.State`; "
				+ "sA.parent = parent; "
				+ "assert(sA.parent = parent);";
	}
	
	@Test
	public void testSfStateflowAddParent() { // OK
		eol = "var function = new `simulink/User-Defined Functions/MATLAB Function`;"
				+ "var parent = EMChart.all.first(); "
				+ "var sA = new `Stateflow.State`; "
				+ "parent.add(sA); "
				+ "assert(sA.parent = parent);";
	}
	
	@Test
	public void testStateflowConstSfChildren() {
		eol = "var function = new `simulink/User-Defined Functions/MATLAB Function`;"
				+ "var parent = EMChart.all.first(); "
				+ "var sA = new `Stateflow.State`(parent); "
				+ "assert(parent.blocks.includes(sA));";
	}
	
	@Test
	public void testStateflowAttrSfChildren() {
		eol = "var function = new `simulink/User-Defined Functions/MATLAB Function`;"
				+ "var parent = EMChart.all.first(); "
				+ "var sA = new `Stateflow.State`; "
				+ "sA.parent = parent; "
				+ "assert(parent.blocks.includes(sA));";
	}
	
	@Test
	public void testAddStateflowSfChildren() {
		eol = "var function = new `simulink/User-Defined Functions/MATLAB Function`;"
				+ "var parent = EMChart.all.first(); "
				+ "var sA = new `Stateflow.State`; "
				+ "parent.add(sA); "
				+ "assert(parent.blocks.includes(sA));";
	}
	
}
