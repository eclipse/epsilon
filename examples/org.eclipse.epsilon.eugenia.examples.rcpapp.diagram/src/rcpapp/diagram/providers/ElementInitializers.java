/*
 * 
 */
package rcpapp.diagram.providers;

import rcpapp.diagram.part.RcpappDiagramEditorPlugin;

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
		ElementInitializers cached = RcpappDiagramEditorPlugin.getInstance()
				.getElementInitializers();
		if (cached == null) {
			RcpappDiagramEditorPlugin.getInstance().setElementInitializers(
					cached = new ElementInitializers());
		}
		return cached;
	}
}
