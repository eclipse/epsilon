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
package org.eclipse.epsilon.concordance.clients.test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.epsilon.common.dt.test.util.TestThatUsesAProject;
import org.eclipse.epsilon.concordance.dt.ConcordanceNature;
import org.eclipse.epsilon.concordance.dt.ConcordancePlugin;
import org.eclipse.epsilon.concordance.history.ConcordanceHistory.Event;
import org.eclipse.epsilon.concordance.history.ConcordanceHistory.EventType;
import org.eclipse.epsilon.concordance.model.Model;
import org.eclipse.epsilon.emc.emf.EmfModelFactory;
import org.eclipse.epsilon.emf.dt.EmfRegistryManager;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.test.util.ModelWithEolAssertions;
import org.junit.After;
import org.junit.Before;

public abstract class ConcordanceClientIntegrationTest extends TestThatUsesAProject {
	
	@Before
	public void setupNature() throws CoreException, InterruptedException {
		addConcordanceNature(project);
	}
	
	@After
	public void waitForResourcesToBeRemovedFromIndex() throws InterruptedException {
		waitForModelChangeNotifications();
	}

	protected static void addConcordanceNature(IProject project) throws CoreException {
		addNature(project, ConcordanceNature.ID);
	}
	
	protected static void waitForModelChangeNotifications() throws InterruptedException {
		Thread.sleep(1000);
	}
	
	protected static ModelWithEolAssertions loadAsModelWithEolAssertions(IResource resource, String name, Object metamodel) throws EolModelLoadingException {
		return new ModelWithEolAssertions(EmfModelFactory.getInstance().loadEmfModel(name, resource.getLocation().toFile(), metamodel));
	}
	
	protected static void registerMetamodel(final IFile metamodel) throws Exception {
		EmfRegistryManager.getInstance().addMetamodel(metamodel.getFullPath().toOSString());
		waitForEPackageRegistryNotifications();
	}
	
	protected static void changeMetamodel(final IFile metamodel, final String newContents) throws CoreException, InterruptedException {
		metamodel.setContents(new ByteArrayInputStream(newContents.getBytes()), IResource.NONE, null);
		waitForEPackageRegistryNotifications();
	}
	
	protected static void waitForEPackageRegistryNotifications() throws InterruptedException {
		Thread.sleep(2000);
	}
	
	protected static void waitFor(Event... events) throws InterruptedException {
		waitFor(Arrays.asList(events));
	}

	protected static void waitFor(Collection<Event> events) throws InterruptedException {
		while (!ConcordancePlugin.getDefault().getHistory().matchesInAnyOrder(events)) {
			Thread.sleep(50);
		}
	}

	protected static Event event(EventType type, IResource model) {
		return new Event(type, new Model(model));
	}
	
	protected Collection<Event> eventsForNewFiles(IResource... files) {
		return eventsForNewFiles(Arrays.asList(files));
	}
	
	protected Collection<Event> eventsForNewFiles(Collection<IResource> files) {
		final Collection<Event> events = new LinkedList<Event>();
		
		for (IResource file : files) {
			events.add(event(EventType.ADD,    file));
			events.add(event(EventType.DELETE, file));
		}
		
		return events;
	}

	protected static Collection<IResource> modelsIn(IProject project) throws CoreException {
		final Collection<IResource> members = new LinkedList<IResource>(Arrays.asList(project.members()));
		
		members.remove(project.findMember(".project"));
		
		return members;
	}
}
