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
