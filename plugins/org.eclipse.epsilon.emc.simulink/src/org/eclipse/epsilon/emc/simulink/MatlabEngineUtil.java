package org.eclipse.epsilon.emc.simulink;

import java.util.ArrayList;
import java.util.List;

public class MatlabEngineUtil {

	
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
	
	public static <T> List<T> matlabArrayToList(Object[] value) {
		 T[] newValue = (T[]) value;
		 ArrayList<T> result = new ArrayList<T>();
		 for (int i=0; i < newValue.length; i++) {
			 result.add(newValue[i]);
		 }
		 return result;
	}
}
