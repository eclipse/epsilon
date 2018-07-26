/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package friends.impl;

import friends.FriendsFactory;
import friends.FriendsPackage;
import friends.Person;
import friends.World;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FriendsPackageImpl extends EPackageImpl implements FriendsPackage {
	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass worldEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass personEClass = null;

	/**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see friends.FriendsPackage#eNS_URI
   * @see #init()
   * @generated
   */
	private FriendsPackageImpl() {
    super(eNS_URI, FriendsFactory.eINSTANCE);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private static boolean isInited = false;

	/**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link FriendsPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
	public static FriendsPackage init() {
    if (isInited) return (FriendsPackage)EPackage.Registry.INSTANCE.getEPackage(FriendsPackage.eNS_URI);

    // Obtain or create and register package
    FriendsPackageImpl theFriendsPackage = (FriendsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof FriendsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new FriendsPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theFriendsPackage.createPackageContents();

    // Initialize created meta-data
    theFriendsPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theFriendsPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(FriendsPackage.eNS_URI, theFriendsPackage);
    return theFriendsPackage;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getWorld() {
    return worldEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getWorld_People() {
    return (EReference)worldEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getPerson() {
    return personEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getPerson_Name() {
    return (EAttribute)personEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getPerson_FriendOf() {
    return (EReference)personEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getPerson_EnemyOf() {
    return (EReference)personEClass.getEStructuralFeatures().get(2);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public FriendsFactory getFriendsFactory() {
    return (FriendsFactory)getEFactoryInstance();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private boolean isCreated = false;

	/**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void createPackageContents() {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    worldEClass = createEClass(WORLD);
    createEReference(worldEClass, WORLD__PEOPLE);

    personEClass = createEClass(PERSON);
    createEAttribute(personEClass, PERSON__NAME);
    createEReference(personEClass, PERSON__FRIEND_OF);
    createEReference(personEClass, PERSON__ENEMY_OF);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private boolean isInitialized = false;

	/**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void initializePackageContents() {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes

    // Initialize classes and features; add operations and parameters
    initEClass(worldEClass, World.class, "World", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getWorld_People(), this.getPerson(), null, "people", null, 0, -1, World.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(personEClass, Person.class, "Person", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPerson_Name(), ecorePackage.getEString(), "name", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPerson_FriendOf(), this.getPerson(), null, "friendOf", null, 0, -1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPerson_EnemyOf(), this.getPerson(), null, "enemyOf", null, 0, -1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);

    // Create annotations
    // gmf.diagram
    createGmfAnnotations();
    // gmf.node
    createGmf_1Annotations();
    // gmf.link
    createGmf_2Annotations();
  }

	/**
   * Initializes the annotations for <b>gmf.diagram</b>.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected void createGmfAnnotations() {
    String source = "gmf.diagram";		
    addAnnotation
      (worldEClass, 
       source, 
       new String[] 
       {
       "foo", "bar"
       });			
  }

	/**
   * Initializes the annotations for <b>gmf.node</b>.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected void createGmf_1Annotations() {
    String source = "gmf.node";			
    addAnnotation
      (personEClass, 
       source, 
       new String[] 
       {
       "figure", "figures.PersonFigure",
       "label.icon", "false",
       "label", "name",
       "label.placement", "external"
       });		
  }

	/**
   * Initializes the annotations for <b>gmf.link</b>.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected void createGmf_2Annotations() {
    String source = "gmf.link";				
    addAnnotation
      (getPerson_FriendOf(), 
       source, 
       new String[] 
       {
       "width", "2",
       "color", "0,255,0",
       "source.decoration", "arrow",
       "target.decoration", "arrow",
       "style", "dash"
       });		
    addAnnotation
      (getPerson_EnemyOf(), 
       source, 
       new String[] 
       {
       "width", "2",
       "color", "255,0,0",
       "source.decoration", "arrow",
       "target.decoration", "arrow",
       "style", "dash"
       });
  }

} //FriendsPackageImpl
