/*
 * 
 */
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
	private static final int GROUP_CATEGORY = 4004;

	/**
	 * @generated
	 */
	private static final int SHORTCUTS_CATEGORY = 4003;

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
