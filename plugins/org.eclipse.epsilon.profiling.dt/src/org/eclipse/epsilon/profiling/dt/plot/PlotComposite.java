/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.profiling.dt.plot;

import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

public class PlotComposite extends Composite implements PaintListener {
	
	
	private final Color white =  new Color(Display.getCurrent(),255,255,255);
	//private final Color black = new Color(Display.getCurrent(),0,0,0);
	//private final Color red = new Color(Display.getCurrent(),255,0,0);
	private final Color blue = new Color(Display.getCurrent(),42,0,255);
	protected Borders borders = new Borders(30, 10, 10, 20);
	protected Canvas canvas;
	protected List<Long> data;
	
	public PlotComposite(Composite parent, int style) {
		super(parent, style);
		this.setLayout(new FillLayout());
		canvas = new Canvas(this, SWT.NONE);		
		canvas.setBackground(white);
		canvas.addPaintListener(this);

	}

	public void paintControl(PaintEvent e) {
		draw();
	}
	
	protected synchronized void draw() {
		GC gc = new GC(canvas);
		
		Rectangle r = canvas.getBounds();
		
		drawXAxis(gc);
		drawYAxis(gc);
		
		// Draw Y axis
		
		gc.setForeground(blue);
		
		float scaleX = (r.width - (borders.left + borders.right)) / (data.size() - 1);
		float scaleY = ((float) (r.height - (borders.top + borders.bottom))) / Collections.max(data);
		
		ListIterator<Long> li = data.listIterator();
		Long d1 = li.next();
		int index = 0;
		while (li.hasNext()) {
			Long d2 = li.next();
			float startX = borders.left + (index * scaleX);
			float startY = r.height - borders.bottom - (d1 * scaleY);
			float endX = borders.left + ((index + 1) * scaleX);
			float endY = r.height - borders.bottom - (d2 * scaleY);
			
			gc.drawLine((int) startX, (int) startY, (int) endX, (int) endY);
			d1 = d2;
			index++;
		}
		
		gc.dispose();				
		
	}
	
	protected void drawXAxis(GC gc) {
		gc.drawLine(borders.left, 
				canvas.getBounds().height - borders.bottom,
				canvas.getBounds().width - borders.right,
				canvas.getBounds().height - borders.bottom);
		String label = "Execution #";
		gc.drawString(label, 
				canvas.getBounds().width - borders.right - (gc.getFontMetrics().getAverageCharWidth() * label.length()), 
				canvas.getBounds().height - borders.bottom + 5);
	}
	
	protected void drawYAxis(GC gc) {
		gc.drawLine(borders.left, 
				borders.top, 
				borders.left, 
				canvas.getBounds().height - borders.bottom);
		gc.drawString("Time", 3, borders.top + 3);
	}

	@Override
	public List<Long> getData() {
		return data;
	}

	public void setData(List<Long> data) {
		this.data = data;
		draw();
	}
	
}
