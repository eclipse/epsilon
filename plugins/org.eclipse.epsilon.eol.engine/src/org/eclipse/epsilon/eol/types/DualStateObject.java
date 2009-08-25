package org.eclipse.epsilon.eol.types;

public class DualStateObject {
	
	protected boolean isWrapped;
	protected Object o;
	
	public DualStateObject(Object o) {
		this.o = o;
		this.isWrapped = o instanceof EolAny;
	}
	
	public Object getWrapped() {
		if (isWrapped) return o;
		else return EolTypeWrapper.getInstance().wrap(o);
	}
	
	public Object getUnwrapped() {
		if (!isWrapped) return o;
		else return EolTypeWrapper.getInstance().unwrap(o);
	}
	
	// TODO : Optimize
	public boolean equals(Object other) {
		if (other == null || !(other instanceof DualStateObject) ) return false;
		DualStateObject dso = (DualStateObject) other;
		return this.getWrapped().equals(dso.getWrapped()) || this.getUnwrapped().equals(dso.getUnwrapped());
	}
}
