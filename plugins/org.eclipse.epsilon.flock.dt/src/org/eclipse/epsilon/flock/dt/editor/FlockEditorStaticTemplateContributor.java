package org.eclipse.epsilon.flock.dt.editor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.dt.editor.contentassist.IAbstractModuleEditorTemplateContributor;
import org.eclipse.jface.text.templates.Template;

public class FlockEditorStaticTemplateContributor implements IAbstractModuleEditorTemplateContributor {

	protected List<Template> templates;
	
	public List<Template> getTemplates() {
		if (templates == null) {
			templates = new ArrayList<Template>();
			templates.add(new Template("migrate", "migration strategy", "", "migrate ${strategyname} ${originaltype} {\r\n\t${cursor}\r\n}", false));
		}
		return templates;
	}
	
}
