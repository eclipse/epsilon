/**
 */
package subdiagrams.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import subdiagrams.Clazz;
import subdiagrams.SubdiagramsFactory;
import subdiagrams.SubdiagramsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SubdiagramsFactoryImpl extends EFactoryImpl implements SubdiagramsFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static SubdiagramsFactory init()
  {
    try
    {
      SubdiagramsFactory theSubdiagramsFactory = (SubdiagramsFactory)EPackage.Registry.INSTANCE.getEFactory("subdiagrams"); 
      if (theSubdiagramsFactory != null)
      {
        return theSubdiagramsFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new SubdiagramsFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SubdiagramsFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case SubdiagramsPackage.PACKAGE: return createPackage();
      case SubdiagramsPackage.CLAZZ: return createClazz();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public subdiagrams.Package createPackage()
  {
    PackageImpl package_ = new PackageImpl();
    return package_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Clazz createClazz()
  {
    ClazzImpl clazz = new ClazzImpl();
    return clazz;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SubdiagramsPackage getSubdiagramsPackage()
  {
    return (SubdiagramsPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static SubdiagramsPackage getPackage()
  {
    return SubdiagramsPackage.eINSTANCE;
  }

} //SubdiagramsFactoryImpl
