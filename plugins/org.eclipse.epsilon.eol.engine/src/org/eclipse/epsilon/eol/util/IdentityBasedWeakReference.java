package org.eclipse.epsilon.eol.util;

import java.lang.ref.WeakReference;

public class IdentityBasedWeakReference extends WeakReference<Object> {

	public IdentityBasedWeakReference(Object referent) {
		super(referent);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		else return this.hashCode() == obj.hashCode();
	}
	
	@Override
	public int hashCode() {
		if (this.get() != null) {
			return System.identityHashCode(this.get());
		}
		else {
			return super.hashCode();
		}
	}
	
}
