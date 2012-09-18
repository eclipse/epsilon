/**
 */
package org.eclipse.epsilon.eugenia.examples.fed;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eugenia.examples.fed.Configuration#getFeatures <em>Features</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eugenia.examples.fed.Configuration#getPlugins <em>Plugins</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.eugenia.examples.fed.FedPackage#getConfiguration()
 * @model annotation="gmf.diagram foo='bar'"
 * @generated
 */
public interface Configuration extends EObject
{
  /**
	 * Returns the value of the '<em><b>Features</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.eugenia.examples.fed.Feature}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Features</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Features</em>' containment reference list.
	 * @see org.eclipse.epsilon.eugenia.examples.fed.FedPackage#getConfiguration_Features()
	 * @model containment="true"
	 * @generated
	 */
  EList<Feature> getFeatures();

  /**
	 * Returns the value of the '<em><b>Plugins</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.eugenia.examples.fed.Plugin}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Plugins</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Plugins</em>' containment reference list.
	 * @see org.eclipse.epsilon.eugenia.examples.fed.FedPackage#getConfiguration_Plugins()
	 * @model containment="true"
	 * @generated
	 */
  EList<Plugin> getPlugins();

} // Configuration
