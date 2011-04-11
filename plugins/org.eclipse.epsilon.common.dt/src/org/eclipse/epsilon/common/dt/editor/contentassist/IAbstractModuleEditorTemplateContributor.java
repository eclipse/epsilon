package org.eclipse.epsilon.common.dt.editor.contentassist;

import java.util.List;

import org.eclipse.jface.text.templates.Template;

public interface IAbstractModuleEditorTemplateContributor {
	
	public abstract List<Template> getTemplates();
	
}