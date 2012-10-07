/*
 * 
 */
package filesystem.diagram.providers;

import filesystem.diagram.part.FilesystemDiagramEditorPlugin;

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
		ElementInitializers cached = FilesystemDiagramEditorPlugin
				.getInstance().getElementInitializers();
		if (cached == null) {
			FilesystemDiagramEditorPlugin.getInstance().setElementInitializers(
					cached = new ElementInitializers());
		}
		return cached;
	}

}
