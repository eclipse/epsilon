package org.eclipse.epsilon.erl.dom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SuppressWarnings("serial")
public class NamedRuleList<T extends NamedRule> extends ArrayList<T> {
	
	public static void main(String[] args) {
		
		Post p1 = new Post();
		p1.setName("P1");
		Post p2 = new Post();
		p2.setName("P1");
		
		NamedRuleList<Post> rules = new NamedRuleList<Post>();
		rules.add(p1);
		rules.add(p2);
		
	}
	
	@Override
	public boolean add(T namedRule) {
		NamedRule toRemove = null;
		for (NamedRule rule : this) {
			if (namedRule.getName().equals(rule.getName())) {
				toRemove = rule;
			}
		}
		if (toRemove != null) {
			remove(toRemove);
		}
		return super.add(namedRule);
	}
	
	@Override
	public boolean addAll(Collection<? extends T> c) {
		List<NamedRule> toRemove = new ArrayList<NamedRule>();
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
	
	public void add(int index, T element) {
		throw new UnsupportedOperationException();
	};
	
	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		throw new UnsupportedOperationException();
	}
	
}
