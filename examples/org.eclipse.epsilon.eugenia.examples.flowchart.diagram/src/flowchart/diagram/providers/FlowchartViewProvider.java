/*
 * 
 */
package flowchart.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.View;

import flowchart.diagram.edit.parts.ActionEditPart;
import flowchart.diagram.edit.parts.ActionNameEditPart;
import flowchart.diagram.edit.parts.DecisionEditPart;
import flowchart.diagram.edit.parts.DecisionNameEditPart;
import flowchart.diagram.edit.parts.FlowchartEditPart;
import flowchart.diagram.edit.parts.SubflowEditPart;
import flowchart.diagram.edit.parts.SubflowNameEditPart;
import flowchart.diagram.edit.parts.TransitionEditPart;
import flowchart.diagram.edit.parts.TransitionNameEditPart;
import flowchart.diagram.part.FlowchartVisualIDRegistry;
import flowchart.diagram.view.factories.ActionNameViewFactory;
import flowchart.diagram.view.factories.ActionViewFactory;
import flowchart.diagram.view.factories.DecisionNameViewFactory;
import flowchart.diagram.view.factories.DecisionViewFactory;
import flowchart.diagram.view.factories.FlowchartViewFactory;
import flowchart.diagram.view.factories.SubflowNameViewFactory;
import flowchart.diagram.view.factories.SubflowViewFactory;
import flowchart.diagram.view.factories.TransitionNameViewFactory;
import flowchart.diagram.view.factories.TransitionViewFactory;

/**
 * @generated
 */
public class FlowchartViewProvider extends AbstractViewProvider {

	/**
	 * @generated
	 */
	protected Class getDiagramViewClass(IAdaptable semanticAdapter,
			String diagramKind) {
		EObject semanticElement = getSemanticElement(semanticAdapter);
		if (FlowchartEditPart.MODEL_ID.equals(diagramKind)
				&& FlowchartVisualIDRegistry
						.getDiagramVisualID(semanticElement) != -1) {
			return FlowchartViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Class getNodeViewClass(IAdaptable semanticAdapter,
			View containerView, String semanticHint) {
		if (containerView == null) {
			return null;
		}
		IElementType elementType = getSemanticElementType(semanticAdapter);
		EObject domainElement = getSemanticElement(semanticAdapter);
		int visualID;
		if (semanticHint == null) {
			// Semantic hint is not specified. Can be a result of call from CanonicalEditPolicy.
			// In this situation there should be NO elementType, visualID will be determined
			// by VisualIDRegistry.getNodeVisualID() for domainElement.
			if (elementType != null || domainElement == null) {
				return null;
			}
			visualID = FlowchartVisualIDRegistry.getNodeVisualID(containerView,
					domainElement);
		} else {
			visualID = FlowchartVisualIDRegistry.getVisualID(semanticHint);
			if (elementType != null) {
				// Semantic hint is specified together with element type.
				// Both parameters should describe exactly the same diagram element.
				// In addition we check that visualID returned by VisualIDRegistry.getNodeVisualID() for
				// domainElement (if specified) is the same as in element type.
				if (!FlowchartElementTypes.isKnownElementType(elementType)
						|| (!(elementType instanceof IHintedType))) {
					return null; // foreign element type
				}
				String elementTypeHint = ((IHintedType) elementType)
						.getSemanticHint();
				if (!semanticHint.equals(elementTypeHint)) {
					return null; // if semantic hint is specified it should be the same as in element type
				}
				if (domainElement != null
						&& visualID != FlowchartVisualIDRegistry
								.getNodeVisualID(containerView, domainElement)) {
					return null; // visual id for node EClass should match visual id from element type
				}
			} else {
				// Element type is not specified. Domain element should be present (except pure design elements).
				// This method is called with EObjectAdapter as parameter from:
				//   - ViewService.createNode(View container, EObject eObject, String type, PreferencesHint preferencesHint) 
				//   - generated ViewFactory.decorateView() for parent element
				if (!FlowchartEditPart.MODEL_ID
						.equals(FlowchartVisualIDRegistry
								.getModelID(containerView))) {
					return null; // foreign diagram
				}
				switch (visualID) {
				case SubflowEditPart.VISUAL_ID:
				case ActionEditPart.VISUAL_ID:
				case DecisionEditPart.VISUAL_ID:
					if (domainElement == null
							|| visualID != FlowchartVisualIDRegistry
									.getNodeVisualID(containerView,
											domainElement)) {
						return null; // visual id in semantic hint should match visual id for domain element
					}
					break;
				case SubflowNameEditPart.VISUAL_ID:
					if (SubflowEditPart.VISUAL_ID != FlowchartVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case ActionNameEditPart.VISUAL_ID:
					if (ActionEditPart.VISUAL_ID != FlowchartVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case DecisionNameEditPart.VISUAL_ID:
					if (DecisionEditPart.VISUAL_ID != FlowchartVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case TransitionNameEditPart.VISUAL_ID:
					if (TransitionEditPart.VISUAL_ID != FlowchartVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				default:
					return null;
				}
			}
		}
		return getNodeViewClass(containerView, visualID);
	}

	/**
	 * @generated
	 */
	protected Class getNodeViewClass(View containerView, int visualID) {
		if (containerView == null
				|| !FlowchartVisualIDRegistry.canCreateNode(containerView,
						visualID)) {
			return null;
		}
		switch (visualID) {
		case SubflowEditPart.VISUAL_ID:
			return SubflowViewFactory.class;
		case SubflowNameEditPart.VISUAL_ID:
			return SubflowNameViewFactory.class;
		case ActionEditPart.VISUAL_ID:
			return ActionViewFactory.class;
		case ActionNameEditPart.VISUAL_ID:
			return ActionNameViewFactory.class;
		case DecisionEditPart.VISUAL_ID:
			return DecisionViewFactory.class;
		case DecisionNameEditPart.VISUAL_ID:
			return DecisionNameViewFactory.class;
		case TransitionNameEditPart.VISUAL_ID:
			return TransitionNameViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Class getEdgeViewClass(IAdaptable semanticAdapter,
			View containerView, String semanticHint) {
		IElementType elementType = getSemanticElementType(semanticAdapter);
		if (!FlowchartElementTypes.isKnownElementType(elementType)
				|| (!(elementType instanceof IHintedType))) {
			return null; // foreign element type
		}
		String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
		if (elementTypeHint == null) {
			return null; // our hint is visual id and must be specified
		}
		if (semanticHint != null && !semanticHint.equals(elementTypeHint)) {
			return null; // if semantic hint is specified it should be the same as in element type
		}
		int visualID = FlowchartVisualIDRegistry.getVisualID(elementTypeHint);
		EObject domainElement = getSemanticElement(semanticAdapter);
		if (domainElement != null
				&& visualID != FlowchartVisualIDRegistry
						.getLinkWithClassVisualID(domainElement)) {
			return null; // visual id for link EClass should match visual id from element type
		}
		return getEdgeViewClass(visualID);
	}

	/**
	 * @generated
	 */
	protected Class getEdgeViewClass(int visualID) {
		switch (visualID) {
		case TransitionEditPart.VISUAL_ID:
			return TransitionViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	private IElementType getSemanticElementType(IAdaptable semanticAdapter) {
		if (semanticAdapter == null) {
			return null;
		}
		return (IElementType) semanticAdapter.getAdapter(IElementType.class);
	}
}
