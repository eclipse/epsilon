package org.eclipse.epsilon.egl.execute.context;

import org.eclipse.epsilon.egl.EglTemplateFactory;
import org.eclipse.epsilon.egl.EgxModule;
import org.eclipse.epsilon.egl.traceability.Template;

public class EgxContext extends EglContext {
	
	protected Template baseTemplate = null;
	
	public EgxContext(EglTemplateFactory templateFactory) {
		super(templateFactory);
	}
	
	@Override
	public Template getBaseTemplate() {
		if (baseTemplate == null) {
			baseTemplate = new EgxModuleTemplateAdapter((EgxModule) module);
		}
		return baseTemplate;
	}
	
	public void setBaseTemplate(Template baseTemplate) {
		this.baseTemplate = baseTemplate;
	}
	
}
