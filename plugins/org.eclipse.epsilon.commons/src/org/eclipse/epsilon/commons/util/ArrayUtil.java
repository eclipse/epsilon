package org.eclipse.epsilon.commons.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ArrayUtil<E> {
	
	public static void main(String[] args) {
		String[] result = new ArrayUtil<String>().toArray(
			new ListBuilder<String>().build("foo"), String.class);
		System.err.println(result);
		
		ArrayUtil<String> ac = new ArrayUtil<String>();
		
		System.err.println(ac.toList(null));
		
	}
	
	public E[] toArray(Collection<E> c, Class<?> arrayType) {
		if (c == null) return null;
		
		@SuppressWarnings("unchecked")
		E[] arr = (E[]) Array.newInstance(arrayType, c.size());
		Iterator<E> it = c.iterator();
		int i=0;
		while (it.hasNext()) {
			arr[i] = it.next(); i++;
		}
		return arr;
	}
	
	public List<E> toList(E[] arr) {
		if (arr == null) return null;
		ArrayList<E> list = new ArrayList<E>();
		for (E e : arr) {
			list.add(e);
		}
		return list;
	}
}
