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
