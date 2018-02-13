package org.eclipse.epsilon.emc.simulink.test.unit;

import org.eclipse.epsilon.emc.simulink.test.util.AbstractSimulinkTest;
import org.junit.Test;


public class CRUDTests extends AbstractSimulinkTest {
	
	/** Simulink Gain */
	
	@Test
	public void testCreateSimulinkGain(){
		eol = "var gain = new `simulink/Math Operations/Gain`; "
				+ "assert(Gain.all.size() = 1); "
				+ "var gain2 = new `simulink/Math Operations/Gain`; "
				+ "assert(Gain.all.size() = 2); "
				;
	}
	
	@Test
	public void testDeleteSimulinkGain(){
		eol = "var gain = new `simulink/Math Operations/Gain`; "
				+ "delete gain; "
				+ "assert(Gain.all.size() = 0);";
	}
	
	/** Simulink Chart */
	
	@Test
	public void testDeleteSimulinkChart(){
		eol = "var chart = new `sflib/Chart`; "
				+ "var prevSize = Chart.all.size();"
				+ "delete chart; "
				+ "assert(Chart.all.size() = (prevSize - 1));";
	}
	
	/** Stateflow State */
		
	@Test
	public void testCreateStateflowState(){
		eol = "var chart = new `sflib/Chart`; "
				+ "var prevSize = State.all.size();"
				+ "var state = new `Stateflow.State`(chart); "
				+ "assert(State.all.size() = (prevSize + 1));";
	}
	
	@Test
	public void testCreateStateflowStateWithEmptyConstructor(){
		eol = "var state = new `Stateflow.State`; "
				+ "var chart = new `sflib/Chart`; "
				+ "chart.add(state); "
				+ "assert(State.all.size() = 1);";
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
				+ "var chart = new `sflib/Chart`; "
				+ "chart.add(state); "
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
		eol = "var state = new `Stateflow.State`; "
				+ "state.name = 'S1'; "
				+ "assert(state.name = 'S1'); "
				+ "var chart = new `sflib/Chart`; "
				+ "chart.add(state); "
				+ "state.name = 'S2'; "
				+ "assert(state.name = 'S2'); ";
	}
	

	@Test
	public void testDeleteStateflowState(){
		eol = "var chart = new `sflib/Chart`; "
				+ "var state = new `Stateflow.State`(chart); "
				+ "var prevSize = State.all.size();"
				+ "delete state; "
				+ "assert(State.all.size() = (prevSize - 1));";
	}
	
	@Test
	public void testDeleteStateflowStateWithEmptyConstructor(){
		eol = "var state = new `Stateflow.State`; "
				+ "var chart = new `sflib/Chart`; "
				+ "chart.add(state); "
				+ "assert(State.all.size() = 1);"
				+ "delete state; "
				+ "assert(State.all.size() = 0);";
	}
	
}
