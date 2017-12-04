package org.eclipse.epsilon.emc.simulink.test;

import org.junit.Test;

public class CRUDTests extends AbstractSimulinkTest {
	
	/** Simulink Gain */
	
	@Test
	public void testCreateSimulinkGain(){
		eol = "var gain = new `simulink/Math Operations/Gain`; "
				+ "assert(Gain.all.size() = 1);";
	}
	
	@Test
	public void testDeleteSimulinkGain(){
		eol = "var gain = new `simulink/Math Operations/Gain`; "
				+ "delete gain; "
				+ "assert(Gain.all.size() = 0);";
	}
	
	/** Simulink Chart */
	
	@Test
	public void testCreateSimulinkChart(){
		eol = "var chart = new `sflib/Chart`; "
				+ "assert(Chart.all.size() = 1);";
	}
	
	@Test
	public void testDeleteSimulinkChart(){
		eol = "var chart = new `sflib/Chart`; "
				+ "delete chart; "
				+ "assert(Chart.all.size() = 0);";
	}
	
	/** Stateflow State */
	
	private String stateType = "`Stateflow.State`"; // TODO decide if just "State" works 
	
	@Test
	public void testCreateStateflowState(){
		eol = "var chart = new `sflib/Chart`; "
				+ "var state = new `Stateflow.State`(chart); "
				+ "assert(" + stateType + ".all.size() = 1);";
	}
	
	@Test
	public void testCreateStateflowStateWithEmptyConstructor(){
		eol = "var state = new `Stateflow.State`; "
				+ "assert(" + stateType + ".all.size() = 1);";
	}
	
	@Test
	public void testReadStateflowId(){
		eol = "var chart = new `sflib/Chart`; "			
				+ "var state = new `Stateflow.State`(chart); "
				+ "assert(state.id <> null); "
				+ "assert(state.id.println <> \"\"); ";
	}
	
	@Test
	public void testReadStateflowIdWithEmptyConstructor(){
		eol = "var state = new `Stateflow.State`; "
				+ "assert(state.id <> null); "
				+ "assert(state.id.println <> \"\"); ";
	}

	@Test
	public void testUpdateStateflowName(){
		eol = "var chart = new `sflib/Chart`; "			
				+ "var state = new `Stateflow.State`(chart); "
				+ "state.name = 'S1'; "
				+ "assert(state.name = 'S1');";
	}
	
	@Test
	public void testUpdateStateflowNameWithEmptyConstructor(){
		eol = "var state = new `Stateflow.State`(chart); "
				+ "state.name = 'S1'; "
				+ "assert(state.name = 'S1');";
	}
	

	@Test
	public void testDeleteStateflowState(){
		eol = "var chart = new `sflib/Chart`; "
				+ "var state = new `Stateflow.State`(chart); "
				+ "assert(" + stateType + ".all.size() = 1);"
				+ "delete state; "
				+ "assert(" + stateType + ".all.size() = 0);";
	}
	
	@Test
	public void testDeleteStateflowStateWithEmptyConstructor(){
		eol = "var state = new `Stateflow.State`; "
				+ "assert(" + stateType + ".all.size() = 1);"
				+ "delete state; "
				+ "assert(" + stateType + ".all.size() = 0);";
	}
	
}
