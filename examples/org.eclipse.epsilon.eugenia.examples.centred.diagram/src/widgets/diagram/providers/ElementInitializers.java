/*
 * 
 */
package widgets.diagram.providers;

import widgets.diagram.part.WidgetsDiagramEditorPlugin;

/**
 * @generated
 */
public class ElementInitializers {

	protected ElementInitializers() {
		// use #getInstance to access cached instance
	}

	/**
	 * @generated
	 */
	public static ElementInitializers getInstance() {
		ElementInitializers cached = WidgetsDiagramEditorPlugin.getInstance()
				.getElementInitializers();
		if (cached == null) {
			WidgetsDiagramEditorPlugin.getInstance().setElementInitializers(
					cached = new ElementInitializers());
		}
		return cached;
	}
}
