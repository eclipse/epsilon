/*
 * 
 */
package org.eclipse.epsilon.eugenia.examples.fed.diagram.edit.parts;

import org.eclipse.epsilon.eugenia.examples.fed.diagram.part.FedVisualIDRegistry;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.directedit.locator.CellEditorLocatorAccess;

/**
 * @generated
 */
public class FedEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (FedVisualIDRegistry.getVisualID(view)) {

			case ConfigurationEditPart.VISUAL_ID:
				return new ConfigurationEditPart(view);

			case FeatureEditPart.VISUAL_ID:
				return new FeatureEditPart(view);

			case FeatureNameEditPart.VISUAL_ID:
				return new FeatureNameEditPart(view);

			case PluginEditPart.VISUAL_ID:
				return new PluginEditPart(view);

			case PluginNameEditPart.VISUAL_ID:
				return new PluginNameEditPart(view);

			case Plugin2EditPart.VISUAL_ID:
				return new Plugin2EditPart(view);

			case PluginName2EditPart.VISUAL_ID:
				return new PluginName2EditPart(view);

			case FeatureFeaturePluginsCompartmentEditPart.VISUAL_ID:
				return new FeatureFeaturePluginsCompartmentEditPart(view);

			case FeatureDependsEditPart.VISUAL_ID:
				return new FeatureDependsEditPart(view);

			case WrappingLabelEditPart.VISUAL_ID:
				return new WrappingLabelEditPart(view);

			case FeatureIncludesEditPart.VISUAL_ID:
				return new FeatureIncludesEditPart(view);

			case WrappingLabel2EditPart.VISUAL_ID:
				return new WrappingLabel2EditPart(view);

			}
		}
		return createUnrecognizedEditPart(context, model);
	}

	/**
	 * @generated
	 */
	private EditPart createUnrecognizedEditPart(EditPart context, Object model) {
		// Handle creation of unrecognized child node EditParts here
		return null;
	}

	/**
	 * @generated
	 */
	public static CellEditorLocator getTextCellEditorLocator(
			ITextAwareEditPart source) {
		return CellEditorLocatorAccess.INSTANCE
				.getTextCellEditorLocator(source);
	}

}
