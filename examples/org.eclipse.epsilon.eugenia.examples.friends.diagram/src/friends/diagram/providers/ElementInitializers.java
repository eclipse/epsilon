/*
 * 
 */
package friends.diagram.providers;

import friends.diagram.part.FriendsDiagramEditorPlugin;

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
		ElementInitializers cached = FriendsDiagramEditorPlugin.getInstance()
				.getElementInitializers();
		if (cached == null) {
			FriendsDiagramEditorPlugin.getInstance().setElementInitializers(
					cached = new ElementInitializers());
		}
		return cached;
	}
}
