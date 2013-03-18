/**
 */
package subdiagrams;

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
 * @see subdiagrams.SubdiagramsFactory
 * @model kind="package"
 * @generated
 */
public interface SubdiagramsPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "subdiagrams";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "subdiagrams";

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
  SubdiagramsPackage eINSTANCE = subdiagrams.impl.SubdiagramsPackageImpl.init();

  /**
   * The meta object id for the '{@link subdiagrams.impl.PackageableElementImpl <em>Packageable Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see subdiagrams.impl.PackageableElementImpl
   * @see subdiagrams.impl.SubdiagramsPackageImpl#getPackageableElement()
   * @generated
   */
  int PACKAGEABLE_ELEMENT = 1;

  /**
   * The number of structural features of the '<em>Packageable Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGEABLE_ELEMENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link subdiagrams.impl.PackageImpl <em>Package</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see subdiagrams.impl.PackageImpl
   * @see subdiagrams.impl.SubdiagramsPackageImpl#getPackage()
   * @generated
   */
  int PACKAGE = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE__NAME = PACKAGEABLE_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Contents</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE__CONTENTS = PACKAGEABLE_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Package</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE_FEATURE_COUNT = PACKAGEABLE_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link subdiagrams.impl.ClazzImpl <em>Clazz</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see subdiagrams.impl.ClazzImpl
   * @see subdiagrams.impl.SubdiagramsPackageImpl#getClazz()
   * @generated
   */
  int CLAZZ = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAZZ__NAME = PACKAGEABLE_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Clazz</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAZZ_FEATURE_COUNT = PACKAGEABLE_ELEMENT_FEATURE_COUNT + 1;


  /**
   * Returns the meta object for class '{@link subdiagrams.Package <em>Package</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Package</em>'.
   * @see subdiagrams.Package
   * @generated
   */
  EClass getPackage();

  /**
   * Returns the meta object for the attribute '{@link subdiagrams.Package#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see subdiagrams.Package#getName()
   * @see #getPackage()
   * @generated
   */
  EAttribute getPackage_Name();

  /**
   * Returns the meta object for the containment reference list '{@link subdiagrams.Package#getContents <em>Contents</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Contents</em>'.
   * @see subdiagrams.Package#getContents()
   * @see #getPackage()
   * @generated
   */
  EReference getPackage_Contents();

  /**
   * Returns the meta object for class '{@link subdiagrams.PackageableElement <em>Packageable Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Packageable Element</em>'.
   * @see subdiagrams.PackageableElement
   * @generated
   */
  EClass getPackageableElement();

  /**
   * Returns the meta object for class '{@link subdiagrams.Clazz <em>Clazz</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Clazz</em>'.
   * @see subdiagrams.Clazz
   * @generated
   */
  EClass getClazz();

  /**
   * Returns the meta object for the attribute '{@link subdiagrams.Clazz#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see subdiagrams.Clazz#getName()
   * @see #getClazz()
   * @generated
   */
  EAttribute getClazz_Name();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  SubdiagramsFactory getSubdiagramsFactory();

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
     * The meta object literal for the '{@link subdiagrams.impl.PackageImpl <em>Package</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see subdiagrams.impl.PackageImpl
     * @see subdiagrams.impl.SubdiagramsPackageImpl#getPackage()
     * @generated
     */
    EClass PACKAGE = eINSTANCE.getPackage();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PACKAGE__NAME = eINSTANCE.getPackage_Name();

    /**
     * The meta object literal for the '<em><b>Contents</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PACKAGE__CONTENTS = eINSTANCE.getPackage_Contents();

    /**
     * The meta object literal for the '{@link subdiagrams.impl.PackageableElementImpl <em>Packageable Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see subdiagrams.impl.PackageableElementImpl
     * @see subdiagrams.impl.SubdiagramsPackageImpl#getPackageableElement()
     * @generated
     */
    EClass PACKAGEABLE_ELEMENT = eINSTANCE.getPackageableElement();

    /**
     * The meta object literal for the '{@link subdiagrams.impl.ClazzImpl <em>Clazz</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see subdiagrams.impl.ClazzImpl
     * @see subdiagrams.impl.SubdiagramsPackageImpl#getClazz()
     * @generated
     */
    EClass CLAZZ = eINSTANCE.getClazz();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLAZZ__NAME = eINSTANCE.getClazz_Name();

  }

} //SubdiagramsPackage
