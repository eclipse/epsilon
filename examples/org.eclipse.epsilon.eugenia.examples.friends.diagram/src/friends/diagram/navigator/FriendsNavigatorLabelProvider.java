/*
 * 
 */
package friends.diagram.navigator;

import org.eclipse.core.runtime.IAdaptable;
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

import friends.diagram.edit.parts.PersonEditPart;
import friends.diagram.edit.parts.PersonEnemyOfEditPart;
import friends.diagram.edit.parts.PersonFriendOfEditPart;
import friends.diagram.edit.parts.PersonNameEditPart;
import friends.diagram.edit.parts.WorldEditPart;
import friends.diagram.part.FriendsDiagramEditorPlugin;
import friends.diagram.part.FriendsVisualIDRegistry;
import friends.diagram.providers.FriendsElementTypes;
import friends.diagram.providers.FriendsParserProvider;

/**
 * @generated
 */
public class FriendsNavigatorLabelProvider extends LabelProvider implements
		ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		FriendsDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		FriendsDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof FriendsNavigatorItem
				&& !isOwnView(((FriendsNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof FriendsNavigatorGroup) {
			FriendsNavigatorGroup group = (FriendsNavigatorGroup) element;
			return FriendsDiagramEditorPlugin.getInstance().getBundledImage(
					group.getIcon());
		}

		if (element instanceof FriendsNavigatorItem) {
			FriendsNavigatorItem navigatorItem = (FriendsNavigatorItem) element;
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
		switch (FriendsVisualIDRegistry.getVisualID(view)) {
		case PersonEnemyOfEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?friends?Person?enemyOf", FriendsElementTypes.PersonEnemyOf_4002); //$NON-NLS-1$
		case PersonEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?friends?Person", FriendsElementTypes.Person_2001); //$NON-NLS-1$
		case WorldEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?friends?World", FriendsElementTypes.World_1000); //$NON-NLS-1$
		case PersonFriendOfEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?friends?Person?friendOf", FriendsElementTypes.PersonFriendOf_4001); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = FriendsDiagramEditorPlugin.getInstance()
				.getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null
				&& FriendsElementTypes.isKnownElementType(elementType)) {
			image = FriendsElementTypes.getImage(elementType);
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
		if (element instanceof FriendsNavigatorGroup) {
			FriendsNavigatorGroup group = (FriendsNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof FriendsNavigatorItem) {
			FriendsNavigatorItem navigatorItem = (FriendsNavigatorItem) element;
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
		switch (FriendsVisualIDRegistry.getVisualID(view)) {
		case PersonEnemyOfEditPart.VISUAL_ID:
			return getPersonEnemyOf_4002Text(view);
		case PersonEditPart.VISUAL_ID:
			return getPerson_2001Text(view);
		case WorldEditPart.VISUAL_ID:
			return getWorld_1000Text(view);
		case PersonFriendOfEditPart.VISUAL_ID:
			return getPersonFriendOf_4001Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getPersonEnemyOf_4002Text(View view) {
		IParser parser = FriendsParserProvider.getParser(
				FriendsElementTypes.PersonEnemyOf_4002,
				view.getElement() != null ? view.getElement() : view,
				CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			FriendsDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPerson_2001Text(View view) {
		IParser parser = FriendsParserProvider.getParser(
				FriendsElementTypes.Person_2001,
				view.getElement() != null ? view.getElement() : view,
				FriendsVisualIDRegistry.getType(PersonNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			FriendsDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getWorld_1000Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getPersonFriendOf_4001Text(View view) {
		IParser parser = FriendsParserProvider.getParser(
				FriendsElementTypes.PersonFriendOf_4001,
				view.getElement() != null ? view.getElement() : view,
				CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			FriendsDiagramEditorPlugin.getInstance().logError(
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
		return WorldEditPart.MODEL_ID.equals(FriendsVisualIDRegistry
				.getModelID(view));
	}

}
