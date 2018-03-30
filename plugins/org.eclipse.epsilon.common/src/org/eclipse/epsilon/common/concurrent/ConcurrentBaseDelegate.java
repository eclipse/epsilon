package org.eclipse.epsilon.common.concurrent;

import java.util.Collection;
import java.util.function.Function;
import org.eclipse.epsilon.common.interfaces.BaseDelegate;

public interface ConcurrentBaseDelegate<T extends ConcurrentBaseDelegate<T>> extends BaseDelegate<T> {
	
	boolean isThreadSafe();
	
	void setThreadSafe(boolean concurrent);
	
	default void mergeAndSetThreadSafety(MergeMode mode, boolean threadSafe) {
		merge(mode);
		setThreadSafe(threadSafe);
	}
	
	/**
	 * Calls {@link BaseDelegate#mergeCollectionsUnique(Function, Function, MergeMode)}
	 * with threadSafeTargetCol if the target (i.e. this or the base) should be thread-safe.
	 */
	default <C> void mergeCollectionsUnique(
		Function<T, Collection<C>> colPropertyGetter,
		Function<Collection<C>, ? extends Collection<C>> threadSafeTargetCol,
		Function<Collection<C>, ? extends Collection<C>> targetCol,
		MergeMode mode) {
		
			T to = getTo(mode);
			
			if (to != null) {
				BaseDelegate.super.mergeCollectionsUnique(
					colPropertyGetter,
					to.isThreadSafe() ? threadSafeTargetCol : targetCol,
					mode
				);
			}
	}
}
