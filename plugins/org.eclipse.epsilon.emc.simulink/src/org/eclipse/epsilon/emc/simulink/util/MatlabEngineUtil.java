/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.emc.simulink.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.emc.simulink.engine.MatlabEngine;
import org.eclipse.epsilon.emc.simulink.exception.MatlabException;
import org.eclipse.epsilon.emc.simulink.types.CellStr;
import org.eclipse.epsilon.emc.simulink.types.Complex;
import org.eclipse.epsilon.emc.simulink.types.HandleObject;
import org.eclipse.epsilon.emc.simulink.types.Struct;

public class MatlabEngineUtil {

	public static List<Double> matlabArrayToList(double[] value) {
		ArrayList<Double> result = new ArrayList<Double>();
		for (int i = 0; i < value.length; i++) {
			result.add(value[i]);
		}
		return result;
	}

	public static List<Long> matlabArrayToList(long[] value) {
		ArrayList<Long> result = new ArrayList<Long>();
		for (int i = 0; i < value.length; i++) {
			result.add(value[i]);
		}
		return result;
	}

	public static List<Integer> matlabArrayToList(int[] value) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < value.length; i++) {
			result.add(value[i]);
		}
		return result;
	}

	public static List<Float> matlabArrayToList(float[] value) {
		ArrayList<Float> result = new ArrayList<Float>();
		for (int i = 0; i < value.length; i++) {
			result.add(value[i]);
		}
		return result;
	}

	public static List<Boolean> matlabArrayToList(boolean[] value) {
		ArrayList<Boolean> result = new ArrayList<Boolean>();
		for (int i = 0; i < value.length; i++) {
			result.add(value[i]);
		}
		return result;
	}

	public static List<Byte> matlabArrayToList(byte[] value) {
		ArrayList<Byte> result = new ArrayList<Byte>();
		for (int i = 0; i < value.length; i++) {
			result.add(value[i]);
		}
		return result;
	}

	public static List<Short> matlabArrayToList(short[] value) {
		ArrayList<Short> result = new ArrayList<Short>();
		for (int i = 0; i < value.length; i++) {
			result.add(value[i]);
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public static <T> List<T> matlabArrayToList(Object[] value) {
		T[] newValue = (T[]) value;
		ArrayList<T> result = new ArrayList<T>();
		for (int i = 0; i < newValue.length; i++) {
			result.add(newValue[i]);
		}
		return result;
	}

	public static Object parseMatlabEngineVariable(MatlabEngine engine, String variableName) throws MatlabException {
		Object value = engine.getVariable(variableName);
		return parseMatlabEngineVariable(value);
	}

	public static Object parseMatlabEngineVariable(Object value) {
		if (value == null)
			return null;
		if (HandleObject.is(value))
			return new HandleObject(value);
		if (value instanceof byte[])
			return MatlabEngineUtil.matlabArrayToList((byte[]) value);
		if (value instanceof short[])
			return MatlabEngineUtil.matlabArrayToList((short[]) value);
		if (value instanceof int[])
			return MatlabEngineUtil.matlabArrayToList((int[]) value);
		if (value instanceof long[])
			return MatlabEngineUtil.matlabArrayToList((long[]) value);
		if (value instanceof float[])
			return MatlabEngineUtil.matlabArrayToList((float[]) value);
		if (value instanceof double[])
			return MatlabEngineUtil.matlabArrayToList((double[]) value);
		if (value instanceof boolean[])
			return MatlabEngineUtil.matlabArrayToList((boolean[]) value);
		if (value instanceof String[])
			return MatlabEngineUtil.matlabArrayToList((String[]) value);
		if (value instanceof Object[])
			return MatlabEngineUtil.matlabArrayToList((Object[]) value);
		if (value instanceof Character) 
			return String.valueOf(value);
		if (value instanceof String) 
			return String.valueOf(value);
		
		if (Struct.is(value))
			return new Struct(value);
		if (Complex.is(value))
			return new Complex(value);
		if (CellStr.is(value))
			return new CellStr(value);
		return value;
	}
}
