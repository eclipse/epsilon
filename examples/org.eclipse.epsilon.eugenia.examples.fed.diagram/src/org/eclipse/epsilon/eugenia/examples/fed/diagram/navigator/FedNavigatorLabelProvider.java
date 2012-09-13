/*
 * 
 */
package org.eclipse.epsilon.eugenia.examples.fed.diagram.navigator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.edit.parts.ConfigurationEditPart;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.edit.parts.FeatureDependsEditPart;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.edit.parts.FeatureEditPart;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.edit.parts.FeatureIncludesEditPart;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.edit.parts.FeatureNameEditPart;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.edit.parts.Plugin2EditPart;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.edit.parts.PluginEditPart;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.edit.parts.PluginName2EditPart;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.edit.parts.PluginNameEditPart;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.part.FedDiagramEditorPlugin;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.part.FedVisualIDRegistry;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.providers.FedElementTypes;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.providers.FedParserProvider;
import org.eclipse.gmf.runtime.common.ui.services.parser.CommonParserHint;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

/**
 * @generated
 */
public class FedNavigatorLabelProvider extends LabelProvider implements
		ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		FedDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		FedDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof FedNavigatorItem
				&& !isOwnView(((FedNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof FedNavigatorGroup) {
			FedNavigatorGroup group = (FedNavigatorGroup) element;
			return FedDiagramEditorPlugin.getInstance().getBundledImage(
					group.getIcon());
		}

		if (element instanceof FedNavigatorItem) {
			FedNavigatorItem navigatorItem = (FedNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		// Due to plugin.xml content will be called only for "own" views
		if (element instanceof IAdaptable) {
			View view = (View) ((IAdaptable) element).getAdapter(View.class);
			if (view != null && isOwnView(view)) {
				return getImage(view);
			}
		}

		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	public Image getImage(View view) {
		switch (FedVisualIDRegistry.getVisualID(view)) {
		case FeatureDependsEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?fed?Feature?depends", FedElementTypes.FeatureDepends_4001); //$NON-NLS-1$
		case Plugin2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?fed?Plugin", FedElementTypes.Plugin_3001); //$NON-NLS-1$
		case FeatureEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?fed?Feature", FedElementTypes.Feature_2001); //$NON-NLS-1$
		case ConfigurationEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?fed?Configuration", FedElementTypes.Configuration_1000); //$NON-NLS-1$
		case FeatureIncludesEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?fed?Feature?includes", FedElementTypes.FeatureIncludes_4002); //$NON-NLS-1$
		case PluginEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?fed?Plugin", FedElementTypes.Plugin_2002); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = FedDiagramEditorPlugin.getInstance()
				.getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null
				&& FedElementTypes.isKnownElementType(elementType)) {
			image = FedElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public String getText(Object element) {
		if (element instanceof FedNavigatorGroup) {
			FedNavigatorGroup group = (FedNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof FedNavigatorItem) {
			FedNavigatorItem navigatorItem = (FedNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		// Due to plugin.xml content will be called only for "own" views
		if (element instanceof IAdaptable) {
			View view = (View) ((IAdaptable) element).getAdapter(View.class);
			if (view != null && isOwnView(view)) {
				return getText(view);
			}
		}

		return super.getText(element);
	}

	/**
	 * @generated
	 */
	public String getText(View view) {
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (FedVisualIDRegistry.getVisualID(view)) {
		case FeatureDependsEditPart.VISUAL_ID:
			return getFeatureDepends_4001Text(view);
		case Plugin2EditPart.VISUAL_ID:
			return getPlugin_3001Text(view);
		case FeatureEditPart.VISUAL_ID:
			return getFeature_2001Text(view);
		case ConfigurationEditPart.VISUAL_ID:
			return getConfiguration_1000Text(view);
		case FeatureIncludesEditPart.VISUAL_ID:
			return getFeatureIncludes_4002Text(view);
		case PluginEditPart.VISUAL_ID:
			return getPlugin_2002Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getFeatureDepends_4001Text(View view) {
		IParser parser = FedParserProvider.getParser(
				FedElementTypes.FeatureDepends_4001,
				view.getElement() != null ? view.getElement() : view,
				CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			FedDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getConfiguration_1000Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getFeatureIncludes_4002Text(View view) {
		IParser parser = FedParserProvider.getParser(
				FedElementTypes.FeatureIncludes_4002,
				view.getElement() != null ? view.getElement() : view,
				CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			FedDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFeature_2001Text(View view) {
		IParser parser = FedParserProvider.getParser(
				FedElementTypes.Feature_2001,
				view.getElement() != null ? view.getElement() : view,
				FedVisualIDRegistry.getType(FeatureNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			FedDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPlugin_2002Text(View view) {
		IParser parser = FedParserProvider.getParser(
				FedElementTypes.Plugin_2002,
				view.getElement() != null ? view.getElement() : view,
				FedVisualIDRegistry.getType(PluginNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			FedDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPlugin_3001Text(View view) {
		IParser parser = FedParserProvider.getParser(
				FedElementTypes.Plugin_3001,
				view.getElement() != null ? view.getElement() : view,
				FedVisualIDRegistry.getType(PluginName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			FedDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return ConfigurationEditPart.MODEL_ID.equals(FedVisualIDRegistry
				.getModelID(view));
	}

}
