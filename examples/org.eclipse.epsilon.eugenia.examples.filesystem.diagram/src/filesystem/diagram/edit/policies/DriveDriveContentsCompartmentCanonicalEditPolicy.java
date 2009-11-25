/*
 * 
 */
package filesystem.diagram.edit.policies;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;

import filesystem.FilesystemPackage;
import filesystem.diagram.edit.parts.Drive2EditPart;
import filesystem.diagram.edit.parts.FileEditPart;
import filesystem.diagram.edit.parts.FolderEditPart;
import filesystem.diagram.edit.parts.ShortcutEditPart;
import filesystem.diagram.part.FilesystemDiagramUpdater;
import filesystem.diagram.part.FilesystemNodeDescriptor;
import filesystem.diagram.part.FilesystemVisualIDRegistry;

/**
 * @generated
 */
public class DriveDriveContentsCompartmentCanonicalEditPolicy extends
		CanonicalEditPolicy {

	/**
	 * @generated
	 */
	Set myFeaturesToSynchronize;

	/**
	 * @generated
	 */
	protected List getSemanticChildrenList() {
		View viewObject = (View) getHost().getModel();
		List result = new LinkedList();
		for (Iterator it = FilesystemDiagramUpdater
				.getDriveDriveContentsCompartment_7001SemanticChildren(
						viewObject).iterator(); it.hasNext();) {
			result
					.add(((FilesystemNodeDescriptor) it.next())
							.getModelElement());
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected boolean isOrphaned(Collection semanticChildren, final View view) {
		int visualID = FilesystemVisualIDRegistry.getVisualID(view);
		switch (visualID) {
		case Drive2EditPart.VISUAL_ID:
		case FolderEditPart.VISUAL_ID:
		case ShortcutEditPart.VISUAL_ID:
		case FileEditPart.VISUAL_ID:
			if (!semanticChildren.contains(view.getElement())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected String getDefaultFactoryHint() {
		return null;
	}

	/**
	 * @generated
	 */
	protected Set getFeaturesToSynchronize() {
		if (myFeaturesToSynchronize == null) {
			myFeaturesToSynchronize = new HashSet();
			myFeaturesToSynchronize.add(FilesystemPackage.eINSTANCE
					.getFolder_Contents());
		}
		return myFeaturesToSynchronize;
	}

}
