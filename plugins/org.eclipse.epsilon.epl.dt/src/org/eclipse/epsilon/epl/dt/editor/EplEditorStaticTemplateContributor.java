package org.eclipse.epsilon.epl.dt.editor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.dt.editor.contentassist.IAbstractModuleEditorTemplateContributor;
import org.eclipse.jface.text.templates.Template;

public class EplEditorStaticTemplateContributor implements IAbstractModuleEditorTemplateContributor {
	
	List<Template> templates = null;
	public List<Template> getTemplates() {
		if (templates == null) {
			templates = new ArrayList<Template>();
			templates.add(new Template("pattern", "pattern", "", "pattern ${rulename} \r\n\t s : ${sourcetype} {\r\n\tmatch: ${cursor}\r\n}",false));
		}
		return templates;
	}
}
