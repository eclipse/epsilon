/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eml.execute.context;

import org.eclipse.epsilon.ecl.trace.MatchTrace;
import org.eclipse.epsilon.eml.EmlModule;
import org.eclipse.epsilon.eml.execute.operations.EmlOperationFactory;
import org.eclipse.epsilon.eml.strategy.DefaultMergingStrategy;
import org.eclipse.epsilon.eml.strategy.IMergingStrategy;
import org.eclipse.epsilon.eml.trace.MergeTrace;
import org.eclipse.epsilon.etl.execute.context.EtlContext;

public class EmlContext extends EtlContext implements IEmlContext {

	protected MatchTrace matchTrace = new MatchTrace();
	protected MergeTrace mergeTrace = new MergeTrace();
	//protected MatchTrace tempMatchTrace = new MatchTrace();
	protected EmlModule module = null;
	
	private IMergingStrategy mergingStrategy = null;
	//private MatchingStrategy matchingStrategy = null;
	
	public EmlContext(){
		this.setOperationFactory(new EmlOperationFactory());
		this.mergingStrategy = new DefaultMergingStrategy();
		//this.matchingStrategy = new DefaultMatchingStrategy();
	}
	
	public IMergingStrategy getMergingStrategy() {
		return mergingStrategy;
	}

	public void setMergingStrategy(IMergingStrategy mergingStrategy) {
		this.mergingStrategy = mergingStrategy;
	}
	
	//public MatchingStrategy getMatchingStrategy() {
	//	return matchingStrategy;
	//}

	//public void setMatchingStrategy(MatchingStrategy matchingStrategy) {
	//	this.matchingStrategy = matchingStrategy;
	//}

	//public MatchTrace getTempMatchTrace() {
	//	return tempMatchTrace;
	//}

	public MatchTrace getMatchTrace(){
		return matchTrace;
	}

	public MergeTrace getMergeTrace(){
		return mergeTrace;
	}
	
	@Override
	public EmlModule getModule(){
		return module;
	}
	
	public void setModule(EmlModule module){
		this.module = module;
	}

	public void setMatchTrace(MatchTrace matchTrace) {
		this.matchTrace = matchTrace;
	}

	public void setMergeTrace(MergeTrace mergeTrace) {
		this.mergeTrace = mergeTrace;
	}

	//public void setTempMatchTrace(MatchTrace tempMatchTrace) {
	//	this.tempMatchTrace = tempMatchTrace;
	//}
	
	/*
	@Override
	public ITransformationStrategy getTransformationStrategy(Object source) {
		if (mergingStrategy.getLeftModel().owns(source)){
			return mergingStrategy.getLeftTransformationStrategy();
		}
		else {
			return mergingStrategy.getRightTransformationStrategy();
		}
	}	
	*/
}
