/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.concordance.clients.conformance;

import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.common.parse.problem.ParseProblem;
import org.eclipse.epsilon.concordance.index.ConcordanceIndex;
import org.eclipse.epsilon.concordance.model.IConcordanceModel;
import org.eclipse.epsilon.concordance.model.ModelVisitor;
import org.eclipse.epsilon.concordance.reporter.metamodel.DefaultMetamodelChangeListener;
import org.eclipse.epsilon.hutn.xmi.dt.ConformanceReporter;
import org.eclipse.epsilon.hutn.xmi.dt.XmiConformanceChecker;

public class ConformanceChecker extends DefaultMetamodelChangeListener {
	
	private final ErrorLogInformer           informer = new ErrorLogInformer();
	private final ConformanceCheckingVisitor visitor = new ConformanceCheckingVisitor(new XmiConformanceChecker(informer));


	public ConformanceChecker() {
		super();
	}
	
	public ConformanceChecker(ConcordanceIndex index) {
		super(index);
	}

	public void ePackageChanged(EPackage oldEPackage, EPackage newEPackage) {
		index.visitAllInstancesOf(newEPackage.getNsURI(), visitor);
		
		informer.reportToErrorLog();
	}
	
	static class ConformanceCheckingVisitor extends ModelVisitor {

		private final XmiConformanceChecker checker;
	
		public ConformanceCheckingVisitor(XmiConformanceChecker checker) {
			this.checker = checker;
		}

		public void visit(IConcordanceModel model) {
			if (model.getResource() != null) {
				checker.reportConformanceOf(model.getResource());
			}
		}
	}
	
	static class ErrorLogInformer implements ConformanceReporter {

		private final Collection<String> conformantModels    = new LinkedList<>();
		private final Collection<String> nonConformantModels = new LinkedList<>();

		
		public void reportConformant(String name) {
			conformantModels.add(name);
		}
		
		public void reportNonConformant(String name, Collection<ParseProblem> conformanceProblems) {
			nonConformantModels.add(name);
		}
		
		public void reportToErrorLog() {
			if (!conformantModels.isEmpty()) {
				LogUtil.logInfo("The following " + conformantModels.size() + " models conform to their metamodel...\n" + present(conformantModels));
			}
			
			if (!nonConformantModels.isEmpty()) {
				LogUtil.logInfo("The following " + nonConformantModels.size() + " models do not conform to their metamodel...\n" + present(nonConformantModels));
			}
			
			reset();
		}
		
		private String present(Collection<String> models) {
			final StringBuilder modelList = new StringBuilder();
			
			for (String model : models) {
				modelList.append(model);
				modelList.append('\n');
			}
			
			return modelList.toString();
		}
		
		private void reset() {
			conformantModels.clear();
			nonConformantModels.clear();
		}
	}
}
