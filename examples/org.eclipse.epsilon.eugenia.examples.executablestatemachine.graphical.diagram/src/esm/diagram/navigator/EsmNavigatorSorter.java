/*
 * 
 */
package esm.diagram.navigator;

import org.eclipse.jface.viewers.ViewerSorter;

import esm.diagram.part.EsmVisualIDRegistry;

/**
 * @generated
 */
public class EsmNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 4003;

	/**
	 * @generated
	 */
	private static final int SHORTCUTS_CATEGORY = 4002;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof EsmNavigatorItem) {
			EsmNavigatorItem item = (EsmNavigatorItem) element;
			if (item.getView().getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
				return SHORTCUTS_CATEGORY;
			}
			return EsmVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
