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
package friends.diagram.navigator;

import org.eclipse.jface.viewers.ViewerSorter;

import friends.diagram.part.FriendsVisualIDRegistry;

/**
 * @generated
 */
public class FriendsNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 3004;

	/**
	 * @generated
	 */
	private static final int SHORTCUTS_CATEGORY = 3003;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof FriendsNavigatorItem) {
			FriendsNavigatorItem item = (FriendsNavigatorItem) element;
			if (item.getView().getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
				return SHORTCUTS_CATEGORY;
			}
			return FriendsVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
