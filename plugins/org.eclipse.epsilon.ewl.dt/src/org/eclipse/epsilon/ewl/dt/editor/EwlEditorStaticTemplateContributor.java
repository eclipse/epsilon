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
