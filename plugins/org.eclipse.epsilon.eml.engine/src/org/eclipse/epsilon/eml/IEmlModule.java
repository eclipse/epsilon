package org.eclipse.epsilon.eml;

import java.util.List;

import org.eclipse.epsilon.eml.dom.MergeRule;
import org.eclipse.epsilon.eml.execute.context.IEmlContext;
import org.eclipse.epsilon.etl.IEtlModule;

public interface IEmlModule extends IEtlModule {

	List<MergeRule> getMergeRules();

	List<MergeRule> getDeclaredMergeRules();

	@Override
	default IEmlContext getContext() {
		return (IEmlContext) ((IEtlModule)this).getContext();
	}
	
}
