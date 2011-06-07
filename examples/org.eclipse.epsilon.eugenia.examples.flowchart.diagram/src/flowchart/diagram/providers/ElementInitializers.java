/*
 * 
 */
package flowchart.diagram.providers;

import flowchart.diagram.part.FlowchartDiagramEditorPlugin;

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
		ElementInitializers cached = FlowchartDiagramEditorPlugin.getInstance()
				.getElementInitializers();
		if (cached == null) {
			FlowchartDiagramEditorPlugin.getInstance().setElementInitializers(
					cached = new ElementInitializers());
		}
		return cached;
	}

}
