package org.eclipse.epsilon.epl.combinations;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class ListCombinationGenerator<T> implements CombinationGenerator<T> {

	private int[] a;
	private int n;
	private int r;
	private BigInteger remaining;
	private BigInteger total;
	protected List<T> list;
	protected boolean initialised = false;
	
	public void initialise() {
		if (initialised == false) {
			this.n = list.size();
			//if (r > n) {
			//	throw new IllegalArgumentException();
			//}
			//if (n < 1) {
			//	throw new IllegalArgumentException();
			//}
			a = new int[r];
			BigInteger nFact = getFactorial(n);
			BigInteger rFact = getFactorial(r);
			BigInteger nminusrFact = getFactorial(n - r);
			total = nFact.divide(rFact.multiply(nminusrFact));
			
			initialised = true;
			reset();
		}
	}
	
	public ListCombinationGenerator(List<T> list, int r) {
		this.r = r;
		this.list = list;
	}

	public void reset() {
		if (initialised) {
			for (int i = 0; i < a.length; i++) {
				a[i] = i;
			}
			remaining = new BigInteger(total.toString());
		}
	}

	public BigInteger getRemaining() {
		initialise();
		return remaining;
	}

	public boolean hasMore() {
		initialise();
		if (list.isEmpty()) return false;
		if (r > list.size()) return false;
		return remaining.compareTo(BigInteger.ZERO) == 1;
	}

	public BigInteger getTotal() {
		initialise();
		return total;
	}

	private static BigInteger getFactorial(int n) {
		BigInteger fact = BigInteger.ONE;
		for (int i = n; i > 1; i--) {
			fact = fact.multiply(new BigInteger(Integer.toString(i)));
		}
		return fact;
	}

	public List<T> getNext() {
		initialise();
		if (!hasMore()) return null;
		
		if (remaining.equals(total)) {
			remaining = remaining.subtract(BigInteger.ONE);
		}
		else {
			int i = r - 1;
			while (a[i] == n - r + i) {
				i--;
			}
			a[i] = a[i] + 1;
			for (int j = i + 1; j < r; j++) {
				a[j] = a[i] + j - i;
			}
	
			remaining = remaining.subtract(BigInteger.ONE);
		}
		
		List<T> next = new ArrayList<T>();
		for (int j : a) {
			next.add(list.get(j));
		}
		
		return next;

	}

	@Override
	public void producedValidCombination() {
		// TODO Auto-generated method stub
		
	}
}