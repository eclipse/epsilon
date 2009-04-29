/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package friends.diagram.part;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gmf.runtime.notation.View;

import friends.diagram.edit.parts.WorldEditPart;

/**
 * @generated
 */
public class FriendsShortcutPropertyTester extends PropertyTester {

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
				return WorldEditPart.MODEL_ID.equals(annotation.getDetails()
						.get("modelID")); //$NON-NLS-1$
			}
		}
		return false;
	}

}
