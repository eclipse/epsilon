/*
 * 
 */
package filesystem.diagram.edit.parts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

import org.eclipse.swt.graphics.Color;
import filesystem.diagram.edit.policies.FolderItemSemanticEditPolicy;
import filesystem.diagram.edit.policies.OpenDiagramEditPolicy;
import filesystem.diagram.part.FilesystemVisualIDRegistry;
import filesystem.diagram.providers.FilesystemElementTypes;

/**
 * @generated
 */
public class FolderEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3002;

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	protected IFigure primaryShape;

	/**
	 * @generated
	 */
	public FolderEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new FolderItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicyRoles.OPEN_ROLE,
				new OpenDiagramEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				EditPolicy result = child
						.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if (result == null) {
					result = new NonResizableEditPolicy();
				}
				return result;
			}

			protected Command getMoveChildrenCommand(Request request) {
				return null;
			}

			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}
		};
		return lep;
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		return primaryShape = new FolderFigure();
	}

	/**
	 * @generated
	 */
	public FolderFigure getPrimaryShape() {
		return (FolderFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof FolderNameEditPart) {
			((FolderNameEditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureFolderLabelFigure());
			return true;
		}
		if (childEditPart instanceof FolderFolderContentsCompartmentEditPart) {
			IFigure pane = getPrimaryShape()
					.getFolderContentsCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((FolderFolderContentsCompartmentEditPart) childEditPart)
					.getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof FolderNameEditPart) {
			return true;
		}
		if (childEditPart instanceof FolderFolderContentsCompartmentEditPart) {
			IFigure pane = getPrimaryShape()
					.getFolderContentsCompartmentFigure();
			pane.remove(((FolderFolderContentsCompartmentEditPart) childEditPart)
					.getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated
	 */
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		if (editPart instanceof FolderFolderContentsCompartmentEditPart) {
			return getPrimaryShape().getFolderContentsCompartmentFigure();
		}
		return getContentPane();
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);
		return result;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected NodeFigure createNodeFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	/**
	 * Default implementation treats passed figure as content pane.
	 * Respects layout one may have set for generated figure.
	 * @param nodeShape instance of generated figure class
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		if (nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(5);
			nodeShape.setLayoutManager(layout);
		}
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	 * @generated
	 */
	public IFigure getContentPane() {
		if (contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	 * @generated
	 */
	protected void setForegroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setForegroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setBackgroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setBackgroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineWidth(int width) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineWidth(width);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineType(int style) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineStyle(style);
		}
	}

	/**
	 * @generated
	 */
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(FilesystemVisualIDRegistry
				.getType(FolderNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSource() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(1);
		types.add(FilesystemElementTypes.Sync_4001);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSourceAndTarget(
			IGraphicalEditPart targetEditPart) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof DriveEditPart) {
			types.add(FilesystemElementTypes.Sync_4001);
		}
		if (targetEditPart instanceof Drive2EditPart) {
			types.add(FilesystemElementTypes.Sync_4001);
		}
		if (targetEditPart instanceof filesystem.diagram.edit.parts.FolderEditPart) {
			types.add(FilesystemElementTypes.Sync_4001);
		}
		if (targetEditPart instanceof ShortcutEditPart) {
			types.add(FilesystemElementTypes.Sync_4001);
		}
		if (targetEditPart instanceof FileEditPart) {
			types.add(FilesystemElementTypes.Sync_4001);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForTarget(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == FilesystemElementTypes.Sync_4001) {
			types.add(FilesystemElementTypes.Drive_2001);
			types.add(FilesystemElementTypes.Drive_3001);
			types.add(FilesystemElementTypes.Folder_3002);
			types.add(FilesystemElementTypes.Shortcut_3003);
			types.add(FilesystemElementTypes.File_3004);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnTarget() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(FilesystemElementTypes.Sync_4001);
		types.add(FilesystemElementTypes.ShortcutTarget_4002);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == FilesystemElementTypes.Sync_4001) {
			types.add(FilesystemElementTypes.Drive_2001);
			types.add(FilesystemElementTypes.Drive_3001);
			types.add(FilesystemElementTypes.Folder_3002);
			types.add(FilesystemElementTypes.Shortcut_3003);
			types.add(FilesystemElementTypes.File_3004);
		} else if (relationshipType == FilesystemElementTypes.ShortcutTarget_4002) {
			types.add(FilesystemElementTypes.Shortcut_3003);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public class FolderFigure extends RoundedRectangle {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureFolderLabelFigure;
		/**
		 * @generated
		 */
		private RectangleFigure fFolderContentsCompartmentFigure;

		/**
		 * @generated
		 */
		public FolderFigure() {
			this.setCornerDimensions(new Dimension(getMapMode().DPtoLP(8),
					getMapMode().DPtoLP(8)));
			this.setBorder(new MarginBorder(getMapMode().DPtoLP(5),
					getMapMode().DPtoLP(5), getMapMode().DPtoLP(5),
					getMapMode().DPtoLP(5)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureFolderLabelFigure = new WrappingLabel();

			fFigureFolderLabelFigure.setText("Folder");
			fFigureFolderLabelFigure.setMaximumSize(new Dimension(getMapMode()
					.DPtoLP(10000), getMapMode().DPtoLP(50)));

			this.add(fFigureFolderLabelFigure);

			fFolderContentsCompartmentFigure = new RectangleFigure();

			fFolderContentsCompartmentFigure.setOutline(false);

			this.add(fFolderContentsCompartmentFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureFolderLabelFigure() {
			return fFigureFolderLabelFigure;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFolderContentsCompartmentFigure() {
			return fFolderContentsCompartmentFigure;
		}

	}

}
