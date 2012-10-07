/*
 * 
 */
package friends.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;

import friends.FriendsPackage;
import friends.diagram.edit.parts.PersonEditPart;
import friends.diagram.edit.parts.PersonEnemyOfEditPart;
import friends.diagram.edit.parts.PersonFriendOfEditPart;
import friends.diagram.edit.parts.WorldEditPart;
import friends.diagram.part.FriendsDiagramEditorPlugin;

/**
 * @generated
 */
public class FriendsElementTypes {

	/**
	 * @generated
	 */
	private FriendsElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map<IElementType, ENamedElement> elements;

	/**
	 * @generated
	 */
	private static ImageRegistry imageRegistry;

	/**
	 * @generated
	 */
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType World_1000 = getElementType("org.eclipse.epsilon.eugenia.examples.friends.diagram.World_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Person_2001 = getElementType("org.eclipse.epsilon.eugenia.examples.friends.diagram.Person_2001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType PersonFriendOf_4001 = getElementType("org.eclipse.epsilon.eugenia.examples.friends.diagram.PersonFriendOf_4001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType PersonEnemyOf_4002 = getElementType("org.eclipse.epsilon.eugenia.examples.friends.diagram.PersonEnemyOf_4002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static ImageRegistry getImageRegistry() {
		if (imageRegistry == null) {
			imageRegistry = new ImageRegistry();
		}
		return imageRegistry;
	}

	/**
	 * @generated
	 */
	private static String getImageRegistryKey(ENamedElement element) {
		return element.getName();
	}

	/**
	 * @generated
	 */
	private static ImageDescriptor getProvidedImageDescriptor(
			ENamedElement element) {
		if (element instanceof EStructuralFeature) {
			EStructuralFeature feature = ((EStructuralFeature) element);
			EClass eContainingClass = feature.getEContainingClass();
			EClassifier eType = feature.getEType();
			if (eContainingClass != null && !eContainingClass.isAbstract()) {
				element = eContainingClass;
			} else if (eType instanceof EClass
					&& !((EClass) eType).isAbstract()) {
				element = eType;
			}
		}
		if (element instanceof EClass) {
			EClass eClass = (EClass) element;
			if (!eClass.isAbstract()) {
				return FriendsDiagramEditorPlugin.getInstance()
						.getItemImageDescriptor(
								eClass.getEPackage().getEFactoryInstance()
										.create(eClass));
			}
		}
		// TODO : support structural features
		return null;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		String key = getImageRegistryKey(element);
		ImageDescriptor imageDescriptor = getImageRegistry().getDescriptor(key);
		if (imageDescriptor == null) {
			imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
		}
		return imageDescriptor;
	}

	/**
	 * @generated
	 */
	public static Image getImage(ENamedElement element) {
		String key = getImageRegistryKey(element);
		Image image = getImageRegistry().get(key);
		if (image == null) {
			ImageDescriptor imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
			image = getImageRegistry().get(key);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImageDescriptor(element);
	}

	/**
	 * @generated
	 */
	public static Image getImage(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImage(element);
	}

	/**
	 * Returns 'type' of the ecore object associated with the hint.
	 * 
	 * @generated
	 */
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap<IElementType, ENamedElement>();

			elements.put(World_1000, FriendsPackage.eINSTANCE.getWorld());

			elements.put(Person_2001, FriendsPackage.eINSTANCE.getPerson());

			elements.put(PersonFriendOf_4001,
					FriendsPackage.eINSTANCE.getPerson_FriendOf());

			elements.put(PersonEnemyOf_4002,
					FriendsPackage.eINSTANCE.getPerson_EnemyOf());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	 * @generated
	 */
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	 * @generated
	 */
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet<IElementType>();
			KNOWN_ELEMENT_TYPES.add(World_1000);
			KNOWN_ELEMENT_TYPES.add(Person_2001);
			KNOWN_ELEMENT_TYPES.add(PersonFriendOf_4001);
			KNOWN_ELEMENT_TYPES.add(PersonEnemyOf_4002);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case WorldEditPart.VISUAL_ID:
			return World_1000;
		case PersonEditPart.VISUAL_ID:
			return Person_2001;
		case PersonFriendOfEditPart.VISUAL_ID:
			return PersonFriendOf_4001;
		case PersonEnemyOfEditPart.VISUAL_ID:
			return PersonEnemyOf_4002;
		}
		return null;
	}

}
