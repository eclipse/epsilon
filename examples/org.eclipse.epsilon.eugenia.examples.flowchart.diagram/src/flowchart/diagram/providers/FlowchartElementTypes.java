/*
 * 
 */
package flowchart.diagram.providers;

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

import flowchart.FlowchartPackage;
import flowchart.diagram.edit.parts.ActionEditPart;
import flowchart.diagram.edit.parts.DecisionEditPart;
import flowchart.diagram.edit.parts.FlowchartEditPart;
import flowchart.diagram.edit.parts.SubflowEditPart;
import flowchart.diagram.edit.parts.TransitionEditPart;
import flowchart.diagram.part.FlowchartDiagramEditorPlugin;

/**
 * @generated
 */
public class FlowchartElementTypes {

	/**
	 * @generated
	 */
	private FlowchartElementTypes() {
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
	public static final IElementType Flowchart_1000 = getElementType("org.eclipse.epsilon.eugenia.examples.flowchart.diagram.Flowchart_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Subflow_2001 = getElementType("org.eclipse.epsilon.eugenia.examples.flowchart.diagram.Subflow_2001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Action_2004 = getElementType("org.eclipse.epsilon.eugenia.examples.flowchart.diagram.Action_2004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Decision_2003 = getElementType("org.eclipse.epsilon.eugenia.examples.flowchart.diagram.Decision_2003"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Transition_4001 = getElementType("org.eclipse.epsilon.eugenia.examples.flowchart.diagram.Transition_4001"); //$NON-NLS-1$

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
				return FlowchartDiagramEditorPlugin.getInstance()
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

			elements.put(Flowchart_1000,
					FlowchartPackage.eINSTANCE.getFlowchart());

			elements.put(Subflow_2001, FlowchartPackage.eINSTANCE.getSubflow());

			elements.put(Action_2004, FlowchartPackage.eINSTANCE.getAction());

			elements.put(Decision_2003,
					FlowchartPackage.eINSTANCE.getDecision());

			elements.put(Transition_4001,
					FlowchartPackage.eINSTANCE.getTransition());
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
			KNOWN_ELEMENT_TYPES.add(Flowchart_1000);
			KNOWN_ELEMENT_TYPES.add(Subflow_2001);
			KNOWN_ELEMENT_TYPES.add(Action_2004);
			KNOWN_ELEMENT_TYPES.add(Decision_2003);
			KNOWN_ELEMENT_TYPES.add(Transition_4001);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case FlowchartEditPart.VISUAL_ID:
			return Flowchart_1000;
		case SubflowEditPart.VISUAL_ID:
			return Subflow_2001;
		case ActionEditPart.VISUAL_ID:
			return Action_2004;
		case DecisionEditPart.VISUAL_ID:
			return Decision_2003;
		case TransitionEditPart.VISUAL_ID:
			return Transition_4001;
		}
		return null;
	}

}
