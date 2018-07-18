/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.eugenia.examples.flowchart.diagram.figures;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;

public class DiamondFigure extends Figure {
	
	@Override
	public void paint(Graphics graphics) {
		
		Rectangle r = getBounds();
		
		// Define the points of a diamond
		Point p1 = new Point(r.x, r.y + r.height/2);
		Point p2 = new Point(r.x + r.width/2, r.y);
		Point p3 = new Point(r.x + r.width, r.y + r.height/2);
		Point p4 = new Point(r.x + r.width/2, r.y + r.height - 1);
		
		PointList pointList = new PointList();
		pointList.addPoint(p1);
		pointList.addPoint(p2);
		pointList.addPoint(p3);
		pointList.addPoint(p4);
		
		// Fill the shape
		graphics.fillPolygon(pointList);
		
		// Draw the outline
		graphics.drawLine(p1, p2);
		graphics.drawLine(p2, p3);
		graphics.drawLine(p3, p4);
		graphics.drawLine(p4, p1);
		
		// Move the label to the centre of the diamond
		WrappingLabel label = (WrappingLabel) getChildren().get(0);
		LayoutUtil.moveToCenter(label, this, graphics);
		label.paint(graphics);
		
	}
	
}
