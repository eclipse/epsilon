package org.eclipse.epsilon.flexmi.dt;

import java.io.File;

import org.eclipse.epsilon.egl.EglTemplate;
import org.eclipse.epsilon.egl.EglTemplateFactory;
import org.eclipse.epsilon.egl.dom.GenerationRule;
import org.eclipse.epsilon.egl.spec.EglTemplateSpecification;

public class LazyEglTemplateFactory extends EglTemplateFactory {
	
	protected ContentTree contentTree = new ContentTree("");
	protected GenerationRule generationRule;
	
	@Override
	protected EglTemplate createTemplate(EglTemplateSpecification spec) throws Exception {
		LazyEglTemplate template = new LazyEglTemplate(spec, context, new File("/").toURI(), new File("/").getAbsolutePath());
		template.setGenerationRule(generationRule);
		template.setContentTree(contentTree);
		return template;
	}
	
	public ContentTree getContentTree() {
		return contentTree;
	}
	
	public void setGenerationRule(GenerationRule generationRule) {
		this.generationRule = generationRule;
	}
}
