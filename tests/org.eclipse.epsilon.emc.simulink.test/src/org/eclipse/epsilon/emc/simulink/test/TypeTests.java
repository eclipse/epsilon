package org.eclipse.epsilon.emc.simulink.test;

import org.junit.Ignore;
import org.junit.Test;

public class TypeTests extends AbstractSimulinkTest {

	/** SIMULINK OBJECTS*/

	@Test
	public void testSimulinkType(){
		eol = "var gain = new `simulink/Math Operations/Gain`; "

				+ "assert(gain.isTypeOf(Gain)); ";
	}

	@Test
	public void testSimulinkKind(){
		eol = "var gain = new `simulink/Math Operations/Gain`; "

				+ "assert(gain.isKindOf(Gain)); ";
	}

	@Test
	public void testSimulinkTypeAll(){
		eol = "var gain = new `simulink/Math Operations/Gain`; "

				+ "assert(Gain.all.size().println = 1); ";
	}

	@Test
	public void testSimulinkTypeAllOfType(){
		eol = "var gain = new `simulink/Math Operations/Gain`; "

				+ "assert(Gain.allOfType.size().println = 1); ";
	}

	@Test
	public void testSimulinkTypeAllOfKind(){
		eol = "var gain = new `simulink/Math Operations/Gain`; "

				+ "assert(Gain.allOfKind.size().println = 1); ";
	}
	
	// 
	@Test
	public void testSimulinkBlockType(){
		eol = "var gain = new `simulink/Math Operations/Gain`; "

				+ "assert(gain.isTypeOf(Block)); ";
	}

	@Test
	public void testSimulinkBlockKind(){
		eol = "var gain = new `simulink/Math Operations/Gain`; "

				+ "assert(gain.isKindOf(Block)); ";
	}

	@Test
	public void testSimulinkBlockTypeAll(){
		eol = "var gain = new `simulink/Math Operations/Gain`; "

				+ "assert(Block.all.size().println = 1); ";
	}

	@Test
	public void testSimulinkBlockTypeAllOfType(){
		eol = "var gain = new `simulink/Math Operations/Gain`; "

				+ "assert(Block.allOfType.size().println = 1); ";
	}

	@Test
	public void testSimulinkBlockTypeAllOfKind(){
		eol = "var gain = new `simulink/Math Operations/Gain`; "

				+ "assert(Block.allOfKind.size().println = 1); ";
	}

	/** SIMULINK STATEFLOW OBJECT (CHART) */

	@Test 
	public void testSimulinkStateflowIsTypeOf(){
		eol = "var chart = new `sflib/Chart`; "

				+ "assert(chart.isTypeOf(Chart));"; 
	}

	@Test 
	public void testSimulinkStateflowType(){
		eol = "var chart = new `sflib/Chart`; "
				
				+ "assert(chart.type = 'Chart')); "; 
	}

	@Test 
	public void testSimulinkStateflowTypeAll(){
		eol = "var chart = new `sflib/Chart`; "

				+ "assert(Chart.all.size().println = 1); ";
	}

	@Test 
	public void testSimulinkStateflowTypeAllOfType(){
		eol = "var chart = new `sflib/Chart`; "

				+ "assert(Chart.allOfType.size().println = 1); ";
	}

	@Test 
	public void testSimulinkStateflowTypeAllOfKind(){
		eol = "var chart = new `sflib/Chart`; "

				+ "assert(Chart.allOfKind.size().println = 1); ";
	}

	/** STATEFLOW OBJECT */

	@Test
	public void testStateflowType(){
		eol = "var chart = new `sflib/Chart`; "
				+ "var state = new `Stateflow.State`(chart); "

				+ "assert(state.type.println = 'State'); ";
	}

	@Test
	@Ignore
	public void testStateflowTypeAllShort(){
		eol = "var chart = new `sflib/Chart`; "
				+ "var state = new `Stateflow.State`(chart); "

				+ "assert(State.all.size().println = 1); ";
	}

	@Test
	public void testStateflowTypeAllLong(){
		eol = "var chart = new `sflib/Chart`; "
				+ "var state = new `Stateflow.State`(chart); "

				+ "assert(`Stateflow.State`.all.size().println = 1); ";
	}

	@Test
	@Ignore
	public void testStateflowTypeAllOfTypeShort(){
		eol = "var chart = new `sflib/Chart`; "
				+ "var state = new `Stateflow.State`(chart); "

				+ "assert(State.allOfType.size().println = 1); ";
	}

	@Test
	public void testStateflowTypeAllOfTypeLong(){
		eol = "var chart = new `sflib/Chart`; "
				+ "var state = new `Stateflow.State`(chart); "

				+ "assert(`Stateflow.State`.allOfType.size().println = 1); ";
	}

	@Test
	@Ignore
	public void testStateflowTypeAllOfKindShort(){
		eol = "var chart = new `sflib/Chart`; "
				+ "var state = new `Stateflow.State`(chart); "

				+ "assert(State.allOfKind.size().println = 1); ";
	}

	@Test
	public void testStateflowTypeAllOfKindLong(){
		eol = "var chart = new `sflib/Chart`; "
				+ "var state = new `Stateflow.State`(chart); "

				+ "assert(`Stateflow.State`.allOfKind.size().println = 1); ";
	}

	/** STATEFLOW OBJECT WITH EMPTY CONSTRUCTOR*/

	@Test
	@Ignore
	public void testStateflowTypeWithEmptyConstructor(){
		eol = "var state = new `Stateflow.State`; "

				+ "assert(`Stateflow.State`.type.println = 'State'); ";
	}

	@Test
	@Ignore
	public void testStateflowTypeAllWithEmptyConstructor(){
		eol = "var state = new `Stateflow.State`; "

				+ "assert(State.all.size().println = 1); ";
	}

	@Test
	@Ignore
	public void testStateflowTypeAllOfTypeWithEmptyConstructor(){
		eol = "var state = new `Stateflow.State`; "

				+ "assert(State.allOfType.size().println = 1); ";
	}

	@Test
	@Ignore
	public void testStateflowTypeAllOfKindWithEmptyConstructor(){
		eol = "var state = new `Stateflow.State`; "

				+ "assert(State.allOfKind.size().println = 1); ";
	}

}
