/*
 * 
 */
package friends.diagram.part;

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

import friends.FriendsPackage;
import friends.Person;
import friends.World;
import friends.diagram.edit.parts.PersonEditPart;
import friends.diagram.edit.parts.PersonEnemyOfEditPart;
import friends.diagram.edit.parts.PersonFriendOfEditPart;
import friends.diagram.edit.parts.WorldEditPart;
import friends.diagram.providers.FriendsElementTypes;

/**
 * @generated
 */
public class FriendsDiagramUpdater {

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
	public static List<FriendsNodeDescriptor> getSemanticChildren(View view) {
		switch (FriendsVisualIDRegistry.getVisualID(view)) {
		case WorldEditPart.VISUAL_ID:
			return getWorld_1000SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<FriendsNodeDescriptor> getWorld_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		World modelElement = (World) view.getElement();
		LinkedList<FriendsNodeDescriptor> result = new LinkedList<FriendsNodeDescriptor>();
		for (Iterator<?> it = modelElement.getPeople().iterator(); it.hasNext();) {
			Person childElement = (Person) it.next();
			int visualID = FriendsVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == PersonEditPart.VISUAL_ID) {
				result.add(new FriendsNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<FriendsLinkDescriptor> getContainedLinks(View view) {
		switch (FriendsVisualIDRegistry.getVisualID(view)) {
		case WorldEditPart.VISUAL_ID:
			return getWorld_1000ContainedLinks(view);
		case PersonEditPart.VISUAL_ID:
			return getPerson_2001ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<FriendsLinkDescriptor> getIncomingLinks(View view) {
		switch (FriendsVisualIDRegistry.getVisualID(view)) {
		case PersonEditPart.VISUAL_ID:
			return getPerson_2001IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<FriendsLinkDescriptor> getOutgoingLinks(View view) {
		switch (FriendsVisualIDRegistry.getVisualID(view)) {
		case PersonEditPart.VISUAL_ID:
			return getPerson_2001OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<FriendsLinkDescriptor> getWorld_1000ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<FriendsLinkDescriptor> getPerson_2001ContainedLinks(
			View view) {
		Person modelElement = (Person) view.getElement();
		LinkedList<FriendsLinkDescriptor> result = new LinkedList<FriendsLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Person_FriendOf_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Person_EnemyOf_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<FriendsLinkDescriptor> getPerson_2001IncomingLinks(
			View view) {
		Person modelElement = (Person) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<FriendsLinkDescriptor> result = new LinkedList<FriendsLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Person_FriendOf_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Person_EnemyOf_4002(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<FriendsLinkDescriptor> getPerson_2001OutgoingLinks(
			View view) {
		Person modelElement = (Person) view.getElement();
		LinkedList<FriendsLinkDescriptor> result = new LinkedList<FriendsLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Person_FriendOf_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Person_EnemyOf_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<FriendsLinkDescriptor> getIncomingFeatureModelFacetLinks_Person_FriendOf_4001(
			Person target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<FriendsLinkDescriptor> result = new LinkedList<FriendsLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == FriendsPackage.eINSTANCE
					.getPerson_FriendOf()) {
				result.add(new FriendsLinkDescriptor(setting.getEObject(),
						target, FriendsElementTypes.PersonFriendOf_4001,
						PersonFriendOfEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<FriendsLinkDescriptor> getIncomingFeatureModelFacetLinks_Person_EnemyOf_4002(
			Person target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<FriendsLinkDescriptor> result = new LinkedList<FriendsLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == FriendsPackage.eINSTANCE
					.getPerson_EnemyOf()) {
				result.add(new FriendsLinkDescriptor(setting.getEObject(),
						target, FriendsElementTypes.PersonEnemyOf_4002,
						PersonEnemyOfEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<FriendsLinkDescriptor> getOutgoingFeatureModelFacetLinks_Person_FriendOf_4001(
			Person source) {
		LinkedList<FriendsLinkDescriptor> result = new LinkedList<FriendsLinkDescriptor>();
		for (Iterator<?> destinations = source.getFriendOf().iterator(); destinations
				.hasNext();) {
			Person destination = (Person) destinations.next();
			result.add(new FriendsLinkDescriptor(source, destination,
					FriendsElementTypes.PersonFriendOf_4001,
					PersonFriendOfEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<FriendsLinkDescriptor> getOutgoingFeatureModelFacetLinks_Person_EnemyOf_4002(
			Person source) {
		LinkedList<FriendsLinkDescriptor> result = new LinkedList<FriendsLinkDescriptor>();
		for (Iterator<?> destinations = source.getEnemyOf().iterator(); destinations
				.hasNext();) {
			Person destination = (Person) destinations.next();
			result.add(new FriendsLinkDescriptor(source, destination,
					FriendsElementTypes.PersonEnemyOf_4002,
					PersonEnemyOfEditPart.VISUAL_ID));
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
		public List<FriendsNodeDescriptor> getSemanticChildren(View view) {
			return FriendsDiagramUpdater.getSemanticChildren(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<FriendsLinkDescriptor> getContainedLinks(View view) {
			return FriendsDiagramUpdater.getContainedLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<FriendsLinkDescriptor> getIncomingLinks(View view) {
			return FriendsDiagramUpdater.getIncomingLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<FriendsLinkDescriptor> getOutgoingLinks(View view) {
			return FriendsDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
