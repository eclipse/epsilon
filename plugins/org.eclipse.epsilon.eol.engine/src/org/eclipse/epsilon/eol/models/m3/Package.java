package org.eclipse.epsilon.eol.models.m3;

import java.util.ArrayList;
import java.util.List;

public class Package extends NamedElement {
	
	protected List<Package> subPackages = new ArrayList<Package>();
	protected List<Type> types = new ArrayList<Type>();
	
	public List<Package> getSubPackages() {
		return subPackages;
	}
	
	public List<Type> getTypes() {
		return types;
	}
}
