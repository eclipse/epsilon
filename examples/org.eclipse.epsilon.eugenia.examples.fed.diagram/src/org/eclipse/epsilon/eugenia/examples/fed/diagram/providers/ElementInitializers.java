/*
 * 
 */
package org.eclipse.epsilon.eugenia.examples.fed.diagram.providers;

import org.eclipse.epsilon.eugenia.examples.fed.diagram.part.FedDiagramEditorPlugin;

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
		ElementInitializers cached = FedDiagramEditorPlugin.getInstance()
				.getElementInitializers();
		if (cached == null) {
			FedDiagramEditorPlugin.getInstance().setElementInitializers(
					cached = new ElementInitializers());
		}
		return cached;
	}
}
