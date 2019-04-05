package org.eclipse.epsilon.flexmi.dt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.FormColors;

public class BrowserContainer extends Composite {
	
	protected boolean borderVisible = false;
	
	public BrowserContainer(Composite parent, int style) {
		super(parent, style);
		
		FillLayout layout = new FillLayout();
		layout.marginHeight = 5;
		layout.marginWidth = 5;
		setLayout(layout);
		
		this.addPaintListener(new PaintListener() {
			
			@Override
			public void paintControl(PaintEvent e) {
				Rectangle b = BrowserContainer.this.getBounds();
				GC gc = e.gc;
				if (borderVisible) {
					
					Color color = new FormColors(Display.getCurrent()).getBorderColor();
					gc.setForeground(color);
					gc.drawRectangle(0, 0, b.width - 1, b.height - 1);
				}
			}
		});
		
	}
	
	public boolean isBorderVisible() {
		return borderVisible;
	}
	
	public void setBorderVisible(boolean borderVisible) {
		this.borderVisible = borderVisible;
	}
	
}
