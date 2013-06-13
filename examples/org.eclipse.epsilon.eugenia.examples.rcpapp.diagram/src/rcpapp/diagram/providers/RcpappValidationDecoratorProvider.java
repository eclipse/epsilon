/*
 * 
 */
package rcpapp.diagram.providers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.Label;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditDomain;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.AbstractDecorator;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.CreateDecoratorsOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecorator;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import rcpapp.diagram.edit.parts.ModelEditPart;
import rcpapp.diagram.part.RcpappDiagramEditor;
import rcpapp.diagram.part.RcpappDiagramEditorPlugin;
import rcpapp.diagram.part.RcpappVisualIDRegistry;
import rcpapp.diagram.part.ValidationMarker;

/**
 * @generated
 */
public class RcpappValidationDecoratorProvider extends AbstractProvider
		implements IDecoratorProvider {

	/**
	 * @generated
	 */
	private static final String KEY = "validationStatus"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static Map/*<String, List<IDecorator>>*/allDecorators = new HashMap();

	/**
	 * @generated
	 */
	public void createDecorators(IDecoratorTarget decoratorTarget) {
		EditPart editPart = (EditPart) decoratorTarget
				.getAdapter(EditPart.class);
		if (editPart instanceof GraphicalEditPart
				|| editPart instanceof AbstractConnectionEditPart) {
			Object model = editPart.getModel();
			if ((model instanceof View)) {
				View view = (View) model;
				if (!(view instanceof Edge) && !view.isSetElement()) {
					return;
				}
			}
			EditDomain ed = editPart.getViewer().getEditDomain();
			if (!(ed instanceof DiagramEditDomain)) {
				return;
			}
			if (((DiagramEditDomain) ed).getEditorPart() instanceof RcpappDiagramEditor) {
				decoratorTarget.installDecorator(KEY, new StatusDecorator(
						decoratorTarget));
			}
		}
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (!(operation instanceof CreateDecoratorsOperation)) {
			return false;
		}
		IDecoratorTarget decoratorTarget = ((CreateDecoratorsOperation) operation)
				.getDecoratorTarget();
		View view = (View) decoratorTarget.getAdapter(View.class);
		return view != null
				&& ModelEditPart.MODEL_ID.equals(RcpappVisualIDRegistry
						.getModelID(view));
	}

	/**
	 * @generated
	 */
	public static void refreshDecorators(View view) {
		refreshDecorators(ViewUtil.getIdStr(view), view.getDiagram());
	}

	/**
	 * @generated
	 */
	private static void refreshDecorators(String viewId, Diagram diagram) {
		final List decorators = viewId != null ? (List) allDecorators
				.get(viewId) : null;
		if (decorators == null || decorators.isEmpty() || diagram == null) {
			return;
		}
		final Diagram fdiagram = diagram;
		PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {

			public void run() {
				try {
					TransactionUtil.getEditingDomain(fdiagram).runExclusive(
							new Runnable() {

								public void run() {
									for (Iterator it = decorators.iterator(); it
											.hasNext();) {
										IDecorator decorator = (IDecorator) it
												.next();
										decorator.refresh();
									}
								}
							});
				} catch (Exception e) {
					RcpappDiagramEditorPlugin.getInstance().logError(
							"Decorator refresh failure", e); //$NON-NLS-1$
				}
			}
		});
	}

	/**
	 * @generated
	 */
	public static class StatusDecorator extends AbstractDecorator {

		/**
		 * @generated
		 */
		private String viewId;

		/**
		 * @generated
		 */
		public StatusDecorator(IDecoratorTarget decoratorTarget) {
			super(decoratorTarget);
			try {
				final View view = (View) getDecoratorTarget().getAdapter(
						View.class);
				TransactionUtil.getEditingDomain(view).runExclusive(
						new Runnable() {

							public void run() {
								StatusDecorator.this.viewId = view != null ? ViewUtil
										.getIdStr(view) : null;
							}
						});
			} catch (Exception e) {
				RcpappDiagramEditorPlugin.getInstance().logError(
						"ViewID access failure", e); //$NON-NLS-1$			
			}
		}

		/**
		 * @generated
		 */
		public void refresh() {
			removeDecoration();
			View view = (View) getDecoratorTarget().getAdapter(View.class);
			if (view == null || view.eResource() == null) {
				return;
			}
			EditPart editPart = (EditPart) getDecoratorTarget().getAdapter(
					EditPart.class);
			if (editPart == null || editPart.getViewer() == null) {
				return;
			}

			// query for all the validation markers of the current resource
			int severity = IStatus.INFO;
			ValidationMarker foundMarker = null;
			ValidationMarker[] markers = ValidationMarker.getMarkers(
					editPart.getViewer(), viewId);
			if (markers == null || markers.length == 0) {
				return;
			}
			Label toolTip = null;
			for (int i = 0; i < markers.length; i++) {
				ValidationMarker marker = markers[i];
				int nextSeverity = marker.getStatusSeverity();
				Image nextImage = getImage(nextSeverity);
				if (foundMarker == null) {
					foundMarker = marker;
					toolTip = new Label(marker.getMessage(), nextImage);
				} else {
					if (toolTip.getChildren().isEmpty()) {
						Label comositeLabel = new Label();
						FlowLayout fl = new FlowLayout(false);
						fl.setMinorSpacing(0);
						comositeLabel.setLayoutManager(fl);
						comositeLabel.add(toolTip);
						toolTip = comositeLabel;
					}
					toolTip.add(new Label(marker.getMessage(), nextImage));
				}
				severity = (nextSeverity > severity) ? nextSeverity : severity;
			}
			if (foundMarker == null) {
				return;
			}

			// add decoration
			if (editPart instanceof org.eclipse.gef.GraphicalEditPart) {
				if (view instanceof Edge) {
					setDecoration(getDecoratorTarget().addConnectionDecoration(
							getImage(severity), 50, true));
				} else {
					int margin = -1;
					if (editPart instanceof org.eclipse.gef.GraphicalEditPart) {
						margin = MapModeUtil.getMapMode(
								((org.eclipse.gef.GraphicalEditPart) editPart)
										.getFigure()).DPtoLP(margin);
					}
					setDecoration(getDecoratorTarget()
							.addShapeDecoration(getImage(severity),
									IDecoratorTarget.Direction.NORTH_EAST,
									margin, true));
				}
				getDecoration().setToolTip(toolTip);
			}
		}

		/**
		 * @generated
		 */
		private Image getImage(int severity) {
			String imageName = ISharedImages.IMG_OBJS_ERROR_TSK;
			switch (severity) {
			case IStatus.ERROR:
				imageName = ISharedImages.IMG_OBJS_ERROR_TSK;
				break;
			case IStatus.WARNING:
				imageName = ISharedImages.IMG_OBJS_WARN_TSK;
				break;
			default:
				imageName = ISharedImages.IMG_OBJS_INFO_TSK;
			}
			return PlatformUI.getWorkbench().getSharedImages()
					.getImage(imageName);
		}

		/**
		 * @generated
		 */
		public void activate() {
			if (viewId == null) {
				return;
			}

			// add self to global decorators registry
			List list = (List) allDecorators.get(viewId);
			if (list == null) {
				list = new ArrayList(2);
				list.add(this);
				allDecorators.put(viewId, list);
			} else if (!list.contains(this)) {
				list.add(this);
			}
		}

		/**
		 * @generated
		 */
		public void deactivate() {
			if (viewId == null) {
				return;
			}

			// remove self from global decorators registry
			List list = (List) allDecorators.get(viewId);
			if (list != null) {
				list.remove(this);
				if (list.isEmpty()) {
					allDecorators.remove(viewId);
				}
			}
			super.deactivate();
		}
	}
}
