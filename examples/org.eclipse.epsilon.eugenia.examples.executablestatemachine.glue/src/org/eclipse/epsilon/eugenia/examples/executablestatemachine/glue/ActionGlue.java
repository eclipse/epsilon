package org.eclipse.epsilon.eugenia.examples.executablestatemachine.glue;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EStructuralFeature;

public class ActionGlue {

	public EStructuralFeature targetFor(EAttribute[] attributes) {
		return attributes[0].getEContainingClass().getEStructuralFeature("actionImpl");
	}
}
