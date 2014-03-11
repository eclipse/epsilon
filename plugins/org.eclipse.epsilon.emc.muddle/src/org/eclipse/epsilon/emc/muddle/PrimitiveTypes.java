package org.eclipse.epsilon.emc.muddle;

import org.eclipse.epsilon.emc.muddle.BooleanType;
import org.eclipse.epsilon.emc.muddle.IntegerType;
import org.eclipse.epsilon.emc.muddle.MuddleFactory;
import org.eclipse.epsilon.emc.muddle.RealType;
import org.eclipse.epsilon.emc.muddle.StringType;


public class PrimitiveTypes {
	
	protected static IntegerType integerType = MuddleFactory.eINSTANCE.createIntegerType();
	protected static StringType stringType = MuddleFactory.eINSTANCE.createStringType();
	protected static BooleanType booleanType = MuddleFactory.eINSTANCE.createBooleanType();
	protected static RealType realType = MuddleFactory.eINSTANCE.createRealType();
	
	public static IntegerType getIntegerType() {
		return integerType;
	}
	
	public static StringType getStringType() {
		return stringType;
	}
	
	public static BooleanType getBooleanType() {
		return booleanType;
	}
	
	public static RealType getRealType() {
		return realType;
	}
}
