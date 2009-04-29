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

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

import friends.FriendsPackage;
import friends.World;
import friends.diagram.edit.parts.PersonEditPart;
import friends.diagram.edit.parts.PersonEnemyOfEditPart;
import friends.diagram.edit.parts.PersonEnemyOfExternalLabelEditPart;
import friends.diagram.edit.parts.PersonFriendOfEditPart;
import friends.diagram.edit.parts.PersonFriendOfExternalLabelEditPart;
import friends.diagram.edit.parts.PersonNameEditPart;
import friends.diagram.edit.parts.WorldEditPart;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class FriendsVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "org.eclipse.epsilon.eugenia.examples.friends.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (WorldEditPart.MODEL_ID.equals(view.getType())) {
				return WorldEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return friends.diagram.part.FriendsVisualIDRegistry.getVisualID(view
				.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(
					Platform.getDebugOption(DEBUG_KEY))) {
				FriendsDiagramEditorPlugin.getInstance().logError(
						"Unable to parse view type as a visualID number: "
								+ type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return String.valueOf(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (FriendsPackage.eINSTANCE.getWorld().isSuperTypeOf(
				domainElement.eClass())
				&& isDiagram((World) domainElement)) {
			return WorldEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = friends.diagram.part.FriendsVisualIDRegistry
				.getModelID(containerView);
		if (!WorldEditPart.MODEL_ID.equals(containerModelID)
				&& !"friends".equals(containerModelID)) { //$NON-NLS-1$
			return -1;
		}
		int containerVisualID;
		if (WorldEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = friends.diagram.part.FriendsVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = WorldEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case WorldEditPart.VISUAL_ID:
			if (FriendsPackage.eINSTANCE.getPerson().isSuperTypeOf(
					domainElement.eClass())) {
				return PersonEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = friends.diagram.part.FriendsVisualIDRegistry
				.getModelID(containerView);
		if (!WorldEditPart.MODEL_ID.equals(containerModelID)
				&& !"friends".equals(containerModelID)) { //$NON-NLS-1$
			return false;
		}
		int containerVisualID;
		if (WorldEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = friends.diagram.part.FriendsVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = WorldEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case PersonEditPart.VISUAL_ID:
			if (PersonNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case WorldEditPart.VISUAL_ID:
			if (PersonEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PersonFriendOfEditPart.VISUAL_ID:
			if (PersonFriendOfExternalLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PersonEnemyOfEditPart.VISUAL_ID:
			if (PersonEnemyOfExternalLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(World element) {
		return true;
	}

}
