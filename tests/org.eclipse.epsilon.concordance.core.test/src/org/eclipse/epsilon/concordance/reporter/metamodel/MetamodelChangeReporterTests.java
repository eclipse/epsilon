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
package org.eclipse.epsilon.concordance.reporter.metamodel;

import static org.eclipse.epsilon.test.util.builders.emf.EClassBuilder.anEClass;
import static org.eclipse.epsilon.test.util.builders.emf.EPackageBuilder.aMetamodel;

import org.easymock.EasyMock;
import org.eclipse.emf.ecore.EPackage;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MetamodelChangeReporterTests {

	private static EPackage.Registry originalRegistry;
	
	@BeforeClass
	public static void setup() {
		originalRegistry = EPackage.Registry.INSTANCE;
	}
	
	@AfterClass
	public static void teardown() {
		EPackage.Registry.INSTANCE.putAll(originalRegistry);
	}
	
	
	private final EPackage ePackage = aMetamodel().with(anEClass().named("SomeClass")).build();
	
	private MetamodelChangeReporter reporter;
	private MetamodelChangeListener mockListener;
	
	@Before
	public void setupEachTime() {
		EPackage.Registry.INSTANCE.clear();
		
		reporter = new MetamodelChangeReporter();
		mockListener = EasyMock.createMock("mockListener", MetamodelChangeListener.class);
	}
	
	
	@Test
	public void noNotificationOnAdd() {
		EasyMock.replay(mockListener);


		EPackage.Registry.INSTANCE.put("empty", ePackage);	
		reporter.addListener(mockListener);
		
		EasyMock.verify(mockListener);
	}
	
	@Test
	public void notificationAfterPoll() {
		mockListener.ePackageAdded(ePackage);

		EasyMock.replay(mockListener);
	
		
		EPackage.Registry.INSTANCE.put("empty", ePackage);
		reporter.addListener(mockListener);		
		reporter.pollRegistry();
				
		EasyMock.verify(mockListener);
	}
	
	@Test
	public void doNotReceiveNotificationForAlreadyEncountered() {
		mockListener.ePackageAdded(ePackage);

		EasyMock.replay(mockListener);

		
		EPackage.Registry.INSTANCE.put("empty", ePackage);	
		reporter.addListener(mockListener);
		reporter.pollRegistry();
		reporter.pollRegistry();
				
		EasyMock.verify(mockListener);
	}
	
	@Test
	public void addObserverNotifiesOfCurrentCache() {
		mockListener.ePackageAdded(ePackage);

		EasyMock.replay(mockListener);
	
		
		EPackage.Registry.INSTANCE.put("empty", ePackage);
		reporter.pollRegistry();
		reporter.addListener(mockListener);
				
		EasyMock.verify(mockListener);
	}
	 
	@Test
	public void pollRegistryForDeletedEPackage() {
		mockListener.ePackageAdded(ePackage);
		mockListener.ePackageRemoved(ePackage);

		EasyMock.replay(mockListener);
	
		
		EPackage.Registry.INSTANCE.put("empty", ePackage);
		reporter.pollRegistry();

		reporter.addListener(mockListener);

		EPackage.Registry.INSTANCE.remove("empty");
		reporter.pollRegistry();
				
		EasyMock.verify(mockListener);
	}
	
	@Test
	public void doNotReceiveNotificationForAlreadyDeleted() {
		mockListener.ePackageAdded(ePackage);
		mockListener.ePackageRemoved(ePackage);

		EasyMock.replay(mockListener);
	
		
		EPackage.Registry.INSTANCE.put("empty", ePackage);
		reporter.pollRegistry();

		reporter.addListener(mockListener);
		
		EPackage.Registry.INSTANCE.remove("empty");
		reporter.pollRegistry();
		reporter.pollRegistry();
				
		EasyMock.verify(mockListener);
	}
	
	@Test
	public void doNotReceiveNotificationForTwoEqualEPackages() {
		final EPackage familiesPackage = aMetamodel().withNsURI("families").with(anEClass().named("Family")).build();
		final EPackage samePackage     = aMetamodel().withNsURI("families").with(anEClass().named("Family")).build();

		
		mockListener.ePackageAdded(familiesPackage);
		
		EasyMock.replay(mockListener);
	
		
		EPackage.Registry.INSTANCE.put("empty", familiesPackage);
		reporter.pollRegistry();

		reporter.addListener(mockListener);
		
		EPackage.Registry.INSTANCE.put("empty", samePackage);
		reporter.pollRegistry();
				
		EasyMock.verify(mockListener);
	}
	
	
	@Test
	public void pollRegistryForChangedEPackage() {
		final EPackage newEPackage = aMetamodel().with(anEClass().named("New")).build();
		
		mockListener.ePackageAdded(ePackage);
		mockListener.ePackageChanged(ePackage, newEPackage);

		EasyMock.replay(mockListener);
	
		
		EPackage.Registry.INSTANCE.put("empty", ePackage);
		reporter.pollRegistry();
		reporter.addListener(mockListener);
		
		EPackage.Registry.INSTANCE.put("empty", newEPackage);
		reporter.pollRegistry();
				
		EasyMock.verify(mockListener);
	}
	
	@Test
	public void removePollAddFiresTwoNotifications() {
		mockListener.ePackageAdded(ePackage);
		mockListener.ePackageRemoved(ePackage);

		EasyMock.replay(mockListener);
	
		
		EPackage.Registry.INSTANCE.put("empty", ePackage);
		reporter.pollRegistry();
		reporter.addListener(mockListener);
		
		EPackage.Registry.INSTANCE.remove("empty");
		reporter.pollRegistry();
				
		EasyMock.verify(mockListener);
	}
	
	
	@Test
	public void severalChangesAtOnce() {
		final EPackage ecore = aMetamodel().with(anEClass().named("EClass")).build();
		final EPackage uml   = aMetamodel().with(anEClass().named("ActivityGraph")).build();
		final EPackage uml2  = aMetamodel().with(anEClass().named("Activity")).build();

		
		mockListener.ePackageAdded(ePackage);
		mockListener.ePackageAdded(ecore);
		mockListener.ePackageAdded(uml);
		mockListener.ePackageRemoved(ecore);
		mockListener.ePackageChanged(uml, uml2);

		EasyMock.replay(mockListener);
	
		
		EPackage.Registry.INSTANCE.put("empty", ePackage);
		EPackage.Registry.INSTANCE.put("ecore", ecore);
		reporter.addListener(mockListener);
		
		EPackage.Registry.INSTANCE.put("uml", uml);
		reporter.pollRegistry();
		
		EPackage.Registry.INSTANCE.remove("ecore");
		EPackage.Registry.INSTANCE.put("uml", uml2);
		reporter.pollRegistry();
				
		EasyMock.verify(mockListener);
	}
}
