package org.eclipse.epsilon.erl.execute.concurrent;

import java.util.function.Supplier;
import org.eclipse.epsilon.common.concurrent.ConcurrentBaseDelegate;
import org.eclipse.epsilon.common.interfaces.BaseDelegate.MergeMode;

public class DelegatePersistentThreadLocal<T extends ConcurrentBaseDelegate<T>> extends PersistentThreadLocal<T> {

	public DelegatePersistentThreadLocal(int numThreads, Supplier<? extends T> initialValue) {
		super(numThreads, initialValue);
	}

	public DelegatePersistentThreadLocal(Supplier<? extends T> initialValue) {
		super(initialValue);
	}
	
	@Override
	public void remove() {
		get().merge(MergeMode.MERGE_INTO_BASE);
		super.remove();
	}
	
	@Override
	public void removeAll() {
		getAll().forEach(t -> t.mergeAndSetThreadSafety(MergeMode.MERGE_INTO_BASE, false));
		super.removeAll();
	}
}
