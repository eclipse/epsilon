/*******************************************************************************
 * Copyright (c) 2014 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitris Kolovos - initial API and implementation
 ******************************************************************************/
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
