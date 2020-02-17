/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.picto;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.graphics.Point;

public class ViewRenderer {
	
	protected Browser browser;
	protected double zoom = 1.0;
	
	public ViewRenderer(Browser browser) {
		this.browser = browser;
	}
	
	public Browser getBrowser() {
		return browser;
	}
	
	public Point getScrollPosition() {
		Double scrollX = (Double) browser.evaluate("return window.pageXOffset;");
		Double scrollY = (Double) browser.evaluate("return window.pageYOffset;");
		return new Point(scrollX.intValue(), scrollY.intValue());
	}
	
	public Point getPrintableArea() {
		return new Point(
				((Double) browser.evaluate("return document.body.scrollWidth")).intValue(),
				((Double) browser.evaluate("return document.body.scrollHeight")).intValue());
	}
	
	public void setScrollPosition(Point point) {
		browser.evaluate("window.scroll(" + point.x + ", " + point.y + ");");
	}
	
	public void zoom(ZoomType type) {
		if (type == ZoomType.IN) zoom = Math.min(zoom + 0.1, 3.0);
		else if (type == ZoomType.OUT) zoom = Math.max(0, zoom - 0.1);
		else zoom = 1.0;
		
		browser.execute("javascript:document.body.style.zoom=" + zoom + ";");
	}
	
	public double getZoom() {
		return zoom;
	}
	
	protected void display(String text) {
		browser.setText(text);
	}
	
	protected void display(File file) {
		browser.setUrl(URI.createFileURI(file.getAbsolutePath()).toString());
	}
	
	public void nothingToRender() {
		display("<html>Nothing to render.</html>");
	}
	
	public enum ZoomType {
		IN,
		OUT,
		ACTUAL
	}
}
