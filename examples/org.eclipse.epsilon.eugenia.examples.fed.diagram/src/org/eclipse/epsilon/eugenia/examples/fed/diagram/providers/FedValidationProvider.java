/*
 * 
 */
package org.eclipse.epsilon.eugenia.examples.fed.diagram.providers;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.edit.parts.ConfigurationEditPart;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.part.FedDiagramEditorPlugin;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.part.FedVisualIDRegistry;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class FedValidationProvider {

	/**
	 * @generated
	 */
	private static boolean constraintsActive = false;

	/**
	 * @generated
	 */
	public static boolean shouldConstraintsBePrivate() {
		return false;
	}

	/**
	 * @generated
	 */
	public static void runWithConstraints(
			TransactionalEditingDomain editingDomain, Runnable operation) {
		final Runnable op = operation;
		Runnable task = new Runnable() {
			public void run() {
				try {
					constraintsActive = true;
					op.run();
				} finally {
					constraintsActive = false;
				}
			}
		};
		if (editingDomain != null) {
			try {
				editingDomain.runExclusive(task);
			} catch (Exception e) {
				FedDiagramEditorPlugin.getInstance().logError(
						"Validation failed", e); //$NON-NLS-1$
			}
		} else {
			task.run();
		}
	}

	/**
	 * @generated
	 */
	static boolean isInDefaultEditorContext(Object object) {
		if (shouldConstraintsBePrivate() && !constraintsActive) {
			return false;
		}
		if (object instanceof View) {
			return constraintsActive
					&& ConfigurationEditPart.MODEL_ID
							.equals(FedVisualIDRegistry
									.getModelID((View) object));
		}
		return true;
	}

}
