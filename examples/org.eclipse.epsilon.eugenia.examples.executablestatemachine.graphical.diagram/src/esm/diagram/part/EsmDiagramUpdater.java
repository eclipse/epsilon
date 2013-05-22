/*
 * 
 */
package esm.diagram.part;

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
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;

import esm.EsmPackage;
import esm.Machine;
import esm.State;
import esm.Transition;
import esm.diagram.edit.parts.MachineEditPart;
import esm.diagram.edit.parts.StateEditPart;
import esm.diagram.edit.parts.TransitionEditPart;
import esm.diagram.providers.EsmElementTypes;

/**
 * @generated
 */
public class EsmDiagramUpdater {

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
	public static List<EsmNodeDescriptor> getSemanticChildren(View view) {
		switch (EsmVisualIDRegistry.getVisualID(view)) {
		case MachineEditPart.VISUAL_ID:
			return getMachine_1000SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsmNodeDescriptor> getMachine_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Machine modelElement = (Machine) view.getElement();
		LinkedList<EsmNodeDescriptor> result = new LinkedList<EsmNodeDescriptor>();
		for (Iterator<?> it = modelElement.getStates().iterator(); it.hasNext();) {
			State childElement = (State) it.next();
			int visualID = EsmVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == StateEditPart.VISUAL_ID) {
				result.add(new EsmNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsmLinkDescriptor> getContainedLinks(View view) {
		switch (EsmVisualIDRegistry.getVisualID(view)) {
		case MachineEditPart.VISUAL_ID:
			return getMachine_1000ContainedLinks(view);
		case StateEditPart.VISUAL_ID:
			return getState_2001ContainedLinks(view);
		case TransitionEditPart.VISUAL_ID:
			return getTransition_4001ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsmLinkDescriptor> getIncomingLinks(View view) {
		switch (EsmVisualIDRegistry.getVisualID(view)) {
		case StateEditPart.VISUAL_ID:
			return getState_2001IncomingLinks(view);
		case TransitionEditPart.VISUAL_ID:
			return getTransition_4001IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsmLinkDescriptor> getOutgoingLinks(View view) {
		switch (EsmVisualIDRegistry.getVisualID(view)) {
		case StateEditPart.VISUAL_ID:
			return getState_2001OutgoingLinks(view);
		case TransitionEditPart.VISUAL_ID:
			return getTransition_4001OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsmLinkDescriptor> getMachine_1000ContainedLinks(
			View view) {
		Machine modelElement = (Machine) view.getElement();
		LinkedList<EsmLinkDescriptor> result = new LinkedList<EsmLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsmLinkDescriptor> getState_2001ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsmLinkDescriptor> getTransition_4001ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsmLinkDescriptor> getState_2001IncomingLinks(View view) {
		State modelElement = (State) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<EsmLinkDescriptor> result = new LinkedList<EsmLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsmLinkDescriptor> getTransition_4001IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsmLinkDescriptor> getState_2001OutgoingLinks(View view) {
		State modelElement = (State) view.getElement();
		LinkedList<EsmLinkDescriptor> result = new LinkedList<EsmLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsmLinkDescriptor> getTransition_4001OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	private static Collection<EsmLinkDescriptor> getContainedTypeModelFacetLinks_Transition_4001(
			Machine container) {
		LinkedList<EsmLinkDescriptor> result = new LinkedList<EsmLinkDescriptor>();
		for (Iterator<?> links = container.getTransitions().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Transition) {
				continue;
			}
			Transition link = (Transition) linkObject;
			if (TransitionEditPart.VISUAL_ID != EsmVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			State dst = link.getTarget();
			State src = link.getSource();
			result.add(new EsmLinkDescriptor(src, dst, link,
					EsmElementTypes.Transition_4001,
					TransitionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<EsmLinkDescriptor> getIncomingTypeModelFacetLinks_Transition_4001(
			State target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<EsmLinkDescriptor> result = new LinkedList<EsmLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != EsmPackage.eINSTANCE
					.getTransition_Target()
					|| false == setting.getEObject() instanceof Transition) {
				continue;
			}
			Transition link = (Transition) setting.getEObject();
			if (TransitionEditPart.VISUAL_ID != EsmVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			State src = link.getSource();
			result.add(new EsmLinkDescriptor(src, target, link,
					EsmElementTypes.Transition_4001,
					TransitionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<EsmLinkDescriptor> getOutgoingTypeModelFacetLinks_Transition_4001(
			State source) {
		Machine container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof Machine) {
				container = (Machine) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<EsmLinkDescriptor> result = new LinkedList<EsmLinkDescriptor>();
		for (Iterator<?> links = container.getTransitions().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Transition) {
				continue;
			}
			Transition link = (Transition) linkObject;
			if (TransitionEditPart.VISUAL_ID != EsmVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			State dst = link.getTarget();
			State src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new EsmLinkDescriptor(src, dst, link,
					EsmElementTypes.Transition_4001,
					TransitionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static final DiagramUpdater TYPED_INSTANCE = new DiagramUpdater() {
		/**
		 * @generated
		 */
		@Override
		public List<EsmNodeDescriptor> getSemanticChildren(View view) {
			return EsmDiagramUpdater.getSemanticChildren(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<EsmLinkDescriptor> getContainedLinks(View view) {
			return EsmDiagramUpdater.getContainedLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<EsmLinkDescriptor> getIncomingLinks(View view) {
			return EsmDiagramUpdater.getIncomingLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<EsmLinkDescriptor> getOutgoingLinks(View view) {
			return EsmDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
