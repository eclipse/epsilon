package org.eclipse.epsilon.epl.combinations;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.epl.NoMatch;

public class DynamicListCombinationGenerator<T> implements CombinationGenerator<T>{
	
	protected int n;
	protected List<T> list = null;
	protected ListCombinationGenerator<T> listCombinationGenerator = null;
	protected ArrayList<CombinationGeneratorListener<T>> listeners = new ArrayList<CombinationGeneratorListener<T>>();
	protected boolean producedValidCombination = false;
	protected State state = State.NORMAL;
	protected Boolean optional = null;
	
	public void addListener(CombinationGeneratorListener<T> listener) {
		listeners.add(listener);
	}
	
	public void removeListener(CombinationGeneratorListener<T> listener) {
		listeners.remove(listener);
	}
	
	public DynamicListCombinationGenerator(List<T> list, int n) {
		init(list, n);
	}
	
	protected void init(List<T> list, int n) {
		this.list = list;
		this.n = n;
		
		if (list instanceof DynamicList<?>) {
			((DynamicList<T>) list).addListener(new DynamicListListener<T>() {
				@Override
				public void valuesChanged(DynamicList<T> list) {
					createCombinationGenerator();
				}
			});
		}
		else {
			createCombinationGenerator();
		}
		
	}
	
	protected void createCombinationGenerator() {
		listCombinationGenerator = new ListCombinationGenerator<T>(list, n);		
	}
	
	public void reset() {
		if (listCombinationGenerator != null) listCombinationGenerator.reset();
		if (list instanceof DynamicList<?>) ((DynamicList<T>) list).reset();
		for (CombinationGeneratorListener<T> listener : listeners) {
			listener.reset();
		}
		producedValidCombination = false;
		state = State.NORMAL;
		optional = null;
	}
	
	@Override
	public boolean hasMore() {
		
		if (state!=State.NORMAL && isOptional()) {
			if (state == State.CAN_RETURN_OPTIONAL) return true;
			if (state == State.HAS_RETURNED_OPTIONAL) return false;
		}
		
		nudgeList();
		boolean hasMore = listCombinationGenerator.hasMore();
		if (!hasMore && !producedValidCombination && isOptional()) {
			state = State.CAN_RETURN_OPTIONAL;
			hasMore = true;
		}
		
		return hasMore;
	}

	@Override
	public List<T> getNext() {
		
		if (state != State.NORMAL && isOptional()) {
			if (state == State.HAS_RETURNED_OPTIONAL) return null;
			
			if (state == State.CAN_RETURN_OPTIONAL) {
				ArrayList<T> optional = new ArrayList<T>();
				for (int i=0;i<n;i++) {
					optional.add((T) NoMatch.INSTANCE);
				}
				state = State.HAS_RETURNED_OPTIONAL;
				return optional;
			}
		}
		
		nudgeList();
		List<T> next = listCombinationGenerator.getNext();
		
		for (CombinationGeneratorListener<T> listener : listeners) {
			listener.generated(next);
		}
		
		return next;
	}
	
	/**
	 * Nudge the list so that it loads
	 * its contents if it's dynamic
	 */
	protected void nudgeList() {
		list.size();
	}

	@Override
	public void producedValidCombination() {
		this.producedValidCombination = true;
	}
	
	public boolean isOptional() {
		if (optional == null) {
			optional = checkOptional();
		}
		return optional;
	}
	
	public Boolean checkOptional() {
		return false;
	}
	
	enum State {
		NORMAL,
		CAN_RETURN_OPTIONAL,
		HAS_RETURNED_OPTIONAL
	}
	
}
