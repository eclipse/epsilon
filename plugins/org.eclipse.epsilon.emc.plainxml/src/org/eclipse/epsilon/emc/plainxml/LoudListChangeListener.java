/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.emc.plainxml;

public abstract class LoudListChangeListener<E> implements LoudListListener<E>{
	
	public abstract void listChanged(LoudList<E> list);
	
	public void objectAdded(LoudList<E> list, E o) {
		listChanged(list);
	}

	public void objectAdded(LoudList<E> list, E o, int index) {
		listChanged(list);
	}

	public void objectRemoved(LoudList<E> list, E o) {
		listChanged(list);
	}

	public void objectRemoved(LoudList<E> list, E o, int index) {
		listChanged(list);
	}

}
