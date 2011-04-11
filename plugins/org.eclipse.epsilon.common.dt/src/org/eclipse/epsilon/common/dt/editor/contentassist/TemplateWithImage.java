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
