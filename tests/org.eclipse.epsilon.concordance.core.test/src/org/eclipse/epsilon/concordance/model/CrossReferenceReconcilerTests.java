/*******************************************************************************
 * Copyright (c) 2009 The University of York.
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
package org.eclipse.epsilon.concordance.model;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.epsilon.common.dt.test.util.TestThatUsesAProject;
import org.eclipse.epsilon.emc.emf.EmfModelFactory;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.test.util.ModelWithEolAssertions;
import org.junit.Test;

public class CrossReferenceReconcilerTests extends TestThatUsesAProject  {

	private static final String SOURCE = "<?xml version=\"1.0\" encoding=\"ASCII\"?>" + "\n" +
	                                     "<xrefs:Element xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:xrefs=\"xrefs\" single=\"Target.model#/0\"/>";
	
	private static final String TARGET = "<?xml version=\"1.0\" encoding=\"ASCII\"?>" + "\n" + 
	                                     "<xrefs:Element xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:xrefs=\"xrefs\" name=\"targeted\"/>";

		
	@Test
	public void shouldReconcileSourceWhenTargetMoves() throws IOException, CoreException, EolModelLoadingException {
		final IFile source         = createFile(project, "Source.model", SOURCE);
		final IFile originalTarget = project.getFile("Target.model");
		final IFile movedTarget    = createFile(project, "MovedTarget.model", TARGET);
		
		new CrossReferenceReconciler(modelFor(source)).reconcile(modelFor(originalTarget), modelFor(movedTarget));
		
		modelWithEolAssertionsFor(source).assertEquals("targeted", "Element.all.first.single.name");
	}
	
	@Test
	public void shouldReconcileSourceWhenSourceMoves() throws IOException, CoreException, EolModelLoadingException {
		createFolder(project, "container");
		
		final IFile originalSource = project.getFile("Source.model");
		final IFile movedSource = createFile(project, "container/MovedSource.model", SOURCE);
		createFile(project, "Target.model", TARGET);
		
		new CrossReferenceReconciler(modelFor(movedSource)).reconcile(modelFor(originalSource), modelFor(movedSource));
		
		modelWithEolAssertionsFor(movedSource).assertEquals("targeted", "Element.all.first.single.name");
	}
	
	private static ConcordanceModel modelFor(IResource resource) {
		return new ConcordanceModel(resource);
	}
	
	private ModelWithEolAssertions modelWithEolAssertionsFor(IResource model) throws EolModelLoadingException {
		return new ModelWithEolAssertions(EmfModelFactory.getInstance().loadEmfModel(model.getName(), model.getLocation().toFile(), "xrefs"));
	}
}
