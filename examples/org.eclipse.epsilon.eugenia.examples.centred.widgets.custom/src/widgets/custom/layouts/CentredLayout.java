/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package widgets.custom.layouts;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

public class CentredLayout implements LayoutManager {
	
	@SuppressWarnings("unchecked")
	public void layout(IFigure container) {
		for (IFigure child : (List<IFigure>)container.getChildren()) {
	    	layoutChild(container.getClientArea(), child);
	    }
	}

	private void layoutChild(final Rectangle containerBounds, IFigure child) {
		/*
		 * size:   the width and height of a figure
		 * bounds: the space a figure occupies - an origin (x,y) and size (width,height)
		 */
		
		// Ensure child is no larger than the container
		final Dimension childSize   = intersection(containerBounds.getSize(), child.getPreferredSize());
 
		final Rectangle childBounds = centredBounds(containerBounds, childSize);
		
		child.setBounds(childBounds);
	}
	
	private static Rectangle centredBounds(Rectangle containerBounds, Dimension childSize) {
		return new Rectangle(containerBounds.x + (containerBounds.width - childSize.width)/2,
		                     containerBounds.y + (containerBounds.height - childSize.height)/2,
		                     childSize.width,
		                     childSize.height);
	}

	private static Dimension intersection(Dimension first, Dimension second) {
		final Dimension d = new Dimension();
        d.width  = Math.min(first.width, second.width);
        d.height = Math.min(first.height, second.height);
        return d;
	}
	

	
	private final StackLayout delegate = new StackLayout();

	
	public Object getConstraint(IFigure child) {
		return delegate.getConstraint(child);
	}

	public Dimension getMinimumSize(IFigure container, int wHint, int hHint) {
		return delegate.getMinimumSize(container, wHint, hHint);
	}

	public Dimension getPreferredSize(IFigure container, int wHint, int hHint) {
		return delegate.getPreferredSize(container, wHint, hHint);

	}

	public void invalidate() {
		delegate.invalidate();
	}

	public void remove(IFigure child) {
		delegate.remove(child);
	}

	public void setConstraint(IFigure child, Object constraint) {
		delegate.setConstraint(child, constraint);
	}
}
