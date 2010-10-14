package org.eclipse.epsilon.emc.plainxml;

public abstract class LoudListChangeListener<E> implements LoudListListener<E>{
	
	public abstract void listChanged(LoudList<E> list);
	
	@Override
	public void objectAdded(LoudList<E> list, E o) {
		listChanged(list);
	}

	@Override
	public void objectAdded(LoudList<E> list, E o, int index) {
		listChanged(list);
	}

	@Override
	public void objectRemoved(LoudList<E> list, E o) {
		listChanged(list);
	}

	@Override
	public void objectRemoved(LoudList<E> list, E o, int index) {
		listChanged(list);
	}

}
