package org.eclipse.epsilon.egl;

/**
 * @deprecated
 * Use {@link EglModule} instead.
 *
 */
public class EglTemplateFactoryModuleAdapter extends EglModule {
	
	public EglTemplateFactoryModuleAdapter() {
		super();
	}
	
	public EglTemplateFactoryModuleAdapter(EglTemplateFactory factory) {
		super(factory);
	}
	
}
