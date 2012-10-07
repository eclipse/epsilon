/**
 */
package org.eclipse.epsilon.eugenia.examples.fed;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eugenia.examples.fed.Feature#getPlugins <em>Plugins</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eugenia.examples.fed.Feature#getDepends <em>Depends</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eugenia.examples.fed.Feature#getIncludes <em>Includes</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eugenia.examples.fed.Feature#getPluginDependencies <em>Plugin Dependencies</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.eugenia.examples.fed.FedPackage#getFeature()
 * @model
 * @generated
 */
public interface Feature extends NamedElement
{
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
   * @see org.eclipse.epsilon.eugenia.examples.fed.FedPackage#getFeature_Plugins()
   * @model containment="true"
   *        annotation="gmf.compartment layout='free'"
   * @generated
   */
  EList<Plugin> getPlugins();

  /**
   * Returns the value of the '<em><b>Depends</b></em>' reference list.
   * The list contents are of type {@link org.eclipse.epsilon.eugenia.examples.fed.Feature}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Depends</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Depends</em>' reference list.
   * @see org.eclipse.epsilon.eugenia.examples.fed.FedPackage#getFeature_Depends()
   * @model annotation="gmf.link target.decoration='arrow' style='dash'"
   * @generated
   */
  EList<Feature> getDepends();

  /**
   * Returns the value of the '<em><b>Includes</b></em>' reference list.
   * The list contents are of type {@link org.eclipse.epsilon.eugenia.examples.fed.Feature}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Includes</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Includes</em>' reference list.
   * @see org.eclipse.epsilon.eugenia.examples.fed.FedPackage#getFeature_Includes()
   * @model annotation="gmf.link target.decoration='arrow' source.decoration='filledrhomb'"
   * @generated
   */
  EList<Feature> getIncludes();

		/**
   * Returns the value of the '<em><b>Plugin Dependencies</b></em>' reference list.
   * The list contents are of type {@link org.eclipse.epsilon.eugenia.examples.fed.Plugin}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Plugin Dependencies</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Plugin Dependencies</em>' reference list.
   * @see org.eclipse.epsilon.eugenia.examples.fed.FedPackage#getFeature_PluginDependencies()
   * @model
   * @generated
   */
	EList<Plugin> getPluginDependencies();

} // Feature
