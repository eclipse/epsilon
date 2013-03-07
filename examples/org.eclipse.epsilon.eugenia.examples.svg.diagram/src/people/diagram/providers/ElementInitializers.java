/*
 * 
 */
package people.diagram.providers;

import people.diagram.part.PeopleDiagramEditorPlugin;

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
		ElementInitializers cached = PeopleDiagramEditorPlugin.getInstance()
				.getElementInitializers();
		if (cached == null) {
			PeopleDiagramEditorPlugin.getInstance().setElementInitializers(
					cached = new ElementInitializers());
		}
		return cached;
	}
}
