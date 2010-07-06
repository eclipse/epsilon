/*
 * 
 */
package flowchart.diagram.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;

import flowchart.Decision;
import flowchart.Flowchart;
import flowchart.FlowchartPackage;
import flowchart.Node;
import flowchart.Subflow;
import flowchart.Transition;
import flowchart.diagram.edit.parts.DecisionEditPart;
import flowchart.diagram.edit.parts.FlowchartEditPart;
import flowchart.diagram.edit.parts.SubflowEditPart;
import flowchart.diagram.edit.parts.TransitionEditPart;
import flowchart.diagram.providers.FlowchartElementTypes;

/**
 * @generated
 */
public class FlowchartDiagramUpdater {

	/**
	 * @generated
	 */
	public static boolean isShortcutOrphaned(View view) {
		return !view.isSetElement() || view.getElement() == null
				|| view.getElement().eIsProxy();
	}

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch (FlowchartVisualIDRegistry.getVisualID(view)) {
		case FlowchartEditPart.VISUAL_ID:
			return getFlowchart_1000SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFlowchart_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Flowchart modelElement = (Flowchart) view.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getNodes().iterator(); it.hasNext();) {
			Node childElement = (Node) it.next();
			int visualID = FlowchartVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == SubflowEditPart.VISUAL_ID) {
				result.add(new FlowchartNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DecisionEditPart.VISUAL_ID) {
				result.add(new FlowchartNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getContainedLinks(View view) {
		switch (FlowchartVisualIDRegistry.getVisualID(view)) {
		case FlowchartEditPart.VISUAL_ID:
			return getFlowchart_1000ContainedLinks(view);
		case SubflowEditPart.VISUAL_ID:
			return getSubflow_2001ContainedLinks(view);
		case DecisionEditPart.VISUAL_ID:
			return getDecision_2003ContainedLinks(view);
		case TransitionEditPart.VISUAL_ID:
			return getTransition_4001ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (FlowchartVisualIDRegistry.getVisualID(view)) {
		case SubflowEditPart.VISUAL_ID:
			return getSubflow_2001IncomingLinks(view);
		case DecisionEditPart.VISUAL_ID:
			return getDecision_2003IncomingLinks(view);
		case TransitionEditPart.VISUAL_ID:
			return getTransition_4001IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (FlowchartVisualIDRegistry.getVisualID(view)) {
		case SubflowEditPart.VISUAL_ID:
			return getSubflow_2001OutgoingLinks(view);
		case DecisionEditPart.VISUAL_ID:
			return getDecision_2003OutgoingLinks(view);
		case TransitionEditPart.VISUAL_ID:
			return getTransition_4001OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFlowchart_1000ContainedLinks(View view) {
		Flowchart modelElement = (Flowchart) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getSubflow_2001ContainedLinks(View view) {
		Subflow modelElement = (Subflow) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDecision_2003ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getTransition_4001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getSubflow_2001IncomingLinks(View view) {
		Subflow modelElement = (Subflow) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDecision_2003IncomingLinks(View view) {
		Decision modelElement = (Decision) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getTransition_4001IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getSubflow_2001OutgoingLinks(View view) {
		Subflow modelElement = (Subflow) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDecision_2003OutgoingLinks(View view) {
		Decision modelElement = (Decision) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getTransition_4001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Transition_4001(
			Flowchart container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getTransitions().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Transition) {
				continue;
			}
			Transition link = (Transition) linkObject;
			if (TransitionEditPart.VISUAL_ID != FlowchartVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Node dst = link.getTarget();
			Node src = link.getSource();
			result.add(new FlowchartLinkDescriptor(src, dst, link,
					FlowchartElementTypes.Transition_4001,
					TransitionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Transition_4001(
			Node target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != FlowchartPackage.eINSTANCE
					.getTransition_Target()
					|| false == setting.getEObject() instanceof Transition) {
				continue;
			}
			Transition link = (Transition) setting.getEObject();
			if (TransitionEditPart.VISUAL_ID != FlowchartVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Node src = link.getSource();
			result.add(new FlowchartLinkDescriptor(src, target, link,
					FlowchartElementTypes.Transition_4001,
					TransitionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Transition_4001(
			Node source) {
		Flowchart container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof Flowchart) {
				container = (Flowchart) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getTransitions().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Transition) {
				continue;
			}
			Transition link = (Transition) linkObject;
			if (TransitionEditPart.VISUAL_ID != FlowchartVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Node dst = link.getTarget();
			Node src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new FlowchartLinkDescriptor(src, dst, link,
					FlowchartElementTypes.Transition_4001,
					TransitionEditPart.VISUAL_ID));
		}
		return result;
	}

}
