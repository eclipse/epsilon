package org.eclipse.epsilon.commons.util;

import java.util.ArrayList;

public class ListBuilder<E> {
	
	public ArrayList<E> build(E...es) {
		ArrayList<E> list = new ArrayList<E>();
		for (E e : es) {
			list.add(e);
		}
		return list;
	}
	
}
