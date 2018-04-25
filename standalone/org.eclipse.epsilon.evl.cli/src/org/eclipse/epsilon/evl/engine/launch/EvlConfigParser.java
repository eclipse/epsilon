package org.eclipse.epsilon.evl.engine.launch;

import org.eclipse.epsilon.eol.cli.EolConfigParser;
import org.eclipse.epsilon.evl.IEvlModule;
import org.eclipse.epsilon.evl.launch.EvlRunConfiguration;

public class EvlConfigParser extends EolConfigParser<IEvlModule, EvlRunConfiguration> {

	public static void main(String[] args) {
		new EvlConfigParser(EvlRunConfiguration.class).apply(args).run();
	}
	
	public EvlConfigParser(Class<EvlRunConfiguration> configurationClass) {
		super(configurationClass);
	}
	
}
