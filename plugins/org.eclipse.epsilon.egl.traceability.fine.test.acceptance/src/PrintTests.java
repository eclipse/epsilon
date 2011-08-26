/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */


import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.egl.engine.traceability.fine.context.IEglContextWithFineGrainedTraceability;
import org.eclipse.epsilon.egl.engine.traceability.fine.operations.print.PrintOperation;
import org.eclipse.epsilon.egl.engine.traceability.fine.operations.print.Printer;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.Region;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.TraceElement;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.builder.RegionBuilder;
import org.eclipse.epsilon.egl.engine.traceability.fine.wrappers.TraceableModel;
import org.eclipse.epsilon.emc.emf.EmfUtil;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.operations.OperationFactory;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.test.util.builders.emf.EClassBuilder;



public class PrintTests {

	private static class MyModule extends EolModule {
		
		@Override
		protected void prepareContext(IEolContext context) {
			super.prepareContext(context);
			makeModelsTraceable(context);
		}
		
		private void makeModelsTraceable(IEolContext context) {
			final List<IModel> untraceableModels = context.getModelRepository().getModels();
			final List<TraceableModel> traceableModels = new LinkedList<TraceableModel>();
			
			for (int modelIndex = 0; modelIndex < untraceableModels.size(); modelIndex++) {
				final IModel untraceableModel = untraceableModels.remove(modelIndex);
				traceableModels.add(new TraceableModel(untraceableModel));
			}
			
			for (TraceableModel traceableModel : traceableModels) {
				context.getModelRepository().addModel(traceableModel);
			}
		}
		
		@Override
		public IEglContextWithFineGrainedTraceability getContext() {
			return (IEglContextWithFineGrainedTraceability)super.getContext();
		}
		
		@Override
		public void reset() {
			super.reset();
			context = new IEglContextWithFineGrainedTraceability();
			context.setOperationFactory(new OperationFactory() {
				
				@Override
				protected void createCache() {
					super.createCache();
					// TODO Speak to Dimitris: this might be better as an 
					// operation that has been contributed to OutputBuffer,
					// but contributed operations don't receive the full AST..
					operationCache.put("printy", new PrintOperation(new Printer() {
	
						@Override
						public Region print(Object object, RegionBuilder builder) {
							System.out.println(object);
							
							return builder.aRegion()
									.startingAt(1, 1)
									.endingAt(1, object.toString().length())
									.build();
						}
						
					}));
				}
				
			});
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		final MyModule module = new MyModule();
		
		module.getContext().getModelRepository().addModel(new InMemoryEmfModel("Ecore", EmfUtil.createResource(EClassBuilder.anEClass().named("Baz").build()), EcorePackage.eINSTANCE));
		
		module.parse("printy('foo' + 'bar' + EClass.all.first.name + '-' + EClass.all.first.eSuperTypes);");
		
		if (module.getParseProblems().isEmpty()) {
			module.execute();
			module.getContext().getTraceabilityContext().addTargetResourceToTrace("foo.txt");
			
			for (TraceElement element : module.getContext().getTraceabilityContext().getFineGrainedTrace().getElements()) {
				System.out.println(element.getSource() + " -> " + element.getDestination().getResources().get(0) + "@" + element.getDestination().getRegion().getStart() + ":" + element.getDestination().getRegion().getEnd());
			}
		
		} else {
			for (ParseProblem problem : module.getParseProblems()) {
				System.err.println(problem);
			}
		}
		
	}
}
