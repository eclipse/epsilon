/**
 */
package org.eclipse.epsilon.eugenia.examples.fed.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.epsilon.eugenia.examples.fed.Configuration;
import org.eclipse.epsilon.eugenia.examples.fed.Feature;
import org.eclipse.epsilon.eugenia.examples.fed.FedFactory;
import org.eclipse.epsilon.eugenia.examples.fed.FedPackage;
import org.eclipse.epsilon.eugenia.examples.fed.NamedElement;
import org.eclipse.epsilon.eugenia.examples.fed.Plugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FedPackageImpl extends EPackageImpl implements FedPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass configurationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass namedElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass featureEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pluginEClass = null;

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
   * @see org.eclipse.epsilon.eugenia.examples.fed.FedPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private FedPackageImpl()
  {
    super(eNS_URI, FedFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link FedPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static FedPackage init()
  {
    if (isInited) return (FedPackage)EPackage.Registry.INSTANCE.getEPackage(FedPackage.eNS_URI);

    // Obtain or create and register package
    FedPackageImpl theFedPackage = (FedPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof FedPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new FedPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theFedPackage.createPackageContents();

    // Initialize created meta-data
    theFedPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theFedPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(FedPackage.eNS_URI, theFedPackage);
    return theFedPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConfiguration()
  {
    return configurationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConfiguration_Features()
  {
    return (EReference)configurationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConfiguration_Plugins()
  {
    return (EReference)configurationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNamedElement()
  {
    return namedElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNamedElement_Name()
  {
    return (EAttribute)namedElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFeature()
  {
    return featureEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFeature_Plugins()
  {
    return (EReference)featureEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFeature_Depends()
  {
    return (EReference)featureEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFeature_Includes()
  {
    return (EReference)featureEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getFeature_PluginDependencies() {
    return (EReference)featureEClass.getEStructuralFeatures().get(3);
  }

		/**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPlugin()
  {
    return pluginEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FedFactory getFedFactory()
  {
    return (FedFactory)getEFactoryInstance();
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
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    configurationEClass = createEClass(CONFIGURATION);
    createEReference(configurationEClass, CONFIGURATION__FEATURES);
    createEReference(configurationEClass, CONFIGURATION__PLUGINS);

    namedElementEClass = createEClass(NAMED_ELEMENT);
    createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);

    featureEClass = createEClass(FEATURE);
    createEReference(featureEClass, FEATURE__PLUGINS);
    createEReference(featureEClass, FEATURE__DEPENDS);
    createEReference(featureEClass, FEATURE__INCLUDES);
    createEReference(featureEClass, FEATURE__PLUGIN_DEPENDENCIES);

    pluginEClass = createEClass(PLUGIN);
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
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    featureEClass.getESuperTypes().add(this.getNamedElement());
    pluginEClass.getESuperTypes().add(this.getNamedElement());

    // Initialize classes and features; add operations and parameters
    initEClass(configurationEClass, Configuration.class, "Configuration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getConfiguration_Features(), this.getFeature(), null, "features", null, 0, -1, Configuration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getConfiguration_Plugins(), this.getPlugin(), null, "plugins", null, 0, -1, Configuration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(namedElementEClass, NamedElement.class, "NamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNamedElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(featureEClass, Feature.class, "Feature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFeature_Plugins(), this.getPlugin(), null, "plugins", null, 0, -1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFeature_Depends(), this.getFeature(), null, "depends", null, 0, -1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFeature_Includes(), this.getFeature(), null, "includes", null, 0, -1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFeature_PluginDependencies(), this.getPlugin(), null, "pluginDependencies", null, 0, -1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(pluginEClass, Plugin.class, "Plugin", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    // Create resource
    createResource(eNS_URI);

    // Create annotations
    // emf.gen
    createEmfAnnotations();
    // gmf.diagram
    createGmfAnnotations();
    // gmf.node
    createGmf_1Annotations();
    // gmf.compartment
    createGmf_2Annotations();
    // gmf.link
    createGmf_3Annotations();
  }

  /**
   * Initializes the annotations for <b>emf.gen</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void createEmfAnnotations()
  {
    String source = "emf.gen";		
    addAnnotation
      (this, 
       source, 
       new String[] 
       {
       "basePackage", "org.eclipse.epsilon.eugenia.examples"
       });					
  }

  /**
   * Initializes the annotations for <b>gmf.diagram</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void createGmfAnnotations()
  {
    String source = "gmf.diagram";			
    addAnnotation
      (configurationEClass, 
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
  protected void createGmf_1Annotations()
  {
    String source = "gmf.node";				
    addAnnotation
      (namedElementEClass, 
       source, 
       new String[] 
       {
       "label", "name"
       });			
  }

  /**
   * Initializes the annotations for <b>gmf.compartment</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void createGmf_2Annotations()
  {
    String source = "gmf.compartment";					
    addAnnotation
      (getFeature_Plugins(), 
       source, 
       new String[] 
       {
       "layout", "free"
       });		
  }

  /**
   * Initializes the annotations for <b>gmf.link</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void createGmf_3Annotations()
  {
    String source = "gmf.link";						
    addAnnotation
      (getFeature_Depends(), 
       source, 
       new String[] 
       {
       "target.decoration", "arrow",
       "style", "dash"
       });		
    addAnnotation
      (getFeature_Includes(), 
       source, 
       new String[] 
       {
       "target.decoration", "arrow",
       "source.decoration", "filledrhomb"
       });
  }

} //FedPackageImpl
