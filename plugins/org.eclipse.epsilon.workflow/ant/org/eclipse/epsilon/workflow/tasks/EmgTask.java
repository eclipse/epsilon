package org.eclipse.epsilon.workflow.tasks;

import org.eclipse.epsilon.emg.EmgModule;
import org.eclipse.epsilon.epl.IEplModule;

public class EmgTask extends EplTask {
	
	protected Long seed;
	
	@Override
	protected IEplModule createDefaultModule() {
		EmgModule module = new EmgModule();
		if (seed != null) {
			module.setUseSeed(true);
			module.setSeed(seed);
		}
		return module;
	}
	
	public void setSeed(long seed) {
		this.seed = seed;
	}
	
	public long getSeed() {
		return seed;
	}
	
}
