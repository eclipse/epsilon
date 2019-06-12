/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.emc.simulink.engine;

import java.lang.reflect.Method;
import java.util.concurrent.Future;

import org.eclipse.epsilon.emc.simulink.exception.MatlabException;
import org.eclipse.epsilon.emc.simulink.util.MatlabEngineUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("unchecked")
public class MatlabEngine {

	/** ENGINE STATIC METHODS */
	private static final String CONNECT_MATLAB_METHOD = "connectMatlab";
	private static final String CONNECT_MATLAB_ASYNC_METHOD = "connectMatlabAsync";
	private static final String START_MATLAB_METHOD = "connectMatlab";
	private static final String START_MATLAB_ASYNC_METHOD = "connectMatlabAsync";
	private static final String FIND_MATLAB_METHOD = "connectMatlab";
	private static final String FIND_MATLAB_ASYNC_METHOD = "connectMatlabAsync";

	/** ENGINE METHODS */
	private static final String GET_VARIABLE_METHOD = "getVariable";
	private static final String GET_VARIABLE_ASYNC_METHOD = "getVariableAsync";
	private static final String PUT_VARIABLE_METHOD = "putVariable";
	private static final String PUT_VARIABLE_ASYNC_METHOD = "putVariableAsync";
	private static final String EVAL_METHOD = "eval";
	private static final String EVAL_ASYNC_METHOD = "evalAsync";
	private static final String FEVAL_METHOD = "feval";
	private static final String FEVAL_ASYNC_METHOD = "fevalAsync";
	private static final String DISCONNECT_METHOD = "disconnect";
	private static final String DISCONNECT_ASYNC_METHOD = "disconnectAsync";
	private static final String QUIT_METHOD = "quit";
	private static final String QUIT_ASYNC_METHOD = "quitAsync";
	private static final String CLOSE_METHOD = "close";

	private static final String RESULT = "result";
	private static final String ASIGN = " = ";
	private static final String PARAM_REGEX = "[?]";

	/** MATHWOWRKS CLASS */
	private static final String MATLAB_ENGINE_CLASS = "com.mathworks.engine.MatlabEngine";
	
	/** ERRORS AND LOGS */
	private static final String ERROR_INVALID_PARAMETER_NUMBER = "%d parameters were expected but %d were provided";
	private static final Logger LOGGER = LoggerFactory.getLogger(MatlabEngine.class);
	
	/** VARIABLES */
	protected Object engine;
	private static Class<?> engine_class;

	/** METHODS */
	protected Method getVariableMethod;
	protected Method getVariableAsyncMethod;
	protected Method putVariableMethod;
	protected Method putVariableAsyncMethod;
	protected Method evalMethod;
	protected Method evalAsyncMethod;
	protected Method fevalMethod;
	protected Method fevalWithVariableOutputsMethod;
	protected Method fevalAsyncMethod;
	protected Method closeMethod;
	protected Method quitMethod;
	protected Method disconnectMethod;
	

	public MatlabEngine(Class<?> matlabEngineClass) throws Exception {
		try{
			engine = matlabEngineClass.getMethod(CONNECT_MATLAB_METHOD).invoke(null);
		} catch (Exception e) {
			LOGGER.debug("retrying connection");
			engine = matlabEngineClass.getMethod(CONNECT_MATLAB_METHOD).invoke(null);
		}
	}

	public Object evalWithSetupAndResult(String setup, String cmd, Object... parameters) throws MatlabException {
		eval(setup + (setup.endsWith(";") ? "" : ";") + RESULT + ASIGN + cmd, parameters);
		return getVariable(RESULT);
	}

	public Object evalWithResult(String cmd) throws MatlabException {
		eval(RESULT + ASIGN + cmd);
		return getVariable(RESULT);
	}

	public Object evalWithResult(String cmd, Object... parameters) throws MatlabException {
		eval(RESULT + ASIGN + cmd, parameters);
		return getVariable(RESULT);
	}

	public void eval(String cmd, Object... parameters) throws MatlabException {
		cmd = " " + cmd + " ";
		String[] parts = cmd.split(PARAM_REGEX);
		if (parts.length != parameters.length + 1) {
			String error = String.format(ERROR_INVALID_PARAMETER_NUMBER, parts.length - 1, parameters.length);
			throw new RuntimeException(error);
		}
		cmd = parts[0];
		for (int i = 0; i < parameters.length; i++) {
			cmd += String.valueOf(parameters[i]).replace("'", "''").replace("\n", "\\n") + parts[i + 1];
		}
		cmd = cmd.substring(1, cmd.length() - 1);
		eval(cmd);
	}

	/** CLASS HELPERS */
	public static boolean is(Object obj) {
		return (getMatlabClass() == null) ? false : getMatlabClass().isInstance(obj);  
	}
	
	protected static Class<?> getMatlabClass() {
		if (engine_class == null) {
			try {
				engine_class = ClassLoader.getSystemClassLoader().loadClass(MATLAB_ENGINE_CLASS);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return engine_class;
	}
	
	public MatlabEngine(Object engine) {
		if (is(engine)) {
			this.engine = engine;
		}
	}
	
	/** CLASS METHODS */
	
	public static MatlabEngine startMatlab() throws MatlabException {
		try {
			Method startMatlabMethod = engine_class.getMethod(START_MATLAB_METHOD);
			Object returnedEngine = startMatlabMethod.invoke(null);
			return new MatlabEngine(returnedEngine);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MatlabException(e); 
		}
	}
	
	public static MatlabEngine startMatlab(String[] options) throws MatlabException {
		try {
			Method startMatlabMethod = engine_class.getMethod(START_MATLAB_METHOD, String[].class);
			Object returnedEngine = startMatlabMethod.invoke(null, options);
			return new MatlabEngine(returnedEngine);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MatlabException(e); 
		}
	}
	
	public static String[] findMatlab() throws MatlabException {
		try {
			Method findMatlabMethod = engine_class.getMethod(FIND_MATLAB_METHOD);
			return (String[]) findMatlabMethod.invoke(null);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MatlabException(e); 
		}
	}
	
	public static MatlabEngine connectMatlab() throws MatlabException {
		try {
			Method connectMatlabMethod = engine_class.getMethod(CONNECT_MATLAB_METHOD);
			Object returnedEngine = connectMatlabMethod.invoke(null);
			return new MatlabEngine(returnedEngine);		
		} catch (Exception e) {
			e.printStackTrace();
			throw new MatlabException(e); 
		}
	}
	
	public static MatlabEngine connectMatlab(String name) throws MatlabException {
		try {
			Method connectMatlabMethod = engine_class.getMethod(CONNECT_MATLAB_METHOD, String.class);
			Object returnedEngine = connectMatlabMethod.invoke(null, name);
			return new MatlabEngine(returnedEngine);		
		} catch (Exception e) {
			e.printStackTrace();
			throw new MatlabException(e); 
		}
	}
	
	// TODO continue with the asynchronous static class methods 
	
	/** OBJECT METHODS */
	
	public void eval(String cmd) throws MatlabException {
		if (evalMethod == null) {
			try {
				evalMethod = engine.getClass().getMethod(EVAL_METHOD, String.class);
			} catch (Exception e) {
				throw new MatlabException(e);
			}
		}
		try {
			LOGGER.debug(cmd);
			evalMethod.invoke(engine, cmd);
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new MatlabException(e);
		}
	}
	

	public Future<Void> evalAsync(String cmd) throws MatlabException {
		if (evalAsyncMethod == null) {
			try {
				evalAsyncMethod = engine.getClass().getMethod(EVAL_ASYNC_METHOD, String.class);
			} catch (Exception e) {
				throw new MatlabException(e);
			}
		}
		try {
			return (Future<Void>) evalAsyncMethod.invoke(engine, cmd);
		} catch (Exception e) {
			throw new MatlabException(e);
		}
	}
	
	public Object getVariable(String variable) throws MatlabException {
		if (getVariableMethod == null) {
			try {
				getVariableMethod = engine.getClass().getMethod(GET_VARIABLE_METHOD, String.class);
			} catch (Exception e) {
				throw new MatlabException(e);
			}
		}
		try {
			return MatlabEngineUtil.parseMatlabEngineVariable(getVariableMethod.invoke(engine, variable));
		} catch (Exception e) {
			throw new MatlabException(e);
		}
	}
	
	public Object feval(int numberOfOutputs, String function, Object...handles) throws MatlabException {
		if (fevalWithVariableOutputsMethod == null) {
			try {
				fevalWithVariableOutputsMethod = engine.getClass().getMethod(FEVAL_METHOD, int.class, String.class, Object[].class);
			} catch (Exception e) {
				throw new MatlabException(e);
			}
		}
		try {
			Object res = fevalWithVariableOutputsMethod.invoke(engine, numberOfOutputs, function, handles);
			if (res != null) {
				return MatlabEngineUtil.parseMatlabEngineVariable(res);
			}
			return null;
		} catch (Exception e) {
			throw new MatlabException(e);
		}
	}
	
		
	public Object feval(String function, Object... handles) throws MatlabException {
		if (fevalMethod == null) {
			try {
				fevalMethod = engine.getClass().getMethod(FEVAL_METHOD, String.class, Object[].class);
			} catch (Exception e) {
				throw new MatlabException(e);
			}
		}
		try {
			Object res = fevalMethod.invoke(engine, function, handles);
			if (res != null) {
				return MatlabEngineUtil.parseMatlabEngineVariable(res);
			}
			
		} catch (Exception e) {
			MatlabException e1 = new MatlabException(e);
			// Some methods such as saveChanges have no returning value. If called 
			// with this function and fails with not finding the method or the method
			// throwing an exception, try reducing the number of expected outputs
			System.err.println("Trying to find alternative '" + function + "' method...");
			if (e1.isMatchingSignatureError() || e1.isTooManyOutput()) {
				System.err.println("Alternative found for '" + function + "' method");
				return feval(0, function, handles);		
			} else {
				System.err.println("No alternative found for '" + function + "' method");
				throw e1;
			}
		}
		return null;
	}
	
	/*
	// FIXME
	public <T> Future<T> getVariableAsync(String variable) throws MatlabException {
		if (getVariableAsyncMethod == null) {
			try {
				getVariableAsyncMethod = engine.getClass().getMethod(GET_VARIABLE_ASYNC_METHOD, String.class);
			} catch (Exception e) {
				throw new MatlabException(e);
			}
		}
		try {
			Future<T> response = (Future<T>) getVariableAsyncMethod.invoke(engine, variable);
			// TODO Parse into T
			return (Future<T>) response;
		} catch (Exception e) {
			throw new MatlabException(e);
		}
	}*/

	public void putVariable(String variableName, Object value) throws MatlabException {
		if (putVariableMethod == null) {
			try {
				putVariableMethod = engine.getClass().getMethod(PUT_VARIABLE_METHOD, String.class, Object.class);
			} catch (Exception e) {
				throw new MatlabException(e);
			}
		}
		try {
			putVariableMethod.invoke(engine, variableName, value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MatlabException(e);
		}
	}
	
	public void close() throws MatlabException {
		if (closeMethod == null) {
			try {
				closeMethod = engine.getClass().getMethod(CLOSE_METHOD);
			} catch (Exception e) {
				throw new MatlabException(e);
			}
		}
		try {
			closeMethod.invoke(engine);
		} catch (Exception e) {
			throw new MatlabException(e);
		}
	}
	
	public void quit() throws MatlabException {
		if (quitMethod == null) {
			try {
				quitMethod = engine.getClass().getMethod(QUIT_METHOD);
			} catch (Exception e) {
				throw new MatlabException(e);
			}
		}
		try {
			quitMethod.invoke(engine);
		} catch (Exception e) {
			throw new MatlabException(e);
		}
	}
	
	public void disconnect() throws MatlabException {
		if (disconnectMethod == null) {
			try {
				disconnectMethod = engine.getClass().getMethod(DISCONNECT_METHOD);
			} catch (Exception e) {
				throw new MatlabException(e);
			}
		}
		try {
			disconnectMethod.invoke(engine);
		} catch (Exception e) {
			throw new MatlabException(e);
		}
	}

}