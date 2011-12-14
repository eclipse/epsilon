/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolInternalException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.types.EolNativeType;

public class ReflectionUtil {
	
	public static boolean hasMethods(Object obj, String methodName) {
		
		if (obj == null) return false;
		
		for (Method method : obj.getClass().getMethods()) {
			if (method.getName().equals(methodName)) {
				return true;
			}
		}
		return false;
	}
	
	public static Set<String> getMethodNames(Object obj, boolean includeInheritedMethods) {
		
		HashSet<String> methodNames = new HashSet<String>();
		
		if (obj == null) return methodNames;
		
		Method[] methods = null;
		
		if (includeInheritedMethods) {
			methods = obj.getClass().getMethods();
		}
		else {
			methods = obj.getClass().getDeclaredMethods();
		}
		
		for (int i=0;i<methods.length;i++) { 
			methodNames.add(methods[i].getName());
		}
		
		return methodNames;
	}
	
	/**
	 * @param allowContravariantConversionForParameters
	 *   when false, parameters will have exactly the same class as the arguments to the returned method
	 *   when true, parameters may have a type that is more specific than the arguments to the returned method   
	 */
	public static Method getMethodFor(Object obj, String methodName, Object[] parameters, boolean includeInheritedMethods, boolean allowContravariantConversionForParameters){
		
		if (obj == null) return null;
		
		Method[] methods = null;
		
		if (includeInheritedMethods) {
			methods = obj.getClass().getMethods();
		}
		else {
			methods = obj.getClass().getDeclaredMethods();
		}
		
		// Faster than for (Method method : methods)
		// Custom search a lot faster than Class.getMethod(...)
		for (int i=0;i<methods.length;i++){
			boolean namesMatch = false;
			
			namesMatch = methods[i].getName().equalsIgnoreCase(methodName);
			
			if (namesMatch){
				Method method = methods[i];
				
				Class<?>[] parameterTypes = method.getParameterTypes();
				boolean parametersMatch = parameterTypes.length == parameters.length;
				if (parametersMatch){
					//TODO: See why parameter type checking does not work with EolSequence
					for (int j=0;j<parameterTypes.length && parametersMatch; j++){
						Class<?> parameterType = parameterTypes[j];
						Object parameter = parameters[j];
						
						if (allowContravariantConversionForParameters) {
							parametersMatch = parametersMatch && (isInstance(parameterType,parameter));
						} else {
							parametersMatch = parametersMatch && parameterType.equals(parameter.getClass());
						}
					}
					
					if (parametersMatch){
						return method;
					}
				}
			}
		}
		
		// Find static methods
		Class<?> javaClass = null;
		if (obj instanceof EolNativeType) {
			javaClass = ((EolNativeType) obj).getJavaClass();
		}
		if (obj instanceof Class) {
			javaClass = (Class<?>) obj;
		}
		
		if (javaClass != null) {
			methods = javaClass.getMethods();
			
			for (int i=0;i<methods.length;i++){
				boolean namesMatch = false;
				
				namesMatch = methods[i].getName().equalsIgnoreCase(methodName);
				
				if (namesMatch){
					Method method = methods[i];
					
					Class<?>[] parameterTypes = method.getParameterTypes();
					boolean parametersMatch = parameterTypes.length == parameters.length;
					if (parametersMatch){
						//TODO: See why parameter type checking does not work with EolSequence
						for (int j=0;j<parameterTypes.length && parametersMatch; j++){
							Class<?> parameterType = parameterTypes[j];
							Object parameter = parameters[j];
							
							if (allowContravariantConversionForParameters) {
								parametersMatch = parametersMatch && (isInstance(parameterType,parameter));
							} else {
								parametersMatch = parametersMatch && parameterType.equals(parameter.getClass());
							}
						}
						
						if (parametersMatch){
							return method;
						}
					}
				}
			}
		}
		
		
		return null;
	}

	public static Object executeMethod(Object obj, Method method, Object[] parameters, AST ast) throws EolRuntimeException{
		try {
			return executeMethod(method, obj, parameters);
		} catch (Throwable t) {
			throw new EolInternalException(t, ast);
		}
	}
	
	public static Object executeMethod(Object obj, String methodName, Object[] parameters) throws Throwable {
		Method method = getMethodFor(obj, methodName, parameters, true, true);
		try {
			return method.invoke(obj, parameters);
		} 
		catch (InvocationTargetException e) {
			throw e.getTargetException();
		}
	}
	
	public static Object executeMethod(Method method, Object obj, Object[] parameters) throws Throwable {
		try {
			return method.invoke(obj, parameters);
		}
		catch (InvocationTargetException iex) {
			throw iex.getCause();
		}
	}
	
	/**
	 * Returns a string representation
	 * of the method
	 * @param method
	 * @return
	 */
	public static String methodToString(Method method){
		String str = method.getName();
		str += "(";
		for (int i=0;i<method.getParameterTypes().length;i++){
			Class<?> parameterType = method.getParameterTypes()[i];
			str += parameterType.getName();
			if (i < method.getParameterTypes().length - 1) {
				str += " ,";
			}
		}
		str += ")";
		return str;
	}
	
	/**
	 * Returns the value of a field of an object
	 * @param object
	 * @param fieldName
	 * @return
	 */
	public static Object getFieldValue(Object object, String fieldName){
		if (object == null) return null;
		Field field = getField(object.getClass(), fieldName);
		if (field == null) return null;
		field.setAccessible(true);
		try {
			return field.get(object);
		}
		catch (Exception ex){
			return null;
		}
	}
	
	/**
	 * Gets a field of a class using reflection
	 * by introspecting the class and its supertype(s)
	 * @param clazz
	 * @param fieldName
	 * @return
	 */
	public static Field getField(Class<?> clazz, String fieldName){
	
		Field[] fields = clazz.getDeclaredFields();
		for (int i=0;i<fields.length;i++){
			if (fields[i].getName().equals(fieldName))
				return fields[i];
		}
		
		if (clazz.getSuperclass() != Object.class) return getField(clazz.getSuperclass(), fieldName);
		
		return null;
		
	}
	
	/**
	 * Checks if the instance is an instance of clazz
	 * Necessary because in Java, int.class != Integer.class etc
	 * @param clazz
	 * @param instance
	 * @return
	 */
	public static boolean isInstance(Class<?> clazz, Object instance){
		if (instance == null) return true;
		else if (clazz == int.class) return Integer.class.isInstance(instance);
		else if (clazz == float.class) return Float.class.isInstance(instance);
		else if (clazz == double.class) return Double.class.isInstance(instance);
		else if (clazz == boolean.class) return Boolean.class.isInstance(instance);
		else if (clazz == long.class) return Long.class.isInstance(instance);
		else return clazz.isInstance(instance);
	}
	
}
