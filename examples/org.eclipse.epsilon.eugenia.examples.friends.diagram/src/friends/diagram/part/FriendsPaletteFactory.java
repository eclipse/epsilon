/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package friends.diagram.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;

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
		paletteContainer.add(createFriendOf1CreationTool());
		paletteContainer.add(createEnemyOf2CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPerson1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(FriendsElementTypes.Person_1001);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Person1CreationTool_title,
				Messages.Person1CreationTool_desc, types);
		entry.setSmallIcon(FriendsElementTypes
				.getImageDescriptor(FriendsElementTypes.Person_1001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createFriendOf1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(FriendsElementTypes.PersonFriendOf_3001);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.FriendOf1CreationTool_title,
				Messages.FriendOf1CreationTool_desc, types);
		entry
				.setSmallIcon(FriendsDiagramEditorPlugin
						.findImageDescriptor("/org.eclipse.epsilon.eugenia.runtime/icons/Link.gif")); //$NON-NLS-1$
		entry
				.setLargeIcon(FriendsDiagramEditorPlugin
						.findImageDescriptor("/org.eclipse.epsilon.eugenia.runtime/icons/Link.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEnemyOf2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(FriendsElementTypes.PersonEnemyOf_3002);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.EnemyOf2CreationTool_title,
				Messages.EnemyOf2CreationTool_desc, types);
		entry
				.setSmallIcon(FriendsDiagramEditorPlugin
						.findImageDescriptor("/org.eclipse.epsilon.eugenia.runtime/icons/Link.gif")); //$NON-NLS-1$
		entry
				.setLargeIcon(FriendsDiagramEditorPlugin
						.findImageDescriptor("/org.eclipse.epsilon.eugenia.runtime/icons/Link.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private static class NodeToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List elementTypes;

		/**
		 * @generated
		 */
		private NodeToolEntry(String title, String description,
				List elementTypes) {
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
		private final List relationshipTypes;

		/**
		 * @generated
		 */
		private LinkToolEntry(String title, String description,
				List relationshipTypes) {
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
