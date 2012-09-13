/*
 * 
 */
package org.eclipse.epsilon.eugenia.examples.fed.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.epsilon.eugenia.examples.fed.Configuration;
import org.eclipse.epsilon.eugenia.examples.fed.FedPackage;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.edit.parts.ConfigurationEditPart;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.edit.parts.FeatureDependsEditPart;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.edit.parts.FeatureEditPart;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.edit.parts.FeatureFeaturePluginsCompartmentEditPart;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.edit.parts.FeatureIncludesEditPart;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.edit.parts.FeatureNameEditPart;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.edit.parts.Plugin2EditPart;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.edit.parts.PluginEditPart;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.edit.parts.PluginName2EditPart;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.edit.parts.PluginNameEditPart;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.edit.parts.WrappingLabel2EditPart;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.edit.parts.WrappingLabelEditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.structure.DiagramStructure;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class FedVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "org.eclipse.epsilon.eugenia.examples.fed.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (ConfigurationEditPart.MODEL_ID.equals(view.getType())) {
				return ConfigurationEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return org.eclipse.epsilon.eugenia.examples.fed.diagram.part.FedVisualIDRegistry
				.getVisualID(view.getType());
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
				FedDiagramEditorPlugin.getInstance().logError(
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
		return Integer.toString(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (FedPackage.eINSTANCE.getConfiguration().isSuperTypeOf(
				domainElement.eClass())
				&& isDiagram((Configuration) domainElement)) {
			return ConfigurationEditPart.VISUAL_ID;
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
		String containerModelID = org.eclipse.epsilon.eugenia.examples.fed.diagram.part.FedVisualIDRegistry
				.getModelID(containerView);
		if (!ConfigurationEditPart.MODEL_ID.equals(containerModelID)
				&& !"fed".equals(containerModelID)) { //$NON-NLS-1$
			return -1;
		}
		int containerVisualID;
		if (ConfigurationEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.epsilon.eugenia.examples.fed.diagram.part.FedVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = ConfigurationEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case ConfigurationEditPart.VISUAL_ID:
			if (FedPackage.eINSTANCE.getFeature().isSuperTypeOf(
					domainElement.eClass())) {
				return FeatureEditPart.VISUAL_ID;
			}
			if (FedPackage.eINSTANCE.getPlugin().isSuperTypeOf(
					domainElement.eClass())) {
				return PluginEditPart.VISUAL_ID;
			}
			break;
		case FeatureFeaturePluginsCompartmentEditPart.VISUAL_ID:
			if (FedPackage.eINSTANCE.getPlugin().isSuperTypeOf(
					domainElement.eClass())) {
				return Plugin2EditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = org.eclipse.epsilon.eugenia.examples.fed.diagram.part.FedVisualIDRegistry
				.getModelID(containerView);
		if (!ConfigurationEditPart.MODEL_ID.equals(containerModelID)
				&& !"fed".equals(containerModelID)) { //$NON-NLS-1$
			return false;
		}
		int containerVisualID;
		if (ConfigurationEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.epsilon.eugenia.examples.fed.diagram.part.FedVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = ConfigurationEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case ConfigurationEditPart.VISUAL_ID:
			if (FeatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PluginEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FeatureEditPart.VISUAL_ID:
			if (FeatureNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FeatureFeaturePluginsCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PluginEditPart.VISUAL_ID:
			if (PluginNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Plugin2EditPart.VISUAL_ID:
			if (PluginName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FeatureFeaturePluginsCompartmentEditPart.VISUAL_ID:
			if (Plugin2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FeatureDependsEditPart.VISUAL_ID:
			if (WrappingLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FeatureIncludesEditPart.VISUAL_ID:
			if (WrappingLabel2EditPart.VISUAL_ID == nodeVisualID) {
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
	private static boolean isDiagram(Configuration element) {
		return true;
	}

	/**
	 * @generated
	 */
	public static boolean checkNodeVisualID(View containerView,
			EObject domainElement, int candidate) {
		if (candidate == -1) {
			//unrecognized id is always bad
			return false;
		}
		int basic = getNodeVisualID(containerView, domainElement);
		return basic == candidate;
	}

	/**
	 * @generated
	 */
	public static boolean isCompartmentVisualID(int visualID) {
		switch (visualID) {
		case FeatureFeaturePluginsCompartmentEditPart.VISUAL_ID:
			return true;
		default:
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static boolean isSemanticLeafVisualID(int visualID) {
		switch (visualID) {
		case ConfigurationEditPart.VISUAL_ID:
			return false;
		case PluginEditPart.VISUAL_ID:
		case Plugin2EditPart.VISUAL_ID:
			return true;
		default:
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static final DiagramStructure TYPED_INSTANCE = new DiagramStructure() {
		/**
		 * @generated
		 */
		@Override
		public int getVisualID(View view) {
			return org.eclipse.epsilon.eugenia.examples.fed.diagram.part.FedVisualIDRegistry
					.getVisualID(view);
		}

		/**
		 * @generated
		 */
		@Override
		public String getModelID(View view) {
			return org.eclipse.epsilon.eugenia.examples.fed.diagram.part.FedVisualIDRegistry
					.getModelID(view);
		}

		/**
		 * @generated
		 */
		@Override
		public int getNodeVisualID(View containerView, EObject domainElement) {
			return org.eclipse.epsilon.eugenia.examples.fed.diagram.part.FedVisualIDRegistry
					.getNodeVisualID(containerView, domainElement);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean checkNodeVisualID(View containerView,
				EObject domainElement, int candidate) {
			return org.eclipse.epsilon.eugenia.examples.fed.diagram.part.FedVisualIDRegistry
					.checkNodeVisualID(containerView, domainElement, candidate);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean isCompartmentVisualID(int visualID) {
			return org.eclipse.epsilon.eugenia.examples.fed.diagram.part.FedVisualIDRegistry
					.isCompartmentVisualID(visualID);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean isSemanticLeafVisualID(int visualID) {
			return org.eclipse.epsilon.eugenia.examples.fed.diagram.part.FedVisualIDRegistry
					.isSemanticLeafVisualID(visualID);
		}
	};

}
