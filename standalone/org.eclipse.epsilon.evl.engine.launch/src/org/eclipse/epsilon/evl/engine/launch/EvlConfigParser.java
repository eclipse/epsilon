package org.eclipse.epsilon.evl.engine.launch;

import org.eclipse.epsilon.eol.engine.launch.EolConfigParser;
import org.eclipse.epsilon.evl.IEvlModule;

public class EvlConfigParser extends EolConfigParser<IEvlModule, EvlRunConfiguration> {

	public static void main(String[] args) {
		new EvlConfigParser(IEvlModule.class, EvlRunConfiguration.class).apply(args).run();
	}
	
	public EvlConfigParser(Class<? extends IEvlModule> moduleClass, Class<EvlRunConfiguration> configurationClass) {
		super(moduleClass, configurationClass);
		// TODO Auto-generated constructor stub
	}
	
}
