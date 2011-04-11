package org.eclipse.epsilon.ewl.dt.editor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.dt.editor.contentassist.IAbstractModuleEditorTemplateContributor;
import org.eclipse.jface.text.templates.Template;

public class EwlEditorStaticTemplateContributor implements IAbstractModuleEditorTemplateContributor {

	List<Template> templates = null;
	public List<Template> getTemplates() {
		if (templates == null) {
			templates = new ArrayList<Template>();
			templates.add(new Template("wizard", "wizard", "", "wizard ${name} {\r\n\r\n\tguard : self.isKindOf(${type})\r\n\r\n\ttitle : '${title}'\r\n\r\n\tdo {\r\n\t\t${cursor}\r\n\t}\r\n}",false));
		}
		return templates;
	}

}
