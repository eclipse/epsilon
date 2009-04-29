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
package friends.diagram.providers;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.AbstractDecorator;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.CreateDecoratorsOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Image;

import friends.diagram.edit.parts.WorldEditPart;
import friends.diagram.part.FriendsDiagramEditorPlugin;
import friends.diagram.part.FriendsVisualIDRegistry;

/**
 * @generated
 */
public class FriendsShortcutsDecoratorProvider extends AbstractProvider
		implements IDecoratorProvider {

	/**
	 * @generated
	 */
	public static final String SHORTCUTS_DECORATOR_ID = "shortcuts"; //$NON-NLS-1$

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
				&& WorldEditPart.MODEL_ID.equals(FriendsVisualIDRegistry
						.getModelID(view));
	}

	/**
	 * @generated
	 */
	public void createDecorators(IDecoratorTarget decoratorTarget) {
		View view = (View) decoratorTarget.getAdapter(View.class);
		if (view != null) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				decoratorTarget.installDecorator(SHORTCUTS_DECORATOR_ID,
						new ShortcutsDecorator(decoratorTarget));
			}
		}
	}

	/**
	 * @generated
	 */
	protected class ShortcutsDecorator extends AbstractDecorator {

		/**
		 * @generated
		 */
		public ShortcutsDecorator(IDecoratorTarget decoratorTarget) {
			super(decoratorTarget);
		}

		/**
		 * @generated
		 */
		public void activate() {
			refresh();
		}

		/**
		 * @generated
		 */
		public void refresh() {
			removeDecoration();
			EditPart editPart = (EditPart) getDecoratorTarget().getAdapter(
					EditPart.class);
			Image image = FriendsDiagramEditorPlugin.getInstance()
					.getBundledImage("icons/shortcut.gif"); //$NON-NLS-1$
			if (editPart instanceof ShapeEditPart) {
				setDecoration(getDecoratorTarget().addShapeDecoration(image,
						IDecoratorTarget.Direction.SOUTH_WEST, 0, false));
			} else if (editPart instanceof ConnectionEditPart) {
				setDecoration(getDecoratorTarget().addConnectionDecoration(
						image, 50, false));
			}
		}

	}

}
