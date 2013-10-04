/*
 * 
 */
package esm.diagram.providers;

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
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypeImages;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypes;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;

import esm.EsmPackage;
import esm.diagram.edit.parts.EndStateEditPart;
import esm.diagram.edit.parts.MachineEditPart;
import esm.diagram.edit.parts.StateEditPart;
import esm.diagram.edit.parts.TransitionEditPart;
import esm.diagram.part.EsmDiagramEditorPlugin;

/**
 * @generated
 */
public class EsmElementTypes {

	/**
	 * @generated
	 */
	private EsmElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map<IElementType, ENamedElement> elements;

	/**
	 * @generated
	 */
	private static DiagramElementTypeImages elementTypeImages = new DiagramElementTypeImages(
			EsmDiagramEditorPlugin.getInstance()
					.getItemProvidersAdapterFactory());

	/**
	 * @generated
	 */
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType Machine_1000 = getElementType("org.eclipse.epsilon.eugenia.examples.executablestatemachine.graphical.diagram.Machine_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType EndState_2002 = getElementType("org.eclipse.epsilon.eugenia.examples.executablestatemachine.graphical.diagram.EndState_2002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType State_2001 = getElementType("org.eclipse.epsilon.eugenia.examples.executablestatemachine.graphical.diagram.State_2001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Transition_4001 = getElementType("org.eclipse.epsilon.eugenia.examples.executablestatemachine.graphical.diagram.Transition_4001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		return elementTypeImages.getImageDescriptor(element);
	}

	/**
	 * @generated
	 */
	public static Image getImage(ENamedElement element) {
		return elementTypeImages.getImage(element);
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		return getImageDescriptor(getElement(hint));
	}

	/**
	 * @generated
	 */
	public static Image getImage(IAdaptable hint) {
		return getImage(getElement(hint));
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

			elements.put(Machine_1000, EsmPackage.eINSTANCE.getMachine());

			elements.put(EndState_2002, EsmPackage.eINSTANCE.getEndState());

			elements.put(State_2001, EsmPackage.eINSTANCE.getState());

			elements.put(Transition_4001, EsmPackage.eINSTANCE.getTransition());
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
			KNOWN_ELEMENT_TYPES.add(Machine_1000);
			KNOWN_ELEMENT_TYPES.add(EndState_2002);
			KNOWN_ELEMENT_TYPES.add(State_2001);
			KNOWN_ELEMENT_TYPES.add(Transition_4001);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case MachineEditPart.VISUAL_ID:
			return Machine_1000;
		case EndStateEditPart.VISUAL_ID:
			return EndState_2002;
		case StateEditPart.VISUAL_ID:
			return State_2001;
		case TransitionEditPart.VISUAL_ID:
			return Transition_4001;
		}
		return null;
	}

	/**
	 * @generated
	 */
	public static final DiagramElementTypes TYPED_INSTANCE = new DiagramElementTypes(
			elementTypeImages) {

		/**
		 * @generated
		 */
		@Override
		public boolean isKnownElementType(IElementType elementType) {
			return esm.diagram.providers.EsmElementTypes
					.isKnownElementType(elementType);
		}

		/**
		 * @generated
		 */
		@Override
		public IElementType getElementTypeForVisualId(int visualID) {
			return esm.diagram.providers.EsmElementTypes
					.getElementType(visualID);
		}

		/**
		 * @generated
		 */
		@Override
		public ENamedElement getDefiningNamedElement(
				IAdaptable elementTypeAdapter) {
			return esm.diagram.providers.EsmElementTypes
					.getElement(elementTypeAdapter);
		}
	};

}
