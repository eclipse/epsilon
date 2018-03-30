package org.eclipse.epsilon.eol.compile.m3;

import java.util.ArrayList;
import java.util.List;

public class Metamodel extends Package {

	protected List<String> warnings = new ArrayList<>();
	protected List<String> errors = new ArrayList<>();
	
	public List<String> getWarnings() {
		return warnings;
	}
	
	public List<String> getErrors() {
		return errors;
	}
	
	public MetaClass getMetaClass(String name) {
		for (MetaType type : metaTypes) {
			if (type instanceof MetaClass && type.getName().equals(name)) {
				return (MetaClass) type;
			}
		}
		return null;
	}
	
}
