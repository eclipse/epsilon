package org.eclipse.epsilon.workflow.tasks;

import org.eclipse.epsilon.emg.EmgModule;
import org.eclipse.epsilon.epl.IEplModule;

public class EmgTask extends EplTask {
	
	protected long seed;
	protected boolean useSeed;
	
	@Override
	protected IEplModule createDefaultModule() {
		return new EmgModule();
	}
	
	public void setSeed(long seed) {
		this.seed = seed;
	}
	
	public long getSeed() {
		return seed;
	}
	
	public void setUseSeed(boolean useSeed) {
		this.useSeed = useSeed;
	}
	
	public boolean isUseSeed() {
		return useSeed;
	}
	
}
