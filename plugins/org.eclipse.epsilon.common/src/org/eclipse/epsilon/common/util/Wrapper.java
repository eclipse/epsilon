package org.eclipse.epsilon.common.util;

public class Wrapper<T> {
	protected T value;

	public Wrapper(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
}