/*
 * 
 */
package flowchart.diagram.edit.parts;

import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.directedit.locator.CellEditorLocatorAccess;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import flowchart.diagram.part.FlowchartVisualIDRegistry;

/**
 * @generated
 */
public class FlowchartEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (FlowchartVisualIDRegistry.getVisualID(view)) {

			case FlowchartEditPart.VISUAL_ID:
				return new FlowchartEditPart(view);

			case SubflowEditPart.VISUAL_ID:
				return new SubflowEditPart(view);

			case SubflowNameEditPart.VISUAL_ID:
				return new SubflowNameEditPart(view);

			case ActionEditPart.VISUAL_ID:
				return new ActionEditPart(view);

			case ActionNameEditPart.VISUAL_ID:
				return new ActionNameEditPart(view);

			case DecisionEditPart.VISUAL_ID:
				return new DecisionEditPart(view);

			case DecisionNameEditPart.VISUAL_ID:
				return new DecisionNameEditPart(view);

			case TransitionEditPart.VISUAL_ID:
				return new TransitionEditPart(view);

			case TransitionNameEditPart.VISUAL_ID:
				return new TransitionNameEditPart(view);

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
