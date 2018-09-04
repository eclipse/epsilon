package org.eclipse.epsilon.evl.concurrent.profiling;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import org.eclipse.epsilon.common.util.profiling.ProfileDiagnostic;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.function.CheckedEolRunnable;
import org.eclipse.epsilon.eol.launch.ProfilableIEolModule;
import org.eclipse.epsilon.evl.concurrent.EvlModuleParallel;
import org.eclipse.epsilon.evl.execute.UnsatisfiedConstraint;

public abstract class ProfilableEvlModuleParallel extends EvlModuleParallel implements ProfilableIEolModule {

	protected final Collection<ProfileDiagnostic> profiledStages = new ArrayList<>();
	
	protected ProfilableEvlModuleParallel(int parallelism, boolean threadSafeBaseFrames) {
		super(parallelism, threadSafeBaseFrames);
	}

	public ProfilableEvlModuleParallel(int parallelism) {
		super(parallelism);
	}

	public ProfilableEvlModuleParallel() {
		super();
	}
	
	@Override
	public Collection<ProfileDiagnostic> getProfiledStages() {
		return profiledStages;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Set<UnsatisfiedConstraint> profileExecution() throws EolRuntimeException {
		return (Set<UnsatisfiedConstraint>) ProfilableIEolModule.super.profileExecution();
	}
	
	@Override
	protected void prepareExecution() throws EolRuntimeException {
		profileExecutionStage("prepareExecution()", super::prepareExecution);
	}
	
	@Override
	protected void postExecution() throws EolRuntimeException {
		profileExecutionStage("postExecution()", super::postExecution);
	}
	
	protected void profileCreateJobs(CheckedEolRunnable submitCode) throws EolRuntimeException {
		profileExecutionStage("create jobs", submitCode);
	}
	
	protected void profileExecuteJobs(Collection<Runnable> jobs) throws EolRuntimeException {
		profileExecutionStage("execute jobs", () -> getContext().executeParallel(this, jobs));
	}
}
