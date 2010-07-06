package org.eclipse.epsilon.eol.execute.operations.contributors;

import org.eclipse.epsilon.eol.types.NumberUtil;

public class NumberOperationContributor extends OperationContributor {

	@Override
	public boolean contributesTo(Object target) {
		return target instanceof Number;
	}
	
	public Number min(Number other) {
		Number self = (Number) target;
		if (NumberUtil.lessThan(self, other)) {
			return self;
		}
		else {
			return other;
		}
	}
	
	public Number max(Number other) {
		Number self = (Number) target;
		if (NumberUtil.greaterThan(self, other)) {
			return self;
		}
		else {
			return other;
		}
	}
	
	public int floor() {
		Number self = (Number) target;
		return (int) Math.floor(self.doubleValue());
	}
	
	public int ceiling() {
		Number self = (Number) target;
		return (int) Math.ceil(self.doubleValue());
	}
	
	public Number abs() {
		if (target instanceof Integer) return Math.abs((Integer) target);
		if (target instanceof Float) return Math.abs((Float) target);
		if (target instanceof Double) return Math.abs((Double) target);
		if (target instanceof Long) return Math.abs((Long) target);
		return null;
	}
	
	public double asReal() {
		Number value = (Number) target;
		return value.floatValue();
	}
	
	public double asDouble() {
		Number value = (Number) target;
		return value.doubleValue();
	}
	
	public float asFloat() {
		Number value = (Number) target;
		return value.floatValue();
	}
	
	public int asInteger() {
		Number value = (Number) target;
		return value.intValue();
	}
	
	public long asLong() {
		Number value = (Number) target;
		return value.longValue();
	}
	
}
