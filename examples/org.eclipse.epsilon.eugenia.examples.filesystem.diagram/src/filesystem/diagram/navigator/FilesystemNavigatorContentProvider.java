/*
 * 
 */
package filesystem.diagram.navigator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

import java.util.LinkedList;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonContentProvider;

import filesystem.diagram.edit.parts.Drive2EditPart;
import filesystem.diagram.edit.parts.DriveDriveContentsCompartment2EditPart;
import filesystem.diagram.edit.parts.DriveDriveContentsCompartmentEditPart;
import filesystem.diagram.edit.parts.DriveEditPart;
import filesystem.diagram.edit.parts.FileEditPart;
import filesystem.diagram.edit.parts.FilesystemEditPart;
import filesystem.diagram.edit.parts.FolderEditPart;
import filesystem.diagram.edit.parts.FolderFolderContentsCompartmentEditPart;
import filesystem.diagram.edit.parts.ShortcutEditPart;
import filesystem.diagram.edit.parts.ShortcutTargetEditPart;
import filesystem.diagram.edit.parts.SyncEditPart;
import filesystem.diagram.part.FilesystemVisualIDRegistry;
import filesystem.diagram.part.Messages;

/**
 * @generated
 */
public class FilesystemNavigatorContentProvider implements
		ICommonContentProvider {

	/**
	 * @generated
	 */
	private static final Object[] EMPTY_ARRAY = new Object[0];

	/**
	 * @generated
	 */
	private Viewer myViewer;

	/**
	 * @generated
	 */
	private AdapterFactoryEditingDomain myEditingDomain;

	/**
	 * @generated
	 */
	private WorkspaceSynchronizer myWorkspaceSynchronizer;

	/**
	 * @generated
	 */
	private Runnable myViewerRefreshRunnable;

	/**
	 * @generated
	 */
	@SuppressWarnings({ "unchecked", "serial", "rawtypes" })
	public FilesystemNavigatorContentProvider() {
		TransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE
				.createEditingDomain();
		myEditingDomain = (AdapterFactoryEditingDomain) editingDomain;
		myEditingDomain.setResourceToReadOnlyMap(new HashMap() {
			public Object get(Object key) {
				if (!containsKey(key)) {
					put(key, Boolean.TRUE);
				}
				return super.get(key);
			}
		});
		myViewerRefreshRunnable = new Runnable() {
			public void run() {
				if (myViewer != null) {
					myViewer.refresh();
				}
			}
		};
		myWorkspaceSynchronizer = new WorkspaceSynchronizer(editingDomain,
				new WorkspaceSynchronizer.Delegate() {
					public void dispose() {
					}

					public boolean handleResourceChanged(final Resource resource) {
						unloadAllResources();
						asyncRefresh();
						return true;
					}

					public boolean handleResourceDeleted(Resource resource) {
						unloadAllResources();
						asyncRefresh();
						return true;
					}

					public boolean handleResourceMoved(Resource resource,
							final URI newURI) {
						unloadAllResources();
						asyncRefresh();
						return true;
					}
				});
	}

	/**
	 * @generated
	 */
	public void dispose() {
		myWorkspaceSynchronizer.dispose();
		myWorkspaceSynchronizer = null;
		myViewerRefreshRunnable = null;
		myViewer = null;
		unloadAllResources();
		((TransactionalEditingDomain) myEditingDomain).dispose();
		myEditingDomain = null;
	}

	/**
	 * @generated
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		myViewer = viewer;
	}

	/**
	 * @generated
	 */
	void unloadAllResources() {
		for (Resource nextResource : myEditingDomain.getResourceSet()
				.getResources()) {
			nextResource.unload();
		}
	}

	/**
	 * @generated
	 */
	void asyncRefresh() {
		if (myViewer != null && !myViewer.getControl().isDisposed()) {
			myViewer.getControl().getDisplay()
					.asyncExec(myViewerRefreshRunnable);
		}
	}

	/**
	 * @generated
	 */
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
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
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof IFile) {
			IFile file = (IFile) parentElement;
			URI fileURI = URI.createPlatformResourceURI(file.getFullPath()
					.toString(), true);
			Resource resource = myEditingDomain.getResourceSet().getResource(
					fileURI, true);
			ArrayList<FilesystemNavigatorItem> result = new ArrayList<FilesystemNavigatorItem>();
			ArrayList<View> topViews = new ArrayList<View>(resource
					.getContents().size());
			for (EObject o : resource.getContents()) {
				if (o instanceof View) {
					topViews.add((View) o);
				}
			}
			return result.toArray();
		}

		if (parentElement instanceof FilesystemNavigatorGroup) {
			FilesystemNavigatorGroup group = (FilesystemNavigatorGroup) parentElement;
			return group.getChildren();
		}

		if (parentElement instanceof FilesystemNavigatorItem) {
			FilesystemNavigatorItem navigatorItem = (FilesystemNavigatorItem) parentElement;
			if (navigatorItem.isLeaf() || !isOwnView(navigatorItem.getView())) {
				return EMPTY_ARRAY;
			}
			return getViewChildren(navigatorItem.getView(), parentElement);
		}

		/*
		 * Due to plugin.xml restrictions this code will be called only for views representing
		 * shortcuts to this diagram elements created on other diagrams. 
		 */
		if (parentElement instanceof IAdaptable) {
			View view = (View) ((IAdaptable) parentElement)
					.getAdapter(View.class);
			if (view != null) {
				return getViewChildren(view, parentElement);
			}
		}

		return EMPTY_ARRAY;
	}

	/**
	 * @generated
	 */
	private Object[] getViewChildren(View view, Object parentElement) {
		switch (FilesystemVisualIDRegistry.getVisualID(view)) {

		case SyncEditPart.VISUAL_ID: {
			LinkedList<FilesystemAbstractNavigatorItem> result = new LinkedList<FilesystemAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			FilesystemNavigatorGroup target = new FilesystemNavigatorGroup(
					Messages.NavigatorGroupName_Sync_4001_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			FilesystemNavigatorGroup source = new FilesystemNavigatorGroup(
					Messages.NavigatorGroupName_Sync_4001_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					FilesystemVisualIDRegistry.getType(DriveEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					FilesystemVisualIDRegistry
							.getType(Drive2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					FilesystemVisualIDRegistry
							.getType(FolderEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					FilesystemVisualIDRegistry
							.getType(ShortcutEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					FilesystemVisualIDRegistry.getType(FileEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					FilesystemVisualIDRegistry.getType(DriveEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					FilesystemVisualIDRegistry
							.getType(Drive2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					FilesystemVisualIDRegistry
							.getType(FolderEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					FilesystemVisualIDRegistry
							.getType(ShortcutEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					FilesystemVisualIDRegistry.getType(FileEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case FileEditPart.VISUAL_ID: {
			LinkedList<FilesystemAbstractNavigatorItem> result = new LinkedList<FilesystemAbstractNavigatorItem>();
			Node sv = (Node) view;
			FilesystemNavigatorGroup incominglinks = new FilesystemNavigatorGroup(
					Messages.NavigatorGroupName_File_3004_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			FilesystemNavigatorGroup outgoinglinks = new FilesystemNavigatorGroup(
					Messages.NavigatorGroupName_File_3004_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					FilesystemVisualIDRegistry.getType(SyncEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					FilesystemVisualIDRegistry.getType(SyncEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					FilesystemVisualIDRegistry
							.getType(ShortcutTargetEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case FolderEditPart.VISUAL_ID: {
			LinkedList<FilesystemAbstractNavigatorItem> result = new LinkedList<FilesystemAbstractNavigatorItem>();
			Node sv = (Node) view;
			FilesystemNavigatorGroup incominglinks = new FilesystemNavigatorGroup(
					Messages.NavigatorGroupName_Folder_3002_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			FilesystemNavigatorGroup outgoinglinks = new FilesystemNavigatorGroup(
					Messages.NavigatorGroupName_Folder_3002_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					FilesystemVisualIDRegistry
							.getType(FolderFolderContentsCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					FilesystemVisualIDRegistry
							.getType(Drive2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					FilesystemVisualIDRegistry
							.getType(FolderFolderContentsCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					FilesystemVisualIDRegistry
							.getType(FolderEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					FilesystemVisualIDRegistry
							.getType(FolderFolderContentsCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					FilesystemVisualIDRegistry
							.getType(ShortcutEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					FilesystemVisualIDRegistry
							.getType(FolderFolderContentsCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					FilesystemVisualIDRegistry.getType(FileEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					FilesystemVisualIDRegistry.getType(SyncEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					FilesystemVisualIDRegistry.getType(SyncEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					FilesystemVisualIDRegistry
							.getType(ShortcutTargetEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case Drive2EditPart.VISUAL_ID: {
			LinkedList<FilesystemAbstractNavigatorItem> result = new LinkedList<FilesystemAbstractNavigatorItem>();
			Node sv = (Node) view;
			FilesystemNavigatorGroup incominglinks = new FilesystemNavigatorGroup(
					Messages.NavigatorGroupName_Drive_3001_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			FilesystemNavigatorGroup outgoinglinks = new FilesystemNavigatorGroup(
					Messages.NavigatorGroupName_Drive_3001_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					FilesystemVisualIDRegistry
							.getType(DriveDriveContentsCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					FilesystemVisualIDRegistry
							.getType(Drive2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					FilesystemVisualIDRegistry
							.getType(DriveDriveContentsCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					FilesystemVisualIDRegistry
							.getType(FolderEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					FilesystemVisualIDRegistry
							.getType(DriveDriveContentsCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					FilesystemVisualIDRegistry
							.getType(ShortcutEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					FilesystemVisualIDRegistry
							.getType(DriveDriveContentsCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					FilesystemVisualIDRegistry.getType(FileEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					FilesystemVisualIDRegistry.getType(SyncEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					FilesystemVisualIDRegistry.getType(SyncEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					FilesystemVisualIDRegistry
							.getType(ShortcutTargetEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ShortcutEditPart.VISUAL_ID: {
			LinkedList<FilesystemAbstractNavigatorItem> result = new LinkedList<FilesystemAbstractNavigatorItem>();
			Node sv = (Node) view;
			FilesystemNavigatorGroup incominglinks = new FilesystemNavigatorGroup(
					Messages.NavigatorGroupName_Shortcut_3003_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			FilesystemNavigatorGroup outgoinglinks = new FilesystemNavigatorGroup(
					Messages.NavigatorGroupName_Shortcut_3003_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					FilesystemVisualIDRegistry.getType(SyncEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					FilesystemVisualIDRegistry.getType(SyncEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					FilesystemVisualIDRegistry
							.getType(ShortcutTargetEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					FilesystemVisualIDRegistry
							.getType(ShortcutTargetEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case DriveEditPart.VISUAL_ID: {
			LinkedList<FilesystemAbstractNavigatorItem> result = new LinkedList<FilesystemAbstractNavigatorItem>();
			Node sv = (Node) view;
			FilesystemNavigatorGroup incominglinks = new FilesystemNavigatorGroup(
					Messages.NavigatorGroupName_Drive_2001_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			FilesystemNavigatorGroup outgoinglinks = new FilesystemNavigatorGroup(
					Messages.NavigatorGroupName_Drive_2001_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					FilesystemVisualIDRegistry
							.getType(DriveDriveContentsCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					FilesystemVisualIDRegistry
							.getType(Drive2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					FilesystemVisualIDRegistry
							.getType(DriveDriveContentsCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					FilesystemVisualIDRegistry
							.getType(FolderEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					FilesystemVisualIDRegistry
							.getType(DriveDriveContentsCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					FilesystemVisualIDRegistry
							.getType(ShortcutEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					FilesystemVisualIDRegistry
							.getType(DriveDriveContentsCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					FilesystemVisualIDRegistry.getType(FileEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					FilesystemVisualIDRegistry.getType(SyncEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					FilesystemVisualIDRegistry.getType(SyncEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					FilesystemVisualIDRegistry
							.getType(ShortcutTargetEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ShortcutTargetEditPart.VISUAL_ID: {
			LinkedList<FilesystemAbstractNavigatorItem> result = new LinkedList<FilesystemAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			FilesystemNavigatorGroup target = new FilesystemNavigatorGroup(
					Messages.NavigatorGroupName_ShortcutTarget_4002_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			FilesystemNavigatorGroup source = new FilesystemNavigatorGroup(
					Messages.NavigatorGroupName_ShortcutTarget_4002_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					FilesystemVisualIDRegistry.getType(DriveEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					FilesystemVisualIDRegistry
							.getType(Drive2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					FilesystemVisualIDRegistry
							.getType(FolderEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					FilesystemVisualIDRegistry
							.getType(ShortcutEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					FilesystemVisualIDRegistry.getType(FileEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					FilesystemVisualIDRegistry
							.getType(ShortcutEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case FilesystemEditPart.VISUAL_ID: {
			LinkedList<FilesystemAbstractNavigatorItem> result = new LinkedList<FilesystemAbstractNavigatorItem>();
			result.addAll(getForeignShortcuts((Diagram) view, parentElement));
			Diagram sv = (Diagram) view;
			FilesystemNavigatorGroup links = new FilesystemNavigatorGroup(
					Messages.NavigatorGroupName_Filesystem_1000_links,
					"icons/linksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					FilesystemVisualIDRegistry.getType(DriveEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					FilesystemVisualIDRegistry.getType(SyncEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					FilesystemVisualIDRegistry
							.getType(ShortcutTargetEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			if (!links.isEmpty()) {
				result.add(links);
			}
			return result.toArray();
		}
		}
		return EMPTY_ARRAY;
	}

	/**
	 * @generated
	 */
	private Collection<View> getLinksSourceByType(Collection<Edge> edges,
			String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (Edge nextEdge : edges) {
			View nextEdgeSource = nextEdge.getSource();
			if (type.equals(nextEdgeSource.getType())
					&& isOwnView(nextEdgeSource)) {
				result.add(nextEdgeSource);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getLinksTargetByType(Collection<Edge> edges,
			String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (Edge nextEdge : edges) {
			View nextEdgeTarget = nextEdge.getTarget();
			if (type.equals(nextEdgeTarget.getType())
					&& isOwnView(nextEdgeTarget)) {
				result.add(nextEdgeTarget);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getOutgoingLinksByType(
			Collection<? extends View> nodes, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (View nextNode : nodes) {
			result.addAll(selectViewsByType(nextNode.getSourceEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getIncomingLinksByType(
			Collection<? extends View> nodes, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (View nextNode : nodes) {
			result.addAll(selectViewsByType(nextNode.getTargetEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getChildrenByType(
			Collection<? extends View> nodes, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (View nextNode : nodes) {
			result.addAll(selectViewsByType(nextNode.getChildren(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getDiagramLinksByType(
			Collection<Diagram> diagrams, String type) {
		ArrayList<View> result = new ArrayList<View>();
		for (Diagram nextDiagram : diagrams) {
			result.addAll(selectViewsByType(nextDiagram.getEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> selectViewsByType(Collection<View> views,
			String type) {
		ArrayList<View> result = new ArrayList<View>();
		for (View nextView : views) {
			if (type.equals(nextView.getType()) && isOwnView(nextView)) {
				result.add(nextView);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return FilesystemEditPart.MODEL_ID.equals(FilesystemVisualIDRegistry
				.getModelID(view));
	}

	/**
	 * @generated
	 */
	private Collection<FilesystemNavigatorItem> createNavigatorItems(
			Collection<View> views, Object parent, boolean isLeafs) {
		ArrayList<FilesystemNavigatorItem> result = new ArrayList<FilesystemNavigatorItem>(
				views.size());
		for (View nextView : views) {
			result.add(new FilesystemNavigatorItem(nextView, parent, isLeafs));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<FilesystemNavigatorItem> getForeignShortcuts(
			Diagram diagram, Object parent) {
		LinkedList<View> result = new LinkedList<View>();
		for (Iterator<View> it = diagram.getChildren().iterator(); it.hasNext();) {
			View nextView = it.next();
			if (!isOwnView(nextView)
					&& nextView.getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
				result.add(nextView);
			}
		}
		return createNavigatorItems(result, parent, false);
	}

	/**
	 * @generated
	 */
	public Object getParent(Object element) {
		if (element instanceof FilesystemAbstractNavigatorItem) {
			FilesystemAbstractNavigatorItem abstractNavigatorItem = (FilesystemAbstractNavigatorItem) element;
			return abstractNavigatorItem.getParent();
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean hasChildren(Object element) {
		return element instanceof IFile || getChildren(element).length > 0;
	}

}
