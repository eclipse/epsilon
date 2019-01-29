/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.emc.simulink.util.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.epsilon.emc.simulink.model.element.ISimulinkModelElement;
import org.eclipse.epsilon.emc.simulink.util.MatlabEngineUtil;
import org.eclipse.epsilon.emc.simulink.util.manager.Manager;

public abstract class AbstractSimulinkCollection<E, P, M extends Manager<E, P>> implements List<ISimulinkModelElement> {

	private List<P> primitive;
	private M manager;

	@SuppressWarnings("unchecked")
	public AbstractSimulinkCollection(Object primitive, M manager) {
		if (primitive != null) {
			if (isInstanceOfPrimitiveArray(primitive)) {
				this.primitive = MatlabEngineUtil.matlabArrayToList((P[]) primitive);
			} else if (primitive instanceof List) {
				this.primitive = (List<P>) primitive;
			} else if (isInstanceOfPrimitive(primitive)) {
				this.primitive = (List<P>) Arrays.asList(primitive);
			} else {
				new IllegalStateException("Unhandled primitive type: " + primitive.getClass());
			}
		} else {
			this.primitive = new ArrayList<P>();
		}
		this.manager = manager;
	}

	@Override
	public int size() {
		return primitive.size();
	}

	@Override
	public boolean isEmpty() {
		return primitive.isEmpty();
	}

	@Override
	public void clear() {
		primitive.clear();
	}

	@Override
	public Iterator<ISimulinkModelElement> iterator() {
		return getInternalIterator();
	}

	@SuppressWarnings("unchecked")
	@Override
	public ISimulinkModelElement remove(int index) {
		E element = (E) get(index);
		primitive.remove(index);
		return (ISimulinkModelElement) element;
	}

	@Override
	public ISimulinkModelElement get(int index) {
		P handle = primitive.get(index);
		return (ISimulinkModelElement) manager.construct(handle);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean add(ISimulinkModelElement e) {
		int size = primitive.size();
		primitive.add(manager.getId((E) e));
		return primitive.size() == size + 1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ISimulinkModelElement set(int index, ISimulinkModelElement element) {
		E previous = (E) get(index);
		primitive.set(index, manager.getId((E) element));
		return (ISimulinkModelElement) previous;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void add(int index, ISimulinkModelElement element) {
		primitive.add(index, manager.getId((E) element));
	}

	@SuppressWarnings("unchecked")
	@Override
	public int indexOf(Object o) {
		if (isInstanceOf(o)) {
			return primitive.indexOf(manager.getId((E) o));
		} else {
			return -1;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean contains(Object o) {
		if (isInstanceOf(o)) {
			return primitive.contains(manager.getId((E) o));
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean remove(Object o) {
		if (isInstanceOf(o)) {
			return primitive.remove(manager.getId((E) o));
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int lastIndexOf(Object o) {
		if (isInstanceOf(o)) {
			return primitive.lastIndexOf(manager.getId((E) o));
		}
		return -1;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public boolean addAll(Collection<? extends ISimulinkModelElement> c) {
		if (c instanceof AbstractSimulinkCollection) {
			AbstractSimulinkCollection collection = (AbstractSimulinkCollection) c;
			return getPrimitive().addAll(collection.getPrimitive());
		} else {
			int original = primitive.size();
			c.stream().forEach(e -> primitive.add(manager.getId((E) e)));
			return original + c.size() == primitive.size();
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public boolean containsAll(Collection<?> c) {
		if (c instanceof AbstractSimulinkCollection) {
			AbstractSimulinkCollection collection = (AbstractSimulinkCollection) c;
			return getPrimitive().containsAll(collection.getPrimitive());
		} else {
			// FIXME handle filter
			return c.stream().filter(e -> isInstanceOf(e)).map(e -> primitive.contains(manager.getId((E) e)))
					.reduce(Boolean::logicalAnd).orElse(false);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public boolean addAll(int index, Collection<? extends ISimulinkModelElement> c) {
		if (c instanceof AbstractSimulinkCollection) {
			AbstractSimulinkCollection collection = (AbstractSimulinkCollection) c;
			return getPrimitive().addAll(collection.getPrimitive());
		} else {
			// FIXME handle filter
			return c.stream().filter(e -> isInstanceOf(e)).map(e -> primitive.add(manager.getId((E) e)))
					.reduce(Boolean::logicalAnd).orElse(false);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public boolean removeAll(Collection<?> c) {
		if (c instanceof AbstractSimulinkCollection) {
			AbstractSimulinkCollection collection = (AbstractSimulinkCollection) c;
			return getPrimitive().removeAll(collection.getPrimitive());
		} else {
			return c.stream().filter(e -> isInstanceOf(e)).map(e -> primitive.remove(manager.getId((E) e)))
					.reduce(Boolean::logicalAnd).orElse(false);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public boolean retainAll(Collection<?> c) {
		if (c instanceof AbstractSimulinkCollection) {
			AbstractSimulinkCollection collection = (AbstractSimulinkCollection) c;
			return getPrimitive().retainAll(collection.getPrimitive());
		} else {
			List<P> collect = c.stream().filter(e -> isInstanceOf(e)).map(e -> manager.getId((E) e))
					.collect(Collectors.toList());
			return primitive.retainAll(collect);
		}
	}

	protected M getManager() {
		return this.manager;
	}

	protected List<P> getPrimitive() {
		return this.primitive;
	}

	protected abstract boolean isInstanceOf(Object object);

	protected abstract boolean isInstanceOfPrimitive(Object object);

	protected abstract boolean isInstanceOfPrimitiveArray(Object object);

	protected abstract Iterator<ISimulinkModelElement> getInternalIterator();

}
