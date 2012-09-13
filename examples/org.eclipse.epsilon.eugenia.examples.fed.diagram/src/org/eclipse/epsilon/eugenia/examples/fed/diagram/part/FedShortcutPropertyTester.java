/*
 * 
 */
package org.eclipse.epsilon.eugenia.examples.fed.diagram.part;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.edit.parts.ConfigurationEditPart;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class FedShortcutPropertyTester extends PropertyTester {

	/**
	 * @generated
	 */
	protected static final String SHORTCUT_PROPERTY = "isShortcut"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public boolean test(Object receiver, String method, Object[] args,
			Object expectedValue) {
		if (false == receiver instanceof View) {
			return false;
		}
		View view = (View) receiver;
		if (SHORTCUT_PROPERTY.equals(method)) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return ConfigurationEditPart.MODEL_ID.equals(annotation
						.getDetails().get("modelID")); //$NON-NLS-1$
			}
		}
		return false;
	}

}
