/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.concordance.core.hashing.hashers.java;


import java.lang.reflect.Method;

import org.eclipse.epsilon.concordance.core.hashing.hashers.Hasher;


public abstract class TypeSafeHasher<T> implements Hasher {

    private Class<?> expectedType;
	
	protected TypeSafeHasher() {
        expectedType = findExpectedType(getClass());
    }
    
    private static Class<?> findExpectedType(Class<?> fromClass) {
        for (Class<?> c = fromClass; c != Object.class; c = c.getSuperclass()) {
            for (Method method : c.getDeclaredMethods()) {
                if (isHashSafelyMethod(method)) {
                    return method.getParameterTypes()[0];
                }
            }
        }
        
        throw new Error("Cannot determine correct type for hashSafely() method.");
    }
    
    private static boolean isHashSafelyMethod(Method method) {
        return method.getName().equals("hashSafely") 
            && method.getParameterTypes().length == 1
            && !method.isSynthetic(); 
    }
    
    protected TypeSafeHasher(Class<T> expectedType) {
    	this.expectedType = expectedType;
    }

    @SuppressWarnings({"unchecked"})
    public final int hash(Object item) {
    	if (!applicableFor(item)) {
    		throw new IllegalArgumentException(item + " is not an instance of " + expectedType.getCanonicalName());
    	}
    	
        return hashSafely((T)item);
    }
    
    public abstract int hashSafely(T item);

	public boolean applicableFor(Object item) {
		return expectedType.isInstance(item);
	}
}