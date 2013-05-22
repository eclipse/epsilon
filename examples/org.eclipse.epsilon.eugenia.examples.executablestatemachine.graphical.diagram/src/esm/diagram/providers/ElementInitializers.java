/*
 * 
 */
package esm.diagram.providers;

import esm.diagram.part.EsmDiagramEditorPlugin;

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
		ElementInitializers cached = EsmDiagramEditorPlugin.getInstance()
				.getElementInitializers();
		if (cached == null) {
			EsmDiagramEditorPlugin.getInstance().setElementInitializers(
					cached = new ElementInitializers());
		}
		return cached;
	}
}
