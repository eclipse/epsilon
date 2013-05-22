/*
 * 
 */
package esm.diagram.navigator;

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

import esm.diagram.edit.parts.EndStateEditPart;
import esm.diagram.edit.parts.EndStateNameEditPart;
import esm.diagram.edit.parts.MachineEditPart;
import esm.diagram.edit.parts.StateEditPart;
import esm.diagram.edit.parts.StateNameEditPart;
import esm.diagram.edit.parts.TransitionActionEditPart;
import esm.diagram.edit.parts.TransitionEditPart;
import esm.diagram.part.EsmDiagramEditorPlugin;
import esm.diagram.part.EsmVisualIDRegistry;
import esm.diagram.providers.EsmElementTypes;
import esm.diagram.providers.EsmParserProvider;

/**
 * @generated
 */
public class EsmNavigatorLabelProvider extends LabelProvider implements
		ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		EsmDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		EsmDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof EsmNavigatorItem
				&& !isOwnView(((EsmNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof EsmNavigatorGroup) {
			EsmNavigatorGroup group = (EsmNavigatorGroup) element;
			return EsmDiagramEditorPlugin.getInstance().getBundledImage(
					group.getIcon());
		}

		if (element instanceof EsmNavigatorItem) {
			EsmNavigatorItem navigatorItem = (EsmNavigatorItem) element;
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
		switch (EsmVisualIDRegistry.getVisualID(view)) {
		case TransitionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?esm?Transition", EsmElementTypes.Transition_4001); //$NON-NLS-1$
		case MachineEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?esm?Machine", EsmElementTypes.Machine_1000); //$NON-NLS-1$
		case StateEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?esm?State", EsmElementTypes.State_2001); //$NON-NLS-1$
		case EndStateEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?esm?EndState", EsmElementTypes.EndState_2002); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = EsmDiagramEditorPlugin.getInstance()
				.getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null
				&& EsmElementTypes.isKnownElementType(elementType)) {
			image = EsmElementTypes.getImage(elementType);
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
		if (element instanceof EsmNavigatorGroup) {
			EsmNavigatorGroup group = (EsmNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof EsmNavigatorItem) {
			EsmNavigatorItem navigatorItem = (EsmNavigatorItem) element;
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
		switch (EsmVisualIDRegistry.getVisualID(view)) {
		case TransitionEditPart.VISUAL_ID:
			return getTransition_4001Text(view);
		case MachineEditPart.VISUAL_ID:
			return getMachine_1000Text(view);
		case StateEditPart.VISUAL_ID:
			return getState_2001Text(view);
		case EndStateEditPart.VISUAL_ID:
			return getEndState_2002Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getEndState_2002Text(View view) {
		IParser parser = EsmParserProvider.getParser(
				EsmElementTypes.EndState_2002,
				view.getElement() != null ? view.getElement() : view,
				EsmVisualIDRegistry.getType(EndStateNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getTransition_4001Text(View view) {
		IParser parser = EsmParserProvider
				.getParser(EsmElementTypes.Transition_4001,
						view.getElement() != null ? view.getElement() : view,
						EsmVisualIDRegistry
								.getType(TransitionActionEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getState_2001Text(View view) {
		IParser parser = EsmParserProvider.getParser(
				EsmElementTypes.State_2001,
				view.getElement() != null ? view.getElement() : view,
				EsmVisualIDRegistry.getType(StateNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsmDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getMachine_1000Text(View view) {
		return ""; //$NON-NLS-1$
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
		return MachineEditPart.MODEL_ID.equals(EsmVisualIDRegistry
				.getModelID(view));
	}

}
