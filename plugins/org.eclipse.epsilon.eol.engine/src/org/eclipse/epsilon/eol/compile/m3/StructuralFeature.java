package org.eclipse.epsilon.eol.compile.m3;

import org.eclipse.epsilon.eol.types.EolAnyType;
import org.eclipse.epsilon.eol.types.EolType;

public abstract class StructuralFeature extends NamedElement {
	
	protected boolean many;
	protected boolean unique;
	protected boolean ordered;
	protected boolean changeable;
	protected EolType type = EolAnyType.Instance;
	
	public EolType getType() {
		return type;
	}
	
	public void setType(EolType type) {
		this.type = type;
	}
	
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
