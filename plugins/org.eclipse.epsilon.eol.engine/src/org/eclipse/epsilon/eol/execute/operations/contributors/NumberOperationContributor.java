/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.execute.operations.contributors;

import java.util.stream.LongStream;
import org.eclipse.epsilon.eol.types.NumberUtil;

public class NumberOperationContributor extends OperationContributor {

	@Override
	public boolean contributesTo(Object target) {
		return target instanceof Number;
	}
	
	private Number getNumber() {
		return (Number) getTarget();
	}
	
	/**
	 * n!. Note that only values less than or equal to 20 are supported.
	 * @return Factorial of self.
	 * @since 1.6
	 */
	public Number factorial() {
		long n = getNumber().longValue();
        if (n > 20 || n < 0) throw new IllegalArgumentException(n + " is out of range");
        return LongStream.rangeClosed(2, n).reduce(1, (a, b) -> a * b);
	}
	
	public Number min(Number other) {
		Number self = (Number) getTarget();
		if (NumberUtil.lessThan(self, other)) {
			return self;
		}
		else {
			return other;
		}
	}
	
	public Number max(Number other) {
		Number self = (Number) getTarget();
		if (NumberUtil.greaterThan(self, other)) {
			return self;
		}
		else {
			return other;
		}
	}
	
	public int floor() {
		Number self = (Number) getTarget();
		return (int) Math.floor(self.doubleValue());
	}
	
	public Number pow(Number n) {
		Double pow = Math.pow(((Number) getTarget()).doubleValue(), n.doubleValue());
		if (getTarget() instanceof Integer && n instanceof Integer && NumberUtil.greaterThan(n, 0)) {
			return pow.intValue();
		}
		else {
			return pow;
		}
	}
	
	public int ceiling() {
		Number self = (Number) getTarget();
		return (int) Math.ceil(self.doubleValue());
	}
	
	public int round() {
		return Math.round(getNumber().floatValue());
	}
	
	public double ln() {
		return log();
	}
	
	public double log() {
		return Math.log(getNumber().doubleValue());
	}
	
	public double log10() {
		return Math.log10(getNumber().doubleValue());
	}
	
	public Number abs() {
		Object target = this.getTarget();
		if (target instanceof Integer) return Math.abs((Integer) target);
		if (target instanceof Float) return Math.abs((Float) target);
		if (target instanceof Double) return Math.abs((Double) target);
		if (target instanceof Long) return Math.abs((Long) target);
		return null;
	}
	
	public double asReal() {
		Number value = (Number) getTarget();
		return value.floatValue();
	}
	
	public double asDouble() {
		Number value = (Number) getTarget();
		return value.doubleValue();
	}
	
	public float asFloat() {
		Number value = (Number) getTarget();
		return value.floatValue();
	}
	
	public int asInteger() {
		Number value = (Number) getTarget();
		return value.intValue();
	}
	
	public long asLong() {
		Number value = (Number) getTarget();
		return value.longValue();
	}
	
}
