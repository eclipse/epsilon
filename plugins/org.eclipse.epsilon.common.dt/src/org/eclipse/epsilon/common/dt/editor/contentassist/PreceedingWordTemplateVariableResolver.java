package org.eclipse.epsilon.common.dt.editor.contentassist;

import org.eclipse.jface.text.templates.DocumentTemplateContext;
import org.eclipse.jface.text.templates.TemplateContext;
import org.eclipse.jface.text.templates.TemplateVariableResolver;

public class PreceedingWordTemplateVariableResolver extends TemplateVariableResolver {
	
	@Override
	public String getType() {
		return "preceeding_word";
	}
	
	@Override
	protected String resolve(TemplateContext context) {
		if (context instanceof DocumentTemplateContext) {
			DocumentTemplateContext dtc = (DocumentTemplateContext) context;
			return dtc.getKey();
		}
		else return "";
	}
	
	@Override
	protected boolean isUnambiguous(TemplateContext context) {
		return true;
	}
	
}
