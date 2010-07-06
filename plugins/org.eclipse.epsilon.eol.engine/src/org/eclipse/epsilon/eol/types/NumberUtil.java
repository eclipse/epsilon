package org.eclipse.epsilon.eol.types;

public class NumberUtil {
	
	public static Number multiply(Number n1, Number n2) {
		if ((n1 instanceof Integer) && (n2 instanceof Integer)) 
			return ((Integer) n1) * ((Integer) n2);
		if ((n1 instanceof Integer) && (n2 instanceof Float)) 
			return ((Integer) n1) * ((Float) n2);
		if ((n1 instanceof Integer) && (n2 instanceof Double)) 
			return ((Integer) n1) * ((Double) n2);
		if ((n1 instanceof Integer) && (n2 instanceof Short)) 
			return ((Integer) n1) * ((Short) n2);
		if ((n1 instanceof Integer) && (n2 instanceof Byte)) 
			return ((Integer) n1) * ((Byte) n2);
		if ((n1 instanceof Integer) && (n2 instanceof Long)) 
			return ((Integer) n1) * ((Long) n2);
		if ((n1 instanceof Float) && (n2 instanceof Integer)) 
			return ((Float) n1) * ((Integer) n2);
		if ((n1 instanceof Float) && (n2 instanceof Float)) 
			return ((Float) n1) * ((Float) n2);
		if ((n1 instanceof Float) && (n2 instanceof Double)) 
			return ((Float) n1) * ((Double) n2);
		if ((n1 instanceof Float) && (n2 instanceof Short)) 
			return ((Float) n1) * ((Short) n2);
		if ((n1 instanceof Float) && (n2 instanceof Byte)) 
			return ((Float) n1) * ((Byte) n2);
		if ((n1 instanceof Float) && (n2 instanceof Long)) 
			return ((Float) n1) * ((Long) n2);
		if ((n1 instanceof Double) && (n2 instanceof Integer)) 
			return ((Double) n1) * ((Integer) n2);
		if ((n1 instanceof Double) && (n2 instanceof Float)) 
			return ((Double) n1) * ((Float) n2);
		if ((n1 instanceof Double) && (n2 instanceof Double)) 
			return ((Double) n1) * ((Double) n2);
		if ((n1 instanceof Double) && (n2 instanceof Short)) 
			return ((Double) n1) * ((Short) n2);
		if ((n1 instanceof Double) && (n2 instanceof Byte)) 
			return ((Double) n1) * ((Byte) n2);
		if ((n1 instanceof Double) && (n2 instanceof Long)) 
			return ((Double) n1) * ((Long) n2);
		if ((n1 instanceof Short) && (n2 instanceof Integer)) 
			return ((Short) n1) * ((Integer) n2);
		if ((n1 instanceof Short) && (n2 instanceof Float)) 
			return ((Short) n1) * ((Float) n2);
		if ((n1 instanceof Short) && (n2 instanceof Double)) 
			return ((Short) n1) * ((Double) n2);
		if ((n1 instanceof Short) && (n2 instanceof Short)) 
			return ((Short) n1) * ((Short) n2);
		if ((n1 instanceof Short) && (n2 instanceof Byte)) 
			return ((Short) n1) * ((Byte) n2);
		if ((n1 instanceof Short) && (n2 instanceof Long)) 
			return ((Short) n1) * ((Long) n2);
		if ((n1 instanceof Byte) && (n2 instanceof Integer)) 
			return ((Byte) n1) * ((Integer) n2);
		if ((n1 instanceof Byte) && (n2 instanceof Float)) 
			return ((Byte) n1) * ((Float) n2);
		if ((n1 instanceof Byte) && (n2 instanceof Double)) 
			return ((Byte) n1) * ((Double) n2);
		if ((n1 instanceof Byte) && (n2 instanceof Short)) 
			return ((Byte) n1) * ((Short) n2);
		if ((n1 instanceof Byte) && (n2 instanceof Byte)) 
			return ((Byte) n1) * ((Byte) n2);
		if ((n1 instanceof Byte) && (n2 instanceof Long)) 
			return ((Byte) n1) * ((Long) n2);
		if ((n1 instanceof Long) && (n2 instanceof Integer)) 
			return ((Long) n1) * ((Integer) n2);
		if ((n1 instanceof Long) && (n2 instanceof Float)) 
			return ((Long) n1) * ((Float) n2);
		if ((n1 instanceof Long) && (n2 instanceof Double)) 
			return ((Long) n1) * ((Double) n2);
		if ((n1 instanceof Long) && (n2 instanceof Short)) 
			return ((Long) n1) * ((Short) n2);
		if ((n1 instanceof Long) && (n2 instanceof Byte)) 
			return ((Long) n1) * ((Byte) n2);
		if ((n1 instanceof Long) && (n2 instanceof Long)) 
			return ((Long) n1) * ((Long) n2);
		return null;
	}

	public static Number add(Number n1, Number n2) {
		if ((n1 instanceof Integer) && (n2 instanceof Integer)) 
			return ((Integer) n1) + ((Integer) n2);
		if ((n1 instanceof Integer) && (n2 instanceof Float)) 
			return ((Integer) n1) + ((Float) n2);
		if ((n1 instanceof Integer) && (n2 instanceof Double)) 
			return ((Integer) n1) + ((Double) n2);
		if ((n1 instanceof Integer) && (n2 instanceof Short)) 
			return ((Integer) n1) + ((Short) n2);
		if ((n1 instanceof Integer) && (n2 instanceof Byte)) 
			return ((Integer) n1) + ((Byte) n2);
		if ((n1 instanceof Integer) && (n2 instanceof Long)) 
			return ((Integer) n1) + ((Long) n2);
		if ((n1 instanceof Float) && (n2 instanceof Integer)) 
			return ((Float) n1) + ((Integer) n2);
		if ((n1 instanceof Float) && (n2 instanceof Float)) 
			return ((Float) n1) + ((Float) n2);
		if ((n1 instanceof Float) && (n2 instanceof Double)) 
			return ((Float) n1) + ((Double) n2);
		if ((n1 instanceof Float) && (n2 instanceof Short)) 
			return ((Float) n1) + ((Short) n2);
		if ((n1 instanceof Float) && (n2 instanceof Byte)) 
			return ((Float) n1) + ((Byte) n2);
		if ((n1 instanceof Float) && (n2 instanceof Long)) 
			return ((Float) n1) + ((Long) n2);
		if ((n1 instanceof Double) && (n2 instanceof Integer)) 
			return ((Double) n1) + ((Integer) n2);
		if ((n1 instanceof Double) && (n2 instanceof Float)) 
			return ((Double) n1) + ((Float) n2);
		if ((n1 instanceof Double) && (n2 instanceof Double)) 
			return ((Double) n1) + ((Double) n2);
		if ((n1 instanceof Double) && (n2 instanceof Short)) 
			return ((Double) n1) + ((Short) n2);
		if ((n1 instanceof Double) && (n2 instanceof Byte)) 
			return ((Double) n1) + ((Byte) n2);
		if ((n1 instanceof Double) && (n2 instanceof Long)) 
			return ((Double) n1) + ((Long) n2);
		if ((n1 instanceof Short) && (n2 instanceof Integer)) 
			return ((Short) n1) + ((Integer) n2);
		if ((n1 instanceof Short) && (n2 instanceof Float)) 
			return ((Short) n1) + ((Float) n2);
		if ((n1 instanceof Short) && (n2 instanceof Double)) 
			return ((Short) n1) + ((Double) n2);
		if ((n1 instanceof Short) && (n2 instanceof Short)) 
			return ((Short) n1) + ((Short) n2);
		if ((n1 instanceof Short) && (n2 instanceof Byte)) 
			return ((Short) n1) + ((Byte) n2);
		if ((n1 instanceof Short) && (n2 instanceof Long)) 
			return ((Short) n1) + ((Long) n2);
		if ((n1 instanceof Byte) && (n2 instanceof Integer)) 
			return ((Byte) n1) + ((Integer) n2);
		if ((n1 instanceof Byte) && (n2 instanceof Float)) 
			return ((Byte) n1) + ((Float) n2);
		if ((n1 instanceof Byte) && (n2 instanceof Double)) 
			return ((Byte) n1) + ((Double) n2);
		if ((n1 instanceof Byte) && (n2 instanceof Short)) 
			return ((Byte) n1) + ((Short) n2);
		if ((n1 instanceof Byte) && (n2 instanceof Byte)) 
			return ((Byte) n1) + ((Byte) n2);
		if ((n1 instanceof Byte) && (n2 instanceof Long)) 
			return ((Byte) n1) + ((Long) n2);
		if ((n1 instanceof Long) && (n2 instanceof Integer)) 
			return ((Long) n1) + ((Integer) n2);
		if ((n1 instanceof Long) && (n2 instanceof Float)) 
			return ((Long) n1) + ((Float) n2);
		if ((n1 instanceof Long) && (n2 instanceof Double)) 
			return ((Long) n1) + ((Double) n2);
		if ((n1 instanceof Long) && (n2 instanceof Short)) 
			return ((Long) n1) + ((Short) n2);
		if ((n1 instanceof Long) && (n2 instanceof Byte)) 
			return ((Long) n1) + ((Byte) n2);
		if ((n1 instanceof Long) && (n2 instanceof Long)) 
			return ((Long) n1) + ((Long) n2);
		return null;
	}
	
	public static boolean greaterThan(Number n1, Number n2) {
		if ((n1 instanceof Integer) && (n2 instanceof Integer)) 
			return ((Integer) n1) > ((Integer) n2);
		if ((n1 instanceof Integer) && (n2 instanceof Float)) 
			return ((Integer) n1) > ((Float) n2);
		if ((n1 instanceof Integer) && (n2 instanceof Double)) 
			return ((Integer) n1) > ((Double) n2);
		if ((n1 instanceof Integer) && (n2 instanceof Short)) 
			return ((Integer) n1) > ((Short) n2);
		if ((n1 instanceof Integer) && (n2 instanceof Byte)) 
			return ((Integer) n1) > ((Byte) n2);
		if ((n1 instanceof Integer) && (n2 instanceof Long)) 
			return ((Integer) n1) > ((Long) n2);
		if ((n1 instanceof Float) && (n2 instanceof Integer)) 
			return ((Float) n1) > ((Integer) n2);
		if ((n1 instanceof Float) && (n2 instanceof Float)) 
			return ((Float) n1) > ((Float) n2);
		if ((n1 instanceof Float) && (n2 instanceof Double)) 
			return ((Float) n1) > ((Double) n2);
		if ((n1 instanceof Float) && (n2 instanceof Short)) 
			return ((Float) n1) > ((Short) n2);
		if ((n1 instanceof Float) && (n2 instanceof Byte)) 
			return ((Float) n1) > ((Byte) n2);
		if ((n1 instanceof Float) && (n2 instanceof Long)) 
			return ((Float) n1) > ((Long) n2);
		if ((n1 instanceof Double) && (n2 instanceof Integer)) 
			return ((Double) n1) > ((Integer) n2);
		if ((n1 instanceof Double) && (n2 instanceof Float)) 
			return ((Double) n1) > ((Float) n2);
		if ((n1 instanceof Double) && (n2 instanceof Double)) 
			return ((Double) n1) > ((Double) n2);
		if ((n1 instanceof Double) && (n2 instanceof Short)) 
			return ((Double) n1) > ((Short) n2);
		if ((n1 instanceof Double) && (n2 instanceof Byte)) 
			return ((Double) n1) > ((Byte) n2);
		if ((n1 instanceof Double) && (n2 instanceof Long)) 
			return ((Double) n1) > ((Long) n2);
		if ((n1 instanceof Short) && (n2 instanceof Integer)) 
			return ((Short) n1) > ((Integer) n2);
		if ((n1 instanceof Short) && (n2 instanceof Float)) 
			return ((Short) n1) > ((Float) n2);
		if ((n1 instanceof Short) && (n2 instanceof Double)) 
			return ((Short) n1) > ((Double) n2);
		if ((n1 instanceof Short) && (n2 instanceof Short)) 
			return ((Short) n1) > ((Short) n2);
		if ((n1 instanceof Short) && (n2 instanceof Byte)) 
			return ((Short) n1) > ((Byte) n2);
		if ((n1 instanceof Short) && (n2 instanceof Long)) 
			return ((Short) n1) > ((Long) n2);
		if ((n1 instanceof Byte) && (n2 instanceof Integer)) 
			return ((Byte) n1) > ((Integer) n2);
		if ((n1 instanceof Byte) && (n2 instanceof Float)) 
			return ((Byte) n1) > ((Float) n2);
		if ((n1 instanceof Byte) && (n2 instanceof Double)) 
			return ((Byte) n1) > ((Double) n2);
		if ((n1 instanceof Byte) && (n2 instanceof Short)) 
			return ((Byte) n1) > ((Short) n2);
		if ((n1 instanceof Byte) && (n2 instanceof Byte)) 
			return ((Byte) n1) > ((Byte) n2);
		if ((n1 instanceof Byte) && (n2 instanceof Long)) 
			return ((Byte) n1) > ((Long) n2);
		if ((n1 instanceof Long) && (n2 instanceof Integer)) 
			return ((Long) n1) > ((Integer) n2);
		if ((n1 instanceof Long) && (n2 instanceof Float)) 
			return ((Long) n1) > ((Float) n2);
		if ((n1 instanceof Long) && (n2 instanceof Double)) 
			return ((Long) n1) > ((Double) n2);
		if ((n1 instanceof Long) && (n2 instanceof Short)) 
			return ((Long) n1) > ((Short) n2);
		if ((n1 instanceof Long) && (n2 instanceof Byte)) 
			return ((Long) n1) > ((Byte) n2);
		if ((n1 instanceof Long) && (n2 instanceof Long)) 
			return ((Long) n1) > ((Long) n2);
		return false;
	}

	public static Number divide(Number n1, Number n2) {
		if ((n1 instanceof Integer) && (n2 instanceof Integer)) 
			return ((Integer) n1) / ((Integer) n2);
		if ((n1 instanceof Integer) && (n2 instanceof Float)) 
			return ((Integer) n1) / ((Float) n2);
		if ((n1 instanceof Integer) && (n2 instanceof Double)) 
			return ((Integer) n1) / ((Double) n2);
		if ((n1 instanceof Integer) && (n2 instanceof Short)) 
			return ((Integer) n1) / ((Short) n2);
		if ((n1 instanceof Integer) && (n2 instanceof Byte)) 
			return ((Integer) n1) / ((Byte) n2);
		if ((n1 instanceof Integer) && (n2 instanceof Long)) 
			return ((Integer) n1) / ((Long) n2);
		if ((n1 instanceof Float) && (n2 instanceof Integer)) 
			return ((Float) n1) / ((Integer) n2);
		if ((n1 instanceof Float) && (n2 instanceof Float)) 
			return ((Float) n1) / ((Float) n2);
		if ((n1 instanceof Float) && (n2 instanceof Double)) 
			return ((Float) n1) / ((Double) n2);
		if ((n1 instanceof Float) && (n2 instanceof Short)) 
			return ((Float) n1) / ((Short) n2);
		if ((n1 instanceof Float) && (n2 instanceof Byte)) 
			return ((Float) n1) / ((Byte) n2);
		if ((n1 instanceof Float) && (n2 instanceof Long)) 
			return ((Float) n1) / ((Long) n2);
		if ((n1 instanceof Double) && (n2 instanceof Integer)) 
			return ((Double) n1) / ((Integer) n2);
		if ((n1 instanceof Double) && (n2 instanceof Float)) 
			return ((Double) n1) / ((Float) n2);
		if ((n1 instanceof Double) && (n2 instanceof Double)) 
			return ((Double) n1) / ((Double) n2);
		if ((n1 instanceof Double) && (n2 instanceof Short)) 
			return ((Double) n1) / ((Short) n2);
		if ((n1 instanceof Double) && (n2 instanceof Byte)) 
			return ((Double) n1) / ((Byte) n2);
		if ((n1 instanceof Double) && (n2 instanceof Long)) 
			return ((Double) n1) / ((Long) n2);
		if ((n1 instanceof Short) && (n2 instanceof Integer)) 
			return ((Short) n1) / ((Integer) n2);
		if ((n1 instanceof Short) && (n2 instanceof Float)) 
			return ((Short) n1) / ((Float) n2);
		if ((n1 instanceof Short) && (n2 instanceof Double)) 
			return ((Short) n1) / ((Double) n2);
		if ((n1 instanceof Short) && (n2 instanceof Short)) 
			return ((Short) n1) / ((Short) n2);
		if ((n1 instanceof Short) && (n2 instanceof Byte)) 
			return ((Short) n1) / ((Byte) n2);
		if ((n1 instanceof Short) && (n2 instanceof Long)) 
			return ((Short) n1) / ((Long) n2);
		if ((n1 instanceof Byte) && (n2 instanceof Integer)) 
			return ((Byte) n1) / ((Integer) n2);
		if ((n1 instanceof Byte) && (n2 instanceof Float)) 
			return ((Byte) n1) / ((Float) n2);
		if ((n1 instanceof Byte) && (n2 instanceof Double)) 
			return ((Byte) n1) / ((Double) n2);
		if ((n1 instanceof Byte) && (n2 instanceof Short)) 
			return ((Byte) n1) / ((Short) n2);
		if ((n1 instanceof Byte) && (n2 instanceof Byte)) 
			return ((Byte) n1) / ((Byte) n2);
		if ((n1 instanceof Byte) && (n2 instanceof Long)) 
			return ((Byte) n1) / ((Long) n2);
		if ((n1 instanceof Long) && (n2 instanceof Integer)) 
			return ((Long) n1) / ((Integer) n2);
		if ((n1 instanceof Long) && (n2 instanceof Float)) 
			return ((Long) n1) / ((Float) n2);
		if ((n1 instanceof Long) && (n2 instanceof Double)) 
			return ((Long) n1) / ((Double) n2);
		if ((n1 instanceof Long) && (n2 instanceof Short)) 
			return ((Long) n1) / ((Short) n2);
		if ((n1 instanceof Long) && (n2 instanceof Byte)) 
			return ((Long) n1) / ((Byte) n2);
		if ((n1 instanceof Long) && (n2 instanceof Long)) 
			return ((Long) n1) / ((Long) n2);
		return null;
	}

	public static boolean lessThan(Number n1, Number n2) {
		if ((n1 instanceof Integer) && (n2 instanceof Integer)) 
			return ((Integer) n1) < ((Integer) n2);
		if ((n1 instanceof Integer) && (n2 instanceof Float)) 
			return ((Integer) n1) < ((Float) n2);
		if ((n1 instanceof Integer) && (n2 instanceof Double)) 
			return ((Integer) n1) < ((Double) n2);
		if ((n1 instanceof Integer) && (n2 instanceof Short)) 
			return ((Integer) n1) < ((Short) n2);
		if ((n1 instanceof Integer) && (n2 instanceof Byte)) 
			return ((Integer) n1) < ((Byte) n2);
		if ((n1 instanceof Integer) && (n2 instanceof Long)) 
			return ((Integer) n1) < ((Long) n2);
		if ((n1 instanceof Float) && (n2 instanceof Integer)) 
			return ((Float) n1) < ((Integer) n2);
		if ((n1 instanceof Float) && (n2 instanceof Float)) 
			return ((Float) n1) < ((Float) n2);
		if ((n1 instanceof Float) && (n2 instanceof Double)) 
			return ((Float) n1) < ((Double) n2);
		if ((n1 instanceof Float) && (n2 instanceof Short)) 
			return ((Float) n1) < ((Short) n2);
		if ((n1 instanceof Float) && (n2 instanceof Byte)) 
			return ((Float) n1) < ((Byte) n2);
		if ((n1 instanceof Float) && (n2 instanceof Long)) 
			return ((Float) n1) < ((Long) n2);
		if ((n1 instanceof Double) && (n2 instanceof Integer)) 
			return ((Double) n1) < ((Integer) n2);
		if ((n1 instanceof Double) && (n2 instanceof Float)) 
			return ((Double) n1) < ((Float) n2);
		if ((n1 instanceof Double) && (n2 instanceof Double)) 
			return ((Double) n1) < ((Double) n2);
		if ((n1 instanceof Double) && (n2 instanceof Short)) 
			return ((Double) n1) < ((Short) n2);
		if ((n1 instanceof Double) && (n2 instanceof Byte)) 
			return ((Double) n1) < ((Byte) n2);
		if ((n1 instanceof Double) && (n2 instanceof Long)) 
			return ((Double) n1) < ((Long) n2);
		if ((n1 instanceof Short) && (n2 instanceof Integer)) 
			return ((Short) n1) < ((Integer) n2);
		if ((n1 instanceof Short) && (n2 instanceof Float)) 
			return ((Short) n1) < ((Float) n2);
		if ((n1 instanceof Short) && (n2 instanceof Double)) 
			return ((Short) n1) < ((Double) n2);
		if ((n1 instanceof Short) && (n2 instanceof Short)) 
			return ((Short) n1) < ((Short) n2);
		if ((n1 instanceof Short) && (n2 instanceof Byte)) 
			return ((Short) n1) < ((Byte) n2);
		if ((n1 instanceof Short) && (n2 instanceof Long)) 
			return ((Short) n1) < ((Long) n2);
		if ((n1 instanceof Byte) && (n2 instanceof Integer)) 
			return ((Byte) n1) < ((Integer) n2);
		if ((n1 instanceof Byte) && (n2 instanceof Float)) 
			return ((Byte) n1) < ((Float) n2);
		if ((n1 instanceof Byte) && (n2 instanceof Double)) 
			return ((Byte) n1) < ((Double) n2);
		if ((n1 instanceof Byte) && (n2 instanceof Short)) 
			return ((Byte) n1) < ((Short) n2);
		if ((n1 instanceof Byte) && (n2 instanceof Byte)) 
			return ((Byte) n1) < ((Byte) n2);
		if ((n1 instanceof Byte) && (n2 instanceof Long)) 
			return ((Byte) n1) < ((Long) n2);
		if ((n1 instanceof Long) && (n2 instanceof Integer)) 
			return ((Long) n1) < ((Integer) n2);
		if ((n1 instanceof Long) && (n2 instanceof Float)) 
			return ((Long) n1) < ((Float) n2);
		if ((n1 instanceof Long) && (n2 instanceof Double)) 
			return ((Long) n1) < ((Double) n2);
		if ((n1 instanceof Long) && (n2 instanceof Short)) 
			return ((Long) n1) < ((Short) n2);
		if ((n1 instanceof Long) && (n2 instanceof Byte)) 
			return ((Long) n1) < ((Byte) n2);
		if ((n1 instanceof Long) && (n2 instanceof Long)) 
			return ((Long) n1) < ((Long) n2);
		return false;
	}

	public static Number subtract(Number n1, Number n2) {
		if ((n1 instanceof Integer) && (n2 instanceof Integer)) 
			return ((Integer) n1) - ((Integer) n2);
		if ((n1 instanceof Integer) && (n2 instanceof Float)) 
			return ((Integer) n1) - ((Float) n2);
		if ((n1 instanceof Integer) && (n2 instanceof Double)) 
			return ((Integer) n1) - ((Double) n2);
		if ((n1 instanceof Integer) && (n2 instanceof Short)) 
			return ((Integer) n1) - ((Short) n2);
		if ((n1 instanceof Integer) && (n2 instanceof Byte)) 
			return ((Integer) n1) - ((Byte) n2);
		if ((n1 instanceof Integer) && (n2 instanceof Long)) 
			return ((Integer) n1) - ((Long) n2);
		if ((n1 instanceof Float) && (n2 instanceof Integer)) 
			return ((Float) n1) - ((Integer) n2);
		if ((n1 instanceof Float) && (n2 instanceof Float)) 
			return ((Float) n1) - ((Float) n2);
		if ((n1 instanceof Float) && (n2 instanceof Double)) 
			return ((Float) n1) - ((Double) n2);
		if ((n1 instanceof Float) && (n2 instanceof Short)) 
			return ((Float) n1) - ((Short) n2);
		if ((n1 instanceof Float) && (n2 instanceof Byte)) 
			return ((Float) n1) - ((Byte) n2);
		if ((n1 instanceof Float) && (n2 instanceof Long)) 
			return ((Float) n1) - ((Long) n2);
		if ((n1 instanceof Double) && (n2 instanceof Integer)) 
			return ((Double) n1) - ((Integer) n2);
		if ((n1 instanceof Double) && (n2 instanceof Float)) 
			return ((Double) n1) - ((Float) n2);
		if ((n1 instanceof Double) && (n2 instanceof Double)) 
			return ((Double) n1) - ((Double) n2);
		if ((n1 instanceof Double) && (n2 instanceof Short)) 
			return ((Double) n1) - ((Short) n2);
		if ((n1 instanceof Double) && (n2 instanceof Byte)) 
			return ((Double) n1) - ((Byte) n2);
		if ((n1 instanceof Double) && (n2 instanceof Long)) 
			return ((Double) n1) - ((Long) n2);
		if ((n1 instanceof Short) && (n2 instanceof Integer)) 
			return ((Short) n1) - ((Integer) n2);
		if ((n1 instanceof Short) && (n2 instanceof Float)) 
			return ((Short) n1) - ((Float) n2);
		if ((n1 instanceof Short) && (n2 instanceof Double)) 
			return ((Short) n1) - ((Double) n2);
		if ((n1 instanceof Short) && (n2 instanceof Short)) 
			return ((Short) n1) - ((Short) n2);
		if ((n1 instanceof Short) && (n2 instanceof Byte)) 
			return ((Short) n1) - ((Byte) n2);
		if ((n1 instanceof Short) && (n2 instanceof Long)) 
			return ((Short) n1) - ((Long) n2);
		if ((n1 instanceof Byte) && (n2 instanceof Integer)) 
			return ((Byte) n1) - ((Integer) n2);
		if ((n1 instanceof Byte) && (n2 instanceof Float)) 
			return ((Byte) n1) - ((Float) n2);
		if ((n1 instanceof Byte) && (n2 instanceof Double)) 
			return ((Byte) n1) - ((Double) n2);
		if ((n1 instanceof Byte) && (n2 instanceof Short)) 
			return ((Byte) n1) - ((Short) n2);
		if ((n1 instanceof Byte) && (n2 instanceof Byte)) 
			return ((Byte) n1) - ((Byte) n2);
		if ((n1 instanceof Byte) && (n2 instanceof Long)) 
			return ((Byte) n1) - ((Long) n2);
		if ((n1 instanceof Long) && (n2 instanceof Integer)) 
			return ((Long) n1) - ((Integer) n2);
		if ((n1 instanceof Long) && (n2 instanceof Float)) 
			return ((Long) n1) - ((Float) n2);
		if ((n1 instanceof Long) && (n2 instanceof Double)) 
			return ((Long) n1) - ((Double) n2);
		if ((n1 instanceof Long) && (n2 instanceof Short)) 
			return ((Long) n1) - ((Short) n2);
		if ((n1 instanceof Long) && (n2 instanceof Byte)) 
			return ((Long) n1) - ((Byte) n2);
		if ((n1 instanceof Long) && (n2 instanceof Long)) 
			return ((Long) n1) - ((Long) n2);
		return null;
	}

	public static Number negative(Number n) {
		if ((n instanceof Integer)) 
			return -((Integer) n);
		if ((n instanceof Float)) 
			return -((Float) n);
		if ((n instanceof Double)) 
			return -((Double) n);
		if ((n instanceof Short)) 
			return -((Short) n);
		if ((n instanceof Byte)) 
			return -((Byte) n);
		if ((n instanceof Long)) 
			return -((Long) n);
		return null;
	}
	
}
