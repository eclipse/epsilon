/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package friends.diagram.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import java.util.Map;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;

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
	public static List getSemanticChildren(View view) {
		switch (FriendsVisualIDRegistry.getVisualID(view)) {
		case WorldEditPart.VISUAL_ID:
			return getWorld_79SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getWorld_79SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		World modelElement = (World) view.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getPeople().iterator(); it.hasNext();) {
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
	public static List getContainedLinks(View view) {
		switch (FriendsVisualIDRegistry.getVisualID(view)) {
		case WorldEditPart.VISUAL_ID:
			return getWorld_79ContainedLinks(view);
		case PersonEditPart.VISUAL_ID:
			return getPerson_1001ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (FriendsVisualIDRegistry.getVisualID(view)) {
		case PersonEditPart.VISUAL_ID:
			return getPerson_1001IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (FriendsVisualIDRegistry.getVisualID(view)) {
		case PersonEditPart.VISUAL_ID:
			return getPerson_1001OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getWorld_79ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPerson_1001ContainedLinks(View view) {
		Person modelElement = (Person) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Person_FriendOf_3001(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Person_EnemyOf_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPerson_1001IncomingLinks(View view) {
		Person modelElement = (Person) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Person_FriendOf_3001(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Person_EnemyOf_3002(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPerson_1001OutgoingLinks(View view) {
		Person modelElement = (Person) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Person_FriendOf_3001(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Person_EnemyOf_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Person_FriendOf_3001(
			Person target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() == FriendsPackage.eINSTANCE
					.getPerson_FriendOf()) {
				result.add(new FriendsLinkDescriptor(setting.getEObject(),
						target, FriendsElementTypes.PersonFriendOf_3001,
						PersonFriendOfEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Person_EnemyOf_3002(
			Person target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() == FriendsPackage.eINSTANCE
					.getPerson_EnemyOf()) {
				result.add(new FriendsLinkDescriptor(setting.getEObject(),
						target, FriendsElementTypes.PersonEnemyOf_3002,
						PersonEnemyOfEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Person_FriendOf_3001(
			Person source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getFriendOf().iterator(); destinations
				.hasNext();) {
			Person destination = (Person) destinations.next();
			result.add(new FriendsLinkDescriptor(source, destination,
					FriendsElementTypes.PersonFriendOf_3001,
					PersonFriendOfEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Person_EnemyOf_3002(
			Person source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getEnemyOf().iterator(); destinations
				.hasNext();) {
			Person destination = (Person) destinations.next();
			result.add(new FriendsLinkDescriptor(source, destination,
					FriendsElementTypes.PersonEnemyOf_3002,
					PersonEnemyOfEditPart.VISUAL_ID));
		}
		return result;
	}

}
