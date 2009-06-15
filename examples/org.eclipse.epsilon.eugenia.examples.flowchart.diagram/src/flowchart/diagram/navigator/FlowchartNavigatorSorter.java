/*
 * 
 */
package flowchart.diagram.navigator;

import org.eclipse.jface.viewers.ViewerSorter;

import flowchart.diagram.part.FlowchartVisualIDRegistry;

/**
 * @generated
 */
public class FlowchartNavigatorSorter extends ViewerSorter {

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
		if (element instanceof FlowchartNavigatorItem) {
			FlowchartNavigatorItem item = (FlowchartNavigatorItem) element;
			if (item.getView().getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
				return SHORTCUTS_CATEGORY;
			}
			return FlowchartVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
