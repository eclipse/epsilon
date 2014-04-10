/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.emc.plainxml;

import java.util.ArrayList;
import java.util.Collection;

public class LoudList<E> extends ArrayList<E> {
	
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		
		LoudList<Integer> list = new LoudList<Integer>();
		
		list.addListener(new LoudListListener<Integer>() {
			
			public void objectRemoved(LoudList<Integer> list, Integer o, int index) {
				System.err.println("Removed " + o + "->" + index);
			}
			
			public void objectRemoved(LoudList<Integer> list, Integer o) {
				System.err.println("Removed " + o);
			}
			
			public void objectAdded(LoudList<Integer> list, Integer o, int index) {
				// TODO Auto-generated method stub
				
			}
			
			public void objectAdded(LoudList<Integer> list, Integer o) {
				System.err.println("Added " + o);
			}
		});
		
		list.add(1);
		list.add(1);
		list.remove(1);
		list.add(2);
		
		list.clear();
		
	}
	
	
	protected ArrayList<LoudListListener<E>> listeners = new ArrayList<LoudListListener<E>>();
	protected boolean unique = false;
	
	public void addListener(LoudListListener<E> listener) {
		this.listeners.add(listener);
	}
	
	public boolean removeListener(LoudListListener<E> listener) {
		return this.listeners.remove(listener);
	}
	
	public void setUnique(boolean unique) {
		this.unique = unique;
	}
	
	public boolean isUnique() {
		return unique;
	}
	
	@Override
	public boolean add(E e) {
		if (unique && contains(e)) return false;
		
		boolean result = super.add(e);
		for (LoudListListener<E> listener : listeners) {
			listener.objectAdded(this, e);
		}
		return result;
	}

	@Override
	public void add(int index, E element) {
		
		if (unique && contains(element)) return;
		
		super.add(index, element);
		for (LoudListListener<E> listener : listeners) {
			listener.objectAdded(this, element, index);
		}
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		boolean modified = false;
		for (E o : c) {
			modified = modified || add(o);
		}
		return modified;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		for (E o : c) {
			add(index, o);
		}
		return true;
	}

	@Override
	public void clear() {
		ArrayList<E> temp = new ArrayList<E>();
		temp.addAll(this);
		
		super.clear();
		
		for (E o : temp) {
			for (LoudListListener<E> listener : listeners) {
				listener.objectRemoved(this, o);
			}
		}
	}
	
	@Override
	public boolean remove(Object o) {
		boolean result = super.remove(o);
		for (LoudListListener<E> listener : listeners) {
			listener.objectRemoved(this, (E) o);
		}
		return result;
	}

	@Override
	public E remove(int index) {
		E removed = super.remove(index);
		for (LoudListListener<E> listener : listeners) {
			listener.objectRemoved(this, removed, index);
		}
		return removed;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		boolean modified = false;
		for (Object o : c) {
			modified = modified || remove(o);
		}
		return modified;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public E set(int index, E element) {
		E oldValue = get(index);
		if (element != oldValue) {
			remove(index);
			add(index, element);
		}
		return oldValue;
	}

}
