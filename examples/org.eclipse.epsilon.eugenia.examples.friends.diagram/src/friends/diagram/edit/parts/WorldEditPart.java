/*
 * 
 */
package friends.diagram.edit.parts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.handles.MoveHandle;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramDragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.NonResizableLabelEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;

import friends.diagram.edit.commands.FriendsCreateShortcutDecorationsCommand;
import friends.diagram.edit.policies.WorldCanonicalEditPolicy;
import friends.diagram.edit.policies.WorldItemSemanticEditPolicy;
import friends.diagram.part.FriendsVisualIDRegistry;

/**
 * @generated
 */
public class WorldEditPart extends DiagramEditPart {

	/**
	 * @generated
	 */
	public final static String MODEL_ID = "Friends"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 1000;

	/**
	 * @generated
	 */
	public WorldEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new WorldItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new WorldCanonicalEditPolicy());
		installEditPolicy(EditPolicyRoles.CREATION_ROLE,
				new CreationEditPolicyWithCustomReparent(
						FriendsVisualIDRegistry.TYPED_INSTANCE));
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE,
				new DiagramDragDropEditPolicy() {
					public Command getDropObjectsCommand(
							DropObjectsRequest dropRequest) {
						ArrayList<CreateViewRequest.ViewDescriptor> viewDescriptors = new ArrayList<CreateViewRequest.ViewDescriptor>();
						for (Iterator<?> it = dropRequest.getObjects()
								.iterator(); it.hasNext();) {
							Object nextObject = it.next();
							if (false == nextObject instanceof EObject) {
								continue;
							}
							viewDescriptors
									.add(new CreateViewRequest.ViewDescriptor(
											new EObjectAdapter(
													(EObject) nextObject),
											Node.class, null,
											getDiagramPreferencesHint()));
						}
						return createShortcutsCommand(dropRequest,
								viewDescriptors);
					}

					private Command createShortcutsCommand(
							DropObjectsRequest dropRequest,
							List<CreateViewRequest.ViewDescriptor> viewDescriptors) {
						Command command = createViewsAndArrangeCommand(
								dropRequest, viewDescriptors);
						if (command != null) {
							return command
									.chain(new ICommandProxy(
											new FriendsCreateShortcutDecorationsCommand(
													getEditingDomain(),
													(View) getModel(),
													viewDescriptors)));
						}
						return null;
					}
				});
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE);
	}

	/**
	 * @generated
	 */
	/*package-local*/static class LinkLabelDragPolicy extends
			NonResizableLabelEditPolicy {

		/**
		 * @generated
		 */
		@SuppressWarnings("rawtypes")
		protected List createSelectionHandles() {
			MoveHandle mh = new MoveHandle((GraphicalEditPart) getHost());
			mh.setBorder(null);
			return Collections.singletonList(mh);
		}
	}

}
