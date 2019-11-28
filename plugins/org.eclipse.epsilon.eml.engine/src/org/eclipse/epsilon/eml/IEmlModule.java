package org.eclipse.epsilon.eml;

import java.util.List;

import org.eclipse.epsilon.eml.dom.MergeRule;
import org.eclipse.epsilon.etl.IEtlModule;

public interface IEmlModule extends IEtlModule {

	List<MergeRule> getMergeRules();

	List<MergeRule> getDeclaredMergeRules();

}
