package org.eclipse.epsilon.profiling;

public class ProfilerTargetSummary {
	
	protected int index = 0;
	protected String name;
	protected long executionCount = 0l;
	protected long executionTime = 0l;
	protected long aggregateExecutionTime = 0l;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getIndex() {
		return index;
	}
	
	public void setIndex(int index) {
		this.index = index;
	}
	
	public long getExecutionCount() {
		return executionCount;
	}
	
	public void setExecutionCount(long executionCount) {
		this.executionCount = executionCount;
	}
	
	public long getExecutionTime() {
		return executionTime;
	}
	
	public void setExecutionTime(long executionTime) {
		this.executionTime = executionTime;
	}
	
	public long getAggregateExecutionTime() {
		return aggregateExecutionTime;
	}
	
	public void setAggregateExecutionTime(long aggregateExecutionTime) {
		this.aggregateExecutionTime = aggregateExecutionTime;
	}
	
}
