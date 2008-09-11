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

package org.eclipse.epsilon.eugenia.runtime;

import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.swt.graphics.Image;

public class WrappedLabel extends WrappingLabel{

	public WrappedLabel() {
		super();
		doMore();
	}

	public WrappedLabel(Image image) {
		super(image);
		doMore();
	}

	public WrappedLabel(String text, Image image) {
		super(text, image);
		doMore();
	}

	public WrappedLabel(String text) {
		super(text);
		doMore();
	}
	
	public void doMore() {
		setTextWrap(true);
		setTextUnderline(true);
		setTextStrikeThrough(true);
	}
	
}
 