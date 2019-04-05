package org.eclipse.epsilon.flexmi.dt;

import java.io.File;

import org.eclipse.epsilon.egl.EglTemplate;
import org.eclipse.epsilon.egl.EglTemplateFactory;
import org.eclipse.epsilon.egl.spec.EglTemplateSpecification;

public class RenderingEglTemplateFactory extends EglTemplateFactory {
	
	protected ContentTree contentTree = new ContentTree("");
	
	@Override
	protected EglTemplate createTemplate(EglTemplateSpecification spec) throws Exception {
		RenderingEglTemplate template = new RenderingEglTemplate(spec, context, new File("/").toURI(), new File("/").getAbsolutePath());
		template.setContentTree(contentTree);
		return template;
	}
	
	public ContentTree getContentTree() {
		return contentTree;
	}
	
}
