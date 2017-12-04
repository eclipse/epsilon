package org.eclipse.epsilon.emc.simulink.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.emc.simulink.engine.MatlabEngine;

public class MatlabEngineUtil {

	private static final String MATHWORKS = "com.mathworks";
	private static final String ERROR = "Matlab Engine Error:\n %s.\n %s";
	
	public static List<Double> matlabArrayToList(double[] value) {
		 ArrayList<Double> result = new ArrayList<Double>();
		 for (int i=0; i < value.length; i++) {
			 result.add(value[i]);
		 }
		 return result;
	}
	
	public static List<Long> matlabArrayToList(long[] value) {
		 ArrayList<Long> result = new ArrayList<Long>();
		 for (int i=0; i < value.length; i++) {
			 result.add(value[i]);
		 }
		 return result;
	}

	public static List<Integer> matlabArrayToList(int[] value) {
		 ArrayList<Integer> result = new ArrayList<Integer>();
		 for (int i=0; i < value.length; i++) {
			 result.add(value[i]);
		 }
		 return result;
	}
	
	public static List<Float> matlabArrayToList(float[] value) {
		 ArrayList<Float> result = new ArrayList<Float>();
		 for (int i=0; i < value.length; i++) {
			 result.add(value[i]);
		 }
		 return result;
	}
	
	public static List<Boolean> matlabArrayToList(boolean[] value) {
		 ArrayList<Boolean> result = new ArrayList<Boolean>();
		 for (int i=0; i < value.length; i++) {
			 result.add(value[i]);
		 }
		 return result;
	}
	
	public static List<Byte> matlabArrayToList(byte[] value) {
		 ArrayList<Byte> result = new ArrayList<Byte>();
		 for (int i=0; i < value.length; i++) {
			 result.add(value[i]);
		 }
		 return result;
	}
	
	public static List<Short> matlabArrayToList(short[] value) {
		 ArrayList<Short> result = new ArrayList<Short>();
		 for (int i=0; i < value.length; i++) {
			 result.add(value[i]);
		 }
		 return result;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> List<T> matlabArrayToList(Object[] value) {
		 T[] newValue = (T[]) value;
		 ArrayList<T> result = new ArrayList<T>();
		 for (int i=0; i < newValue.length; i++) {
			 result.add(newValue[i]);
		 }
		 return result;
	}
	
	public static Object getArrayWorkspaceVariable(MatlabEngine engine, String variableName) {
		Object value = engine.getVariable(variableName);
		return castMatlabArray(value);
	}
	
	public static Object castMatlabArray(Object value) {
		if (value instanceof int[]) return MatlabEngineUtil.matlabArrayToList((int[]) value);
		if (value instanceof long[]) return MatlabEngineUtil.matlabArrayToList((long[]) value);
		if (value instanceof boolean[]) return MatlabEngineUtil.matlabArrayToList((boolean[]) value);
		if (value instanceof double[]) return MatlabEngineUtil.matlabArrayToList((double[]) value);
		if (value instanceof float[]) return MatlabEngineUtil.matlabArrayToList((float[]) value);
		if (value instanceof byte[]) return MatlabEngineUtil.matlabArrayToList((byte[]) value);
		if (value instanceof short[]) return MatlabEngineUtil.matlabArrayToList((short[]) value);
		if (value instanceof String[]) return MatlabEngineUtil.matlabArrayToList((String[]) value);
		if (value instanceof Object[]) return MatlabEngineUtil.matlabArrayToList((Object[]) value);
		return value;
	}
	
	public static void formatException(Exception exeption) {
		Throwable cause = exeption.getCause();
		if (MatlabEngineUtil.isMatlabException(cause)) {
			String message = String.format(ERROR, (cause!= null) ? cause.getMessage() : "", (cause.getCause()!= null) ? cause.getCause().getMessage() : "");
			throw new RuntimeException(message, cause);
		} else {
			throw new RuntimeException(exeption);
		}
	}

	public static boolean isMatlabException(Throwable cause) {
		return cause != null && cause.getClass().getName().contains(MATHWORKS);  
	}
	
}
