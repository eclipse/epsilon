package org.eclipse.epsilon.emc.simulink.engine;

import java.lang.reflect.Method;
import java.util.concurrent.Future;

import org.eclipse.epsilon.emc.simulink.util.MatlabEngineUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MatlabEngine {

	/** ENGINE COMMANDS */
	private static final String CONNECT_MATLAB_METHOD = "connectMatlab";
	private static final String GET_VARIABLE_METHOD = "getVariable";
	private static final String EVAL_METHOD = "eval";
	private static final String EVAL_ASYNC_METHOD = "evalAsync";

	private static final String RESULT = "result";
	private static final String ASIGN = " = ";
	private static final String PARAM_REGEX = "[?]";

	/** ERRORS */
	private static final String ERROR_INVALID_PARAMETER_NUMBER = "%d parameters were expected but %d were provided";

	private static final Logger LOGGER = LoggerFactory.getLogger(MatlabEngine.class);
	
	/** VARIABLES */
	protected Object engine;
	protected Method evalMethod;
	protected Method getVariableMethod;

	public MatlabEngine(Class<?> matlabEngineClass) throws Exception {
		engine = matlabEngineClass.getMethod(CONNECT_MATLAB_METHOD).invoke(null);
		evalMethod = engine.getClass().getMethod(EVAL_METHOD, String.class);
		getVariableMethod = engine.getClass().getMethod(GET_VARIABLE_METHOD, String.class);
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

	public void eval(String cmd) throws MatlabException {
		try {
			LOGGER.debug("EMC-Simulink: " + cmd);
			evalMethod.invoke(engine, cmd);
		} catch (Exception e) {
			LOGGER.error("EMC-Simulink: " + e.getMessage());
			e.printStackTrace();
			throw new MatlabException(e);
		}
	}

	public Object getVariable(String variable) throws MatlabException {
		try {
			return MatlabEngineUtil.parseMatlabEngineVariable(getVariableMethod.invoke(engine, variable));
		} catch (Exception e) {
			throw new MatlabException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public Future<Void> evalAsync(String cmd) throws MatlabException {
		try {
			Method evalSyncMethod = engine.getClass().getMethod(EVAL_ASYNC_METHOD, String.class);
			return (Future<Void>) evalSyncMethod.invoke(engine, cmd);
		} catch (Exception e) {
			throw new MatlabException(e);
		}
	}

}
