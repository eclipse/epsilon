/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.emc.simulink.exception;

public class MatlabEngineException extends Exception {
	
	private static final String MATLAB_ENGINE_EXCEPTION_CLASS = "com.mathworks.engine.EngineException";
	protected static Class<?> clazz;

	static {
		try {
			clazz = ClassLoader.getSystemClassLoader().loadClass(MATLAB_ENGINE_EXCEPTION_CLASS);
		} catch (ClassNotFoundException e) {
			System.out.println("Caught exception ");
		}
	}
	
	public static Boolean isMatlabEngineException(Exception e) {
		return clazz.isInstance(e);
	}
	

}
