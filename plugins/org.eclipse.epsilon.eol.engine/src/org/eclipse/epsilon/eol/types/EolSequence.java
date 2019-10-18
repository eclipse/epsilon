/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.types;

import java.util.ArrayList;
import java.util.Collection;

public class EolSequence<T> extends ArrayList<T> {
	
	private static final long serialVersionUID = -2401272219693014633L;
	
	public EolSequence() {
		super();
	}
	
	/**
	 * 
	 * @param initialCapacity
	 * @since 1.6
	 */
	public EolSequence(int initialCapacity) {
		super(initialCapacity);
	}

	/**
	 * 
	 * @param c
	 * @since 1.6
	 */
	public EolSequence(Collection<? extends T> c) {
		super(c);
	}
	
	/**
	 * 
	 * @param arr
	 * @since 1.6
	 */
	public EolSequence(T[] arr) {
		this(arr.length);
		for (T t : arr) add(t);
	}
	
}
