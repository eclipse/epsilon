/*
 * 
 */
package org.eclipse.epsilon.eugenia.examples.fed.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.epsilon.eugenia.examples.fed.FedPackage;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.edit.parts.ConfigurationEditPart;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.edit.parts.FeatureDependsEditPart;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.edit.parts.FeatureEditPart;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.edit.parts.FeatureIncludesEditPart;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.edit.parts.Plugin2EditPart;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.edit.parts.PluginEditPart;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.part.FedDiagramEditorPlugin;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;

/**
 * @generated
 */
public class FedElementTypes {

	/**
	 * @generated
	 */
	private FedElementTypes() {
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
	public static final IElementType Configuration_1000 = getElementType("org.eclipse.epsilon.eugenia.examples.fed.diagram.Configuration_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Feature_2001 = getElementType("org.eclipse.epsilon.eugenia.examples.fed.diagram.Feature_2001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Plugin_2002 = getElementType("org.eclipse.epsilon.eugenia.examples.fed.diagram.Plugin_2002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Plugin_3001 = getElementType("org.eclipse.epsilon.eugenia.examples.fed.diagram.Plugin_3001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType FeatureDepends_4001 = getElementType("org.eclipse.epsilon.eugenia.examples.fed.diagram.FeatureDepends_4001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType FeatureIncludes_4002 = getElementType("org.eclipse.epsilon.eugenia.examples.fed.diagram.FeatureIncludes_4002"); //$NON-NLS-1$

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
				return FedDiagramEditorPlugin.getInstance()
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

			elements.put(Configuration_1000,
					FedPackage.eINSTANCE.getConfiguration());

			elements.put(Feature_2001, FedPackage.eINSTANCE.getFeature());

			elements.put(Plugin_2002, FedPackage.eINSTANCE.getPlugin());

			elements.put(Plugin_3001, FedPackage.eINSTANCE.getPlugin());

			elements.put(FeatureDepends_4001,
					FedPackage.eINSTANCE.getFeature_Depends());

			elements.put(FeatureIncludes_4002,
					FedPackage.eINSTANCE.getFeature_Includes());
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
			KNOWN_ELEMENT_TYPES.add(Configuration_1000);
			KNOWN_ELEMENT_TYPES.add(Feature_2001);
			KNOWN_ELEMENT_TYPES.add(Plugin_2002);
			KNOWN_ELEMENT_TYPES.add(Plugin_3001);
			KNOWN_ELEMENT_TYPES.add(FeatureDepends_4001);
			KNOWN_ELEMENT_TYPES.add(FeatureIncludes_4002);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case ConfigurationEditPart.VISUAL_ID:
			return Configuration_1000;
		case FeatureEditPart.VISUAL_ID:
			return Feature_2001;
		case PluginEditPart.VISUAL_ID:
			return Plugin_2002;
		case Plugin2EditPart.VISUAL_ID:
			return Plugin_3001;
		case FeatureDependsEditPart.VISUAL_ID:
			return FeatureDepends_4001;
		case FeatureIncludesEditPart.VISUAL_ID:
			return FeatureIncludes_4002;
		}
		return null;
	}

}
