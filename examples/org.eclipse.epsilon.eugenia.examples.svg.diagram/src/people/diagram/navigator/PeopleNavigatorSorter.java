/*
 * 
 */
package people.diagram.navigator;

import org.eclipse.jface.viewers.ViewerSorter;

import people.diagram.part.PeopleVisualIDRegistry;

/**
 * @generated
 */
public class PeopleNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 2003;

	/**
	 * @generated
	 */
	private static final int SHORTCUTS_CATEGORY = 2002;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof PeopleNavigatorItem) {
			PeopleNavigatorItem item = (PeopleNavigatorItem) element;
			if (item.getView().getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
				return SHORTCUTS_CATEGORY;
			}
			return PeopleVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
