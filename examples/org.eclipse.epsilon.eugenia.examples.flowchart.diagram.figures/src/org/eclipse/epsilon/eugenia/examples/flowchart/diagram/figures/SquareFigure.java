package org.eclipse.epsilon.eugenia.examples.flowchart.diagram.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;

public class SquareFigure extends RectangleFigure {
	
	@Override
	public void paint(Graphics graphics) {
		// Fill shape and draw outline
		super.paint(graphics);
		
		// Move label to the center of the shape
		WrappingLabel label = (WrappingLabel) getChildren().get(0);
		LayoutUtil.moveToCenter(label, this, graphics);
		label.paint(graphics);
	}	
}
