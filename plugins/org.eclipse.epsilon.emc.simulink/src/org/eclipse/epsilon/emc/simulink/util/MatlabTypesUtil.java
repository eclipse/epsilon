package org.eclipse.epsilon.emc.simulink.util;

public class MatlabTypesUtil {

	/**
	 	import com.mathworks.engine.MatlabEngine;
		import com.mathworks.matlab.types.*;
		
		MatlabEngine engine = MatlabEngine.startMatlab();
		engine.eval("cm = containers.Map({'id','name'},{11,'mw'});");
		HandleObject handle = engine.getVariable("cm");
		String[] cells = engine.feval("keys", handle);
	 */
	
	private static final String MATLAB_TYPES_PACKAGE = "com.mathworks.matlab.types.";
	private static final String COMPLEX_TYPE = MATLAB_TYPES_PACKAGE + "Complex";
	private static final String STRUCT_TYPE = MATLAB_TYPES_PACKAGE + "Struct";
	private static final String CELL_STR_TYPE = MATLAB_TYPES_PACKAGE + "CellStr";
	private static final String HANDLE_OBJECT_TYPE = MATLAB_TYPES_PACKAGE + "HandleObject";
	

}
