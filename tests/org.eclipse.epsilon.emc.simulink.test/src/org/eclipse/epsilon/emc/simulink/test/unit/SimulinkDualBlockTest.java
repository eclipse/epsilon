package org.eclipse.epsilon.emc.simulink.test.unit;

import org.eclipse.epsilon.emc.simulink.test.util.AbstractSimulinkTest;
import org.junit.Test;

public class SimulinkDualBlockTest extends AbstractSimulinkTest {

	@Test
	public void testGetStateflowBlock() {
		eol = 	"var name = 'MyChart'; " + LN + 
				"var chart = new `sflib/Chart`; " + LN + 
				"chart.name = name" + LN + 
				"var chartSF = chart.asStateflow();" + LN +  
				"assert(chartSF.name = name);";
	}

	@Test
	public void testGetType() {
		eol = 	"var chart = new `sflib/Chart`; " + LN + 
				"chart.println(); " + LN +
				"assert(chart.getType() = 'Chart');";
	}

	@Test
	public void testAddFromChart() {
		eol = 	"var chart = new `sflib/Chart`; " + LN + 
				"var sA = new `Stateflow.State`; " + LN +  
				"sA.Name  = 'A'; " + LN + 
				"chart.add(sA); " + LN + 
				"assert(chart.blocks().includes(sA));";
	}
	
	@Test
	public void testAdd() {
		eol = 	"var sA = new `Stateflow.State`; " + LN + 
				"sA.Name  = 'A'; " + LN + 
				"var chart = new `sflib/Chart`; " + LN +  
				"sA.parent = chart; " + LN +
				"assert(sA.name = 'A');";
	}

}
