/**
 */
package org.eclipse.epsilon.eugenia.examples.fed;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.epsilon.eugenia.examples.fed.FedFactory
 * @model kind="package"
 *        annotation="emf.gen basePackage='org.eclipse.epsilon.eugenia.examples'"
 * @generated
 */
public interface FedPackage extends EPackage
{
  /**
	 * The package name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNAME = "fed";

  /**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNS_URI = "fed";

  /**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNS_PREFIX = "";

  /**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  FedPackage eINSTANCE = org.eclipse.epsilon.eugenia.examples.fed.impl.FedPackageImpl.init();

  /**
	 * The meta object id for the '{@link org.eclipse.epsilon.eugenia.examples.fed.impl.ConfigurationImpl <em>Configuration</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eugenia.examples.fed.impl.ConfigurationImpl
	 * @see org.eclipse.epsilon.eugenia.examples.fed.impl.FedPackageImpl#getConfiguration()
	 * @generated
	 */
  int CONFIGURATION = 0;

  /**
	 * The feature id for the '<em><b>Features</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CONFIGURATION__FEATURES = 0;

  /**
	 * The feature id for the '<em><b>Plugins</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CONFIGURATION__PLUGINS = 1;

  /**
	 * The number of structural features of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CONFIGURATION_FEATURE_COUNT = 2;

  /**
	 * The meta object id for the '{@link org.eclipse.epsilon.eugenia.examples.fed.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eugenia.examples.fed.impl.NamedElementImpl
	 * @see org.eclipse.epsilon.eugenia.examples.fed.impl.FedPackageImpl#getNamedElement()
	 * @generated
	 */
  int NAMED_ELEMENT = 1;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int NAMED_ELEMENT__NAME = 0;

  /**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int NAMED_ELEMENT_FEATURE_COUNT = 1;

  /**
	 * The meta object id for the '{@link org.eclipse.epsilon.eugenia.examples.fed.impl.FeatureImpl <em>Feature</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eugenia.examples.fed.impl.FeatureImpl
	 * @see org.eclipse.epsilon.eugenia.examples.fed.impl.FedPackageImpl#getFeature()
	 * @generated
	 */
  int FEATURE = 2;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int FEATURE__NAME = NAMED_ELEMENT__NAME;

  /**
	 * The feature id for the '<em><b>Plugins</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int FEATURE__PLUGINS = NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Depends</b></em>' reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int FEATURE__DEPENDS = NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
	 * The feature id for the '<em><b>Includes</b></em>' reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int FEATURE__INCLUDES = NAMED_ELEMENT_FEATURE_COUNT + 2;

  /**
	 * The feature id for the '<em><b>Plugin Dependencies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__PLUGIN_DEPENDENCIES = NAMED_ELEMENT_FEATURE_COUNT + 3;

		/**
	 * The number of structural features of the '<em>Feature</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int FEATURE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 4;

  /**
	 * The meta object id for the '{@link org.eclipse.epsilon.eugenia.examples.fed.impl.PluginImpl <em>Plugin</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eugenia.examples.fed.impl.PluginImpl
	 * @see org.eclipse.epsilon.eugenia.examples.fed.impl.FedPackageImpl#getPlugin()
	 * @generated
	 */
  int PLUGIN = 3;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PLUGIN__NAME = NAMED_ELEMENT__NAME;

  /**
	 * The number of structural features of the '<em>Plugin</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PLUGIN_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;


  /**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eugenia.examples.fed.Configuration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration</em>'.
	 * @see org.eclipse.epsilon.eugenia.examples.fed.Configuration
	 * @generated
	 */
  EClass getConfiguration();

  /**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.epsilon.eugenia.examples.fed.Configuration#getFeatures <em>Features</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Features</em>'.
	 * @see org.eclipse.epsilon.eugenia.examples.fed.Configuration#getFeatures()
	 * @see #getConfiguration()
	 * @generated
	 */
  EReference getConfiguration_Features();

  /**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.epsilon.eugenia.examples.fed.Configuration#getPlugins <em>Plugins</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Plugins</em>'.
	 * @see org.eclipse.epsilon.eugenia.examples.fed.Configuration#getPlugins()
	 * @see #getConfiguration()
	 * @generated
	 */
  EReference getConfiguration_Plugins();

  /**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eugenia.examples.fed.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see org.eclipse.epsilon.eugenia.examples.fed.NamedElement
	 * @generated
	 */
  EClass getNamedElement();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.epsilon.eugenia.examples.fed.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.epsilon.eugenia.examples.fed.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
  EAttribute getNamedElement_Name();

  /**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eugenia.examples.fed.Feature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature</em>'.
	 * @see org.eclipse.epsilon.eugenia.examples.fed.Feature
	 * @generated
	 */
  EClass getFeature();

  /**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.epsilon.eugenia.examples.fed.Feature#getPlugins <em>Plugins</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Plugins</em>'.
	 * @see org.eclipse.epsilon.eugenia.examples.fed.Feature#getPlugins()
	 * @see #getFeature()
	 * @generated
	 */
  EReference getFeature_Plugins();

  /**
	 * Returns the meta object for the reference list '{@link org.eclipse.epsilon.eugenia.examples.fed.Feature#getDepends <em>Depends</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Depends</em>'.
	 * @see org.eclipse.epsilon.eugenia.examples.fed.Feature#getDepends()
	 * @see #getFeature()
	 * @generated
	 */
  EReference getFeature_Depends();

  /**
	 * Returns the meta object for the reference list '{@link org.eclipse.epsilon.eugenia.examples.fed.Feature#getIncludes <em>Includes</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Includes</em>'.
	 * @see org.eclipse.epsilon.eugenia.examples.fed.Feature#getIncludes()
	 * @see #getFeature()
	 * @generated
	 */
  EReference getFeature_Includes();

  /**
	 * Returns the meta object for the reference list '{@link org.eclipse.epsilon.eugenia.examples.fed.Feature#getPluginDependencies <em>Plugin Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Plugin Dependencies</em>'.
	 * @see org.eclipse.epsilon.eugenia.examples.fed.Feature#getPluginDependencies()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_PluginDependencies();

		/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eugenia.examples.fed.Plugin <em>Plugin</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Plugin</em>'.
	 * @see org.eclipse.epsilon.eugenia.examples.fed.Plugin
	 * @generated
	 */
  EClass getPlugin();

  /**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
  FedFactory getFedFactory();

  /**
	 * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
	 * @generated
	 */
  interface Literals
  {
    /**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eugenia.examples.fed.impl.ConfigurationImpl <em>Configuration</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eugenia.examples.fed.impl.ConfigurationImpl
		 * @see org.eclipse.epsilon.eugenia.examples.fed.impl.FedPackageImpl#getConfiguration()
		 * @generated
		 */
    EClass CONFIGURATION = eINSTANCE.getConfiguration();

    /**
		 * The meta object literal for the '<em><b>Features</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference CONFIGURATION__FEATURES = eINSTANCE.getConfiguration_Features();

    /**
		 * The meta object literal for the '<em><b>Plugins</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference CONFIGURATION__PLUGINS = eINSTANCE.getConfiguration_Plugins();

    /**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eugenia.examples.fed.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eugenia.examples.fed.impl.NamedElementImpl
		 * @see org.eclipse.epsilon.eugenia.examples.fed.impl.FedPackageImpl#getNamedElement()
		 * @generated
		 */
    EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

    /**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

    /**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eugenia.examples.fed.impl.FeatureImpl <em>Feature</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eugenia.examples.fed.impl.FeatureImpl
		 * @see org.eclipse.epsilon.eugenia.examples.fed.impl.FedPackageImpl#getFeature()
		 * @generated
		 */
    EClass FEATURE = eINSTANCE.getFeature();

    /**
		 * The meta object literal for the '<em><b>Plugins</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference FEATURE__PLUGINS = eINSTANCE.getFeature_Plugins();

    /**
		 * The meta object literal for the '<em><b>Depends</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference FEATURE__DEPENDS = eINSTANCE.getFeature_Depends();

    /**
		 * The meta object literal for the '<em><b>Includes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference FEATURE__INCLUDES = eINSTANCE.getFeature_Includes();

    /**
		 * The meta object literal for the '<em><b>Plugin Dependencies</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE__PLUGIN_DEPENDENCIES = eINSTANCE.getFeature_PluginDependencies();

				/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eugenia.examples.fed.impl.PluginImpl <em>Plugin</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eugenia.examples.fed.impl.PluginImpl
		 * @see org.eclipse.epsilon.eugenia.examples.fed.impl.FedPackageImpl#getPlugin()
		 * @generated
		 */
    EClass PLUGIN = eINSTANCE.getPlugin();

  }

} //FedPackage
