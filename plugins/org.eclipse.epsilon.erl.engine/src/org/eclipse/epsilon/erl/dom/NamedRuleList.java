package org.eclipse.epsilon.erl.dom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SuppressWarnings("serial")
public class NamedRuleList<T extends NamedRule> extends ArrayList<T> {
	
	@Override
	public boolean add(T namedRule) {
		this.stream()
			.filter(nr -> namedRule.getName().equals(nr.getName()))
			.findAny()
			.ifPresent(this::remove);
		return super.add(namedRule);
	}
	
	@Override
	public boolean addAll(Collection<? extends T> c) {
		List<NamedRule> toRemove = new ArrayList<>();
		for (NamedRule rule : this) {
			for (NamedRule namedRule : c) {
				if (rule.getName().equals(namedRule.getName())) {
					toRemove.add(rule);
				}
			}
		}
		removeAll(toRemove);
		return super.addAll(c);
	}
	
	@Override
	public void add(int index, T element) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		throw new UnsupportedOperationException();
	}
	
}
