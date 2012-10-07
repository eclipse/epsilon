/*
 * 
 */
package friends.diagram.part;

import java.util.Collections;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import friends.diagram.providers.FriendsElementTypes;

/**
 * @generated
 */
public class FriendsPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createObjects1Group());
		paletteRoot.add(createConnections2Group());
	}

	/**
	 * Creates "Objects" palette tool group
	 * @generated
	 */
	private PaletteContainer createObjects1Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Objects1Group_title);
		paletteContainer.setId("createObjects1Group"); //$NON-NLS-1$
		paletteContainer.add(createPerson1CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Connections" palette tool group
	 * @generated
	 */
	private PaletteContainer createConnections2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Connections2Group_title);
		paletteContainer.setId("createConnections2Group"); //$NON-NLS-1$
		paletteContainer.add(createEnemyOf1CreationTool());
		paletteContainer.add(createFriendOf2CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPerson1CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Person1CreationTool_title,
				Messages.Person1CreationTool_desc,
				Collections.singletonList(FriendsElementTypes.Person_2001));
		entry.setId("createPerson1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(FriendsElementTypes
				.getImageDescriptor(FriendsElementTypes.Person_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEnemyOf1CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Messages.EnemyOf1CreationTool_title,
				Messages.EnemyOf1CreationTool_desc,
				Collections
						.singletonList(FriendsElementTypes.PersonEnemyOf_4002));
		entry.setId("createEnemyOf1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(FriendsElementTypes
				.getImageDescriptor(FriendsElementTypes.PersonEnemyOf_4002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createFriendOf2CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Messages.FriendOf2CreationTool_title,
				Messages.FriendOf2CreationTool_desc,
				Collections
						.singletonList(FriendsElementTypes.PersonFriendOf_4001));
		entry.setId("createFriendOf2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(FriendsElementTypes
				.getImageDescriptor(FriendsElementTypes.PersonFriendOf_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private static class NodeToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List<IElementType> elementTypes;

		/**
		 * @generated
		 */
		private NodeToolEntry(String title, String description,
				List<IElementType> elementTypes) {
			super(title, description, null, null);
			this.elementTypes = elementTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}

	/**
	 * @generated
	 */
	private static class LinkToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List<IElementType> relationshipTypes;

		/**
		 * @generated
		 */
		private LinkToolEntry(String title, String description,
				List<IElementType> relationshipTypes) {
			super(title, description, null, null);
			this.relationshipTypes = relationshipTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}
}
