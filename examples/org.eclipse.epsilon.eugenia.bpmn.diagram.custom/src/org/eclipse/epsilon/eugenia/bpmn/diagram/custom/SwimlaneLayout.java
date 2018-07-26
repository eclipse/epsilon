/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.eugenia.bpmn.diagram.custom;
import org.eclipse.draw2d.AbstractHintLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

public class SwimlaneLayout extends AbstractHintLayout {

	@Override
	public void layout(IFigure container) {
		IFigure label = (IFigure) container.getChildren().get(0);
		IFigure compartment = (IFigure) container.getChildren().get(1);
		
		label.setBounds(new Rectangle(container.getBounds().x, container.getBounds().y, 20, container.getBounds().height));
		compartment.setBounds(new Rectangle(container.getBounds().x + 20, container.getBounds().y, container.getBounds().width-20, container.getBounds().height));
	}

	@Override
	protected Dimension calculatePreferredSize(IFigure container, int wHint,
			int hHint) {
		return new Dimension(100, 100);
	}

}
