package org.eclipse.epsilon.emc.plainxml;

public interface LoudListListener<E> {
	
	public void objectAdded(LoudList<E> list, E o);
	
	public void objectAdded(LoudList<E> list, E o, int index);
	
	public void objectRemoved(LoudList<E> list, E o);
	
	public void objectRemoved(LoudList<E> list, E o, int index);
	
}
