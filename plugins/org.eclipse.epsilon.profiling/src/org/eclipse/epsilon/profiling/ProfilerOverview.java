package org.eclipse.epsilon.profiling;

public class ProfilerOverview {
	
	protected long executionTime;
	protected long executionCount;
	
	public long getExecutionTime() {
		return executionTime;
	}
	
	public void setExecutionTime(long executionTime) {
		this.executionTime = executionTime;
	}
	
	public long getExecutionCount() {
		return executionCount;
	}
	
	public void setExecutionCount(long executionCount) {
		this.executionCount = executionCount;
	}
	
	public double getAverageExecutionTime() {
		if (executionCount == 0 || executionTime == 0) return 0;
		else return (double) executionTime / (double) executionCount;
	}
	
}
