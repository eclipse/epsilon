package org.eclipse.epsilon.ecl.dt.editor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.dt.editor.contentassist.IAbstractModuleEditorTemplateContributor;
import org.eclipse.jface.text.templates.Template;

public class EclEditorStaticTemplateContributor implements IAbstractModuleEditorTemplateContributor {
	
	List<Template> templates = null;
	public List<Template> getTemplates() {
		if (templates == null) {
			templates = new ArrayList<Template>();
			templates.add(new Template("matches", "check if two objects match", "", "matches(${cursor})",false));
			templates.add(new Template("match", "match rule", "", "rule ${rulename} \r\n\tmatch l : ${leftmodel}!${lefttype}\r\n\twith r : ${rightmodel}!${righttype} {\r\n\tcompare : ${cursor}\r\n}",false));
			templates.add(new Template("common match", "match rule", "", "rule ${name} \r\n\tmatch l : Left!${name}\r\n\twith r : Right!${name} {\r\n\r\n\tcompare : ${cursor}\r\n}",false));
			templates.add(new Template("do", "do block of a match rule", "", "do {\r\n\t${cursor}\r\n}",false));
			templates.add(new Template("pre", "block executed before the rules", "", "pre ${name} {\r\n\t${cursor}\r\n}",false));
			templates.add(new Template("post", "block executed after the rules", "", "post ${name} {\r\n\t${cursor}\r\n}",false));
			
		}
		return templates;
	}
}
