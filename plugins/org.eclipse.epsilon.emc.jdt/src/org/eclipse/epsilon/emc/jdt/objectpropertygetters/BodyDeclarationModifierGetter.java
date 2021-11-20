package org.eclipse.epsilon.emc.jdt.objectpropertygetters;

import org.eclipse.jdt.core.dom.BodyDeclaration;
import org.eclipse.jdt.core.dom.Modifier;

public class BodyDeclarationModifierGetter extends ObjectPropertyGetter<BodyDeclaration, Boolean> {

	public BodyDeclarationModifierGetter() {
		super(BodyDeclaration.class, "public", "static", "abstract", "protected", "private", "final");
	}
	
	@Override
	public Boolean getValue(BodyDeclaration bodyDeclaration, String property) {
		
		for (Object modifier : bodyDeclaration.modifiers()) {
			if (modifier instanceof Modifier) {
				if (property.equals(((Modifier) modifier).getKeyword().toString())) {
					return true;
				}
			}
		}
		return false;
	}

}
