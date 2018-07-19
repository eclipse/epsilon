package org.eclipse.epsilon.emc.simulink.types;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.epsilon.common.util.ReflectionUtil;
import org.eclipse.epsilon.emc.simulink.util.ReflectionLocalUtil;

public class Complex {

	private static final String COMPLEX_MATLAB_CLASS = "com.mathworks.matlab.types.Complex";
	private static Class<?> complex_class;

	private Object complex;

	public static boolean is(Object obj) {
		return (getMatlabClass() == null) ? false : getMatlabClass().isInstance(obj);
	}

	private static Class<?> getMatlabClass() {
		if (complex_class == null) {
			try {
				complex_class = ClassLoader.getSystemClassLoader().loadClass(COMPLEX_MATLAB_CLASS);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return complex_class;
	}

	public Complex(Object complex) {
		if (is(complex)) {
			this.complex = complex;
		}
	}

	public Complex(Double real, Double imag) {
		try {
			Constructor<?> constructor = getMatlabClass().getConstructor(new Class<?>[] {Double.TYPE, Double.TYPE});
			complex = constructor.newInstance(real, imag);
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			System.out.println("Problem retrieving constructor of the complex type");
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			System.out.println("Problem instantiating the complex type");
			e.printStackTrace();
		}
	}
	
	public Complex(Double real, Integer imag) {
		this(real,imag.doubleValue());
	}
	
	public Complex(Integer real, Double imag) {
		this(real.doubleValue(),imag);
	}
	public Complex(Integer real, Integer imag) {
		this(real.doubleValue(),imag.doubleValue());
	}

	public Complex() {
		this(0,0);
	}

	public Double getReal() throws Exception {
		return (Double) ReflectionLocalUtil.getFieldValue(complex, "real");
	}

	public void setReal(Double real) throws Exception {
		ReflectionLocalUtil.setFieldValue(complex, "real", real);
	}
	
	public void setReal(Integer real) throws Exception {
		setReal(real.doubleValue());
	}

	public Double getImag() throws Exception {
		return (Double) ReflectionLocalUtil.getFieldValue(complex, "imag");
	}

	public void setImag(Double imag) throws Exception {
		ReflectionLocalUtil.setFieldValue(complex, "imag", imag);
	}
	
	public void setImag(Integer imag) throws Exception {
		setImag(imag.doubleValue());
	}
	
	@Override
	public String toString() {
		try {
			return (String) ReflectionUtil.invokeMethod(complex, "toString", null);
		} catch (Exception e) {
			return "";
		}
	}

}
