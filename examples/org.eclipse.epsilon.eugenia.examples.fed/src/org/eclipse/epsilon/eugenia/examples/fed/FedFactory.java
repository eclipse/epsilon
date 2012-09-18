/**
 */
package org.eclipse.epsilon.eugenia.examples.fed;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.epsilon.eugenia.examples.fed.FedPackage
 * @generated
 */
public interface FedFactory extends EFactory
{
  /**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  FedFactory eINSTANCE = org.eclipse.epsilon.eugenia.examples.fed.impl.FedFactoryImpl.init();

  /**
	 * Returns a new object of class '<em>Configuration</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Configuration</em>'.
	 * @generated
	 */
  Configuration createConfiguration();

  /**
	 * Returns a new object of class '<em>Feature</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Feature</em>'.
	 * @generated
	 */
  Feature createFeature();

  /**
	 * Returns a new object of class '<em>Plugin</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Plugin</em>'.
	 * @generated
	 */
  Plugin createPlugin();

  /**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
  FedPackage getFedPackage();

} //FedFactory
