package org.eclipse.epsilon.hutn.test.acceptance.valid;

import org.eclipse.epsilon.hutn.test.acceptance.util.HutnAcceptanceTest;
import org.junit.BeforeClass;
import org.junit.Test;

public class DoublesAndFloats extends HutnAcceptanceTest {
	
	@BeforeClass
	public static void executeHutn() throws Exception {
		final String hutn = "@Spec {"                              +
	                        "	MetaModel \"FamiliesMetaModel\" {" +
	                        "		nsUri = \"families\""          +
	                        "	}"                                 +
	                        "}"                                    +
                            "Families {"                           +
                            "	Family \"The Smiths\" {"           +
                            "		averageAge: 26.7"              + // averageAge is type EFloat
                            "       averageAgePrecise: 26.7"       + // averageAgePrecise is type EDouble
                            "	}"                                 +
                            "}";
		
		model = generateModel(hutn);
	}
	
	@Test
	public void floatTypedSlotShouldProduceFloatValues() {
		model.assertEquals("java.lang.Float", "Family.all.first.averageAge.class.name");
	}
	
	@Test
	public void doubleTypedSlotShouldProduceDoubleValues() {
		model.assertEquals("java.lang.Double", "Family.all.first.averageAgePrecise.class.name");
	}

}
