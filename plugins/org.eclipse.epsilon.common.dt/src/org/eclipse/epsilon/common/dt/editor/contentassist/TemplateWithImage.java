/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.common.dt.editor.contentassist;

import org.eclipse.jface.text.templates.Template;
import org.eclipse.swt.graphics.Image;

public class TemplateWithImage extends Template {
	
	protected Image image;
	
	public TemplateWithImage(String name, String description,
			String contextTypeId, String pattern, boolean isAutoInsertable, Image image) {
		super(name, description, contextTypeId, pattern, isAutoInsertable);
		this.image = image;
	}

	public TemplateWithImage(Template template, Image image) {
		super(template);
		this.image = image;
	}

	public Image getImage() {
		return image;
	}
	
	public void setImage(Image image) {
		this.image = image;
	}
}
