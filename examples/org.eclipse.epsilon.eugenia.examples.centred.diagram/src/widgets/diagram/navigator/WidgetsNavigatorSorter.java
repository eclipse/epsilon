/*
 * 
 */
package widgets.diagram.navigator;

import org.eclipse.jface.viewers.ViewerSorter;

import widgets.diagram.part.WidgetsVisualIDRegistry;

/**
 * @generated
 */
public class WidgetsNavigatorSorter extends ViewerSorter {

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
		if (element instanceof WidgetsNavigatorItem) {
			WidgetsNavigatorItem item = (WidgetsNavigatorItem) element;
			if (item.getView().getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
				return SHORTCUTS_CATEGORY;
			}
			return WidgetsVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
