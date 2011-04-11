package org.eclipse.epsilon.evl.dt.editor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.dt.editor.contentassist.IAbstractModuleEditorTemplateContributor;
import org.eclipse.jface.text.templates.Template;

public class EvlEditorStaticTemplateContributor implements IAbstractModuleEditorTemplateContributor {
	
	List<Template> templates = null;
	public List<Template> getTemplates() {
		if (templates == null) {
			templates = new ArrayList<Template>();
			templates.add(new Template("context", "context", "", 
					"context ${classname} {\r\n" + 
					"\t ${cursor}\r\n" + 
					"}",false));
			
			templates.add(new Template("constraint", "constraint", "", 
						"constraint ${name} {\r\n" + 
						"\tcheck : ${cursor}\r\n" + 
						"\tmessage : \r\n" +
						"}",false));
			
			templates.add(new Template("fix", "fix", "", 
					"fix \r\n" + 
					"\ttitle : ${cursor}\r\n" + 
					"\tdo {\r\n" +
					"\t\t\r\n" +
					"\t}\r\n" +
					"}",false));
			
		}
		return templates;
	}
}
