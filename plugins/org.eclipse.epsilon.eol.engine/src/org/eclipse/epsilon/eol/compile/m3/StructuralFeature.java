package org.eclipse.epsilon.eol.compile.m3;

public abstract class StructuralFeature extends NamedElement {
	
	protected boolean many;
	protected boolean unique;
	protected boolean ordered;
	protected boolean changeable;
	
	public boolean isMany() {
		return many;
	}
	
	public void setMany(boolean many) {
		this.many = many;
	}
	
	public boolean isUnique() {
		return unique;
	}
	
	public void setUnique(boolean unique) {
		this.unique = unique;
	}
	
	public boolean isOrdered() {
		return ordered;
	}
	
	public void setOrdered(boolean ordered) {
		this.ordered = ordered;
	}
	
	public boolean isChangeable() {
		return changeable;
	}
	
	public void setChangeable(boolean changeable) {
		this.changeable = changeable;
	}
	
}
