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
package friends.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.View;

import friends.diagram.edit.parts.PersonEditPart;
import friends.diagram.edit.parts.PersonEnemyOfEditPart;
import friends.diagram.edit.parts.PersonEnemyOfExternalLabelEditPart;
import friends.diagram.edit.parts.PersonFriendOfEditPart;
import friends.diagram.edit.parts.PersonFriendOfExternalLabelEditPart;
import friends.diagram.edit.parts.PersonNameEditPart;
import friends.diagram.edit.parts.WorldEditPart;
import friends.diagram.part.FriendsVisualIDRegistry;
import friends.diagram.view.factories.PersonEnemyOfExternalLabelViewFactory;
import friends.diagram.view.factories.PersonEnemyOfViewFactory;
import friends.diagram.view.factories.PersonFriendOfExternalLabelViewFactory;
import friends.diagram.view.factories.PersonFriendOfViewFactory;
import friends.diagram.view.factories.PersonNameViewFactory;
import friends.diagram.view.factories.PersonViewFactory;
import friends.diagram.view.factories.WorldViewFactory;

/**
 * @generated
 */
public class FriendsViewProvider extends AbstractViewProvider {

	/**
	 * @generated
	 */
	protected Class getDiagramViewClass(IAdaptable semanticAdapter,
			String diagramKind) {
		EObject semanticElement = getSemanticElement(semanticAdapter);
		if (WorldEditPart.MODEL_ID.equals(diagramKind)
				&& FriendsVisualIDRegistry.getDiagramVisualID(semanticElement) != -1) {
			return WorldViewFactory.class;
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
			visualID = FriendsVisualIDRegistry.getNodeVisualID(containerView,
					domainElement);
		} else {
			visualID = FriendsVisualIDRegistry.getVisualID(semanticHint);
			if (elementType != null) {
				// Semantic hint is specified together with element type.
				// Both parameters should describe exactly the same diagram element.
				// In addition we check that visualID returned by VisualIDRegistry.getNodeVisualID() for
				// domainElement (if specified) is the same as in element type.
				if (!FriendsElementTypes.isKnownElementType(elementType)
						|| (!(elementType instanceof IHintedType))) {
					return null; // foreign element type
				}
				String elementTypeHint = ((IHintedType) elementType)
						.getSemanticHint();
				if (!semanticHint.equals(elementTypeHint)) {
					return null; // if semantic hint is specified it should be the same as in element type
				}
				if (domainElement != null
						&& visualID != FriendsVisualIDRegistry.getNodeVisualID(
								containerView, domainElement)) {
					return null; // visual id for node EClass should match visual id from element type
				}
			} else {
				// Element type is not specified. Domain element should be present (except pure design elements).
				// This method is called with EObjectAdapter as parameter from:
				//   - ViewService.createNode(View container, EObject eObject, String type, PreferencesHint preferencesHint) 
				//   - generated ViewFactory.decorateView() for parent element
				if (!WorldEditPart.MODEL_ID.equals(FriendsVisualIDRegistry
						.getModelID(containerView))) {
					return null; // foreign diagram
				}
				switch (visualID) {
				case PersonEditPart.VISUAL_ID:
					if (domainElement == null
							|| visualID != FriendsVisualIDRegistry
									.getNodeVisualID(containerView,
											domainElement)) {
						return null; // visual id in semantic hint should match visual id for domain element
					}
					break;
				case PersonNameEditPart.VISUAL_ID:
					if (PersonEditPart.VISUAL_ID != FriendsVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case PersonFriendOfExternalLabelEditPart.VISUAL_ID:
					if (PersonFriendOfEditPart.VISUAL_ID != FriendsVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case PersonEnemyOfExternalLabelEditPart.VISUAL_ID:
					if (PersonEnemyOfEditPart.VISUAL_ID != FriendsVisualIDRegistry
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
				|| !FriendsVisualIDRegistry.canCreateNode(containerView,
						visualID)) {
			return null;
		}
		switch (visualID) {
		case PersonEditPart.VISUAL_ID:
			return PersonViewFactory.class;
		case PersonNameEditPart.VISUAL_ID:
			return PersonNameViewFactory.class;
		case PersonFriendOfExternalLabelEditPart.VISUAL_ID:
			return PersonFriendOfExternalLabelViewFactory.class;
		case PersonEnemyOfExternalLabelEditPart.VISUAL_ID:
			return PersonEnemyOfExternalLabelViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Class getEdgeViewClass(IAdaptable semanticAdapter,
			View containerView, String semanticHint) {
		IElementType elementType = getSemanticElementType(semanticAdapter);
		if (!FriendsElementTypes.isKnownElementType(elementType)
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
		int visualID = FriendsVisualIDRegistry.getVisualID(elementTypeHint);
		EObject domainElement = getSemanticElement(semanticAdapter);
		if (domainElement != null
				&& visualID != FriendsVisualIDRegistry
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
		case PersonFriendOfEditPart.VISUAL_ID:
			return PersonFriendOfViewFactory.class;
		case PersonEnemyOfEditPart.VISUAL_ID:
			return PersonEnemyOfViewFactory.class;
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
