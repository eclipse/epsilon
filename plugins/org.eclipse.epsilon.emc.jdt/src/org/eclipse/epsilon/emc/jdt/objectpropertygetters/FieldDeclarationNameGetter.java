package org.eclipse.epsilon.emc.jdt.objectpropertygetters;

import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

public class FieldDeclarationNameGetter extends ObjectPropertyGetter<FieldDeclaration, String> {
	
	public FieldDeclarationNameGetter() {
		super(FieldDeclaration.class, "name");
	}
	
	@Override
	public String getValue(FieldDeclaration fd, String property) {
		Object o = fd.fragments().get(0);
		if(o instanceof VariableDeclarationFragment){
			return ((VariableDeclarationFragment) o).getName().toString();
		}
		return null;
	}
	
}
