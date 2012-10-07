/*
 * 
 */
package filesystem.diagram.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.Graphics;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.notation.View;

import filesystem.diagram.edit.policies.SyncItemSemanticEditPolicy;

/**
 * @generated
 */
public class SyncEditPart extends ConnectionNodeEditPart implements
		ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4001;

	/**
	 * @generated
	 */
	public SyncEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new SyncItemSemanticEditPolicy());
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */

	protected Connection createConnectionFigure() {
		return new SyncFigure();
	}

	/**
	 * @generated
	 */
	public SyncFigure getPrimaryShape() {
		return (SyncFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class SyncFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		public SyncFigure() {
			this.setLineWidth(2);
			this.setLineStyle(Graphics.LINE_DOT);

		}

	}

}
