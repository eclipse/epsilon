/*
 * 
 */
package flowchart.diagram.navigator;

import org.eclipse.core.runtime.IAdaptable;
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

import flowchart.diagram.edit.parts.ActionEditPart;
import flowchart.diagram.edit.parts.ActionNameEditPart;
import flowchart.diagram.edit.parts.DecisionEditPart;
import flowchart.diagram.edit.parts.DecisionNameEditPart;
import flowchart.diagram.edit.parts.FlowchartEditPart;
import flowchart.diagram.edit.parts.SubflowEditPart;
import flowchart.diagram.edit.parts.SubflowNameEditPart;
import flowchart.diagram.edit.parts.TransitionEditPart;
import flowchart.diagram.edit.parts.TransitionNameEditPart;
import flowchart.diagram.part.FlowchartDiagramEditorPlugin;
import flowchart.diagram.part.FlowchartVisualIDRegistry;
import flowchart.diagram.providers.FlowchartElementTypes;
import flowchart.diagram.providers.FlowchartParserProvider;

/**
 * @generated
 */
public class FlowchartNavigatorLabelProvider extends LabelProvider implements
		ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		FlowchartDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		FlowchartDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof FlowchartNavigatorItem
				&& !isOwnView(((FlowchartNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof FlowchartNavigatorGroup) {
			FlowchartNavigatorGroup group = (FlowchartNavigatorGroup) element;
			return FlowchartDiagramEditorPlugin.getInstance().getBundledImage(
					group.getIcon());
		}

		if (element instanceof FlowchartNavigatorItem) {
			FlowchartNavigatorItem navigatorItem = (FlowchartNavigatorItem) element;
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
		switch (FlowchartVisualIDRegistry.getVisualID(view)) {
		case ActionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?flowchart?Action", FlowchartElementTypes.Action_2004); //$NON-NLS-1$
		case SubflowEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?flowchart?Subflow", FlowchartElementTypes.Subflow_2001); //$NON-NLS-1$
		case DecisionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?flowchart?Decision", FlowchartElementTypes.Decision_2003); //$NON-NLS-1$
		case TransitionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?flowchart?Transition", FlowchartElementTypes.Transition_4001); //$NON-NLS-1$
		case FlowchartEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?flowchart?Flowchart", FlowchartElementTypes.Flowchart_1000); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = FlowchartDiagramEditorPlugin
				.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null
				&& FlowchartElementTypes.isKnownElementType(elementType)) {
			image = FlowchartElementTypes.getImage(elementType);
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
		if (element instanceof FlowchartNavigatorGroup) {
			FlowchartNavigatorGroup group = (FlowchartNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof FlowchartNavigatorItem) {
			FlowchartNavigatorItem navigatorItem = (FlowchartNavigatorItem) element;
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
		switch (FlowchartVisualIDRegistry.getVisualID(view)) {
		case ActionEditPart.VISUAL_ID:
			return getAction_2004Text(view);
		case SubflowEditPart.VISUAL_ID:
			return getSubflow_2001Text(view);
		case DecisionEditPart.VISUAL_ID:
			return getDecision_2003Text(view);
		case TransitionEditPart.VISUAL_ID:
			return getTransition_4001Text(view);
		case FlowchartEditPart.VISUAL_ID:
			return getFlowchart_1000Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getAction_2004Text(View view) {
		IParser parser = FlowchartParserProvider
				.getParser(FlowchartElementTypes.Action_2004,
						view.getElement() != null ? view.getElement() : view,
						FlowchartVisualIDRegistry
								.getType(ActionNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			FlowchartDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFlowchart_1000Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getSubflow_2001Text(View view) {
		IParser parser = FlowchartParserProvider.getParser(
				FlowchartElementTypes.Subflow_2001,
				view.getElement() != null ? view.getElement() : view,
				FlowchartVisualIDRegistry
						.getType(SubflowNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			FlowchartDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDecision_2003Text(View view) {
		IParser parser = FlowchartParserProvider.getParser(
				FlowchartElementTypes.Decision_2003,
				view.getElement() != null ? view.getElement() : view,
				FlowchartVisualIDRegistry
						.getType(DecisionNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			FlowchartDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getTransition_4001Text(View view) {
		IParser parser = FlowchartParserProvider.getParser(
				FlowchartElementTypes.Transition_4001,
				view.getElement() != null ? view.getElement() : view,
				FlowchartVisualIDRegistry
						.getType(TransitionNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			FlowchartDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6001); //$NON-NLS-1$
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
		return FlowchartEditPart.MODEL_ID.equals(FlowchartVisualIDRegistry
				.getModelID(view));
	}

}
