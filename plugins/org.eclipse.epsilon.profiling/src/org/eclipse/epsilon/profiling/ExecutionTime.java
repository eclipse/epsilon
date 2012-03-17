package org.eclipse.epsilon.profiling;

public class ExecutionTime {
	
	protected long individual = 0;
	protected long aggregate = 0;
	
	public ExecutionTime() { }
	
	public ExecutionTime(long individual, long aggregate) {
		super();
		this.individual = individual;
		this.aggregate = aggregate;
	}

	public long getIndividual() {
		return individual;
	}
	
	public long getAggregate() {
		return aggregate;
	}
	
	public void setIndividual(long individual) {
		this.individual = individual;
	}
	
	public void setAggregate(long aggregate) {
		this.aggregate = aggregate;
	}
	
}
