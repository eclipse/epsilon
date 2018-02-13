package org.eclipse.epsilon.emc.simulink.test.unit;

import static org.junit.Assert.fail;

import java.io.File;

import org.eclipse.epsilon.emc.simulink.test.util.AbstractSimulinkTest;
import org.eclipse.epsilon.emc.simulink.test.util.FileUtils;
import org.junit.Test;

public class InheritanceTests extends AbstractSimulinkTest {

	private static File TRAFFIC_LIGHT = FileUtils.getModelFile("sf_traffic_light.slx"); 
	
	@Test
	public void testStateflowParent() {
	//	modelFile = TRAFFIC_LIGHT;
		/*eol = "var a = SubSystem.all;\n" + 
				"assert( a.size() > 0 );\n" + 
				"for (subsystem in a) {\n" + 
				"	(\"Exploring subsystem: \" + subsystem.name).println();\n" + 
				"	for (child in subsystem.getChildren()) {\n" + 
				"		if (child.isTypeOf(Inport)) {\n" + 
				"			(\"Inport: \" + child.name).println(\"\\t\");\n" + 
				"			(\"To: \" + child.outports[0].lines[0].destination).println(\"\\t\\t\");\n" + 
				"		}\n" + 
				"		else if (child.isTypeOf(Outport)) {\n" + 
				"			(\"Outport: \" + child.name).println(\"\\t\");\n" + 
				"			(\"From: \" + child.inports[0].lines[0].destination).println(\"\\t\\t\");\n" + 
				"		}\n" + 
				"		else {\n" + 
				"			(\"Child: \" + child.name).println(\"\\t\");\n" + 
				"		}\n" + 
				"	}\n" + 
				"}";*/
	//	eol= "var a = SubSystem.all.first().println;";
	}
	/*
	@Test
	public void testStateflowParentDelayed() {
		modelFile = TRAFFIC_LIGHT;
		fail("not yet implemented");
	}
	
	@Test
	public void testSimulinkParent() {
		modelFile = TRAFFIC_LIGHT;
		fail("not yet implemented");
	}

	@Test
	public void testSimulinkChildren() {
		modelFile = TRAFFIC_LIGHT;
		fail("not yet implemented");
	}
	
	@Test
	public void testStateflowChildren() {
		modelFile = TRAFFIC_LIGHT;
		fail("not yet implemented");
	}
	
	@Test
	public void testDualBlockChildren() {
		modelFile = TRAFFIC_LIGHT;
		fail("not yet implemented");
	}
	
	/*
	@Test
	public void setAndGetSubsystemParent() {
		eol = "var s1 = new `simulink/Ports & Subsystems/Subsystem`; " +
				"var s2 = new `simulink/Ports & Subsystems/Subsystem`;" + 
				"s1.parent = s2; " +
				"assert(s1.parent = s2);";
	}

	@Test
	public void setAndUnsetSubsystemParent() {
		eol = "var s1 = new `simulink/Ports & Subsystems/Subsystem`; " +
				"var s2 = new `simulink/Ports & Subsystems/Subsystem`;" + 
				"s1.parent = s2; " +
				"s1.parent = null; " +
				"assert(s1.parent = null);";
	}*/
	
}
