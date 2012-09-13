/*
 * 
 */
package org.eclipse.epsilon.eugenia.examples.fed.diagram.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eugenia.examples.fed.Configuration;
import org.eclipse.epsilon.eugenia.examples.fed.Feature;
import org.eclipse.epsilon.eugenia.examples.fed.FedPackage;
import org.eclipse.epsilon.eugenia.examples.fed.Plugin;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.edit.parts.ConfigurationEditPart;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.edit.parts.FeatureDependsEditPart;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.edit.parts.FeatureEditPart;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.edit.parts.FeatureFeaturePluginsCompartmentEditPart;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.edit.parts.FeatureIncludesEditPart;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.edit.parts.Plugin2EditPart;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.edit.parts.PluginEditPart;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.providers.FedElementTypes;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;

/**
 * @generated
 */
public class FedDiagramUpdater {

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
	public static List<FedNodeDescriptor> getSemanticChildren(View view) {
		switch (FedVisualIDRegistry.getVisualID(view)) {
		case ConfigurationEditPart.VISUAL_ID:
			return getConfiguration_1000SemanticChildren(view);
		case FeatureFeaturePluginsCompartmentEditPart.VISUAL_ID:
			return getFeatureFeaturePluginsCompartment_7001SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<FedNodeDescriptor> getConfiguration_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Configuration modelElement = (Configuration) view.getElement();
		LinkedList<FedNodeDescriptor> result = new LinkedList<FedNodeDescriptor>();
		for (Iterator<?> it = modelElement.getFeatures().iterator(); it
				.hasNext();) {
			Feature childElement = (Feature) it.next();
			int visualID = FedVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == FeatureEditPart.VISUAL_ID) {
				result.add(new FedNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getPlugins().iterator(); it
				.hasNext();) {
			Plugin childElement = (Plugin) it.next();
			int visualID = FedVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == PluginEditPart.VISUAL_ID) {
				result.add(new FedNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<FedNodeDescriptor> getFeatureFeaturePluginsCompartment_7001SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Feature modelElement = (Feature) containerView.getElement();
		LinkedList<FedNodeDescriptor> result = new LinkedList<FedNodeDescriptor>();
		for (Iterator<?> it = modelElement.getPlugins().iterator(); it
				.hasNext();) {
			Plugin childElement = (Plugin) it.next();
			int visualID = FedVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == Plugin2EditPart.VISUAL_ID) {
				result.add(new FedNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<FedLinkDescriptor> getContainedLinks(View view) {
		switch (FedVisualIDRegistry.getVisualID(view)) {
		case ConfigurationEditPart.VISUAL_ID:
			return getConfiguration_1000ContainedLinks(view);
		case FeatureEditPart.VISUAL_ID:
			return getFeature_2001ContainedLinks(view);
		case PluginEditPart.VISUAL_ID:
			return getPlugin_2002ContainedLinks(view);
		case Plugin2EditPart.VISUAL_ID:
			return getPlugin_3001ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<FedLinkDescriptor> getIncomingLinks(View view) {
		switch (FedVisualIDRegistry.getVisualID(view)) {
		case FeatureEditPart.VISUAL_ID:
			return getFeature_2001IncomingLinks(view);
		case PluginEditPart.VISUAL_ID:
			return getPlugin_2002IncomingLinks(view);
		case Plugin2EditPart.VISUAL_ID:
			return getPlugin_3001IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<FedLinkDescriptor> getOutgoingLinks(View view) {
		switch (FedVisualIDRegistry.getVisualID(view)) {
		case FeatureEditPart.VISUAL_ID:
			return getFeature_2001OutgoingLinks(view);
		case PluginEditPart.VISUAL_ID:
			return getPlugin_2002OutgoingLinks(view);
		case Plugin2EditPart.VISUAL_ID:
			return getPlugin_3001OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<FedLinkDescriptor> getConfiguration_1000ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<FedLinkDescriptor> getFeature_2001ContainedLinks(
			View view) {
		Feature modelElement = (Feature) view.getElement();
		LinkedList<FedLinkDescriptor> result = new LinkedList<FedLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_Depends_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_Includes_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<FedLinkDescriptor> getPlugin_2002ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<FedLinkDescriptor> getPlugin_3001ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<FedLinkDescriptor> getFeature_2001IncomingLinks(View view) {
		Feature modelElement = (Feature) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<FedLinkDescriptor> result = new LinkedList<FedLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Feature_Depends_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Feature_Includes_4002(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<FedLinkDescriptor> getPlugin_2002IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<FedLinkDescriptor> getPlugin_3001IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<FedLinkDescriptor> getFeature_2001OutgoingLinks(View view) {
		Feature modelElement = (Feature) view.getElement();
		LinkedList<FedLinkDescriptor> result = new LinkedList<FedLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_Depends_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Feature_Includes_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<FedLinkDescriptor> getPlugin_2002OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<FedLinkDescriptor> getPlugin_3001OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	private static Collection<FedLinkDescriptor> getIncomingFeatureModelFacetLinks_Feature_Depends_4001(
			Feature target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<FedLinkDescriptor> result = new LinkedList<FedLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == FedPackage.eINSTANCE
					.getFeature_Depends()) {
				result.add(new FedLinkDescriptor(setting.getEObject(), target,
						FedElementTypes.FeatureDepends_4001,
						FeatureDependsEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<FedLinkDescriptor> getIncomingFeatureModelFacetLinks_Feature_Includes_4002(
			Feature target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<FedLinkDescriptor> result = new LinkedList<FedLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == FedPackage.eINSTANCE
					.getFeature_Includes()) {
				result.add(new FedLinkDescriptor(setting.getEObject(), target,
						FedElementTypes.FeatureIncludes_4002,
						FeatureIncludesEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<FedLinkDescriptor> getOutgoingFeatureModelFacetLinks_Feature_Depends_4001(
			Feature source) {
		LinkedList<FedLinkDescriptor> result = new LinkedList<FedLinkDescriptor>();
		for (Iterator<?> destinations = source.getDepends().iterator(); destinations
				.hasNext();) {
			Feature destination = (Feature) destinations.next();
			result.add(new FedLinkDescriptor(source, destination,
					FedElementTypes.FeatureDepends_4001,
					FeatureDependsEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<FedLinkDescriptor> getOutgoingFeatureModelFacetLinks_Feature_Includes_4002(
			Feature source) {
		LinkedList<FedLinkDescriptor> result = new LinkedList<FedLinkDescriptor>();
		for (Iterator<?> destinations = source.getIncludes().iterator(); destinations
				.hasNext();) {
			Feature destination = (Feature) destinations.next();
			result.add(new FedLinkDescriptor(source, destination,
					FedElementTypes.FeatureIncludes_4002,
					FeatureIncludesEditPart.VISUAL_ID));
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
		public List<FedNodeDescriptor> getSemanticChildren(View view) {
			return FedDiagramUpdater.getSemanticChildren(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<FedLinkDescriptor> getContainedLinks(View view) {
			return FedDiagramUpdater.getContainedLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<FedLinkDescriptor> getIncomingLinks(View view) {
			return FedDiagramUpdater.getIncomingLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<FedLinkDescriptor> getOutgoingLinks(View view) {
			return FedDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
