package org.eclipse.epsilon.epl.combinations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class CompositeCombinationGenerator<T> implements CombinationGenerator<List<T>> {
	
	protected ArrayList<CombinationGenerator<T>> generators = new ArrayList<CombinationGenerator<T>>();
	protected int currentGeneratorIndex = 0;
	protected Stack<List<T>> currentStack = new Stack<List<T>>();
	protected CompositeCombinationValidator<T> validator = null;
	protected List<List<T>> NEXT = new ArrayList<List<T>>();
	protected List<List<T>> UNKNOWN = new LinkedList<List<T>>();
	protected List<List<T>> lookahead = UNKNOWN;
	
	public static void main(String[] args) throws Exception {
		
		CompositeCombinationGenerator<String> ccg = new CompositeCombinationGenerator<String>();
		
//		NCombinationGenerator<String> f1 = new NCombinationGenerator<String>(createList("a1", "a2", "a3", "a4"), 2);
		//DynamicListCombinationGenerator<String> f1 = new DynamicListCombinationGenerator<String>(createList("a", "b"), 1);
		//DynamicListCombinationGenerator<String> f2 = new DynamicListCombinationGenerator<String>(createList(), 1);
		//DynamicListCombinationGenerator<String> f3 = new DynamicListCombinationGenerator<String>(createList("e", "f"), 1);
		//ccg.addCombinationGenerator(f1);
		//ccg.addCombinationGenerator(f2);
		//ccg.addCombinationGenerator(f3);
		//ccg.addCombinationGenerator(ccg1);
		
		//ccg.setValidator(new CompositeCombinationValidator<String>() {
			
		//	@Override
		//	public boolean isValid(List<List<String>> combination) {
		//		System.err.println("Checked " + combination);
		///		return combination.size() < 3;
		//	}
		//});
		
		
		//while (ccg.hasMore()) {
		//	System.err.println(ccg.getNext());
		//}
	}
	
	public static List<String> createList(String... strings) {
		ArrayList<String> list = new ArrayList<String>();
		for (String str : strings) {
			list.add(str);
		}
		return list;
	}
	
	public CompositeCombinationValidator<T> getValidator() {
		return validator;
	}
	
	public void setValidator(CompositeCombinationValidator<T> validator) {
		this.validator = validator;
	}

	public void addCombinationGenerator(CombinationGenerator<T> g) {
		generators.add(g);
		reset();
	}
	
	public boolean removeCombinationGenerator(CombinationGenerator<T> g) {
		boolean removed = generators.remove(g);
		reset();
		return removed;
	}
	
	public boolean hasMore() throws Exception {
		if (lookahead == UNKNOWN) {
			lookahead = getNextImpl();
			while (lookahead == NEXT) {
				lookahead = getNextImpl();
			}
		}
		
		return lookahead != null;
	}
	
	public List<List<T>> getNext() throws Exception{
		if (lookahead != UNKNOWN) {
			List<List<T>> result = lookahead;
			lookahead = UNKNOWN;
			return result;
		}
		List<List<T>> next = getNextImpl();
		while (next == NEXT) {
			next = getNextImpl();
		}

		return next;
	}
	
	protected List<List<T>> getNextImpl() throws Exception {
		
		while (!getCurrentGenerator().hasMore()) {
			if (isFirstGenerator()) {
				return null;
			}
			else {
				currentStack.pop();
				getCurrentGenerator().reset();
				setCurrentGenerator(getPreviousGenerator());
			}
		}
		
		if (!currentStack.isEmpty()) currentStack.pop();
		currentStack.push(getCurrentGenerator().getNext());
		
		boolean validCombination = isValidCombination();
		if (validCombination) getCurrentGenerator().producedValidCombination();
		
		while (!isLastGenerator() && validCombination) {
			setCurrentGenerator(getNextGenerator());
			currentStack.push(getCurrentGenerator().getNext());
			validCombination = isValidCombination();
			if (validCombination) getCurrentGenerator().producedValidCombination();
		}
		 
		if (validCombination) {
			return currentStack;
		}
		else {
			return NEXT;
		}
	}
	
	public void reset() {
		for (CombinationGenerator<T> g : generators) {
			g.reset();
		}
		if (!generators.isEmpty()) {
			currentGeneratorIndex = 0;
		}
	}
	
	protected boolean isValidCombination() throws Exception {
		
		for (List<T> t : currentStack) {
			if (t == null) return false;
		}
		
		if (validator == null) {
			return true;
		}
		else {
			return validator.isValid(currentStack);
		}
	}
	
	protected CombinationGenerator<T> getPreviousGenerator() {
		if (currentGeneratorIndex == 0) return null;
		else return generators.get(currentGeneratorIndex - 1); 
	}
	
	protected CombinationGenerator<T> getNextGenerator() {
		if (currentGeneratorIndex == generators.size()-1) return null;
		else return generators.get(currentGeneratorIndex + 1);
	}
	
	protected CombinationGenerator<T> getCurrentGenerator() {
		return generators.get(currentGeneratorIndex);
	}
	
	protected void setCurrentGenerator(CombinationGenerator<T> g) {
		currentGeneratorIndex = generators.indexOf(g);
	}
	
	protected boolean isFirstGenerator() {
		return getPreviousGenerator() == null;
	}
	
	protected boolean isLastGenerator() {
		return getNextGenerator() == null;
	}

	@Override
	public void producedValidCombination() {
		// TODO Auto-generated method stub
		
	}
	
}
